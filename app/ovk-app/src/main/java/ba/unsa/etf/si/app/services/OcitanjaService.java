package ba.unsa.etf.si.app.services;


import ba.unsa.etf.si.app.dao.OcitanjaDAO;
import ba.unsa.etf.si.app.entity.Ocitanja;
import ba.unsa.etf.si.app.entity.Potrosac;
import ba.unsa.etf.si.app.util.HibernateUtil;

import org.hibernate.Session;

public class OcitanjaService {
	public boolean kreirajOcitanja(Potrosac TMPpotrosacBySifraVodomjera, Potrosac TMPpotrosacByIdPotrosaca, Double TMPpotrosnja, Integer TMPgodina, Integer TMPmjesec, Boolean TMPaccess)
	{	
		try{
		Session session = HibernateUtil.getSessionFactory().openSession(); 
		
		OcitanjaDAO dao = new OcitanjaDAO();
        
        dao.setSession(session);
		
		Ocitanja o = new Ocitanja();
		o.setPotrosacBySifraVodomjera(TMPpotrosacBySifraVodomjera);
		o.setPotrosacByIdPotrosaca(TMPpotrosacByIdPotrosaca);
		o.setGodina(TMPgodina);
		o.setMjesec(TMPmjesec);
		o.setPotrosnja(TMPpotrosnja);
		o.setAccess(TMPaccess);
		
        dao.DodajParametre(o);
        
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
		try{
			Session session = HibernateUtil.getSessionFactory().openSession(); 
			
			OcitanjaDAO dao = new OcitanjaDAO();
	        
	        dao.setSession(session);
			
			o.setPotrosacBySifraVodomjera(TMPpotrosacBySifraVodomjera);
			o.setPotrosacByIdPotrosaca(TMPpotrosacByIdPotrosaca);
			o.setGodina(TMPgodina);
			o.setMjesec(TMPmjesec);
			o.setPotrosnja(TMPpotrosnja);
			o.setAccess(TMPaccess);
			
	        dao.DodajParametre(o);
	        
			session.close();
			
			return true;
			}
			catch(Exception ex)
			{
				return false;
			}
	} 
	
	public boolean obrisiOcitanja(Ocitanja o)
	{
		
		
		return true;
	}
	
	public void pretragaOcitanja()
	{
		
	}
	
	public void pretragaPoSifri(int n)
	{
		
	}
	
	
	
}
