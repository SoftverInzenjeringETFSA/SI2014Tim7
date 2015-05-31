package ba.unsa.etf.si.app.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import ba.unsa.etf.si.app.entity.Korisnik;
import ba.unsa.etf.si.app.entity.Parametri;
import ba.unsa.etf.si.app.entity.Potrosac;
import ba.unsa.etf.si.app.entity.Racuni;
import java.util.Date;

public class RacuniDAO extends AbstractDAO<Racuni,Integer> {

/*
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
*/
    public List<Racuni> finByDateId(Date datumKreacije, int id) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.like("datumKreacije",datumKreacije));
        criteria.add(Restrictions.like("id",id));
        return criteria.list();  
    }

    public List<Racuni> findByPotrosac(Potrosac p) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.like("potrosac",p));
        return criteria.list();
    }
	
    public List<Racuni> finByDate(Date datumKreacije) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.like("datumKreacije",datumKreacije));
        return criteria.list();  
    }
    public List<Racuni> finById(int id) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.like("id",id));
        return criteria.list();  
    }
}
