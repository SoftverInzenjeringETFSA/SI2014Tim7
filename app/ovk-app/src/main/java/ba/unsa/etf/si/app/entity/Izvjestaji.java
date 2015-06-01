package ba.unsa.etf.si.app.entity;
// Generated May 10, 2015 4:50:37 PM by Hibernate Tools 4.3.1

import java.util.Date;




/**
 * Izvjestaji generated by hbm2java
 */
public class Izvjestaji  implements java.io.Serializable {

	 private static final long serialVersionUID = 1L;

     private Integer id;
     private Integer brojPausalaca;
     private Double potrosnjaPausalacaVoda;
     private Double potrosnjaPausalacaKanalizacija;
     private Integer brojOstalih;
     private Double potrosnjaOstalihVoda;
     private Double potrosnjaOstalihKanalizacija;
     private Date datumOd;
     private Date datumDo;

    public Izvjestaji() {
    }

    public Izvjestaji(Integer brojPausalaca, Double potrosnjaPausalacaVoda, Double potrosnjaPausalacaKanalizacija, Integer brojOstalih, Double potrosnjaOstalihVoda, Double potrosnjaOstalihKanalizacija, Date datumOd, Date datumDo) {
       this.brojPausalaca = brojPausalaca;
       this.potrosnjaPausalacaVoda = potrosnjaPausalacaVoda;
       this.potrosnjaPausalacaKanalizacija = potrosnjaPausalacaKanalizacija;
       this.brojOstalih = brojOstalih;
       this.potrosnjaOstalihVoda = potrosnjaOstalihVoda;
       this.potrosnjaOstalihKanalizacija = potrosnjaOstalihKanalizacija;
       this.datumOd = datumOd;
       this.datumDo = datumDo;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getBrojPausalaca() {
        return this.brojPausalaca;
    }
    
    public void setBrojPausalaca(Integer brojPausalaca) {
        this.brojPausalaca = brojPausalaca;
    }
    public Double getPotrosnjaPausalacaVoda() {
        return this.potrosnjaPausalacaVoda;
    }
    
    public void setPotrosnjaPausalacaVoda(Double potrosnjaPausalacaVoda) {
        this.potrosnjaPausalacaVoda = potrosnjaPausalacaVoda;
    }
    public Double getPotrosnjaPausalacaKanalizacija() {
        return this.potrosnjaPausalacaKanalizacija;
    }
    
    public void setPotrosnjaPausalacaKanalizacija(Double potrosnjaPausalacaKanalizacija) {
        this.potrosnjaPausalacaKanalizacija = potrosnjaPausalacaKanalizacija;
    }
    public Integer getBrojOstalih() {
        return this.brojOstalih;
    }
    
    public void setBrojOstalih(Integer brojOstalih) {
        this.brojOstalih = brojOstalih;
    }
    public Double getPotrosnjaOstalihVoda() {
        return this.potrosnjaOstalihVoda;
    }
    
    public void setPotrosnjaOstalihVoda(Double potrosnjaOstalihVoda) {
        this.potrosnjaOstalihVoda = potrosnjaOstalihVoda;
    }
    public Double getPotrosnjaOstalihKanalizacija() {
        return this.potrosnjaOstalihKanalizacija;
    }
    
    public void setPotrosnjaOstalihKanalizacija(Double potrosnjaOstalihKanalizacija) {
        this.potrosnjaOstalihKanalizacija = potrosnjaOstalihKanalizacija;
    }
    public Date getDatumOd() {
        return this.datumOd;
    }
    
    public void setDatumOd(Date datumOd) {
        this.datumOd = datumOd;
    }
    
    public Date getDatumDo() {
        return this.datumDo;
    }
    
    public void setDatumDo(Date datumDo) {
        this.datumDo = datumDo;
    }



}


