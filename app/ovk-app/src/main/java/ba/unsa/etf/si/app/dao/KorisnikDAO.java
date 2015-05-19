package ba.unsa.etf.si.app.dao;

import ba.unsa.etf.si.app.entity.Korisnik;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class KorisnikDAO extends AbstractDAO<Korisnik,Integer>{
	public List<Korisnik> findByImePrezime(String ime, String prezime) {  
            Criteria criteria = getSession().createCriteria(getPersistentClass());
            criteria.add(Restrictions.like("ime","%" + ime + "%").ignoreCase());
            criteria.add(Restrictions.like("prezime","%" + prezime + "%").ignoreCase());
            return criteria.list();  
        }  
}
