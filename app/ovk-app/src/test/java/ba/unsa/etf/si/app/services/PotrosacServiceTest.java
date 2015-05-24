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
	private static Potrosac potrosac1;

	@Test
	public void testCreateNewPotrosac() {
		PotrosacService potrosaci = new PotrosacService();
		potrosac = new Potrosac();
		potrosac.setIme("Emina");
		potrosac.setPrezime("Muharemovic");
		potrosac.setJmbg("2709992176217");
		potrosac.setSifraVodomjera(3);
		potrosac.setKategorija("pausalni");
		potrosaci.createNewPotrosac(potrosac);
		
		potrosac = potrosaci.getPotrosacByJMBG("2709992176217");
		assertNotNull(potrosac);
		
		potrosaci.hardDeletePotrosac(potrosac);
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
		
		potrosac = new Potrosac();
		potrosac.setIme("EminaXYZ");
		potrosac.setPrezime("Muharemovic");
		potrosac.setJmbg("2709992176217");
		potrosac.setSifraVodomjera(3);
		potrosac.setKategorija("pausalni");
		potrosaci.createNewPotrosac(potrosac);
	
		potrosac = new Potrosac();
		potrosac.setIme("EminaXYZ");
		potrosac.setPrezime("Muharemovic");
		potrosac.setJmbg("2309992170008");
		potrosac.setSifraVodomjera(4);
		potrosac.setKategorija("pausalni");
		potrosaci.createNewPotrosac(potrosac);
		
		List<Potrosac> rezultati = potrosaci.searchByCriteria("EminaXYZ", "", "");
		assertEquals(rezultati.size(), 2);
		
		for (Potrosac p : rezultati) {
			potrosaci.hardDeletePotrosac(p);
		}
	}

	@Test
	public void testModifyPotrosac() {
		PotrosacService potrosaci = new PotrosacService();
		
		potrosac = new Potrosac();
		potrosac.setIme("Ines");
		potrosac.setPrezime("Hadzic");
		potrosac.setJmbg("2709992176217");
		potrosac.setSifraVodomjera(34);
		potrosac.setKategorija("pausalni");
		potrosaci.createNewPotrosac(potrosac);
		potrosac.setIme("Hana");
		potrosaci.modifyPotrosac(potrosac);
		assertEquals(potrosac.getIme(),"Hana");
		potrosaci.hardDeletePotrosac(potrosac);	
	}

	@Test
	public void testDeletePotrosac() {
		PotrosacService potrosaci = new PotrosacService();
		
		potrosac= new Potrosac();
		potrosac.setIme("Ines");
		potrosac.setPrezime("Hadzic");
		potrosac.setJmbg("2709992176217");
		potrosac.setSifraVodomjera(34);
		potrosac.setKategorija("pausalni");
		potrosaci.createNewPotrosac(potrosac);
		potrosaci.deletePotrosac(potrosac);
		
		potrosac1= new Potrosac();
		potrosac1.setIme("Ines");
		potrosac1.setPrezime("Balic");
		potrosac1.setJmbg("2309992170008");
		potrosac1.setSifraVodomjera(7);
		potrosac1.setKategorija("pausalni");
		potrosaci.createNewPotrosac(potrosac1);
		assertEquals(potrosac.getIme(),potrosac1.getIme());
	
		potrosaci.hardDeletePotrosac(potrosac);	
		potrosaci.hardDeletePotrosac(potrosac1);	
	}
	@Test
	public void testHardDeletePotrosac(){
		PotrosacService potrosaci = new PotrosacService();
		
		potrosac= new Potrosac();
		potrosac.setIme("Ines");
		potrosac.setPrezime("Hadzic");
		potrosac.setJmbg("2709992176217");
		potrosac.setSifraVodomjera(34);
		potrosac.setKategorija("pausalni");
		potrosaci.createNewPotrosac(potrosac);
		potrosaci.hardDeletePotrosac(potrosac);
		assertNotNull(potrosac);
	}

	@Test
	public void testGetPotrosacByJMBG() {
		PotrosacService potrosaci = new PotrosacService();
		potrosac= new Potrosac();
		potrosac.setIme("Ines");
		potrosac.setPrezime("Hadzic");
		potrosac.setJmbg("2709992176217");
		potrosac.setSifraVodomjera(34);
		potrosac.setKategorija("pausalni");
		potrosaci.createNewPotrosac(potrosac);
		assertEquals(potrosac.getJmbg(),"2709992176217");
		potrosaci.hardDeletePotrosac(potrosac);	
		
	}

	@Test
	public void testMainSearch() {
		PotrosacService potrosaci = new PotrosacService();
		
		potrosac = new Potrosac();
		potrosac.setIme("EminaXYZ");
		potrosac.setPrezime("Muharemovic");
		potrosac.setJmbg("2709992176217");
		potrosac.setSifraVodomjera(3);
		potrosac.setKategorija("pausalni");
		potrosaci.createNewPotrosac(potrosac);
	
		potrosac1 = new Potrosac();
		potrosac1.setIme("EminaXYZ");
		potrosac1.setPrezime("Muharemovic");
		potrosac1.setJmbg("2309992170008");
		potrosac1.setSifraVodomjera(4);
		potrosac1.setKategorija("pausalni");
		potrosaci.createNewPotrosac(potrosac1);
		
		List<Potrosac> rez = potrosaci.mainSearch("Pero", "Peric", "0101006500006","Kiseljak","3");
		assertEquals(rez.size(), 0);
		
		potrosaci.hardDeletePotrosac(potrosac);
		potrosaci.hardDeletePotrosac(potrosac1);
		
	}

	@Test
	public void testDajPotrosaceZaRacun() {
		PotrosacService potrosaci = new PotrosacService();
		
		potrosac = new Potrosac();
		potrosac.setIme("EminaXYZ");
		potrosac.setPrezime("Muharemovic");
		potrosac.setJmbg("2709992176217");
		potrosac.setSifraVodomjera(3);
		potrosac.setKategorija("pausalni");
		potrosaci.createNewPotrosac(potrosac);
		List<Potrosac> rez=potrosaci.dajPotrosaceZaRacun("EminaXYZ", "Muharemovic", 3);
		assertEquals(rez.size(), 1);
		
		for (Potrosac p : rez) {
			potrosaci.hardDeletePotrosac(p);
		}
		
	
	}

	@Test
	public void testDajSvePotrosace() {
		PotrosacService potrosaci = new PotrosacService();
		
		potrosac = new Potrosac();
		potrosac.setIme("EminaXYZ");
		potrosac.setPrezime("Muharemovic");
		potrosac.setJmbg("2709992176217");
		potrosac.setSifraVodomjera(3);
		potrosac.setKategorija("pausalni");
		potrosaci.createNewPotrosac(potrosac);
	
		potrosac = new Potrosac();
		potrosac.setIme("EminaXYZ");
		potrosac.setPrezime("Muharemovic");
		potrosac.setJmbg("2309992170008");
		potrosac.setSifraVodomjera(4);
		potrosac.setKategorija("pausalni");
		potrosaci.createNewPotrosac(potrosac);
		
		List<Potrosac> rezultati = potrosaci.dajSvePotrosace();
		assertEquals(rezultati.size(), 2);
		
		for (Potrosac p : rezultati) {
			potrosaci.hardDeletePotrosac(p);
		}
	}

}
