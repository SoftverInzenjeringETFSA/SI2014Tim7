package ba.unsa.etf.app.services;

import java.util.List;


import org.hibernate.Session;
import org.junit.Test;

import ba.unsa.etf.si.app.entity.Ocitanja;
import ba.unsa.etf.si.app.entity.Potrosac;
import ba.unsa.etf.si.app.services.OcitanjaService;
import ba.unsa.etf.si.app.servisi.PotrosacService;
import ba.unsa.etf.si.app.util.HibernateUtil;
import junit.framework.TestCase;

public class OcitanjaServiceTest extends TestCase {
	
	@Test
	public void testKreirajOcitanja() {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		
		PotrosacService p = new PotrosacService(session);
		
		List<Potrosac> potrosac = p.pretragaPoIme("Anes");
		
		Potrosac tmpPotrosac = potrosac.get(0);
		
		OcitanjaService o = new OcitanjaService(session);
		
		Ocitanja tmp = new Ocitanja();
		tmp.setAccess(false);
		tmp.setGodina(12);
		tmp.setMjesec(12);
		tmp.setPotrosnja(12.0);
		tmp.setPotrosacByIdPotrosaca(tmpPotrosac);
		
		o.kreirajOcitanja(tmp);
		
		session = HibernateUtil.getSessionFactory().openSession();
		o.setSession(session);
		//tmp.setPotrosacBySifraVodomjera(tmpPotrosac);
		tmp.setGodina(13);
		tmp.setMjesec(13);
		
		assertTrue(o.kreirajOcitanja(tmp));
		
	}
	/*
	@Test
	public void testObrisiOcitanja() 
	{
		
		Session session = HibernateUtil.getSessionFactory().openSession();
	
		OcitanjaService o = new OcitanjaService(session);
		
		Ocitanja ocitanja = o.pretragaPoId(18);
		assertTrue(o.obrisiOcitanja(ocitanja));
		
		
		
		
	}
	*/
	/*@Test
	public void testVracaLiIspravno()
	{
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		OcitanjaService o = new OcitanjaService(session);
		
		Ocitanja ocitanja = o.pretragaPoId(18);
		int a = ocitanja.getId();
		assertEquals(18,a);
		
	}*/
	
	/*@Test
	public void testModificirajOcitanja() 
	{
		
		Session session = HibernateUtil.getSessionFactory().openSession();
	
		OcitanjaService o = new OcitanjaService(session);
		
		Ocitanja ocitanja = o.pretragaPoId(2);

		ocitanja.setMjesec(15);
		
		
		assertTrue(o.modificirajOcitanja(ocitanja));
			
	}*/
	
}
