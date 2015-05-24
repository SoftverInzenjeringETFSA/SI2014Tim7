package ba.unsa.etf.si.app.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ba.unsa.etf.si.app.dao.KorisnikDAO;
import ba.unsa.etf.si.app.dao.PotrosacDAO;
import ba.unsa.etf.si.app.entity.Korisnik;
import ba.unsa.etf.si.app.entity.Potrosac;
import ba.unsa.etf.si.app.util.HibernateUtil;

public class PotrosacService {

    
    public void createNewPotrosac(Potrosac p){
        Boolean test = false;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        PotrosacDAO dao = new PotrosacDAO();
        dao.setSession(session);
        // Pretraga da li vec postoji potrosac u bazi sa datim podatcima
        List<Potrosac> svi  = dao.findByFullJMBG(p.getJmbg());
        if(svi.isEmpty()){
            test = true;
        }
        // Pocetak sesije obavezni kod za korisnika
        if(test){
            if(validateJMBG(p.getJmbg())){
              try{  
                // Dodavanje novog korisnika
                dao.save(p);
                // Zatvaranje sesije, isto obavezni dio
                session.getTransaction().commit();
                session.close();
              }catch(Exception e){
                  throw new IllegalArgumentException("Molim provjerite unesene podatke .");
              }
            }
            else{
                session.getTransaction().commit();
                session.close();
                throw new IllegalArgumentException("JMBG nije validan!");
            }
        }
        else{
            session.getTransaction().commit();
            session.close();
            throw new IllegalArgumentException("Potrosac vec postoji u sistemu !");
        }
    }
    public Boolean validateJMBG(String JMBGX){
        char[] jmbg = JMBGX.toCharArray();
        if(jmbg.length!=13) {
        return false;
        }
        int[] j;
        j = new int[jmbg.length];
        for(int i = 0; i < jmbg.length; i++) {
            j[i] = Integer.parseInt(String.valueOf(jmbg[i]));
        }
        int v = 11-((7*(j[0]+j[6])+6*(j[1]+j[7])+5*(j[2]+j[8])+4*(j[3]+j[9])+3*(j[4]+j[10])+ 2*(j[5]+j[11]))%11);
        return (v<10&&j[12]==v)||(v>9&&j[12]==0);
        }
    
    // Naredne dvije klase rade zajedno, jedna vraca listu potrosaca, a druga mjenja jednog potrosaca kojeg smo preuzali iz liste
    public List<Potrosac> searchByCriteria(String ime,String prezime,String jmbg){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();   
        PotrosacDAO dao = new PotrosacDAO();
        dao.setSession(session);
    	List <Potrosac> listaPretrage = dao.findByImePrezimeJMBG(ime,prezime,jmbg);
        session.getTransaction().commit();
        //zatvaranje sesije
        session.close();
        return listaPretrage;
        }
    public void modifyPotrosac(Potrosac p){
            if(validateJMBG(p.getJmbg())){
                Session session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                PotrosacDAO dao = new PotrosacDAO();
                dao.setSession(session);
                dao.save(p);
                // Zatvaranje sesije, isto obavezni dio
                session.getTransaction().commit();
                session.close();
            }
            else{
                throw new IllegalArgumentException("Potrosac nije prosao validaciju, provjerite podatke");
            }
    }
    public void deletePotrosac(Potrosac p){
                Potrosac zaBrisanje = getPotrosacByJMBG(p.getJmbg());
                if(!zaBrisanje.getHidden()){
                    zaBrisanje.setHidden(Boolean.TRUE);
                }else{
                    zaBrisanje.setHidden(Boolean.FALSE);
                }
                modifyPotrosac(zaBrisanje);
    }      
    public Potrosac getPotrosacByJMBG(String JMBG){
        if(validateJMBG(JMBG)){
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            PotrosacDAO dao = new PotrosacDAO();
            dao.setSession(session);
            List<Potrosac> k = dao.findByFullJMBG(JMBG);
            session.getTransaction().commit();
            session.close();
            
            if(!k.isEmpty() && k.get(0).getJmbg().equals(JMBG)){
                return k.get(0);
            }
            else{
                throw new IllegalArgumentException("Potrosac ne postoji u sistemu");
            }   
        }
        else{
            throw new IllegalArgumentException("JMBG nije validan!");
        }
    }
    
    public List<Potrosac> mainSearch(String ime,String prezime,String jmbg,String adresa,String sifra){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();   
        PotrosacDAO dao = new PotrosacDAO();
        dao.setSession(session);
    	List <Potrosac> listaPretrage = dao.findByImePrezimeJMBGAdresa(ime,prezime,jmbg,adresa);
        session.getTransaction().commit();
        //zatvaranje sesije
        session.close();
        if("".equals(sifra)){
            return listaPretrage;
        }
        List<Potrosac> listaPretragePovratna = new ArrayList<Potrosac>();
        for (Potrosac p : listaPretrage) {
            if(String.valueOf(p.getSifraVodomjera()).contains(sifra)){
                listaPretragePovratna.add(p);
            }
        }
        return listaPretragePovratna;
    }
        
    
        // Za koristenje Pretrage racua
        public List<Potrosac> dajPotrosaceZaRacun(String ime,String prezime,int sifraVodomjera){
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();   
            PotrosacDAO dao = new PotrosacDAO();
            dao.setSession(session);
            List <Potrosac> listaPretrage = dao.findByImePrezimeSifra(ime,prezime,sifraVodomjera);
            session.getTransaction().commit();
            session.close();
            return listaPretrage;
        }
        
        // Za forme Ocitanja
        public List<Potrosac> dajSvePotrosace(){
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();   
            PotrosacDAO dao = new PotrosacDAO();
            dao.setSession(session);
            List <Potrosac> listaPretrage = dao.findAll();
            session.getTransaction().commit();
            session.close();
            return listaPretrage;
        }
        
        
        
}