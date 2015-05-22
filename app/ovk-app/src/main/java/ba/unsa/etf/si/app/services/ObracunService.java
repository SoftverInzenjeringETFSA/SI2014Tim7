package ba.unsa.etf.si.app.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import org.hibernate.Transaction;

import ba.unsa.etf.si.app.dao.OcitanjaDAO;
import ba.unsa.etf.si.app.dao.RacuniDAO;
import ba.unsa.etf.si.app.entity.Ocitanja;
import ba.unsa.etf.si.app.entity.Parametri;
import ba.unsa.etf.si.app.entity.Potrosac;
import ba.unsa.etf.si.app.entity.Racuni;
import ba.unsa.etf.si.app.util.HibernateUtil;

public class ObracunService {
	public List<Racuni> formirajRacune(Date odDatuma,Date doDatuma){
           OcitanjaService ocitanja = new OcitanjaService();
           ParametriService paramS = new ParametriService();
           List<Ocitanja> ocitanjaZaRacune = ocitanja.getOcitanjaForRacuni(odDatuma, doDatuma);
           Parametri param = paramS.dajParametre();
           List<Racuni> racuniList = new ArrayList<Racuni>();
            for (Ocitanja ocitanjaZaRacuneX : ocitanjaZaRacune) {
                Racuni racun = formirajRacun(ocitanjaZaRacuneX,param);
                racuniList.add(racun);
            }
            
            if(racuniList.isEmpty()){
                throw new IllegalArgumentException("Nema ocitanja");
            }
            else{
                return racuniList;
            }
        }
	
        private Racuni formirajRacun(Ocitanja o,Parametri param){
            Potrosac p = o.getPotrosacByIdPotrosaca();
            Double potrosnja = 0.0;
            if("Pausalni".equals(p.getKategorija())){
                potrosnja = param.getFiksniVodaZaPausalce();
            }
            else{
                potrosnja = o.getPotrosnja();
            }
            Double fixnaCijenaZaKoristenjeUsluga = param.getFiksnaCijena();
            Double cijenaVoda = potrosnja*(param.getPvnZaKoristenjeVoda()+param.getCijenaVodePoKubiku()+param.getPvnZaZastituVoda());
            Double cijenaKanalizacije = 0.0;
            if(p.getUsluga()){
                cijenaKanalizacije = potrosnja*param.getCijenaKanalizacijePoKubiku();
            }
            Double ukupno = cijenaKanalizacije + cijenaVoda;
            Double cijenaKsaPDV = cijenaKanalizacije + cijenaKanalizacije*param.getStopaPdv();
            Double cijenaVsaPDV = cijenaVoda + cijenaVoda*param.getStopaPdv();
            Double ukupnoSaPDV = cijenaVsaPDV + cijenaKsaPDV;
            Racuni r = new Racuni();
            r.setCijenaKanalizacije(cijenaKanalizacije);
            r.setCijenaKanalizacijeSaPdv(cijenaKsaPDV);
            r.setCijenaVoda(cijenaVoda);
            r.setCijenaVodaSaPdv(cijenaVsaPDV);
            r.setDatumKreacije(Calendar.getInstance().getTime());
            r.setFisknaCijenaZaKoristenjeUsluga(fixnaCijenaZaKoristenjeUsluga);
            r.setOcitanja(o);
            r.setPotrosac(p);
            if(p.getUsluga()){
                r.setPotrosnjaZaKoristenjeKanalizacije(potrosnja);
            }
            else{
                r.setPotrosnjaZaKoristenjeKanalizacije(0.0);
            }
            r.setPvnZaKoristenjeVoda(param.getPvnZaKoristenjeVoda());
            r.setPvnZaZastituVoda(param.getPvnZaZastituVoda());
            r.setUkupnaCijena(ukupno);
            r.setUkupnaCijenaSaPdv(ukupnoSaPDV);
            return r;
        }
        
        public void snimiRacune(List<Racuni> racuni,List<Ocitanja> ocitanja){
        OcitanjaService o = new OcitanjaService();
            for (Ocitanja ocitanja1 : ocitanja) {
                ocitanja1.setAccess(Boolean.FALSE);
                o.modifyOcitanja(ocitanja1);
            }
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            RacuniDAO dao = new RacuniDAO();
            dao.setSession(session);
            
            for(Racuni r : racuni){
                dao.save(r);
            }
            
            session.getTransaction().commit();
            session.close();
        
        }
		
        public List<Racuni> pretragaRacuna(Date datumKreacije,int id,String ime,String prezime,int sifraVodomjera){
        PotrosacService pService = new PotrosacService();
        List<Potrosac> pList = pService.dajPotrosaceZaRacun(ime, prezime, sifraVodomjera);
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();   
        RacuniDAO dao = new RacuniDAO();
        dao.setSession(session);
        // Pretraga po Datumu i ID
        List<Racuni> rList = dao.finByDateId(datumKreacije,id);
        // Pretraga po potrosacu
        List<Racuni> rList2 = new ArrayList();
        if(!pList.isEmpty()){
            for (Potrosac p : pList) {
                List<Racuni> temp = dao.findByPotrosac(p);
                if(!temp.isEmpty()){
                    rList2.add(temp.get(0));
                }
            }
        }
        session.getTransaction().commit();
        session.close();
        
        if(rList.isEmpty()&&rList2.isEmpty()){
            throw new IllegalArgumentException("Racuni za unesene parametre ne postoje"); 
        }
        else if(rList.isEmpty()){
            return rList2;
        }
        else if(rList2.isEmpty()){
            return rList;
        }
        else{
            List<Racuni> temp = new ArrayList();
            for(Racuni r1 : rList){
                for(Racuni r2 : rList2){
                    if(r1.getId()==r2.getId()){
                        temp.add(r1);
                    }
                }
            }
            if(temp.isEmpty()){
                throw new IllegalArgumentException("Racuni za unesene parametre ne postoje"); 
            }
            else{
                return temp;
            }
        }
    }

        public void uplatiRacun(Racuni r){
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            RacuniDAO dao = new RacuniDAO();
            dao.setSession(session);
            dao.save(r);
            session.getTransaction().commit();
            session.close();
        }
}

