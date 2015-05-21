/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ba.unsa.etf.si.app.services;

import ba.unsa.etf.si.app.entity.Korisnik;
import java.util.List;
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
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createNewKorisnik method, of class KorisnikService.
     */
    @org.junit.Test
    public void testCreateNewKorisnik() {
        System.out.println("createNewKorisnik");
        Korisnik k = null;
        KorisnikService instance = new KorisnikService();
        String expResult = "";
        String result = instance.createNewKorisnik(k);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getKorisnikByJMBG method, of class KorisnikService.
     */
    @org.junit.Test
    public void testGetKorisnikByJMBG() {
        System.out.println("getKorisnikByJMBG");
        String JMBG = "";
        KorisnikService instance = new KorisnikService();
        Korisnik expResult = null;
        Korisnik result = instance.getKorisnikByJMBG(JMBG);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modifyKorisnik method, of class KorisnikService.
     */
    @org.junit.Test
    public void testModifyKorisnik() {
        System.out.println("modifyKorisnik");
        Korisnik k = null;
        KorisnikService instance = new KorisnikService();
        instance.modifyKorisnik(k);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteKorisnik method, of class KorisnikService.
     */
    @org.junit.Test
    public void testDeleteKorisnik() {
        System.out.println("deleteKorisnik");
        Korisnik k = null;
        KorisnikService instance = new KorisnikService();
        instance.deleteKorisnik(k);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of closeSession method, of class KorisnikService.
     */
    @org.junit.Test
    public void testCloseSession() {
        System.out.println("closeSession");
        KorisnikService instance = new KorisnikService();
        instance.closeSession();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        List<Korisnik> expResult = null;
        List<Korisnik> result = instance.searchByCriteria(ime, prezime, jmbg, username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkLogin method, of class KorisnikService.
     */
    @org.junit.Test
    public void testCheckLogin() {
        System.out.println("checkLogin");
        String Username = "";
        String Password = "";
        KorisnikService instance = new KorisnikService();
        Boolean expResult = null;
        Boolean result = instance.checkLogin(Username, Password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
