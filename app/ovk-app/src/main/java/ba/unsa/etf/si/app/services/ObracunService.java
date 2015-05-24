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

public class ObracunService {

	public List<Racuni> formirajRacune(Date odDatuma, Date doDatuma) {
		OcitanjaService ocitanja = new OcitanjaService();
		ParametriService paramS = new ParametriService();
		Calendar odDat = Calendar.getInstance();
		Calendar doDat = Calendar.getInstance();
		odDat.setTime(odDatuma);
		doDat.setTime(doDatuma);

		formirajOcitanjaZaPausalce(odDat.get(odDat.MONTH) + 1,
				doDat.get(doDat.MONTH) + 1, odDat.get(odDat.YEAR), ocitanja);
		//lista koja sadrzi ocitanja za pocetni i krajnji mjesec
		List<Ocitanja> ocitanjaZaRacune = ocitanja.getOcitanjaForRacuni(
				odDatuma, doDatuma);
		//lista koja sa drzi ocitanja za pocetni mjesec,nakon obracuna acces atribut im se postavlja na false
		List<Ocitanja> ocitanjaZaPocetni = new ArrayList();
		for(Ocitanja ocitanje:ocitanjaZaRacune){
			if(ocitanje.getMjesec()== odDat.get(odDat.MONTH)+1){
				ocitanjaZaPocetni.add(ocitanje);
			}
		}
		//System.out.println(ocitanjaZaRacune.size());
		
		//preuzimanje parametara potrebnih za obracun
	    Parametri param = paramS.dajParametre();
		List<Racuni> racuniList = new ArrayList<Racuni>();
		Calendar odCal = Calendar.getInstance();
		
		//obracun racuna za svako ocitanje iz liste
		for (Ocitanja ocitanjaZaRacuneX : ocitanjaZaRacune) {
			odCal.setTime(doDatuma);
			Racuni racun = formirajRacun(ocitanjaZaRacuneX, param, ocitanja,
					odCal.get(odCal.MONTH) + 1);
			if (racun != null) {
				racuniList.add(racun);
			}
		}

		if (racuniList.isEmpty()) {
			throw new IllegalArgumentException("Nije moguce kreirati racune za dati period!");
		} else {
			
			snimiRacune(racuniList,ocitanjaZaPocetni, ocitanja);
			return racuniList;
		}
	}

	
	private Racuni formirajRacun(Ocitanja o, Parametri param,
			OcitanjaService servis, int krajnjiMjesec) {
		Potrosac p = o.getPotrosacByIdPotrosaca();
		Double potrosnja = 0.0;
		String kat = p.getKategorija();
		
		//ako je potrosac pausalni, racun se obracunava na osnovu fiksne cijene
		if ("Pausalni".equals(p.getKategorija())) {
			if (o.getMjesec() == krajnjiMjesec) {
				potrosnja = param.getFiksniVodaZaPausalce();
			}
		} 
		//ako potrosac nije pausalni, potrosnja se racuna na osnovu ocitanog stanja za dva mjeseca
		else {
			List<Ocitanja> ocitanjaPoVodomjeru = servis.getId(p
					.getSifraVodomjera());
			for (Ocitanja ocitanje : ocitanjaPoVodomjeru) {
				if (o.getMjesec() + 1 == ocitanje.getMjesec()) {
					if (ocitanje.getMjesec() == krajnjiMjesec) {
						if (o.getGodina().intValue() == ocitanje.getGodina()
								.intValue()) {
							potrosnja = ocitanje.getPotrosnja()
									- o.getPotrosnja();
							break;
						}
					}
				}
			}
		}
		if (potrosnja == 0.0) {
			return null;
		}
		
		//inicijaliziranje parametara i obracunavanje
		Double fixnaCijenaZaKoristenjeUsluga = param.getFiksnaCijena();
		Double cijenaVoda = potrosnja
				* (param.getPvnZaKoristenjeVoda()
						+ param.getCijenaVodePoKubiku() + param
							.getPvnZaZastituVoda());
		Double cijenaKanalizacije = 0.0;
		if (p.getUsluga()) {
			cijenaKanalizacije = potrosnja
					* param.getCijenaKanalizacijePoKubiku();
		}
		Double ukupno = cijenaKanalizacije + cijenaVoda;
		Double cijenaKsaPDV = cijenaKanalizacije + cijenaKanalizacije
				* param.getStopaPdv();
		Double cijenaVsaPDV = cijenaVoda + cijenaVoda * param.getStopaPdv();
		Double ukupnoSaPDV = cijenaVsaPDV + cijenaKsaPDV;
		Racuni r = new Racuni();
		r.setCijenaKanalizacije(cijenaKanalizacije);
		r.setCijenaKanalizacijeSaPdv(cijenaKsaPDV);
		r.setCijenaVoda(cijenaVoda);
		r.setCijenaVodaSaPdv(cijenaVsaPDV);
		r.setDatumKreacije(Calendar.getInstance().getTime());
		r.setFisknaCijenaZaKoristenjeUsluga(fixnaCijenaZaKoristenjeUsluga);
		r.setOcitanja(o);
		r.setPotrosac(p);
		if (p.getUsluga()) {
			r.setPotrosnjaZaKoristenjeKanalizacije(potrosnja);
		} else {
			r.setPotrosnjaZaKoristenjeKanalizacije(0.0);
		}
		r.setPvnZaKoristenjeVoda(param.getPvnZaKoristenjeVoda());
		r.setPvnZaZastituVoda(param.getPvnZaZastituVoda());
		r.setUkupnaCijena(ukupno);
		r.setUkupnaCijenaSaPdv(ukupnoSaPDV);

		return r;
	}

	public void snimiRacune(List<Racuni> racuni, List<Ocitanja> ocitanja, OcitanjaService o) {
		
		//ocitanju za koje je racun obracunat access polje postavlja se na false
		for (Ocitanja ocitanja1 : ocitanja) {
			ocitanja1.setAccess(Boolean.FALSE);
			o.modifyOcitanja(ocitanja1);
		}
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
			String prezime, int sifraVodomjera) {
		PotrosacService pService = new PotrosacService();
		List<Potrosac> pList = pService.dajPotrosaceZaRacun(ime, prezime,
				sifraVodomjera);
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		RacuniDAO dao = new RacuniDAO();
		dao.setSession(session);
		// Pretraga po Datumu i ID
		List<Racuni> rList = dao.finByDateId(datumKreacije, id);
		// Pretraga po potrosacu
		List<Racuni> rList2 = new ArrayList();
		if (!pList.isEmpty()) {
			for (Potrosac p : pList) {
				List<Racuni> temp = dao.findByPotrosac(p);
				if (!temp.isEmpty()) {
					rList2.add(temp.get(0));
				}
			}
		}
		session.getTransaction().commit();
		

		if (rList.isEmpty() && rList2.isEmpty()) {
			throw new IllegalArgumentException(
					"Racuni za unesene parametre ne postoje");
		} else if (rList.isEmpty()) {
			return rList2;
		} else if (rList2.isEmpty()) {
			return rList;
		} else {
			List<Racuni> temp = new ArrayList();
			for (Racuni r1 : rList) {
				for (Racuni r2 : rList2) {
					if (r1.getId() == r2.getId()) {
						temp.add(r1);
					}
				}
			}
			if (temp.isEmpty()) {
				throw new IllegalArgumentException(
						"Racuni za unesene parametre ne postoje");
			} else {
				return temp;
			}
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
			if ("Pausalni".equals(potrosac.getKategorija())) {

				if (potrosac.getAktivnost()) {

					pausalci.add(potrosac);
				}
			}
		}

		for (Potrosac potrosac : pausalci) {
			try {
				Ocitanja p = servis.getOcitanjeForRacuni(odMjesec, godina,
						potrosac);
			} catch (Exception e) {
				Ocitanja o = new Ocitanja();
				o.setPotrosacByIdPotrosaca(potrosac);
				o.setMjesec(odMjesec);
				o.setGodina(godina);
				servis.createNewOcitanja(o);
			}
			try {
				Ocitanja p = servis.getOcitanjeForRacuni(doMjesec, godina,
						potrosac);
			} catch (Exception e) {
				Ocitanja o = new Ocitanja();
				o.setPotrosacByIdPotrosaca(potrosac);
				o.setMjesec(doMjesec);
				o.setGodina(godina);
				servis.createNewOcitanja(o);
			}

		}
	}
}
