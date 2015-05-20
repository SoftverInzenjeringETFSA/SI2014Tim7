package ba.unsa.etf.app.services;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;



import ba.unsa.etf.si.app.dao.RacuniDAO;
import ba.unsa.etf.si.app.entity.Parametri;
import ba.unsa.etf.si.app.entity.Racuni;
import ba.unsa.etf.si.app.util.HibernateUtil;

public class ObracunService {
	
	private Session s;
	private RacuniDAO dao;
	
	
	public ObracunService(){
		 dao = new RacuniDAO();
	}

		public static double getCijenaProizvodnje() {
		return cijenaProizvodnje;
	}

	public static void setCijenaProizvodnje(double cijenaProizvodnje) {
		ObracunService.cijenaProizvodnje = cijenaProizvodnje;
	}

	public static double getCijenaOdvodjenja() {
		return cijenaOdvodjenja;
	}

	public static void setCijenaOdvodjenja(double cijenaOdvodjenja) {
		ObracunService.cijenaOdvodjenja = cijenaOdvodjenja;
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

	public static double getFiksniBrojKubika() {
		return fiksniBrojKubika;
	}

	public static void setFiksniBrojKubika(double fiksniBrojKubika) {
		ObracunService.fiksniBrojKubika = fiksniBrojKubika;
	}

	public static double getStopaPDV() {
		return stopaPDV;
	}

	public static void setStopaPDV(double stopaPDV) {
		ObracunService.stopaPDV = stopaPDV;
	}

		public static double cijenaProizvodnje;
		public static double cijenaOdvodjenja;
		public static double PVNKoristenja;
		public static double PVNZastite;
		public static double fiksniBrojKubika;
		public static double stopaPDV;
		
		
		
		public void formirajRacune(Date pocetni, Date krajnji){
			 
		}
		
		public boolean snimiRacune(){
			return true;
		}
		public void printajRacune(){
			
		}
		
		public boolean modificirajRacun(Racuni racun){
			return true;
		}
		
		public void izbrisiRacun(Racuni racun){
			dao.delete(racun.getId());
		}
		
		
		
		
		
		
}
