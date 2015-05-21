package ba.unsa.etf.si.app.services;


import ba.unsa.etf.si.app.dao.OcitanjaDAO;

import ba.unsa.etf.si.app.entity.Ocitanja;


import org.hibernate.Session;


public class OcitanjaService {
	private OcitanjaDAO dao;
	private Session session;
	
	
	public void setSession(Session session) {
		this.session = session;
	}


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
	
	public void pretragaOcitanja()
	{
		
	}

	
}
