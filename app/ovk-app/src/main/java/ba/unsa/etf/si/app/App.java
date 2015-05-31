package ba.unsa.etf.si.app;



import ba.etf.unsa.si.app.ui.Login;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import ba.unsa.etf.si.app.dao.OcitanjaDAO;
import ba.unsa.etf.si.app.dao.PotrosacDAO;
import ba.unsa.etf.si.app.entity.Korisnik;
import ba.unsa.etf.si.app.entity.Ocitanja;
import ba.unsa.etf.si.app.entity.Potrosac;
import ba.unsa.etf.si.app.services.KorisnikService;
import ba.unsa.etf.si.app.services.ObracunService;
import ba.unsa.etf.si.app.services.OcitanjaService;
import ba.unsa.etf.si.app.services.PotrosacService;
import ba.unsa.etf.si.app.util.HibernateUtil;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {   
        //pokretanje login forme
        Login login = new Login();
        login.setVisible(true);
        /*
        ObracunService s = new ObracunService();
        Date x = new Date();
        Date y = new Date();
        DateFormat format = new SimpleDateFormat("MM/yyyy");
        try{
        x = format.parse("10/2010");
        y = format.parse("12/2010");
        
        } catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        s.formirajRacune(x, y);
        */
        
        
       /*PotrosacService serv = new PotrosacService();
       Potrosac k = new Potrosac();
       k.setJmbg("0611992177631");
       Boolean test = serv.validateJMBG(k.getJmbg());
       System.out.println(test);*/
        //primjer koristenja dao klase
        
        /*KorisnikService s = new KorisnikService();
        List<Korisnik> list = s.searchByCriteria("", "", "2309", "");
        System.out.println(list.size());*/
        //otvaranje sesije i pocetak transakcije, potrebno za svaku komunikaciju sa bazom
    	/*Session session = HibernateUtil.getSessionFactory().openSession();
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
        session.close();*/
       
    }
}
