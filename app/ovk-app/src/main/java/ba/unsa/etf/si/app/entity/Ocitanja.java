package ba.unsa.etf.si.app.entity;
// Generated May 10, 2015 4:50:37 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Ocitanja generated by hbm2java
 */
public class Ocitanja  implements java.io.Serializable {

	 private static final long serialVersionUID = 1L;
   
	 private Integer id;
     private Potrosac potrosacBySifraVodomjera;
     private Potrosac potrosacByIdPotrosaca;
     private Double potrosnja;
     private Integer godina;
     private Integer mjesec;
     private Boolean access;
     //neka greska u mapiranju?
     private Set racunis = new HashSet(0);

    public Ocitanja() {
    }

    public Ocitanja(Potrosac potrosacBySifraVodomjera, Potrosac potrosacByIdPotrosaca, Double potrosnja, Integer godina, Integer mjesec, Boolean access, Set racunis) {
       this.potrosacBySifraVodomjera = potrosacBySifraVodomjera;
       this.potrosacByIdPotrosaca = potrosacByIdPotrosaca;
       this.potrosnja = potrosnja;
       this.godina = godina;
       this.mjesec = mjesec;
       this.access = access;
       this.racunis = racunis;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Potrosac getPotrosacBySifraVodomjera() {
        return this.potrosacBySifraVodomjera;
    }
    
    public void setPotrosacBySifraVodomjera(Potrosac potrosacBySifraVodomjera) {
        this.potrosacBySifraVodomjera = potrosacBySifraVodomjera;
    }
    public Potrosac getPotrosacByIdPotrosaca() {
        return this.potrosacByIdPotrosaca;
    }
    
    public void setPotrosacByIdPotrosaca(Potrosac potrosacByIdPotrosaca) {
        this.potrosacByIdPotrosaca = potrosacByIdPotrosaca;
    }
    public Double getPotrosnja() {
        return this.potrosnja;
    }
    
    public void setPotrosnja(Double potrosnja) {
        this.potrosnja = potrosnja;
    }
    public Integer getGodina() {
        return this.godina;
    }
    
    public void setGodina(Integer godina) {
        this.godina = godina;
    }
    public Integer getMjesec() {
        return this.mjesec;
    }
    
    public void setMjesec(Integer mjesec) {
        this.mjesec = mjesec;
    }
    public Boolean getAccess() {
        return this.access;
    }
    
    public void setAccess(Boolean access) {
        this.access = access;
    }
    public Set getRacunis() {
        return this.racunis;
    }
    
    public void setRacunis(Set racunis) {
        this.racunis = racunis;
    }




}


