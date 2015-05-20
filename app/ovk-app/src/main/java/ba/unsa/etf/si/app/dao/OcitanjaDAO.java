package ba.unsa.etf.si.app.dao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

import ba.unsa.etf.si.app.entity.Ocitanja;

public class OcitanjaDAO extends AbstractDAO<Ocitanja, Integer> {
	
    private Session session;
    
    public void setSession(Session s){
            this.session = s;
    }
    
    
    public List<Ocitanja> preuzmiSveRacune(){
    	
            return null;
    }

    public boolean dodajParametre(Ocitanja o) {
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
    
    
    public void closeSession(){
            session.close();
    }
	
    public List<Ocitanja> dajOcitanja() {  
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.like("access",0).ignoreCase());     
        return criteria.list();  
    }  
    
}
