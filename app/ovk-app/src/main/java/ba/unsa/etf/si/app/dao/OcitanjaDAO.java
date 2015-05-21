package ba.unsa.etf.si.app.dao;
import org.hibernate.Criteria;


import org.hibernate.criterion.Restrictions;

import java.util.List;



import ba.unsa.etf.si.app.entity.Ocitanja;

public class OcitanjaDAO extends AbstractDAO<Ocitanja, Integer> {
	
	
    public List<Ocitanja> dajOcitanja() {  
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.like("access",0).ignoreCase());     
        return criteria.list();
    }
    
}
