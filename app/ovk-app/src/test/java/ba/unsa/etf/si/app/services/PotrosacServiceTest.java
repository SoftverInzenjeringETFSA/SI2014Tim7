package ba.unsa.etf.si.app.services;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Session;
import org.junit.BeforeClass;
import org.junit.Test;

import ba.unsa.etf.si.app.entity.Potrosac;
import ba.unsa.etf.si.app.util.HibernateUtil;

public class PotrosacServiceTest {
	private static Potrosac potrosac;
	@Test(expected=IllegalArgumentException.class)
	public void testCreateNewPotrosac() {
		PotrosacService potrosaci = new PotrosacService();
		potrosac = new Potrosac();
		potrosac.setIme("Emina");
		potrosac.setPrezime("Muharemovic");
		potrosac.setJmbg("2709992176217");
		potrosac.setTelefon("061/111-222");
		potrosac.setBrojClanova("4");
		potrosac.setKategorija("Sa vodomjerom");
		potrosac.setSifraVodomjera(3);
		potrosac.setUsluga(true);
		potrosac.setAktivnost(true);
		potrosac.setHidden(true);
		potrosaci.createNewPotrosac(potrosac);
	}
	
	@Test
	public void testValidateJMBG() {
		PotrosacService potrosaci = new PotrosacService();
		assertTrue(potrosaci.validateJMBG("2709992176217"));
		assertFalse(potrosaci.validateJMBG("2709"));
	}

	@Test
	public void testSearchByCriteria() {
		PotrosacService potrosaci = new PotrosacService();
		List<Potrosac> rez=potrosaci.searchByCriteria("Emina", "Muharemovic", "2709992176217");
		assertEquals(rez.size(), 1);	
	}

	@Test
	public void testModifyPotrosac() {
		PotrosacService potrosaci = new PotrosacService();
		List<Potrosac> rez=potrosaci.searchByCriteria("Emina", "Muharemovic", "2709992176217");
		rez.get(0).setAdresa("Adresa 4");
		potrosaci.modifyPotrosac(rez.get(0));
		assertEquals(rez.get(0).getAdresa(),"Adresa 4");
	}

	@Test
	public void testDeletePotrosac() {
		PotrosacService potrosaci = new PotrosacService();
		List<Potrosac> rez=potrosaci.searchByCriteria("Armin", "Klacar", "2309992170008");
		potrosaci.deletePotrosac(rez.get(0));
		assertEquals(rez.size(), 1);		
	}
	
	@Test
	public void testGetPotrosacByJMBG() {
		PotrosacService potrosaci = new PotrosacService();
		List<Potrosac> rez=potrosaci.searchByCriteria("Emina", "Muharemovic", "2709992176217");
		assertEquals(rez.get(0).getJmbg(),"2709992176217");	
	}

	@Test
	public void testMainSearch() {
		PotrosacService potrosaci = new PotrosacService();
		List<Potrosac> rez = potrosaci.mainSearch("Emina", "Muharemovic","2709992176217","Adresa 4","3");
		assertEquals(rez.size(), 1);	
	}

	@Test
	public void testDajPotrosaceZaRacun() {
		PotrosacService potrosaci = new PotrosacService();
		List<Potrosac> rez=potrosaci.dajPotrosaceZaRacun("Emina", "Muharemovic", 3);
		assertEquals(rez.size(), 1);
	}

	@Test
	public void testDajSvePotrosace() {
		PotrosacService potrosaci = new PotrosacService();
		List<Potrosac> rezultati = potrosaci.dajSvePotrosace();
		assertEquals(rezultati.size(), 4);
		
	}

}
