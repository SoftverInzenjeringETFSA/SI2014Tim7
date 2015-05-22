package ba.unsa.etf.si.app.dao;

import ba.unsa.etf.si.app.entity.Korisnik;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class KorisnikDAO extends AbstractDAO<Korisnik,Integer>{
	public List<Korisnik> findByImePrezimeJMBG(String ime, String prezime,String jmbg,String username) {  
            Criteria criteria = getSession().createCriteria(getPersistentClass());
            criteria.add(Restrictions.like("ime","%" + ime + "%").ignoreCase());
            criteria.add(Restrictions.like("prezime","%" + prezime + "%").ignoreCase());
            criteria.add(Restrictions.like("jmbg","%" + jmbg + "%").ignoreCase());
            criteria.add(Restrictions.like("username","%" + username + "%").ignoreCase());
            return criteria.list();  
        } 
        
        
        public List<Korisnik> findByFullUsernameJMBG(String username,String jmbg){
            Criteria criteria = getSession().createCriteria(getPersistentClass());
            criteria.add(Restrictions.like("jmbg",jmbg).ignoreCase());
            criteria.add(Restrictions.like("username",username).ignoreCase());
            return criteria.list();  
        }
        
        public List<Korisnik> findByFullJMBG(String jmbg){
            Criteria criteria = getSession().createCriteria(getPersistentClass());
            criteria.add(Restrictions.like("jmbg",jmbg).ignoreCase());
            return criteria.list();  
        }
        
        public List<Korisnik> findByFullUsername(String username){
            Criteria criteria = getSession().createCriteria(getPersistentClass());
            criteria.add(Restrictions.like("username",username).ignoreCase());
            return criteria.list();  
        }   
}
