package ba.unsa.etf.si.app.services;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import ba.unsa.etf.si.app.entity.Ocitanja;
import ba.unsa.etf.si.app.entity.Potrosac;

public class OcitanjaServiceTest {
	private static Ocitanja o;


	
	public void testGetPotrosac() {
		OcitanjaService ocitanja = new OcitanjaService();
		Potrosac p=ocitanja.getPotrosac(123);
		assertNull(p);
	}
	

	@Test
	public void testCreateNewOcitanja() {
		PotrosacService potrosaci = new PotrosacService();
		Potrosac potrosac = new Potrosac();
		potrosac.setIme("Emina");
		potrosac.setPrezime("Muharemovic");
		potrosac.setJmbg("2709992176217");
		potrosac.setSifraVodomjera(3);
		potrosac.setKategorija("pausalni");
		potrosaci.createNewPotrosac(potrosac);
		OcitanjaService ocitanja = new OcitanjaService();
		o=new Ocitanja();
		o.setGodina(2015);
		o.setMjesec(5);
		o.setPotrosacByIdPotrosaca(potrosac);
		o.setPotrosnja(123.0);
		o.setSifraVodomjera(5);
		ocitanja.createNewOcitanja(o);
		assertNotNull(o);
		ocitanja.hardDeleteOcitanja(o);
		potrosaci.hardDeletePotrosac(potrosac);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testGetId() {
		OcitanjaService ocitanja = new OcitanjaService();
		List<Ocitanja>rez=ocitanja.getId(5);
		assertNull(rez.size());
	}

	@Test
	public void testModifyOcitanja() {
		PotrosacService potrosaci = new PotrosacService();
		Potrosac potrosac = new Potrosac();
		potrosac.setIme("Emina");
		potrosac.setPrezime("Muharemovic");
		potrosac.setJmbg("2709992176217");
		potrosac.setSifraVodomjera(3);
		potrosac.setKategorija("pausalni");
		potrosaci.createNewPotrosac(potrosac);
		OcitanjaService ocitanja = new OcitanjaService();
		o=new Ocitanja();
		o.setGodina(2015);
		o.setMjesec(5);
		o.setPotrosacByIdPotrosaca(potrosac);
		o.setPotrosnja(123.0);
		o.setSifraVodomjera(5);
		ocitanja.createNewOcitanja(o);
		o.setMjesec(4);
		ocitanja.modifyOcitanja(o);
		assertTrue(o.getMjesec()==4);
		ocitanja.hardDeleteOcitanja(o);
		potrosaci.hardDeletePotrosac(potrosac);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testHardDeleteOcitanja() {
		OcitanjaService ocitanja = new OcitanjaService();
		o=new Ocitanja();
		o.setGodina(2015);
		o.setMjesec(5);
		o.setPotrosnja(123.0);
		o.setSifraVodomjera(5);
		ocitanja.hardDeleteOcitanja(o);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testDeleteOcitanja() {
		OcitanjaService ocitanja = new OcitanjaService();
		o=new Ocitanja();
		o.setGodina(2015);
		o.setMjesec(5);
		o.setPotrosnja(123.0);
		o.setSifraVodomjera(5);
		ocitanja.deleteOcitanja(o);
	
	
	}

	@Test(expected=IllegalArgumentException.class)
	public void testGetOcitanjaForRacuni() {
		OcitanjaService ocitanja = new OcitanjaService();
		Date datum1=new Date("01/04/2015");
		Date datum2=new Date("30/04/2015");
		List<Ocitanja>rez=ocitanja.getOcitanjaForRacuni(datum1,datum2);
		assertNull(rez);
		
	}

	@Test
	public void testGetOcitanjeForRacuni() {
		PotrosacService potrosaci = new PotrosacService();
		Potrosac potrosac = new Potrosac();
		potrosac.setIme("Pero");
		potrosac.setPrezime("Peric");
		potrosac.setJmbg("2309992170008");
		potrosac.setSifraVodomjera(4);
		potrosac.setKategorija("pausalni");
		potrosaci.createNewPotrosac(potrosac);
		OcitanjaService ocitanja = new OcitanjaService();
		o=new Ocitanja();
		o.setGodina(2014);
		o.setMjesec(4);
		o.setPotrosacByIdPotrosaca(potrosac);
		o.setPotrosnja(123.0);
		o.setSifraVodomjera(5);
		ocitanja.createNewOcitanja(o);
		Ocitanja rez=ocitanja.getOcitanjeForRacuni(4, 2014, potrosac);
		assertNotNull(rez);
		ocitanja.hardDeleteOcitanja(o);
		potrosaci.hardDeletePotrosac(potrosac);
	}

}
