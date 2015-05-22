package ba.unsa.etf.si.app;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import ba.unsa.etf.si.app.dao.OcitanjaDAO;
import ba.unsa.etf.si.app.dao.PotrosacDAO;
import ba.unsa.etf.si.app.entity.Ocitanja;
import ba.unsa.etf.si.app.entity.Potrosac;
import ba.unsa.etf.si.app.services.KorisnikService;
import ba.unsa.etf.si.app.services.OcitanjaService;
import ba.unsa.etf.si.app.util.HibernateUtil;


/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {
       
        //primjer koristenja dao klase
        
        //otvaranje sesije i pocetak transakcije, potrebno za svaku komunikaciju sa bazom
    	Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        //instanca dao klase i proslijedjivanje sesije
    	PotrosacDAO dao = new PotrosacDAO();
    	dao.setSession(session);
    	//vraca listu svih korisnika
    	List<Potrosac> svi = new ArrayList<Potrosac>();
    	svi = dao.findAll();
        System.out.println(svi.get(0).getSifraVodomjera());
    	Ocitanja o = new Ocitanja();
    	o.setGodina(2012);
    	o.setAccess(true);
    	o.setMjesec(12);
        o.setPotrosacByIdPotrosaca(svi.get(0));
    	o.setSifraVodomjera(svi.get(0).getSifraVodomjera());
        System.out.println(svi.get(0).getSifraVodomjera());
        OcitanjaService x = new OcitanjaService();
        x.createNewOcitanja(o);
    	//commit, obavezno poslije svake komunikacije s bazom
    	session.getTransaction().commit();
        
        //zatvaranje sesije
        session.close();
       
    }
}
