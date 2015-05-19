/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ba.unsa.etf.si.app.services;

import ba.unsa.etf.si.app.dao.KorisnikDAO;
import ba.unsa.etf.si.app.entity.Korisnik;
import ba.unsa.etf.si.app.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author armin
 */
public class KorisnikService {
    List<Korisnik> svi;
    public KorisnikService(){
        svi = new ArrayList<Korisnik>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();   
        KorisnikDAO dao = new KorisnikDAO();
        dao.setSession(session);
    	svi = dao.findAll();
        session.getTransaction().commit();
        //zatvaranje sesije
        session.close();
    }
    public String createNewKorisnik(Korisnik k){
        int id = -1;
        for (Korisnik svi1 : svi) {
            if (k.getJmbg().equals(svi1.getJmbg())) {
                id = svi1.getId();
            } else if (k.getUsername().equals(svi1.getUsername())) {
                id = svi1.getId();
            }
        }
        // Pocetak sesije obavezni kod za korisnika
        if(id==-1){
            if(validate(k)){
                Session session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                KorisnikDAO dao = new KorisnikDAO();
                dao.setSession(session);
                // Dodavanje novog korisnika
                k.setPassword(createPassword());
                dao.save(k);
                // Zatvaranje sesije, isto obavezni dio
                session.getTransaction().commit();
                session.close();
                return k.getPassword();
            }
            return "Korisnik nije prosao validaciju, provjerite podatke";
        }
        return "Korisnik postoji vec u sistemu";
    }
    
    // Sljedece dvije metode trebaju da rade zajedno, prvo nadjemo korisnika i uzmemo njegove podatke
    // zatim mjenjamo te podatke i saljemo u modifyKorisnik
    // getKorisnikByJMBG takodjer sluzi za pretragu po JMBG
    public Korisnik getKorisnikByJMBG(String JMBG){
        Korisnik k = new Korisnik();
        k.setJmbg(JMBG);
        if(validateJMBG(k)){
            for (Korisnik svi1 : svi) {
                if (JMBG.equals(svi1.getJmbg())) {
                    return svi1;
                } 
            }
        }
        return new Korisnik();
    }
    public String modifyKorisnik(Korisnik k){
            if(validate(k)){
                Session session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                KorisnikDAO dao = new KorisnikDAO();
                dao.setSession(session);
                // Dodavanje novog korisnika
                k.setPassword(createPassword());
                dao.save(k);
                // Zatvaranje sesije, isto obavezni dio
                session.getTransaction().commit();
                session.close();
                return "Uspjesna izmjena korisnika";
            }
            return "Korisnik nije prosao validaciju, provjerite podatke";
    }
    // Kako i ova klasa radi zajedno sa metodom za pretragu, ovdje je nepotrebno vracati odgovor
    public void deleteKorisnik(Korisnik k){
                Session session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                KorisnikDAO dao = new KorisnikDAO();
                dao.setSession(session);
                // Dodavanje novog korisnika
                k.setPassword(createPassword());
                dao.delete(k.getId());
                // Zatvaranje sesije, isto obavezni dio
                session.getTransaction().commit();
                session.close();
    }
    private Boolean validate(Korisnik k){
        if(!validateJMBG(k)){
        return false;
        }
        return validateBrLicne(k);
    }
    private String createPassword(){
        String newPass;
        newPass = Long.toHexString(Double.doubleToLongBits(Math.random()));
        return newPass;
    }
    private Boolean validateJMBG(Korisnik k){
        String[] jmbg = k.getJmbg().split("");
        if(jmbg.length!=14) {
        return false;
        }
        int[] j;
        j = new int[jmbg.length-1];
        for(int i = 0; i < jmbg.length-1; i++) {
        j[i] = Integer.parseInt(jmbg[i+1]);
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
    
    public List<Korisnik> searchByCriteria(String ime,String prezime,String jmbg){
        List <Korisnik> listaPretrage = new ArrayList<Korisnik>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();   
        KorisnikDAO dao = new KorisnikDAO();
        dao.setSession(session);
    	listaPretrage = dao.findByImePrezimeJMBG(ime,prezime,jmbg);
        session.getTransaction().commit();
        //zatvaranje sesije
        session.close();
    return listaPretrage;
    }
    
    // Metoda za upotrebu prilikom logiranja na sistem
    public Korisnik getKorisnikByUsername(String Username){
        for (Korisnik svi1 : svi) {
            if (Username.equals(svi1.getJmbg())) {
                return svi1;
                } 
            }
        return new Korisnik();
    }
    
     
}
