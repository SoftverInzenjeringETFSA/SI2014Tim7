package ba.unsa.etf.si.app.dao;

<<<<<<< HEAD


import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import ba.unsa.etf.si.app.entity.Ocitanja;

public class OcitanjaDAO extends AbstractDAO<Ocitanja, Integer> {
	
    private Session session;
    
    public void setSession(Session s){
            this.session = s;
    }
    
    
    public List<Ocitanja> PreuzmiSveRacune(){
    	
            return null;
    }

    public boolean DodajParametre(Ocitanja o) {
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
	
	
	
	
=======
import ba.unsa.etf.si.app.entity.Ocitanja;

public class OcitanjaDAO extends AbstractDAO<Ocitanja,Integer>{
>>>>>>> origin/master
	
}
