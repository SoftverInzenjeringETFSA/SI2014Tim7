package ba.unsa.etf.si.app.services;

import static org.junit.Assert.*;

import org.junit.Test;

import ba.unsa.etf.si.app.entity.Parametri;
import ba.unsa.etf.si.app.entity.Potrosac;

public class ParametriServiceTest {
	private static Parametri parametar;

	@Test
	public void testCreateOrModifyParams() {
		ParametriService parametri = new ParametriService();
		Parametri p=parametri.dajParametre();
		p.setFiksnaCijena(10.0);
		parametri.createOrModifyParams(p);
		assertTrue(p.getFiksnaCijena()==10);
		
		
	}

	@Test
	public void testDajParametre() {
		ParametriService parametri = new ParametriService();
		Parametri p=parametri.dajParametre();
		assertNotNull(p);
	}

}
