package ba.unsa.etf.app.services;


import org.junit.Test;

import ba.unsa.etf.si.app.entity.Potrosac;
import junit.framework.TestCase;

public class OcitanjaServiceTest extends TestCase {
	
	@Test
	public void testKreirajOcitanja() {
			
		Potrosac p = new Potrosac();
		p.setIme("Anes");
		p.setPrezime("Luckin");
		p.setJmbg("12");
		p.setAdresa("Neka");
		p.setTelefon("2113");
		p.setBrojClanova("4");
		p.setKategorija("Pausalni");
		p.setSifraVodomjera(12);
		p.setUsluga(true);
		p.setAktivnost(true);
		p.setHidden(false);
		
		
		
		OcitanjaService o = new OcitanjaService();
		
		assertTrue("Bajo moj!", o.kreirajOcitanja(p,p, 12.0, 1, 11, true));
		

	}

}
