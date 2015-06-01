package ba.unsa.etf.si.app.services;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import ba.unsa.etf.si.app.entity.Racuni;

public class ObracunServiceTest {

	@Test(expected=IllegalArgumentException.class)
	public void testFormirajRacune() {
		ObracunService obracuni = new ObracunService();
		Date datum1=new Date("01/04/2015");
		Date datum2=new Date("30/04/2015");
		List<Racuni>rez=obracuni.formirajRacune(datum1, datum2);
		assertEquals(rez.size(), 0);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testPretragaRacuna() {
		ObracunService obracuni = new ObracunService();
		Date datum1=new Date("01/04/2015");
		Date datum2=new Date("30/04/2015");
		List<Racuni>rez=obracuni.pretragaRacuna(datum1,123,"Pero","Peric","111",true);
		assertEquals(rez.size(), 0);
	}

	@Test
	public void testUplatiRacun() {
		ObracunService obracuni = new ObracunService();
		Racuni r=obracuni.pretragaRacunaPoID(1);
		obracuni.uplatiRacun(r);
		assertNotNull(r);
	}

	@Test
	public void testFormirajOcitanjaZaPausalce() {
		ObracunService obracuni = new ObracunService();
		OcitanjaService o=new OcitanjaService();
		obracuni.formirajOcitanjaZaPausalce(1, 5,2015, o);
	}

	@Test
	public void testRound() {
		double broj=ObracunService.round(3.54322, 2);
		assertNotNull(broj);
	}

	@Test
	public void testPretragaRacunaPoID() {
		ObracunService obracuni = new ObracunService();
		Racuni r=obracuni.pretragaRacunaPoID(2);
		assertNotNull(r);
	}

}
