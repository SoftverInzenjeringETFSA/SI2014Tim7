package ba.unsa.etf.si.app.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import ba.unsa.etf.si.app.entity.Korisnik;
import ba.unsa.etf.si.app.entity.Parametri;
import ba.unsa.etf.si.app.entity.Racuni;

public class RacuniDAO extends AbstractDAO<Racuni,Integer> {

	
	private Session session;
	
	public void setSession(Session s){
		this.session = s;
	}
	public List<Racuni> PreuzmiSveRacune(){
		return null;
	}
	
	public List<Racuni> pretragaRacuna(int sifra, int potrosac, String ime, String prezime) {  
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.like("ime","%" + ime + "%").ignoreCase());
        criteria.add(Restrictions.like("prezime","%" + prezime + "%").ignoreCase());
        criteria.add(Restrictions.like("id",sifra).ignoreCase());
        return criteria.list();  
    }  
	
	public void closeSession(){
		session.close();
	}
	
}
