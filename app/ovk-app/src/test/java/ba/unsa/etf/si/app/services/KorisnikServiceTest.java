/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ba.unsa.etf.si.app.services;

import ba.unsa.etf.si.app.dao.KorisnikDAO;
import ba.unsa.etf.si.app.entity.Korisnik;
import ba.unsa.etf.si.app.util.HibernateUtil;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import org.hibernate.Session;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author armin
 */
public class KorisnikServiceTest {
    
    private static Korisnik testCaseKorisnik;
    private static Korisnik testCaseKorisnik2;
    private Session session;
    private static KorisnikDAO dao;
    public KorisnikServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
   
    }
    
    @AfterClass
    public static void tearDownClass() {

    }
    
    @Before
    public void setUp() {
        Calendar cal = Calendar.getInstance();
        cal.set(2000, 10, 10);
        Date x = cal.getTime();
        testCaseKorisnik2 = new Korisnik("Armin","Klaèar","0101006500006","00AAA0001","TestAdress 2","062123452","example1@example.com",x,false,"testUsername2","testPassword2");
        KorisnikService instance = new KorisnikService();
        testCaseKorisnik2.setPassword(instance.createNewKorisnik(testCaseKorisnik2));
        testCaseKorisnik = new Korisnik("Armin","Klaèar","2709992176217","00AAA0000","TestAdress 1","062123456","example@example.com",x,true,"testUsername1","testPassword1");
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        dao = new KorisnikDAO();
        dao.setSession(session);
    }
    
    @After
    public void tearDown() {
        KorisnikService instance = new KorisnikService();
        instance.deleteKorisnik(testCaseKorisnik2);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Test of createNewKorisnik method, of class KorisnikService.
     */
    @org.junit.Test
    public void testCreateNewKorisnik() {
        System.out.println("createNewKorisnik");
        KorisnikService instance = new KorisnikService();
        instance.createNewKorisnik(testCaseKorisnik);
        List<Korisnik> s = dao.findByFullJMBG(testCaseKorisnik.getJmbg());
        instance.deleteKorisnik(testCaseKorisnik);
        assertEquals(s.get(0).getJmbg(), testCaseKorisnik.getJmbg());
    }

    /**
     * Test of getKorisnikByJMBG method, of class KorisnikService.
     */
    @org.junit.Test
    public void testGetKorisnikByJMBG() {
        System.out.println("getKorisnikByJMBG");
        String JMBG = "0101006500006";
        KorisnikService instance = new KorisnikService();
        Korisnik result = instance.getKorisnikByJMBG(JMBG);
        assertEquals(JMBG, result.getJmbg());
    }

    /**
     * Test of modifyKorisnik method, of class KorisnikService.
     */
    @org.junit.Test
    public void testModifyKorisnik() {
        System.out.println("modifyKorisnik");
        String JMBG = "0101006500006";
      
        KorisnikService instance = new KorisnikService();
        Korisnik result = instance.getKorisnikByJMBG(JMBG);
       
        result.setAdmin(Boolean.TRUE);
        instance.modifyKorisnik(result);
        
        result = instance.getKorisnikByJMBG(JMBG);
        Boolean test = result.getAdmin();
        
        result.setAdmin(Boolean.FALSE);
        instance.modifyKorisnik(result);
        
        assertEquals(test,true);
    }

    /**
     * Test of deleteKorisnik method, of class KorisnikService.
     */
    @org.junit.Test(expected=IllegalArgumentException.class)
    public void testDeleteKorisnik() {
        System.out.println("deleteKorisnik");
        Calendar cal = Calendar.getInstance();
        cal.set(2000, 10, 10);
        Date x = cal.getTime();
        KorisnikService instance = new KorisnikService();
        testCaseKorisnik = new Korisnik("Armin","Klaèar","2309992170008","00AAA0000","TestAdress 1","062123456","example@example.com",x,true,"testUsername1","testPassword1");
        instance.createNewKorisnik(testCaseKorisnik);
        instance.deleteKorisnik(testCaseKorisnik);
        Korisnik s = instance.getKorisnikByJMBG(testCaseKorisnik.getJmbg());
    }

    /**
     * Test of searchByCriteria method, of class KorisnikService.
     */
    @org.junit.Test
    public void testSearchByCriteria() {
        System.out.println("searchByCriteria");
        String ime = "";
        String prezime = "";
        String jmbg = "";
        String username = "";
        KorisnikService instance = new KorisnikService();
        List<Korisnik> result = instance.searchByCriteria(ime, prezime, jmbg, username);
        assertThat(result.isEmpty(), is(false));
    }

    /**
     * Test of checkLogin method, of class KorisnikService.
     */
    @org.junit.Test
    public void testCheckLogin() {
        System.out.println("checkLogin");
        String Username = "testUsername2";
        String Password = testCaseKorisnik2.getPassword();
        KorisnikService instance = new KorisnikService();
        Boolean expResult = false;
        Boolean result = instance.checkLogin(Username, Password);
        assertEquals(expResult, result);
    }
    
}
