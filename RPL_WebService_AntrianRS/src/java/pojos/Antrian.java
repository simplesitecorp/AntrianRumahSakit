package pojos;
// Generated Nov 26, 2018 2:51:37 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Antrian generated by hbm2java
 */
public class Antrian  implements java.io.Serializable {


     private String namaPsn;
     private String namaRs;
     private String namaKlinik;
     private Date date;

    public Antrian() {
    }

    public Antrian(String namaPsn, String namaRs, String namaKlinik, Date date) {
       this.namaPsn = namaPsn;
       this.namaRs = namaRs;
       this.namaKlinik = namaKlinik;
       this.date = date;
    }
   
    public String getNamaPsn() {
        return this.namaPsn;
    }
    
    public void setNamaPsn(String namaPsn) {
        this.namaPsn = namaPsn;
    }
    public String getNamaRs() {
        return this.namaRs;
    }
    
    public void setNamaRs(String namaRs) {
        this.namaRs = namaRs;
    }
    public String getNamaKlinik() {
        return this.namaKlinik;
    }
    
    public void setNamaKlinik(String namaKlinik) {
        this.namaKlinik = namaKlinik;
    }
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }




}


