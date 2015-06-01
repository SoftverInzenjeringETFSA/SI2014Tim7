package ba.unsa.etf.si.app.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import org.hibernate.Transaction;

import ba.unsa.etf.si.app.dao.OcitanjaDAO;
import ba.unsa.etf.si.app.dao.RacuniDAO;
import ba.unsa.etf.si.app.entity.Ocitanja;
import ba.unsa.etf.si.app.entity.Parametri;
import ba.unsa.etf.si.app.entity.Potrosac;
import ba.unsa.etf.si.app.entity.Racuni;
import ba.unsa.etf.si.app.util.HibernateUtil;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ObracunService {

	public List<Racuni> formirajRacune(Date odDatuma, Date doDatuma) {
		OcitanjaService ocitanja = new OcitanjaService();
		ParametriService paramS = new ParametriService();
		Calendar odDat = Calendar.getInstance();
		Calendar doDat = Calendar.getInstance();
		odDat.setTime(odDatuma);
		doDat.setTime(doDatuma);
                if(odDatuma.compareTo(doDatuma)==0||odDat.get(odDat.YEAR)<2000||doDat.get(odDat.YEAR)<2000){
                    throw new IllegalArgumentException("Nije moguce kreirati racune za dati period!");
                }
		formirajOcitanjaZaPausalce(odDat.get(odDat.MONTH) + 1,
				doDat.get(doDat.MONTH) + 1, odDat.get(odDat.YEAR), ocitanja);
		//lista koja sadrzi ocitanja za pocetni i krajnji mjesec
		List<Ocitanja> ocitanjaZaRacune = ocitanja.getOcitanjaForRacuni(
				odDatuma, doDatuma);
		//System.out.println(ocitanjaZaRacune.size());
		
		//preuzimanje parametara potrebnih za obracun
	    Parametri param = paramS.dajParametre();
		List<Racuni> racuniList = new ArrayList<Racuni>();
		Calendar odCal = Calendar.getInstance();
		int pocetniMjesec = odDat.get(odDat.MONTH);
                int krajnjiMjesec = doDat.get(doDat.MONTH) + 1;
		//obracun racuna za svako ocitanje iz liste
                    for (Ocitanja ocitanjaZaRacuneX : ocitanjaZaRacune) {
                        for (Ocitanja ocitanjaZaRacuneY : ocitanjaZaRacune) {
                            int pocetni = ocitanjaZaRacuneX.getMjesec();
                            int krajnji =ocitanjaZaRacuneY.getMjesec()-1;
                            int p1 =ocitanjaZaRacuneY.getPotrosacByIdPotrosaca().getId();
                            int p2 = ocitanjaZaRacuneX.getPotrosacByIdPotrosaca().getId();
                            int g1 = ocitanjaZaRacuneX.getGodina();
                            int g2 = ocitanjaZaRacuneY.getGodina();
                            if(pocetni==krajnji&&g1==g2&&p1==p2){
                            Racuni racun = formirajRacun(ocitanjaZaRacuneX, ocitanjaZaRacuneY, param, ocitanja);
                                if (racun != null) {
                                    racuniList.add(racun);
                                }
                            }
                        }
                    }

		if (racuniList.isEmpty()) {
			throw new IllegalArgumentException("Nije moguce kreirati racune za dati period!");
		} else {
			
			snimiRacune(racuniList);
			return racuniList;
		}
	}

	
	private Racuni formirajRacun(Ocitanja oPocetak,Ocitanja oKraj, Parametri param, OcitanjaService servis) {
		Potrosac p = oPocetak.getPotrosacByIdPotrosaca();
		Double potrosnja = 0.0;
		String kat = p.getKategorija();
		
		//ako je potrosac pausalni, racun se obracunava na osnovu fiksne cijene
		if ("Pausalac".equals(p.getKategorija())) {
				potrosnja = param.getFiksniVodaZaPausalce() * Integer.valueOf(p.getBrojClanova());
		} 
		//ako potrosac nije pausalni, potrosnja se racuna na osnovu ocitanog stanja za dva mjeseca
		else {
                       potrosnja = oKraj.getPotrosnja() - oPocetak.getPotrosnja();
		}
		if (potrosnja == 0.0) {
			return null;
		}
                DateFormat format = new SimpleDateFormat("MM/yyyy");
                String datum = String.valueOf(oPocetak.getMjesec())+"/"+oPocetak.getGodina();
                Date datumKreiranja = new Date();
                		try {

		datumKreiranja = format.parse(datum);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//inicijaliziranje parametara i obracunavanje
		Double fixnaCijenaZaKoristenjeUsluga = param.getFiksnaCijena();
		Double cijenaVoda = round(potrosnja
				* (param.getPvnZaKoristenjeVoda()
						+ param.getCijenaVodePoKubiku() + param
							.getPvnZaZastituVoda()),2);
		Double cijenaKanalizacije = 0.0;
		if (p.getUsluga()) {
			cijenaKanalizacije = round(potrosnja
					* param.getCijenaKanalizacijePoKubiku(),2);
		}
		Double ukupno = round(cijenaKanalizacije + cijenaVoda + param.getFiksnaCijena(),2);
		Double cijenaKsaPDV = round(cijenaKanalizacije + cijenaKanalizacije
				* param.getStopaPdv()/100,2);
		Double cijenaVsaPDV = round(cijenaVoda + cijenaVoda * param.getStopaPdv()/100,2);
		Double ukupnoSaPDV = round(cijenaVsaPDV + cijenaKsaPDV + param.getFiksnaCijena() + param.getFiksnaCijena()*param.getStopaPdv()/100,2);
		Racuni r = new Racuni();
		r.setCijenaKanalizacije(cijenaKanalizacije);
		r.setCijenaKanalizacijeSaPdv(cijenaKsaPDV);
		r.setCijenaVoda(cijenaVoda);
		r.setCijenaVodaSaPdv(cijenaVsaPDV);
		r.setDatumKreacije(datumKreiranja);
		r.setFisknaCijenaZaKoristenjeUsluga(fixnaCijenaZaKoristenjeUsluga);
		r.setOcitanja(oKraj);
		r.setPotrosac(p);
		if (p.getUsluga()) {
			r.setPotrosnjaZaKoristenjeKanalizacije(potrosnja);
		} else {
			r.setPotrosnjaZaKoristenjeKanalizacije(0.0);
		}
                r.setPotrosnjaZaKoristenjeVoda(potrosnja);
		r.setPvnZaKoristenjeVoda(potrosnja*param.getPvnZaKoristenjeVoda());
		r.setPvnZaZastituVoda(potrosnja*param.getPvnZaZastituVoda());
		r.setUkupnaCijena(ukupno);
		r.setUkupnaCijenaSaPdv(ukupnoSaPDV);
                oPocetak.setAccess(false);
                servis.modifyOcitanja(oPocetak);
		return r;
	}

	private void snimiRacune(List<Racuni> racuni) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		RacuniDAO dao = new RacuniDAO();
		dao.setSession(session);

		for (Racuni r : racuni) {
			dao.save(r);
		}

		session.getTransaction().commit();
		session.close();

	}

	public List<Racuni> pretragaRacuna(Date datumKreacije, int id, String ime,
			String prezime, String sifraVodomjera,Boolean nemaDatuma) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		RacuniDAO dao = new RacuniDAO();
		dao.setSession(session);
                PotrosacService servP = new PotrosacService();
                List<Potrosac> pList = servP.mainSearch(ime, prezime, "", "", String.valueOf(sifraVodomjera));
                List<Racuni> returnList = new ArrayList();
		// Pretraga po Datumu i ID
                Date s = new Date();
		List<Racuni> rListID = dao.finById(id);
                List<Racuni> rListDate = dao.finByDate(datumKreacije);
                List<Racuni> rList = new ArrayList();
                if(rListID.isEmpty()&&rListDate.isEmpty()){
                    rList = dao.findAll();
                    if(pList.isEmpty()||id!=0||nemaDatuma == false){
                        throw new IllegalArgumentException("Nema računa za date podatke!");
                    }
                }
                else if(rListID.isEmpty()){
                    rList=rListDate;
                    if(id!=0){
                        throw new IllegalArgumentException("Nema računa za date podatke!");
                    }
                }
                else if(rListDate.isEmpty()){
                    rList=rListID;
                    if(nemaDatuma == false){
                        throw new IllegalArgumentException("Nema računa za date podatke!");
                    }
                }
                else{
                    for(Racuni poDatumu : rListDate){
                        for(Racuni poID : rListID){
                            int datumProvjera = poID.getId();
                            int idProvjera = poDatumu.getId();
                            if(idProvjera == datumProvjera){
                                rList.add(poDatumu);
                            }
                        }
                    }
                }
                // Pretraga po Potrosacu

                if(!rList.isEmpty()){
                    if(pList.isEmpty()){
                        return rList;
                    }
                    for (Racuni r : rList) {
                        for (Potrosac p : pList) {
                            int racunID = r.getPotrosac().getId();
                            int potrosacID = p.getId();
                            if(racunID==potrosacID){
                                returnList.add(r);
                            }
                        }
                    }
                    if(!returnList.isEmpty()){
                        return returnList;
                    }
                    else{
                        throw new IllegalArgumentException("Nema računa za date podatke!");
                    }
                }
                else{
                    throw new IllegalArgumentException("Nema računa za date podatke!");
                }
	}

	public void uplatiRacun(Racuni r) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		RacuniDAO dao = new RacuniDAO();
		dao.setSession(session);
			dao.save(r);
		session.getTransaction().commit();
		session.close();
	}

	//pausalci nemaju klasicna ocitavanja, ali zbog procesa obracuna neophodno je da postoje u bazi, ova funkcija ih kreira za datume za koje se vrsi obracun
	public void formirajOcitanjaZaPausalce(int odMjesec, int doMjesec,
			int godina, OcitanjaService servis) {
            
            
		PotrosacService servisPotrosac = new PotrosacService();
		List<Potrosac> potrosaci = servisPotrosac.dajSvePotrosace();
		List<Potrosac> pausalci = new ArrayList();
                
		for (Potrosac potrosac : potrosaci) {
			if ("Pausalac".equals(potrosac.getKategorija())) {

				if (potrosac.getAktivnost()) {
					pausalci.add(potrosac);
				}
			}
		}
                odMjesec--;
        while(odMjesec++!=doMjesec){
		for (Potrosac potrosac : pausalci) {
			try {
				Ocitanja p = servis.getOcitanjeForRacuni(odMjesec, godina,
						potrosac);
			} catch (Exception e) {
				Ocitanja o = new Ocitanja();
				o.setPotrosacByIdPotrosaca(potrosac);
				o.setMjesec(odMjesec);
				o.setGodina(godina);
                                o.setAccess(true);
                                o.setPotrosnja(0.0);
				servis.createNewOcitanja(o);
			}
		}
	}
        }
        
        // Metoda za zaokruzivanje double na x decimala
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    
    
    public Racuni pretragaRacunaPoID(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		RacuniDAO dao = new RacuniDAO();
		dao.setSession(session);
		// Pretraga po Datumu i ID
		List<Racuni> rListID = dao.finById(id);
                                session.getTransaction().commit();
		session.close();
                if(rListID.isEmpty()){
                    throw new IllegalArgumentException("Ne postroji racun!");
                }
                else{
                    return rListID.get(0);
                }
    }
  
        
}
