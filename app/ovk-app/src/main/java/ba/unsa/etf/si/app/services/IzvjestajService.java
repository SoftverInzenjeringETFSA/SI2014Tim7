package ba.unsa.etf.si.app.services;

import ba.unsa.etf.si.app.dao.IzvjestajiDAO;
import ba.unsa.etf.si.app.dao.OcitanjaDAO;
import ba.unsa.etf.si.app.dao.PotrosacDAO;
import ba.unsa.etf.si.app.dao.RacuniDAO;
import ba.unsa.etf.si.app.entity.Izvjestaji;
import ba.unsa.etf.si.app.entity.Ocitanja;
import ba.unsa.etf.si.app.entity.Potrosac;

import java.util.Date;
import java.util.List;

import ba.unsa.etf.si.app.entity.Racuni;
import ba.unsa.etf.si.app.util.HibernateUtil;

import java.util.ArrayList;

import org.hibernate.Session;

public class IzvjestajService {
    
    private Session session;
    
    public IzvjestajService() {
    	session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void kreirajIzvjestaj(Date donjaGranica, Date gornjaGranica)
    {
        if (donjaGranica.after(gornjaGranica)){
            throw new IllegalArgumentException("Prvi datum mora biti stariji od drugog datuma.");
       }
        IzvjestajiDAO dao = new IzvjestajiDAO();
        dao.setSession(session);
        List<Racuni> racuni;
        Izvjestaji novi = new Izvjestaji();
        racuni=nadjiListuRacuna(donjaGranica, gornjaGranica);
        if(racuni.size()==0)
        {
        	throw new IllegalArgumentException("Nema racuna u tom periodu!");
        }
        int brojPausalni=0;
        Double vodaPausalni=0.0;
        Double kanalizacijaPausalni=0.0;
        Double vodaOstali=0.0;
        Double kanalizacijaOstali=0.0;
        int brojOstali=0;
        
        for (int i=0; i<racuni.size(); i++)
        {
        	String provjera = racuni.get(i).getPotrosac().getKategorija();
        	Double kanalizacija = racuni.get(i).getPotrosnjaZaKoristenjeKanalizacije();
        	Double voda = racuni.get(i).getPotrosnjaZaKoristenjeVoda();
        	
        	if(provjera.equals("Pausalni"))
        	{
        		vodaPausalni=vodaPausalni+voda;
        		kanalizacijaPausalni=kanalizacijaPausalni+kanalizacija;
        		brojPausalni++;
        	}
        	else
        	{
        		vodaOstali=vodaOstali+voda;
        		kanalizacijaOstali=kanalizacijaOstali+kanalizacija;
        		brojOstali++;
        	}
        }
        novi.setBrojOstalih(brojOstali);
        novi.setBrojPausalaca(brojPausalni);
        novi.setPotrosnjaOstalihKanalizacija(kanalizacijaOstali);
        novi.setPotrosnjaOstalihVoda(vodaOstali);
        novi.setPotrosnjaPausalacaKanalizacija(kanalizacijaPausalni);
        novi.setPotrosnjaPausalacaVoda(vodaPausalni);
        session.beginTransaction();
        dao.save(novi);
        session.getTransaction().commit();
        
    }
    
    public List<Izvjestaji> vratiSveIzvjestaje()
    {
    	IzvjestajiDAO dao = new IzvjestajiDAO();
        dao.setSession(session);
        List<Izvjestaji> izv;
        session.beginTransaction();
        izv = dao.findAll();
        session.getTransaction().commit();
        
        return izv;
    }
    
    public Izvjestaji vratiSveIzvjestajeZaId(int id)
    {
    	IzvjestajiDAO dao = new IzvjestajiDAO();
        dao.setSession(session);
        Izvjestaji izv;
        session.beginTransaction();
        izv = dao.findById(id);
        session.getTransaction().commit();
        
        return izv;
    }
    
    public void obrisiIzvjestaj(Izvjestaji i)
    {
    	session.beginTransaction();
    	IzvjestajiDAO dao = new IzvjestajiDAO();
        dao.setSession(session);
        dao.delete(i.getId());
        session.getTransaction().commit();
    }
    
    
public void izracunajParametreZaIzvjestaj(Date donjaGranica, Date gornjaGranica){
        
        if (donjaGranica.after(gornjaGranica)){
             throw new IllegalArgumentException("Prvi datum mora biti stariji od drugog datuma.");
        }
        
        List<Racuni> racuni;
        List<Potrosac> potrosaci;
        racuni=nadjiListuRacuna(donjaGranica, gornjaGranica);
        potrosaci=nadjiPotrosace();
        
        //varijable u koje ce se smjestatati i racunati vrijednosti
        //potrebne za ispis izvjestaja
        double brojPausalnihVoda=0; //broj korisnika vodova (pausalni)
        double brojNePausalnihVoda=0; // broj korisnika vodova (nepausalni)
        double brojPausalnihKanalizacija=0;  //broj korisnika kanalizacije (pausalni)
        double brojNePausalnihKanalizacija=0; //broj korisnika kanalizacije (nepausalni)
        double potrosnjaVodePausalni=0; //u kubicima
        double potrosnjaVodeNePausalni=0; //u kubicima
        
        Potrosac p;
        
        //racunanje potrosnje vode i kanalizacije za pausalne i nepausalne potrosace
        for (int i=0; i<racuni.size(); i++){
            p=racuni.get(i).getPotrosac();
            
            if (p.getKategorija()=="Pausalni"){        
                //fiksna cijena * broj clanova domacinstva
                potrosnjaVodePausalni+=racuni.get(i).getFisknaCijenaZaKoristenjeUsluga()*Double.parseDouble(p.getBrojClanova());
                
                //"usluga" je boolean, a u SRS-u pi�e: Usluga (�Voda� ili �Voda i Kanalizacija�)
                //pa sam stavio da korisnik imao kanalizaciju ako je usluga==true
                
            }
            if (p.getKategorija()=="Sa vodomjerom"){
                
                potrosnjaVodeNePausalni+=racuni.get(i).getPotrosnjaZaKoristenjeVoda();
                
                
            }
   
            
        }
        
        //koliko ima pausalnih, a koliko nepausalnih korisnika
         for (int i=0; i<potrosaci.size(); i++){
             if (potrosaci.get(i).getKategorija()=="Pausalni"){
                brojPausalnihVoda++;
                
                if (potrosaci.get(i).getUsluga()==true){
                    brojPausalnihKanalizacija++;
                }
              
            }
            if (potrosaci.get(i).getKategorija()=="Sa vodomjerom"){
                brojNePausalnihVoda++;
                if (potrosaci.get(i).getUsluga()==true){
                    brojNePausalnihKanalizacija++;
                }
            }
         }
        
    }
    
    private List<Potrosac> nadjiPotrosace(){
        
        //Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
            
        //instanca dao klase i proslijedjivanje sesije
    	PotrosacDAO dao = new PotrosacDAO();
    	dao.setSession(session);
    	
    	//vraca listu SVIH potrosaca
    	List<Potrosac> potrosaci;
    	potrosaci = dao.findAll();
        
        //commit, obavezno poslije svake komunikacije s bazom
    	session.getTransaction().commit();
        
        //zatvaranje sesije
        //session.close();
        //HibernateUtil.getSessionFactory().close();
        
        return potrosaci;
    }
    
    //lista racuna koji su izmedju dva datuma
    private List<Racuni> nadjiListuRacuna(Date donjaGranica, Date gornjaGranica){
        
        //Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
            
        //instanca dao klase i proslijedjivanje sesije
    	RacuniDAO dao = new RacuniDAO();
    	dao.setSession(session);
    	
    	//vraca listu SVIH racuna
    	List<Racuni> sviRacuni;
    	sviRacuni = dao.findAll();
        
        //commit, obavezno poslije svake komunikacije s bazom
    	session.getTransaction().commit();
        
        //zatvaranje sesije
        //session.close();
       // HibernateUtil.getSessionFactory().close();
        
        //u ovu listu ce biti smjesti racuni koji su UNUTAR dva zadana datuma
        List<Racuni> zadovoljavajuci = new ArrayList<Racuni>();
        
        //izdvajanje racuna koji su unutar dva zadana datuma
        for (int i=0; i<sviRacuni.size(); i++){
            
            if ((sviRacuni.get(i).getDatumKreacije()).after(donjaGranica) && (sviRacuni.get(i).getDatumKreacije()).before(gornjaGranica)){
                zadovoljavajuci.add(sviRacuni.get(i));
            }
        } 

        return zadovoljavajuci;
    }
    
}