package ba.unsa.etf.si.app.services;


import ba.unsa.etf.si.app.dao.OcitanjaDAO;
import ba.unsa.etf.si.app.dao.PotrosacDAO;
import ba.unsa.etf.si.app.entity.Ocitanja;
import ba.unsa.etf.si.app.entity.Potrosac;
import ba.unsa.etf.si.app.util.HibernateUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;




import org.hibernate.SQLQuery;
import org.hibernate.Session;


public class OcitanjaService{
		private Session session;
		
		public OcitanjaService()
		{
			session = HibernateUtil.getSessionFactory().openSession();
		}
    
    public Potrosac getPotrosac(int sifra){
        session.beginTransaction();
        PotrosacDAO dao = new PotrosacDAO();
        dao.setSession(session);
        List<Potrosac> pList = dao.findByFullSifra(sifra);
        if(pList.isEmpty()){
        	session.getTransaction().commit();
            throw new IllegalArgumentException("Potrosac sa datom sifrom ne postoji");
        }
        else{
        	
        session.getTransaction().commit();	
        return pList.get(0);
        }
    }
    public void createNewOcitanja(Ocitanja o){
        session.beginTransaction();
        OcitanjaDAO dao = new OcitanjaDAO();
        dao.setSession(session);
        
        PotrosacService pService = new PotrosacService();
        Potrosac p = o.getPotrosacByIdPotrosaca();
        Potrosac temp = pService.getPotrosacByJMBG(p.getJmbg());
        if(temp.getJmbg() == null ? p.getJmbg() != null : !temp.getJmbg().equals(p.getJmbg())){
            session.getTransaction().commit();
            throw new IllegalArgumentException("Potrosac kojeg trazite ne postoji u bazi podataka");
        }
        else {
            List<Ocitanja> tempOcitanjaList = dao.findOcitanja(o.getMjesec(), o.getGodina(), o.getPotrosacByIdPotrosaca());
            if(!tempOcitanjaList.isEmpty()){
                session.getTransaction().commit();
                throw new IllegalArgumentException("Ocitanje za date podatke vec postoji");
            }
            else{
                // Dozvoliti mogucu izmjenu ocitanja
                o.setAccess(Boolean.TRUE);
                dao.save(o);
                // Zatvaranje sesije, isto obavezni dio
                session.getTransaction().commit();

            }
        }
    }
    // Sljedece dvije klase rade zajedno, prvo nadjemo listu ocitanja, izaberemo jednu od opcija, te zatim modificiramo izabrano ocitanje
    public List<Ocitanja> getId(int sifra){
        session.beginTransaction();
        OcitanjaDAO dao = new OcitanjaDAO();
        dao.setSession(session);
        List<Ocitanja> tempOcitanjaList = dao.findOcitanjaBySifraVodomjeraAccess(sifra);
        if(tempOcitanjaList.isEmpty()){
        	session.getTransaction().commit();
            throw new IllegalArgumentException("Ne postoji ocitanje u bazi sa datim podacima");
        }
        else{
        	session.getTransaction().commit();
            return tempOcitanjaList;
        }
    }
    
    public void modifyOcitanja(Ocitanja o){
        session.beginTransaction();
        OcitanjaDAO dao = new OcitanjaDAO();
        dao.setSession(session);
        dao.save(o);
        // Zatvaranje sesije, isto obavezni dio
        session.getTransaction().commit();
    	}
        
    // Sljedeca metoda radi zajedno sa getPotrosac
    public void deleteOcitanja(Ocitanja o){
        session.beginTransaction();
        OcitanjaDAO dao = new OcitanjaDAO();
        dao.setSession(session);
        
        List<Ocitanja> tempOcitanjaList = dao.findOcitanjaForDelete(o.getMjesec(), o.getGodina(), o.getPotrosacByIdPotrosaca());
        if(tempOcitanjaList.isEmpty()){
            session.getTransaction().commit();
            throw new IllegalArgumentException("Ocitanje za unesene vrijednosti ne postoji ili je racun vec napravljan");
        }
        else{
            dao.delete(tempOcitanjaList.get(0).getId());
            session.getTransaction().commit();
        }
    }
    // sljedece metode rade uz ObracunService
    public List<Ocitanja> getOcitanjaForRacuni(Date odDatuma,Date doDatuma){
            session.beginTransaction();
            OcitanjaDAO dao = new OcitanjaDAO();
            dao.setSession(session);
            List<Ocitanja> ocitanjaZaRacune = dao.findByDate(odDatuma,doDatuma);
            session.getTransaction().commit();
            if(ocitanjaZaRacune.isEmpty()){
                throw new IllegalArgumentException("Nema ocitanja u tom periodu");
            }
            else{
                return ocitanjaZaRacune; 
            }
    }
    
    
}
