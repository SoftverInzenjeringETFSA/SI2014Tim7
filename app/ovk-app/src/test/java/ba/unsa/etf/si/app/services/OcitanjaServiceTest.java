package ba.unsa.etf.si.app.services;

import static org.junit.Assert.*;

import java.util.List;




import junit.framework.TestCase;

import org.hibernate.Session;
import org.junit.Test;

import ba.unsa.etf.si.app.dao.OcitanjaDAO;
import ba.unsa.etf.si.app.entity.Ocitanja;
import ba.unsa.etf.si.app.entity.Potrosac;
import ba.unsa.etf.si.app.services.OcitanjaService;
import ba.unsa.etf.si.app.services.PotrosacService;
import ba.unsa.etf.si.app.util.HibernateUtil;

public class OcitanjaServiceTest {
	
	@Test
	public void testKreirajOcitanja() {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		PotrosacService p = new PotrosacService(session);
	
		
		List<Potrosac> potrosac = p.pretragaPoIme("Anes");
		
		Potrosac tmpPotrosac = potrosac.get(0);
		
		OcitanjaService o = new OcitanjaService(session);
		
		Ocitanja tmp = new Ocitanja();
		tmp.setAccess(false);
		tmp.setGodina(4);
		tmp.setMjesec(4);
		tmp.setPotrosnja(4.0);
		tmp.setPotrosacByIdPotrosaca(tmpPotrosac);
		
		o.kreirajOcitanja(tmp);
		
		session = HibernateUtil.getSessionFactory().openSession();
		o.setSession(session);
		tmp.setPotrosacBySifraVodomjera(tmpPotrosac);
		tmp.setGodina(20);
		tmp.setMjesec(20);
		
		assertTrue(o.kreirajOcitanja(tmp));
		
	}
	
	@Test
	public void testObrisiOcitanja() 
	{
		
		Session session = HibernateUtil.getSessionFactory().openSession();
	
		OcitanjaService o = new OcitanjaService(session);
		
		Ocitanja ocitanja = o.pretragaPoId(27);
		assertTrue(o.obrisiOcitanja(ocitanja));
		
		
	}
	
	@Test
	public void testVracaLiIspravno()
	{
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		OcitanjaService o = new OcitanjaService(session);
		
		Ocitanja ocitanja = o.pretragaPoId(24);
		int a = ocitanja.getId();
		assertEquals(24,a);
		
	}
	
	@Test
	public void testModificirajOcitanja() 
	{
		
		Session session = HibernateUtil.getSessionFactory().openSession();
	
		OcitanjaService o = new OcitanjaService(session);
		
		Ocitanja ocitanja = o.pretragaPoId(25);

		ocitanja.setMjesec(15);
		
		
		assertTrue(o.modificirajOcitanja(ocitanja));
			
	}
	
	
	
	@Test
	public void testirajPretraguPoTriParametra() 
	{
		
		Session session = HibernateUtil.getSessionFactory().openSession();
	
		
		OcitanjaService s = new OcitanjaService(session);
		
		//Potrosac p = new Potrosac();
		
		//p.setSifraVodomjera(1);
		
		Ocitanja o	= s.findByMjesecGodinaId(13, 13,1);
	
		int i = o.getId();
		
		assertEquals(26,i);
			
	}
	
	
}
