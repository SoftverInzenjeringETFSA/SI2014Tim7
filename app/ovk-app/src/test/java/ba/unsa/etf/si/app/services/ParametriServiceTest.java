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
		parametar=new Parametri();
		parametar.setCijenaKanalizacijePoKubiku(20.0);
		parametar.setCijenaVodePoKubiku(25.0);
		parametar.setFiksnaCijena(30.0);
		parametar.setFiksniKanalizacijaZaPausalce(12.5);
		parametar.setId(2);
		parametar.setPvnZaKoristenjeVoda(32.0);
		parametar.setPvnZaZastituVoda(12.0);
		parametar.setStopaPdv(17.0);
		parametri.createOrModifyParams(parametar);
		assertTrue(parametar.getId()==2);
		
		
	}

	@Test
	public void testDajParametre() {
		ParametriService parametri = new ParametriService();
		parametar=new Parametri();
		parametar.setCijenaKanalizacijePoKubiku(20.0);
		parametar.setCijenaVodePoKubiku(25.0);
		parametar.setFiksnaCijena(30.0);
		parametar.setFiksniKanalizacijaZaPausalce(12.5);
		parametar.setId(2);
		parametar.setPvnZaKoristenjeVoda(32.0);
		parametar.setPvnZaZastituVoda(12.0);
		parametar.setStopaPdv(17.0);
		parametri.createOrModifyParams(parametar);
		assertTrue(parametar.getId()==2);
		Parametri rezultat=parametri.dajParametre();
		assertEquals(parametar.getId(),rezultat.getId());
	}

}
