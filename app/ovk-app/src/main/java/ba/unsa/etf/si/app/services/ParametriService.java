/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ba.unsa.etf.si.app.services;


import ba.unsa.etf.si.app.dao.ParametriDAO;
import ba.unsa.etf.si.app.entity.Parametri;
import ba.unsa.etf.si.app.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author armin
 */
public class ParametriService {
    
    // Metoda za dodavanja parametara u bazu ako ne postoji ili izmjenu ako postoje
    public void createOrModifyParams(Parametri params){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        ParametriDAO dao = new ParametriDAO();
        dao.setSession(session);
        List<Parametri> sviParametri = dao.findAll();
        if(!sviParametri.isEmpty()){
            params.setId(sviParametri.get(0).getId());
            dao.merge(params);
        }
        else{
            dao.save(params);
        }
        // Zatvaranje sesije, isto obavezni dio
        session.getTransaction().commit();
        session.close();
    }
    
    public Parametri dajParametre(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        ParametriDAO dao = new ParametriDAO();
        dao.setSession(session);
        List<Parametri> sviParametri = dao.findAll();
        session.getTransaction().commit();
        session.close();
        if(!sviParametri.isEmpty()){
            return sviParametri.get(0);
        } else {
            throw new IllegalArgumentException("Nema parametara u bazi");
        }
    }
    
    
}
