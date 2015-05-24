/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ba.unsa.etf.si.app.services;

import ba.unsa.etf.si.app.dao.KorisnikDAO;
import ba.unsa.etf.si.app.entity.Korisnik;
import ba.unsa.etf.si.app.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author armin
 */
public class KorisnikService {
    
    public String createNewKorisnik(Korisnik k){
        Boolean test = false;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        KorisnikDAO dao = new KorisnikDAO();
        dao.setSession(session);
        List<Korisnik> svi  = dao.findByFullUsernameJMBG(k.getUsername(),k.getJmbg());
        if(svi.isEmpty()){
            test = true;
        }
        // Pocetak sesije obavezni kod za korisnika
        if(test){
            if(validate(k)){
                // Dodavanje novog korisnika
                k.setPassword(createPassword());
                dao.save(k);
                // Zatvaranje sesije, isto obavezni dio
                session.getTransaction().commit();
                session.close();
                return k.getPassword();
            }
            else{
                session.getTransaction().commit();
                session.close();
                throw new IllegalArgumentException("JMBG/Broj licne nije validan!");
            }
        }
        else{
            session.getTransaction().commit();
            session.close();
            throw new IllegalArgumentException("Korisnik vec postoji u sistemu !");
        }
    }
    
    // Sljedece dvije metode trebaju da rade zajedno, prvo nadjemo korisnika i uzmemo njegove podatke
    // zatim mjenjamo te podatke i saljemo u modifyKorisnik
    // getKorisnikByJMBG takodjer sluzi za pretragu po JMBG
    public Korisnik getKorisnikByJMBG(String JMBG){
        if(validateJMBG(JMBG)){
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            KorisnikDAO dao = new KorisnikDAO();
            dao.setSession(session);
            List<Korisnik> k = dao.findByFullJMBG(JMBG);
            session.getTransaction().commit();
            session.close();
            
            if(!k.isEmpty() && k.get(0).getJmbg().equals(JMBG)){
                return k.get(0);
            }
            else{
                throw new IllegalArgumentException("Korisnik ne postoji u sistemu");
            }   
        }
        else{
            throw new IllegalArgumentException("JMBG nije validan!");
        }
    }
    public void modifyKorisnik(Korisnik k){
            if(validate(k)){
                Session session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                KorisnikDAO dao = new KorisnikDAO();
                dao.setSession(session);
                // Dodavanje novog korisnika
                dao.save(k);
                // Zatvaranje sesije, isto obavezni dio
                session.getTransaction().commit();
                session.close();
            }
            else{
                throw new IllegalArgumentException("Korisnik nije prosao validaciju, provjerite podatke");
            }
    }
    // Kako i ova klasa radi zajedno sa metodom za pretragu, ovdje je nepotrebno vracati odgovor
    public void deleteKorisnik(Korisnik k){
                Korisnik zaBrisanje = getKorisnikByJMBG(k.getJmbg());
                Session session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                KorisnikDAO dao = new KorisnikDAO();
                dao.setSession(session);
                // Dodavanje novog korisnika
                dao.delete(zaBrisanje.getId());
                // Zatvaranje sesije, isto obavezni dio
                session.getTransaction().commit();
                session.close();
    }
    private Boolean validate(Korisnik k){
        if(!validateJMBG(k.getJmbg())){
            return false;
        }
        return validateBrLicne(k);
    }
    private String createPassword(){
        String newPass;
        newPass = Long.toHexString(Double.doubleToLongBits(Math.random()));
        return newPass;
    }
    private Boolean validateJMBG(String JMBGX){
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
    private Boolean validateBrLicne(Korisnik k){
        return k.getBrojLicne().length()==9;
    }
    public void closeSession(){
        HibernateUtil.getSessionFactory().close();
    }
    
    public List<Korisnik> searchByCriteria(String ime,String prezime,String jmbg,String username){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();   
        KorisnikDAO dao = new KorisnikDAO();
        dao.setSession(session);
    	List <Korisnik> listaPretrage = dao.findByImePrezimeJMBG(ime,prezime,jmbg,username);
        session.getTransaction().commit();
        //zatvaranje sesije
        session.close();
    return listaPretrage;
    }
    
    public List<Korisnik> searchByFullUsername(String username){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();   
        KorisnikDAO dao = new KorisnikDAO();
        dao.setSession(session);
    	List <Korisnik> listaPretrage = dao.findByFullUsername(username);
        session.getTransaction().commit();
        //zatvaranje sesije
        session.close();
    return listaPretrage;
    }
    
        public List<Korisnik> searchByUsername(String username){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();   
        KorisnikDAO dao = new KorisnikDAO();
        dao.setSession(session);
    	List <Korisnik> listaPretrage = dao.findByUsername(username);
        session.getTransaction().commit();
        //zatvaranje sesije
        session.close();
    return listaPretrage;
    }
    
    
    
    
    // Metoda za upotrebu prilikom logiranja na sistem
    public Boolean checkLogin(String Username,String Password){
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            KorisnikDAO dao = new KorisnikDAO();
            dao.setSession(session);
            List<Korisnik> k = dao.findByFullUsername(Username);
            session.getTransaction().commit();
            session.close();
            if(!k.isEmpty() && k.get(0).getUsername().equals(Username)){
                if(k.get(0).getPassword().equals(Password)){
                    return k.get(0).getAdmin();
                }
                else{
                    throw new IllegalArgumentException("Unijeli ste pogrešan password");
                }   
            }
            else{
                throw new IllegalArgumentException("Korisnik ne postoji u sistemu");
            }   
    }
}
