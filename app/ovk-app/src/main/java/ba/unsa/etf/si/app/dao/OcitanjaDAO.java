package ba.unsa.etf.si.app.dao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

import ba.unsa.etf.si.app.entity.Korisnik;
import ba.unsa.etf.si.app.entity.Ocitanja;

public class OcitanjaDAO extends AbstractDAO<Ocitanja, Integer> {
	
    private Session session;
    

    public boolean dodajOcitanja(Ocitanja o) {
            try {
                    
            Transaction t = session.beginTransaction();
            session.save(o);
            t.commit();
            
            return true;
            }
            catch(Exception e){
                    return false;
            }            
    }
    
	
    public List<Ocitanja> dajOcitanja() {  
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.like("access",0).ignoreCase());     
        return criteria.list();
    }
    
	/*public List<Ocitanja> findByMjesecGodinaSifraVodomjera(Int month, Int year,Int sifraVodomjera) {  
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.like("ime","%" + ime + "%").ignoreCase());
        criteria.add(Restrictions.like("prezime","%" + prezime + "%").ignoreCase());
        criteria.add(Restrictions.like("jmbg","%" + jmbg + "%").ignoreCase());
        return criteria.list();  
    }  */
    
}
