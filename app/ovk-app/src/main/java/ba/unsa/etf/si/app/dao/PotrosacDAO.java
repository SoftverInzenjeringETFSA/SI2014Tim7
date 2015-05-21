package ba.unsa.etf.si.app.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import ba.unsa.etf.si.app.entity.Korisnik;
import ba.unsa.etf.si.app.entity.Potrosac;

public class PotrosacDAO extends AbstractDAO<Potrosac,Integer> {
	public List<Potrosac> findByImePrezimeJMBG(String ime, String prezime,String jmbg) {  
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.like("ime","%" + ime + "%").ignoreCase());
        criteria.add(Restrictions.like("prezime","%" + prezime + "%").ignoreCase());
        criteria.add(Restrictions.like("jmbg","%" + jmbg + "%").ignoreCase());
        return criteria.list();  
    } 
    

}
