package ba.unsa.etf.si.app.services;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import ba.unsa.etf.si.app.entity.Ocitanja;
import ba.unsa.etf.si.app.entity.Potrosac;

public class OcitanjaServiceTest {
	private static Ocitanja o;


	@Test
	public void testGetPotrosac() {
		OcitanjaService ocitanja = new OcitanjaService();
		Potrosac p=ocitanja.getPotrosac(3);
		assertNotNull(p);
	}
	@Test
	public void testCreateNewOcitanja() {
		PotrosacService potrosaci = new PotrosacService();
		List<Potrosac> p=potrosaci.searchByCriteria("Emina", "Muharemovic", "2709992176217");
		OcitanjaService ocitanja = new OcitanjaService();
		o=new Ocitanja();
		o.setGodina(2015);
		o.setMjesec(5);
		o.setPotrosacByIdPotrosaca(p.get(0));
		o.setPotrosnja(123.0);
		o.setSifraVodomjera(3);
		o.setAccess(true);
		ocitanja.createNewOcitanja(o);
		assertNotNull(o);
		ocitanja.hardDeleteOcitanja(o);
	}
	
	@Test
	public void testGetId() {
		OcitanjaService ocitanja = new OcitanjaService();
		List<Ocitanja>rez=ocitanja.getId(2);
		assertNotNull(rez.size());
	}

	@Test
	public void testModifyOcitanja() {
		OcitanjaService ocitanja = new OcitanjaService();
		List<Ocitanja>rez=ocitanja.getId(2);
		rez.get(0).setMjesec(5);
		ocitanja.modifyOcitanja(rez.get(0));
		assertTrue(rez.get(0).getMjesec()==5);
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
		List<Ocitanja>rez=ocitanja.getId(123);
		ocitanja.deleteOcitanja(rez.get(0));
	}


	@Test
	public void testGetOcitanjeForRacuni() {
		OcitanjaService ocitanja = new OcitanjaService();
		Date datum1=new Date("01/04/2015");
		Date datum2=new Date("30/04/2015");
		List<Ocitanja>rez=ocitanja.getOcitanjaForRacuni(datum1, datum2);
		assertNotNull(rez);
		
	}
	@Test
	public void testGetOcitanjeForRacuni2() {
		OcitanjaService ocitanja = new OcitanjaService();
		PotrosacService potrosaci = new PotrosacService();
		List<Potrosac> p=potrosaci.searchByCriteria("Kenan", "Mahmutovic", "1512997172641");
		Ocitanja o=ocitanja.getOcitanjeForRacuni(4, 2015, p.get(0));
		assertNotNull(o);
			
	}

}
