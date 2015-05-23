package ba.unsa.etf.si.app.services;


import ba.unsa.etf.si.app.dao.OcitanjaDAO;
import ba.unsa.etf.si.app.dao.PotrosacDAO;

import ba.unsa.etf.si.app.entity.Ocitanja;
import ba.unsa.etf.si.app.entity.Potrosac;
import ba.unsa.etf.si.app.util.HibernateUtil;
import java.util.Date;
import java.util.List;


import org.hibernate.Session;


public class OcitanjaService {
	
    
    public Potrosac getPotrosac(int sifra){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        PotrosacDAO dao = new PotrosacDAO();
        dao.setSession(session);
        List<Potrosac> pList = dao.findByFullSifra(sifra);
        if(pList.isEmpty()){
            throw new IllegalArgumentException("Potrosac sa datom sifrom ne postoji");
        }
        else{
        return pList.get(0);
        }
    }
    public void createNewOcitanja(Ocitanja o){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        OcitanjaDAO dao = new OcitanjaDAO();
        dao.setSession(session);
        
        PotrosacService pService = new PotrosacService(session);
        Potrosac p = o.getPotrosacByIdPotrosaca();
        Potrosac temp = pService.pretragaPoJMBG(p.getJmbg());
        if(temp.getJmbg() == null ? p.getJmbg() != null : !temp.getJmbg().equals(p.getJmbg())){
            session.getTransaction().commit();
            session.close();
            throw new IllegalArgumentException("Potrosac kojeg trazite ne postoji u bazi podataka");
        }
        else {
            List<Ocitanja> tempOcitanjaList = dao.findOcitanja(o.getMjesec(), o.getGodina(), o.getPotrosacByIdPotrosaca());
            if(!tempOcitanjaList.isEmpty()){
                session.getTransaction().commit();
                session.close();
                throw new IllegalArgumentException("Ocitanja za date podatke vec postoji");
            }
            else{
                // Dozvoliti mogucu izmjenu ocitanja
                o.setAccess(Boolean.TRUE);
                dao.save(o);
                // Zatvaranje sesije, isto obavezni dio
                session.getTransaction().commit();
                session.close();
            }
        }
    }
    // Sljedece dvije klase rade zajedno, prvo nadjemo listu ocitanja, izaberemo jednu od opcija, te zatim modificiramo izabrano ocitanje
    public List<Ocitanja> getId(int sifra){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        OcitanjaDAO dao = new OcitanjaDAO();
        dao.setSession(session);
        List<Ocitanja> tempOcitanjaList = dao.findOcitanjaBySifraVodomjeraAccess(sifra);
        if(tempOcitanjaList.isEmpty()){
            throw new IllegalArgumentException("Ne postoji ocitanje u bazi sa datim podatcima");
        }
        else{
            return tempOcitanjaList;
        }
    }
    
    public void modifyOcitanja(Ocitanja o){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        OcitanjaDAO dao = new OcitanjaDAO();
        dao.setSession(session);
        dao.save(o);
        // Zatvaranje sesije, isto obavezni dio
        session.getTransaction().commit();
        session.close();
    }
    // Sljedeca metoda radi zajedno sa getPotrosac
    public void deleteOcitanja(Ocitanja o){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        OcitanjaDAO dao = new OcitanjaDAO();
        dao.setSession(session);
        
        List<Ocitanja> tempOcitanjaList = dao.findOcitanjaForDelete(o.getMjesec(), o.getGodina(), o.getPotrosacByIdPotrosaca());
        if(tempOcitanjaList.isEmpty()){
            session.getTransaction().commit();
            session.close();
            throw new IllegalArgumentException("Ocitanje za unesene vrijednosti ne postoji ili je racun vec napravljan");
        }
        else{
            dao.delete(tempOcitanjaList.get(0).getId());
            session.getTransaction().commit();
            session.close();
        }
    }
    
    
    // sljedece metode rade uz ObracunService
    public List<Ocitanja> getOcitanjaForRacuni(Date odDatuma,Date doDatuma){
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            OcitanjaDAO dao = new OcitanjaDAO();
            dao.setSession(session);
            List<Ocitanja> ocitanjaZaRacune = dao.findByDate(odDatuma,doDatuma);
            session.getTransaction().commit();
            session.close();
            if(ocitanjaZaRacune.isEmpty()){
                throw new IllegalArgumentException("Nema ocitanja u tom periodu");
            }
            else{
                return ocitanjaZaRacune; 
            }
    }
    
    
}
