package ba.unsa.etf.si.app.services;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import ba.unsa.etf.si.app.entity.Izvjestaji;
import ba.unsa.etf.si.app.entity.Potrosac;
import ba.unsa.etf.si.app.entity.Racuni;

public class IzvjestajServiceTest {
	private static Izvjestaji izvjestaj;

	@Test
	public void testKreirajIzvjestaj() {
		IzvjestajService izvjestaji = new IzvjestajService();
		Date datum1=new Date("01/04/2015");
		Date datum2=new Date("30/04/2015");
		izvjestaji.kreirajIzvjestaj(datum1, datum2);	
	}

	@Test
	public void testVratiSveIzvjestaje() {
		IzvjestajService izvjestaji = new IzvjestajService();
		List<Izvjestaji>rez=izvjestaji.vratiSveIzvjestaje();
		assertNotNull(rez);
		
	}

	@Test
	public void testVratiSveIzvjestajeZaId() {
		IzvjestajService izvjestaji = new IzvjestajService();
		Izvjestaji rez=izvjestaji.vratiSveIzvjestajeZaId(123);
		assertNull(rez);
	}

	@Test(expected=IllegalStateException.class)
	public void testObrisiIzvjestaj() {
		IzvjestajService izvjestaji = new IzvjestajService();
		izvjestaj=new Izvjestaji();
		izvjestaj.setBrojOstalih(200);
		izvjestaj.setBrojPausalaca(100);
		izvjestaj.setPotrosnjaOstalihKanalizacija(2000.32);
		izvjestaj.setPotrosnjaOstalihVoda(1232.456);
		izvjestaj.setPotrosnjaPausalacaKanalizacija(1231.4323);
		izvjestaj.setPotrosnjaPausalacaVoda(2001.12);
		izvjestaj.setId(2);
		izvjestaji.obrisiIzvjestaj(izvjestaj);
		assertNull(izvjestaj);	
	}

	@Test(expected=IllegalArgumentException.class)
	public void testIzracunajParametreZaIzvjestaj() {
		IzvjestajService izvjestaji = new IzvjestajService();
		Date datum1=new Date("01/04/2015");
		Date datum2=new Date("30/04/2015");
		izvjestaji.izracunajParametreZaIzvjestaj(datum2, datum1);	
	}
	@Test
	public void testNadjiPotrosace() {
		IzvjestajService izvjestaji = new IzvjestajService();
		Date datum1=new Date("01/04/2015");
		Date datum2=new Date("30/04/2015");
		List<Racuni>r=izvjestaji.nadjiListuRacuna(datum1, datum2);
		assertNotNull(r);
	}

}
