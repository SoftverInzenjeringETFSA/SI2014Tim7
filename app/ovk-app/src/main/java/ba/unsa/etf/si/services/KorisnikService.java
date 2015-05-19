/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ba.unsa.etf.si.services;

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
        String jmbg = "";
        String username = "";
        for (Korisnik svi1 : svi) {
            if (k.getJmbg().equals(svi1.getJmbg())) {
                jmbg = k.getJmbg();
                id = svi1.getId();
            } else if (k.getUsername().equals(svi1.getUsername())) {
                username = k.getUsername();
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
        k = setPassword(k);
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
    private Boolean validate(Korisnik k){
        if(!validateJMBG(k)){
        return false;
        }
        return validateBrLicne(k);
    }
    private Korisnik setPassword(Korisnik k){
        String newPass;
        newPass = Long.toHexString(Double.doubleToLongBits(Math.random()));
        k.setPassword(newPass);
        return k;
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
        return ((v<10&&j[12]==v)||(v>9&&j[12]==0));
    }
    private Boolean validateBrLicne(Korisnik k){
        return (k.getBrojLicne().length()==9);
    }
    public void closeSession(){
        HibernateUtil.getSessionFactory().close();
    }
}
