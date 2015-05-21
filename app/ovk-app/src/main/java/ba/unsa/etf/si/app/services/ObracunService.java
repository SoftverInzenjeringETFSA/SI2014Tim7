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
import ba.unsa.etf.si.app.entity.Racuni;
import ba.unsa.etf.si.app.util.HibernateUtil;

public class ObracunService {
	
	private Session s;
	private RacuniDAO dao;
	
	
	public ObracunService(){
		 dao = new RacuniDAO();
                 ParametriService params = new ParametriService();
		 Parametri parametri = params.dajParametre();
		 ObracunService.setCijenaKanalizacijePoKubiku(parametri.getCijenaKanalizacijePoKubiku());
		 ObracunService.setCijenaVodePoKubiku(parametri.getCijenaVodePoKubiku());
		 ObracunService.setFiksnaCijena(parametri.getFiksnaCijena());
		 ObracunService.setPVNKoristenja(parametri.getPvnZaKoristenjeVoda());
		 ObracunService.setPVNZastite(parametri.getPvnZaZastituVoda());
		 ObracunService.setStopaPDV(parametri.getStopaPdv());
		 
	}



		public static double getCijenaVodePoKubiku() {
		return cijenaVodePoKubiku;
	}

	public static void setCijenaVodePoKubiku(double cijenaVodePoKubiku) {
		ObracunService.cijenaVodePoKubiku = cijenaVodePoKubiku;
	}

	public static double getCijenaKanalizacijePoKubiku() {
		return cijenaKanalizacijePoKubiku;
	}

	public static void setCijenaKanalizacijePoKubiku(
			double cijenaKanalizacijePoKubiku) {
		ObracunService.cijenaKanalizacijePoKubiku = cijenaKanalizacijePoKubiku;
	}

	public static double getPVNKoristenja() {
		return PVNKoristenja;
	}

	public static void setPVNKoristenja(double pVNKoristenja) {
		PVNKoristenja = pVNKoristenja;
	}

	public static double getPVNZastite() {
		return PVNZastite;
	}

	public static void setPVNZastite(double pVNZastite) {
		PVNZastite = pVNZastite;
	}

	public static double getFiksniBrojKubikaVodaZaPausalce() {
		return fiksniBrojKubikaVodaZaPausalce;
	}

	public static void setFiksniBrojKubikaVodaZaPausalce(
			double fiksniBrojKubikaVodaZaPausalce) {
		ObracunService.fiksniBrojKubikaVodaZaPausalce = fiksniBrojKubikaVodaZaPausalce;
	}

	public static double getFiksniBrojKubikaKanalizacijaZaPausalce() {
		return fiksniBrojKubikaKanalizacijaZaPausalce;
	}

	public static void setFiksniBrojKubikaKanalizacijaZaPausalce(
			double fiksniBrojKubikaKanalizacijaZaPausalce) {
		ObracunService.fiksniBrojKubikaKanalizacijaZaPausalce = fiksniBrojKubikaKanalizacijaZaPausalce;
	}

	public static double getStopaPDV() {
		return stopaPDV;
	}

	public static void setStopaPDV(double stopaPDV) {
		ObracunService.stopaPDV = stopaPDV;
	}

	public static double getFiksnaCijena() {
		return fiksnaCijena;
	}

	public static void setFiksnaCijena(double fiksnaCijena) {
		ObracunService.fiksnaCijena = fiksnaCijena;
	}



		public static double cijenaVodePoKubiku;
		public static double cijenaKanalizacijePoKubiku;
		public static double PVNKoristenja;
		public static double PVNZastite;
		public static double fiksniBrojKubikaVodaZaPausalce;
		public static double fiksniBrojKubikaKanalizacijaZaPausalce;
		public static double stopaPDV;
		public static double fiksnaCijena;
		
		
		
		public List<Racuni> formirajRacune(Calendar pocetni, Calendar krajnji){
			 List<Racuni> racuni = new ArrayList<Racuni>();
			 OcitanjaService servis = new OcitanjaService();
			 List<Ocitanja> ocitanja = servis.pretragaOcitanja(pocetni.MONTH, pocetni.YEAR);
			  
			 
			 for(int i=0;i<ocitanja.size();i++){
				 Ocitanja o = servis.pretragaOcitanja(ocitanja.get(i).getPotrosacByIdPotrosaca().getId().intValue(),krajnji.MONTH, pocetni.YEAR);
				 double vrijednost = o.getPotrosnja() - ocitanja.get(i).getPotrosnja();
				 Racuni racun = obracunajRacun(vrijednost);
				 racun.setPotrosac(ocitanja.get(i).getPotrosacByIdPotrosaca());
				 racun.setOcitanja(ocitanja.get(i));
				 			 
				 racuni.add(racun);
				 				 
			 }
			
			 return racuni;
		}
		
		
		
		private Racuni obracunajRacun(double vrijednost) {
			 Racuni racun = new Racuni();
			 double cijenaKanalizacije = vrijednost*cijenaKanalizacijePoKubiku;
			 double cijenaVode = vrijednost*cijenaVodePoKubiku;
			 double cijenaKanalizacijeSaPDV = cijenaKanalizacije + cijenaKanalizacije*stopaPDV;
			 double cijenaVodeSaPDV = cijenaVode + cijenaVode*stopaPDV;
			 double ukupnaCijena = (cijenaVodePoKubiku+cijenaKanalizacijePoKubiku+PVNKoristenja+PVNZastite)*vrijednost+fiksnaCijena;
			 double ukupnaCijenaSaPDV = ukupnaCijena+ ukupnaCijena*stopaPDV;
			 // double cijenaZaKoristenjeVode = vrijednost*PVNKoristenja;
			 racun.setCijenaKanalizacije(cijenaKanalizacije);
			 racun.setCijenaKanalizacijeSaPdv(cijenaKanalizacijeSaPDV);
			 racun.setCijenaVoda(cijenaVode);
			 racun.setCijenaVodaSaPdv(cijenaVodeSaPDV);
			 racun.setFisknaCijenaZaKoristenjeUsluga(fiksnaCijena);
			 racun.setPotrosnjaZaKoristenjeKanalizacije(vrijednost);
			 racun.setPotrosnjaZaKoristenjeVoda(vrijednost);
			 racun.setPvnZaKoristenjeVoda(PVNKoristenja);
			 racun.setPvnZaZastituVoda(PVNZastite);
			 racun.setUkupnaCijena(ukupnaCijena);
			 racun.setUkupnaCijenaSaPdv(ukupnaCijenaSaPDV);
			 
			 return racun;
			 
			 
		}



		public boolean snimiRacune(List<Racuni> racuni){
			try{
				s = HibernateUtil.getSessionFactory().openSession();
				Transaction t = s.beginTransaction();
				for( int i=0; i< racuni.size(); i++){
				s.save(racuni.get(i));
				
			}
				t.commit();
				s.close();
				return true;
				
				}
				catch(Exception e){
					return false;
				}
				
			
		}
				
		public boolean modificirajRacun(Racuni racun){
			return true;
		}
		
		public void izbrisiRacun(Racuni racun){
			dao.delete(racun.getId());
		}
		
		
		
		
		
		
}
