package ba.unsa.etf.si.app.entity;
// Generated May 10, 2015 4:50:37 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Potrosac generated by hbm2java
 */
public class Potrosac  implements java.io.Serializable {

	 private static final long serialVersionUID = 1L;
	 
     private Integer id;
     private String ime;
     private String prezime;
     private String jmbg;
     private String adresa;
     private String telefon;
     private String brojClanova;
     private String kategorija;
     private Integer sifraVodomjera;
     private Boolean usluga;
     private Boolean aktivnost;
     private Boolean hidden;
     //popraviti ovo
     private Set ocitanjasForSifraVodomjera = new HashSet(0);
     private Set racunis = new HashSet(0);
     private Set ocitanjasForIdPotrosaca = new HashSet(0);

    public Potrosac() {
    }

    public Potrosac(String ime, String prezime, String jmbg, String adresa, String telefon, String brojClanova, String kategorija, Integer sifraVodomjera, Boolean usluga, Boolean aktivnost, Boolean hidden, Set ocitanjasForSifraVodomjera, Set racunis, Set ocitanjasForIdPotrosaca) {
       this.ime = ime;
       this.prezime = prezime;
       this.jmbg = jmbg;
       this.adresa = adresa;
       this.telefon = telefon;
       this.brojClanova = brojClanova;
       this.kategorija = kategorija;
       this.sifraVodomjera = sifraVodomjera;
       this.usluga = usluga;
       this.aktivnost = aktivnost;
       this.hidden = hidden;
       this.ocitanjasForSifraVodomjera = ocitanjasForSifraVodomjera;
       this.racunis = racunis;
       this.ocitanjasForIdPotrosaca = ocitanjasForIdPotrosaca;
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
    public String getBrojClanova() {
        return this.brojClanova;
    }
    
    public void setBrojClanova(String brojClanova) {
        this.brojClanova = brojClanova;
    }
    public String getKategorija() {
        return this.kategorija;
    }
    
    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }
    public Integer getSifraVodomjera() {
        return this.sifraVodomjera;
    }
    
    public void setSifraVodomjera(Integer sifraVodomjera) {
        this.sifraVodomjera = sifraVodomjera;
    }
    public Boolean getUsluga() {
        return this.usluga;
    }
    
    public void setUsluga(Boolean usluga) {
        this.usluga = usluga;
    }
    public Boolean getAktivnost() {
        return this.aktivnost;
    }
    
    public void setAktivnost(Boolean aktivnost) {
        this.aktivnost = aktivnost;
    }
    public Boolean getHidden() {
        return this.hidden;
    }
    
    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }
    public Set getOcitanjasForSifraVodomjera() {
        return this.ocitanjasForSifraVodomjera;
    }
    
    public void setOcitanjasForSifraVodomjera(Set ocitanjasForSifraVodomjera) {
        this.ocitanjasForSifraVodomjera = ocitanjasForSifraVodomjera;
    }
    public Set getRacunis() {
        return this.racunis;
    }
    
    public void setRacunis(Set racunis) {
        this.racunis = racunis;
    }
    public Set getOcitanjasForIdPotrosaca() {
        return this.ocitanjasForIdPotrosaca;
    }
    
    public void setOcitanjasForIdPotrosaca(Set ocitanjasForIdPotrosaca) {
        this.ocitanjasForIdPotrosaca = ocitanjasForIdPotrosaca;
    }
}


