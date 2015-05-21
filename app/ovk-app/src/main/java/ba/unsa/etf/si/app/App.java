package ba.unsa.etf.si.app;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import ba.unsa.etf.si.app.dao.OcitanjaDAO;
import ba.unsa.etf.si.app.dao.PotrosacDAO;
import ba.unsa.etf.si.app.entity.Ocitanja;
import ba.unsa.etf.si.app.entity.Potrosac;
import ba.unsa.etf.si.app.services.KorisnikService;
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
        
        
        //instanca dao klase i proslijedjivanje sesije
    	PotrosacDAO dao1 = new PotrosacDAO();
    	OcitanjaDAO dao = new OcitanjaDAO();
    	dao1.setSession(session);
    	dao.setSession(session);
    	//vraca listu svih korisnika
    	List<Potrosac> svi = new ArrayList<Potrosac>();
    	svi = dao1.findAll();
    	Ocitanja o = new Ocitanja();
    	o.setGodina(2012);
    	o.setAccess(true);
    	o.setMjesec(12);
    	o.setPotrosacByIdPotrosaca(svi.get(0));
    	o.setPotrosacBySifraVodomjera(svi.get(0));
    	dao.save(o);
    	//commit, obavezno poslije svake komunikacije s bazom
    	session.getTransaction().commit();
        
        //zatvaranje sesije
        session.close();
        HibernateUtil.getSessionFactory().close();*/
       
    }
}
