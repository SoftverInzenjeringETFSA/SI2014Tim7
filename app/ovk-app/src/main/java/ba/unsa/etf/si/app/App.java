package ba.unsa.etf.si.app;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import ba.unsa.etf.si.app.dao.KorisnikDAO;
import ba.unsa.etf.si.app.entity.Korisnik;
import ba.unsa.etf.si.app.util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        /*
        
        //primjer koristenja dao klase
        
        //otvaranje sesije i pocetak transakcije, potrebno za svaku komunikaciju sa bazom
    	Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        //instanca dao klase i proslijedjivanje sesije
    	KorisnikDAO dao = new KorisnikDAO();
    	dao.setSession(session);
    	
    	//vraca listu svih korisnika
    	List<Korisnik> svi = new ArrayList<Korisnik>();
    	svi = dao.findAll();
    	
    	//commit, obavezno poslije svake komunikacije s bazom
    	session.getTransaction().commit();
        
        //zatvaranje sesije
        session.close();
        HibernateUtil.getSessionFactory().close();
    	*/
    }
}
