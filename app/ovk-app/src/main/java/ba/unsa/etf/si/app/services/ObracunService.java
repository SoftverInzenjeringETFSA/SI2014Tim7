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
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.component.TextFieldBuilder;
import net.sf.dynamicreports.report.exception.DRException;

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
	
                if(rListID.isEmpty()){
                    throw new IllegalArgumentException("Ne postroji racun!");
                }
                else{
                    return rListID.get(0);
                }
    }
    
    public void print(Racuni r,String naziv,String datumKreacije) throws FileNotFoundException, DRException{
    //dynamic report
                JasperReportBuilder report = DynamicReports.report();
                //add title
                TextFieldBuilder<String> title1 = DynamicReports.cmp.text("  Vodovod i Kanalizacija d.o.o.\n");
                report.title(title1);
                TextFieldBuilder<String> title2 = DynamicReports.cmp.text("  Jaroslava Černija 8, 71 000 Sarajevo\n");
                report.title(title2);
                TextFieldBuilder<String> title3 = DynamicReports.cmp.text("  Tel: +387 33 237-655\n\n\n\n");
                report.title(title3);



                
                TextFieldBuilder<String> title4 = DynamicReports.cmp.text("  ID:" + r.getId() + "\n");
                report.title(title4);
       
                 TextFieldBuilder<String> title5 = DynamicReports.cmp.text("  Očitanja" + datumKreacije + "\n");
                report.title(title5);
                
                 TextFieldBuilder<String> title6 = DynamicReports.cmp.text("  Potrošač):" + naziv + "\n");
                report.title(title6);
                
                 TextFieldBuilder<String> title7 = DynamicReports.cmp.text("  Datum uplate:" + r.getDatumUplate() + "\n");
                report.title(title7);
                
                TextFieldBuilder<String> title8 = DynamicReports.cmp.text("  Datum kreacije:" + r.getDatumKreacije() + "\n");
                report.title(title8);
  

                TextFieldBuilder<String> title9 = DynamicReports.cmp.text("  Fiksna cijena za korištenje usluga:" +  r.getFisknaCijenaZaKoristenjeUsluga() + "\n");
                report.title(title9);
                
                 TextFieldBuilder<String> title10 = DynamicReports.cmp.text("  Potrošnja (voda):" + r.getPotrosnjaZaKoristenjeVoda() + "\n");
                report.title(title10);
                
                TextFieldBuilder<String> title11 = DynamicReports.cmp.text("  Potrošnja (kanalizacija):" + r.getPotrosnjaZaKoristenjeKanalizacije() + "\n");
                report.title(title11);
                
                 TextFieldBuilder<String> title12 = DynamicReports.cmp.text("  Cijena vode:" + r.getCijenaVoda() + "\n");
                report.title(title12);
                
                 TextFieldBuilder<String> title13 = DynamicReports.cmp.text("  Cijena kanalizacije:" + r.getCijenaKanalizacije() + "\n");
                report.title(title13);
                
                TextFieldBuilder<String> title14 = DynamicReports.cmp.text("  Ukupna cijena:" + r.getUkupnaCijena() + "\n");
                report.title(title14);
                
                TextFieldBuilder<String> title15 = DynamicReports.cmp.text("  Cijena vode s PDV-om:" + r.getCijenaVodaSaPdv() + "\n");
                report.title(title15);
                
                TextFieldBuilder<String> title16 = DynamicReports.cmp.text("  Cijena kanalizacije s PDV-om:" + r.getCijenaKanalizacijeSaPdv() + "\n");
                report.title(title16);
                
                TextFieldBuilder<String> title17 = DynamicReports.cmp.text("  PVN za korištenje voda:" + r.getPvnZaKoristenjeVoda() + "\n");
                report.title(title17);
                
                TextFieldBuilder<String> title18 = DynamicReports.cmp.text("  PVN za zaštitu voda:" + r.getPvnZaZastituVoda() + "\n");
                report.title(title18);

                TextFieldBuilder<String> title20 = DynamicReports.cmp.text("Potpis ovlaštenog lica: ___________________ \n");
                report.title(title20);
                report.show(false);
    }
  
        
}
