package ba.unsa.etf.si.app.servisi;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Session;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ba.unsa.etf.si.app.entity.Potrosac;
import ba.unsa.etf.si.app.util.HibernateUtil;

public class PotrosacServiceTest {
	private static Potrosac potrosac;

	@BeforeClass
	public static void setUpOnce() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		PotrosacService potrosaci = new PotrosacService(session);
		potrosac = new Potrosac();
		potrosac.setIme("Emina");
		potrosac.setPrezime("Muharemovic");
		potrosac.setJmbg("2709992176219");
		potrosac.setSifraVodomjera(1);
		potrosac.setKategorija("pausalni");
		potrosaci.kreirajPotrosaca(potrosac);
		session.close();
	}

	@AfterClass
	public static void tearDownOnce() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		PotrosacService potrosaci = new PotrosacService(session);
		potrosaci.izbrisiPotrosaca(potrosac);
		session.close();
	}

	public void testKreirajPotrosaca() {
		assertNotNull(potrosac);

		Session session = HibernateUtil.getSessionFactory().openSession();
		PotrosacService potrosaci = new PotrosacService(session);
		Potrosac p = potrosaci.pretragaPoId(potrosac.getId());

		assertEquals(p.getIme(), potrosac.getIme());

	}

	@Test
	public void testModificirajPotrosaca() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		PotrosacService potrosaci = new PotrosacService(session);
		Potrosac p = potrosaci.pretragaPoId(potrosac.getId());
		p.setKategorija("obicni");
		potrosaci.modificirajPotrosaca(p);

		p = potrosaci.pretragaPoId(p.getId());
		assertEquals(p.getKategorija(), "obicni");
		session.close();
	}

	@Test
	public void testPretragaPoIme() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		PotrosacService potrosaci = new PotrosacService(session);
		List<Potrosac> rez = potrosaci.pretragaPoIme("Emina");
		assertTrue(!rez.isEmpty());
		assertEquals(rez.get(0).getIme(), "Emina");
		session.close();
	}

	@Test
	public void testPretragaPoJMBG() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		PotrosacService potrosaci = new PotrosacService(session);
		Potrosac p = potrosaci.pretragaPoJMBG(potrosac.getJmbg());
		assertNotNull(p);
		session.close();
	}

	@Test
	public void testPretragaPoVodomjeru() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		PotrosacService potrosaci = new PotrosacService(session);
		Integer sifra = potrosaci.pretragaPoVodomjeru(1).get(0)
				.getSifraVodomjera();
		Integer tmp = 1;
		assertEquals(sifra, tmp);
		session.close();
	}

	@Test
	public void testPretragaPoKategoriji() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		PotrosacService potrosaci = new PotrosacService(session);
		String kategorija = potrosaci.pretragaPoKategoriji("pausalni").get(0)
				.getKategorija();
		assertEquals(kategorija, "pausalni");
		session.close();
	}

}
