package ba.unsa.etf.si.app.servisi;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ba.unsa.etf.si.app.dao.PotrosacDAO;
import ba.unsa.etf.si.app.entity.Potrosac;
import ba.unsa.etf.si.app.util.HibernateUtil;

public class PotrosacService {
	private PotrosacDAO dao;
	private Session session;

	
	public PotrosacService(Session session) {
		
		dao = new PotrosacDAO();
		dao.setSession(session);
		this.session = session;
		
	}
		
	public void kreirajPotrosaca(Potrosac p){
		session.beginTransaction();
		if(validateJMBG(p)){
			dao.save(p);
			session.getTransaction().commit();
		} else {
			throw new IllegalArgumentException("JMBG nije validan!");
		}
	}
	
	public void modificirajPotrosaca(Potrosac p){
		session.beginTransaction();
		dao.save(p);
		session.getTransaction().commit();
	}
	
	public void izbrisiPotrosaca(Potrosac p){
		session.beginTransaction();
		dao.delete(p.getId());
		session.getTransaction().commit();
	}
	
	public Potrosac pretragaPoId(Integer id) {
		return dao.findById(id);
	}
	
	public List<Potrosac> pretragaPoIme(String ime){
		Potrosac p = new Potrosac();
		p.setIme(ime);
		return dao.findByExample(p);
		
	}
	
	public Potrosac pretragaPoJMBG(String jmbg){
		Potrosac p = new Potrosac();
		p.setJmbg(jmbg);
		return dao.findByExample(p).get(0);
	}
	
	public List<Potrosac> pretragaPoVodomjeru(Integer sifraVodomjera){
		Potrosac p = new Potrosac();
		p.setSifraVodomjera(sifraVodomjera);
		return dao.findByExample(p);
	}
	
	public List<Potrosac> pretragaPoKategoriji(String kategorija){
		Potrosac p = new Potrosac();
		p.setKategorija(kategorija);
		return dao.findByExample(p);
	}
	
	private Boolean validateJMBG(Potrosac p){
		return true;
        /*String[] jmbg = p.getJmbg().split("");
        if(jmbg.length!=14) {
        return false;
        }
        int[] j;
        j = new int[jmbg.length-1];
        for(int i = 0; i < jmbg.length-1; i++) {
        j[i] = Integer.parseInt(jmbg[i+1]);
        }
        int v = 11-((7*(j[0]+j[6])+6*(j[1]+j[7])+5*(j[2]+j[8])+4*(j[3]+j[9])+3*(j[4]+j[10])+ 2*(j[5]+j[11]))%11);
        return (v<10&&j[12]==v)||(v>9&&j[12]==0);*/
    }
}
