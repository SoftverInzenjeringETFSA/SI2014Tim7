package ba.unsa.etf.si.app.services;

import ba.unsa.etf.si.app.dao.IzvjestajiDAO;
import ba.unsa.etf.si.app.dao.OcitanjaDAO;
import ba.unsa.etf.si.app.dao.PotrosacDAO;
import ba.unsa.etf.si.app.dao.RacuniDAO;
import ba.unsa.etf.si.app.entity.Izvjestaji;
import ba.unsa.etf.si.app.entity.Ocitanja;
import ba.unsa.etf.si.app.entity.Parametri;
import ba.unsa.etf.si.app.entity.Potrosac;

import java.util.Date;
import java.util.List;

import ba.unsa.etf.si.app.entity.Racuni;
import ba.unsa.etf.si.app.util.HibernateUtil;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.component.TextFieldBuilder;
import net.sf.dynamicreports.report.exception.DRException;

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
        List<Potrosac> listasvih = new ArrayList();
        Boolean pomocna = false;
        
        for (int i=0; i<racuni.size(); i++)
        {
        	String provjera = racuni.get(i).getPotrosac().getKategorija();
        	Double kanalizacija = racuni.get(i).getPotrosnjaZaKoristenjeKanalizacije();
        	Double voda = racuni.get(i).getPotrosnjaZaKoristenjeVoda();
        	
        	for(int j=0;j<listasvih.size();j++)
        	{
        		if(listasvih.get(j).equals(racuni.get(i).getPotrosac()))
        		{
        			if(provjera.equals("Pausalac"))
        			{
                		vodaPausalni=vodaPausalni+voda;
                		kanalizacijaPausalni=kanalizacijaPausalni+kanalizacija;
        			}
        			else
        			{
                		vodaOstali=vodaOstali+voda;
                		kanalizacijaOstali=kanalizacijaOstali+kanalizacija;
        			}
        			pomocna=true;
        			break;
        		}
        	}
        	if(pomocna==true)
        	{
        		pomocna=false;
        		continue;
        	}
        	if(provjera.equals("Pausalac"))
        	{
        		vodaPausalni=vodaPausalni+voda;
        		kanalizacijaPausalni=kanalizacijaPausalni+kanalizacija;
        		brojPausalni++;
        		listasvih.add(racuni.get(i).getPotrosac());
        	}
        	else
        	{
        		vodaOstali=vodaOstali+voda;
        		kanalizacijaOstali=kanalizacijaOstali+kanalizacija;
        		brojOstali++;
        		listasvih.add(racuni.get(i).getPotrosac());
        	}
        }
        novi.setBrojOstalih(brojOstali);
        novi.setBrojPausalaca(brojPausalni);
        novi.setPotrosnjaOstalihKanalizacija(kanalizacijaOstali);
        novi.setPotrosnjaOstalihVoda(vodaOstali);
        novi.setPotrosnjaPausalacaKanalizacija(kanalizacijaPausalni);
        novi.setPotrosnjaPausalacaVoda(vodaPausalni);
        novi.setDatumOd(donjaGranica);
        novi.setDatumDo(gornjaGranica);
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
            
            if (p.getKategorija()=="Pausalac"){        
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
             if (potrosaci.get(i).getKategorija()=="Pausalac"){
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
    public List<Racuni> nadjiListuRacuna(Date donjaGranica, Date gornjaGranica){
        
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
    
    
    
    
    // Printanje izvjestaja :
    
    public void print(Izvjestaji i) throws FileNotFoundException, DRException{
    //dynamic report
                JasperReportBuilder report = DynamicReports.report();
                //add title
                TextFieldBuilder<String> title1 = DynamicReports.cmp.text("  Vodovod i Kanalizacija d.o.o.\n");
                report.title(title1);
                TextFieldBuilder<String> title2 = DynamicReports.cmp.text("  Jaroslava Černija 8, 71 000 Sarajevo\n");
                report.title(title2);
                TextFieldBuilder<String> title3 = DynamicReports.cmp.text("  Tel: +387 33 237-655\n\n\n\n");
                report.title(title3);

                // Za ova sva polja ispod mora biti ispis :
                i.getBrojPausalaca();
                i.getBrojOstalih();
                i.getPotrosnjaOstalihKanalizacija();
                i.getPotrosnjaOstalihVoda();
                i.getPotrosnjaPausalacaKanalizacija();
                i.getPotrosnjaPausalacaVoda();
                
                
                TextFieldBuilder<String> title4 = DynamicReports.cmp.text("  Broj paušalnih:" + i.getBrojPausalaca() + "\n");
                report.title(title4);
                
                 TextFieldBuilder<String> title5 = DynamicReports.cmp.text("  Broj ostalih:" + i.getBrojOstalih() + "\n");
                report.title(title5);
                
                 TextFieldBuilder<String> title6 = DynamicReports.cmp.text("  Potrošnja ostalih (kanalizacija):" + i.getPotrosnjaOstalihKanalizacija() + "\n");
                report.title(title6);
                
                 TextFieldBuilder<String> title7 = DynamicReports.cmp.text("  Broj ostalih (voda):" + i.getPotrosnjaOstalihVoda() + "\n");
                report.title(title7);
                
                TextFieldBuilder<String> title8 = DynamicReports.cmp.text("  Potrošnja paušalaca (kanalizacija):" + i.getPotrosnjaPausalacaKanalizacija() + "\n");
                report.title(title8);
  
   
       
                ParametriService ps= new ParametriService();
                Parametri p=ps.dajParametre();
                
                double potrosnjaPausalci;
                 potrosnjaPausalci=i.getPotrosnjaPausalacaVoda()*(p.getPvnZaKoristenjeVoda()+p.getPvnZaZastituVoda()+p.getCijenaVodePoKubiku())
                                    + p.getFiksniKanalizacijaZaPausalce()*i.getPotrosnjaPausalacaKanalizacija();;
                 
                 double potrosnjaOstali;
                 potrosnjaOstali=i.getPotrosnjaOstalihVoda()*(p.getPvnZaKoristenjeVoda()+p.getPvnZaZastituVoda()+p.getCijenaVodePoKubiku())
                         + p.getCijenaKanalizacijePoKubiku()*i.getPotrosnjaOstalihKanalizacija();
                 
                 double prihodPausalci;
                 prihodPausalci=potrosnjaPausalci*(1+p.getStopaPdv()/100);
                 
                 double prihodOstali;
                 prihodOstali=potrosnjaOstali*(1+p.getStopaPdv()/100);
                 
                 
                TextFieldBuilder<String> title9 = DynamicReports.cmp.text("  Potrošnja paušalci:" +  potrosnjaPausalci + "\n");
                report.title(title9);
                
                 TextFieldBuilder<String> title10 = DynamicReports.cmp.text("  Potrošnja ostalih:" + potrosnjaOstali + "\n");
                report.title(title10);
                
                TextFieldBuilder<String> title11 = DynamicReports.cmp.text("  Prihod pausalci:" + prihodPausalci + "\n");
                report.title(title11);
                
                 TextFieldBuilder<String> title12 = DynamicReports.cmp.text("  Prihod ostali:" + prihodOstali + "\n");
                report.title(title12);
                
                 TextFieldBuilder<String> title13 = DynamicReports.cmp.text("  Ukupni prihod:" + prihodPausalci+prihodOstali + "\n");
                report.title(title13);
                
                
                // Za Dodatna polja :
                // potrosnjaPausalci = PotrosnjaVodaPausalac*(PVN1+PVN2+cijenaVoda) + PotrosnjaKanalizacijaPausalac*cijenaKanalizacija
                // potrosnjaOstali = PotrosnjaVodaOstalih*(PVN1+PVN2+cijenaVoda) + PotrosnjaKanalizacijaOstalih*cijenaKanalizacija
                // Dodatna polja :
                    // 1. Ukupni prihod za Pausalce = potrosnjaPausalci*(1+stopaPDV/100)
                    // 2. Ukupni prihod za Ostale = potrosnjaOstali*(1+stopaPDV/100)
                    // 3. Ukupni prihod za Sviju = 1. + 2. 
                
                
                TextFieldBuilder<String> title20 =DynamicReports.cmp.text("Potpis ovlaštenog lica: ___________________ \n");
                report.title(title20);
                String s = i.getDatumOd()+"-"+i.getDatumDo();
                TextFieldBuilder<String> title21 = DynamicReports.cmp.text("Datum: " + s);
                report.title(title21);          
                report.show(true);
    
    }
    
}