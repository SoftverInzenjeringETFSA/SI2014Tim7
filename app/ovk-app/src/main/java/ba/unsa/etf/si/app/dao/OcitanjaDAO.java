package ba.unsa.etf.si.app.dao;
import org.hibernate.Criteria;


import org.hibernate.criterion.Restrictions;

import java.util.List;


import ba.unsa.etf.si.app.entity.Ocitanja;
import ba.unsa.etf.si.app.entity.Potrosac;
import java.util.Calendar;
import java.util.Date;

public class OcitanjaDAO extends AbstractDAO<Ocitanja, Integer> {
	
	
        public List<Ocitanja> findOcitanja(int mjesec,int godina,Potrosac id){
            Criteria criteria = getSession().createCriteria(getPersistentClass());
            criteria.add(Restrictions.like("mjesec",mjesec));
            criteria.add(Restrictions.like("godina",godina));
            criteria.add(Restrictions.like("potrosacByIdPotrosaca",id));
            return criteria.list();  
        }
    
    
        public List<Ocitanja> findOcitanjaBySifraVodomjeraAccess(int sifra){
            Criteria criteria = getSession().createCriteria(getPersistentClass());
            criteria.add(Restrictions.like("sifraVodomjera",sifra));
            criteria.add(Restrictions.like("access",true));
            return criteria.list();  
        }
    
        public List<Ocitanja> findOcitanjaForDelete(int mjesec,int godina,Potrosac id){
            Criteria criteria = getSession().createCriteria(getPersistentClass());
            criteria.add(Restrictions.like("mjesec",mjesec));
            criteria.add(Restrictions.like("godina",godina));
            criteria.add(Restrictions.like("potrosacByIdPotrosaca",id));
            criteria.add(Restrictions.like("access",true));
            return criteria.list();  
        }
    
    
        public List<Ocitanja> findByDate(Date odDatuma,Date doDatuma){
            Calendar odCal = Calendar.getInstance();
            Calendar doCal = Calendar.getInstance();
            odCal.setTime(odDatuma);
            doCal.setTime(doDatuma);
         
            Criteria criteria = getSession().createCriteria(getPersistentClass());
            criteria.add(Restrictions.between("mjesec",odCal.get(odCal.MONTH)+1,doCal.get(odCal.MONTH)+1));
            criteria.add(Restrictions.between("godina",odCal.get(odCal.YEAR),doCal.get(doCal.YEAR)));
            criteria.add(Restrictions.like("access",true));
            return criteria.list();  
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
