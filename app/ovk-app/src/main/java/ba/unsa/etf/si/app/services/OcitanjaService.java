package ba.unsa.etf.si.app.services;


import java.util.List;

import ba.unsa.etf.si.app.dao.OcitanjaDAO;
import ba.unsa.etf.si.app.entity.Ocitanja;


import ba.unsa.etf.si.app.entity.Potrosac;

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
	
	
	public Ocitanja findByMjesecGodinaId(int month, int year,int id) {  
		
		Ocitanja o = new Ocitanja();
		Potrosac p = new Potrosac();
		
		dao = new OcitanjaDAO();
		dao.setSession(session);
		
		p.setId(id);
		o.setGodina(year);
		o.setMjesec(month);
		o.setPotrosacByIdPotrosaca(p);
		
		return dao.findByExample(o).get(0);
        /*Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.like("mjesec","%" + month + "%").ignoreCase());
        criteria.add(Restrictions.like("godina","%" + year + "%").ignoreCase());
        //criteria.add(Restrictions.like("sifra_vodomjera","%" + sifraVodomjera + "%").ignoreCase());
        return criteria.list();  */
    } 
	
	
	
	public List<Ocitanja> findByMjesecGodinaId(int month, int year) {  
		
		dao = new OcitanjaDAO();
		dao.setSession(session);
		Ocitanja o = new Ocitanja();
		
		o.setGodina(year);
		o.setMjesec(month);
		
		return dao.findByExample(o);
        /*Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.like("mjesec","%" + month + "%").ignoreCase());
        criteria.add(Restrictions.like("godina","%" + year + "%").ignoreCase());
        //criteria.add(Restrictions.like("sifra_vodomjera","%" + sifraVodomjera + "%").ignoreCase());
        return criteria.list();  */
    }
	
	
}
