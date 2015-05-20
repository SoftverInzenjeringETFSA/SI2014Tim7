package ba.unsa.etf.si.app.services;


import ba.unsa.etf.si.app.dao.OcitanjaDAO;
import ba.unsa.etf.si.app.entity.Ocitanja;
import ba.unsa.etf.si.app.entity.Potrosac;
import ba.unsa.etf.si.app.util.HibernateUtil;

import org.hibernate.Session;

public class OcitanjaService {
	public boolean kreirajOcitanja(Potrosac TMPpotrosacBySifraVodomjera, Potrosac TMPpotrosacByIdPotrosaca, Double TMPpotrosnja, Integer TMPgodina, Integer TMPmjesec, Boolean TMPaccess)
	{	
		
		/*Kreira se obracun sa primljenim parametrima i stavlja se na bazu*/
		
		
		
		
		try{
		Session session = HibernateUtil.getSessionFactory().openSession(); 
		
		OcitanjaDAO dao = new OcitanjaDAO();
        
        dao.setSession(session);
		
        
        //Kreira se novo ocitanje i postavljaju se parametri preko setera
		Ocitanja o = new Ocitanja();
		
		o.setPotrosacBySifraVodomjera(TMPpotrosacBySifraVodomjera);
		o.setPotrosacByIdPotrosaca(TMPpotrosacByIdPotrosaca);
		o.setGodina(TMPgodina);
		o.setMjesec(TMPmjesec);
		o.setPotrosnja(TMPpotrosnja);
		o.setAccess(TMPaccess);
		
        dao.dodajOcitanja(o);
        
		session.close();
		
		return true;
		}
		catch(Exception ex)
		{
			return false;
		}
	}
	
	public boolean modificirajOcitanja(Ocitanja o)
	{	
		return true;
	} 
	
	public boolean obrisiOcitanja(Ocitanja o)
	{	
		return true;
	}
	
	public void pretragaOcitanja()
	{
		
	}
	
	
}
