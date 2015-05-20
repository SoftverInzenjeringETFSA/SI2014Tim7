package ba.unsa.etf.si.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.unsa.etf.si.app.entity.Parametri;
import ba.unsa.etf.si.app.entity.Racuni;

public class RacuniDAO extends AbstractDAO<Racuni,Integer> {

	
	private Session session;
	
	public void setSession(Session s){
		this.session = s;
	}
	public List<Racuni> PreuzmiSveRacune(){
		return null;
	}	
	
	public void closeSession(){
		session.close();
	}
	
}
