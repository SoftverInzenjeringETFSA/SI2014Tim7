package ba.unsa.etf.si.app.entity;
// Generated May 10, 2015 4:50:37 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Korisnik generated by hbm2java
 */
public class Korisnik  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
     private Integer id;
     private String ime;
     private String prezime;
     private String jmbg;
     private String brojLicne;
     private String adresa;
     private String telefon;
     private String mail;
     private Date datumZaposljenja;
     private Boolean admin;
     private String username;
     private String password;

    public Korisnik() {
    }

    public Korisnik(String ime, String prezime, String jmbg, String brojLicne, String adresa, String telefon, String mail, Date datumZaposljenja, Boolean admin, String username, String password) {
       this.ime = ime;
       this.prezime = prezime;
       this.jmbg = jmbg;
       this.brojLicne = brojLicne;
       this.adresa = adresa;
       this.telefon = telefon;
       this.mail = mail;
       this.datumZaposljenja = datumZaposljenja;
       this.admin = admin;
       this.username = username;
       this.password = password;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getIme() {
        return this.ime;
    }
    
    public void setIme(String ime) {
        this.ime = ime;
    }
    public String getPrezime() {
        return this.prezime;
    }
    
    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }
    public String getJmbg() {
        return this.jmbg;
    }
    
    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }
    public String getBrojLicne() {
        return this.brojLicne;
    }
    
    public void setBrojLicne(String brojLicne) {
        this.brojLicne = brojLicne;
    }
    public String getAdresa() {
        return this.adresa;
    }
    
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
    public String getTelefon() {
        return this.telefon;
    }
    
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    public String getMail() {
        return this.mail;
    }
    
    public void setMail(String mail) {
        this.mail = mail;
    }
    public Date getDatumZaposljenja() {
        return this.datumZaposljenja;
    }
    
    public void setDatumZaposljenja(Date datumZaposljenja) {
        this.datumZaposljenja = datumZaposljenja;
    }
    public Boolean getAdmin() {
        return this.admin;
    }
    
    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return ime+" "+prezime+" "+jmbg+" "+username;
    }


}


