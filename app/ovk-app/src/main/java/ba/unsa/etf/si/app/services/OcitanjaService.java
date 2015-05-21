package ba.unsa.etf.si.app.services;


import ba.unsa.etf.si.app.dao.OcitanjaDAO;

import ba.unsa.etf.si.app.entity.Ocitanja;
import java.util.ArrayList;
import java.util.List;


import org.hibernate.Session;


public class OcitanjaService {
	private OcitanjaDAO dao;
	private Session session;
	
	
	public void setSession(Session session) {
		this.session = session;
	}
        
        // Temp constructor. Potrebno ukinuti Konstruktor koji prima session
        public OcitanjaService(){}
        
	public OcitanjaService(Session session) {
		
		dao = new OcitanjaDAO();
		dao.setSession(session);
		this.session = session;
		
	}
	
	
	public boolean kreirajOcitanja(Ocitanja o)
	{	try{
			
			dao = new OcitanjaDAO();
			dao.setSession(session);
			session.beginTransaction();
			dao.save(o);
			session.getTransaction().commit();
			
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
			
			dao = new OcitanjaDAO();
			dao.setSession(session);
			session.beginTransaction();
			dao.save(o);
			session.getTransaction().commit();
			
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
		try{
		
		dao = new OcitanjaDAO();
		dao.setSession(session);
		session.beginTransaction();
		dao.delete(o.getId());
		session.getTransaction().commit();
		
		session.close();
		return true;
		}
		catch(Exception ex)
		{
			return false;
		}
	}
	
	public Ocitanja pretragaPoId(Integer id) {
		dao = new OcitanjaDAO();
		dao.setSession(session);
		return dao.findById(id);
	}
	
        // temp fix
	public List<Ocitanja> pretragaOcitanja(int a,int b)
	{
	return new ArrayList<Ocitanja>();	
	}
            // temp fix
    public Ocitanja pretragaOcitanja(int intValue, int MONTH, int YEAR) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	
}
