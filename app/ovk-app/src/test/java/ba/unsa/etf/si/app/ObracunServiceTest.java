package ba.unsa.etf.si.app;

import org.junit.Test;

import ba.unsa.etf.app.services.ObracunService;
import ba.unsa.etf.si.app.entity.Parametri;
import junit.framework.TestCase;

public class ObracunServiceTest extends TestCase {

	@Test
	public void testUnesiParametreObracuna() {
		
		ObracunService o = new ObracunService();
		
		
		assertTrue( "Uspjesno!",o.unesiParametreObracuna(12.0, 1.2, 2.3, 2.3, 4.5, 10.0, 1.1, 1.2));
		
	
	}

}
