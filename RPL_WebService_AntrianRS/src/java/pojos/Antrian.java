package pojos;
// Generated Dec 15, 2018 7:41:16 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Antrian generated by hbm2java
 */
public class Antrian  implements java.io.Serializable {


     private String namaPsn;
     private String namaRs;
     private String namaKlinik;
         private Date tanggal;
     private int nomorAntrian;

    public Antrian() {
    }

    public Antrian(String namaPsn, String namaRs, String namaKlinik, Date tanggal, int nomorAntrian) {
       this.namaPsn = namaPsn;
       this.namaRs = namaRs;
       this.namaKlinik = namaKlinik;
       this.tanggal = tanggal;
       this.nomorAntrian = nomorAntrian;
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
    public Date getTanggal() {
        return this.tanggal;
    }
    
    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }
    public int getNomorAntrian() {
        return this.nomorAntrian;
    }
    
    public void setNomorAntrian(int nomorAntrian) {
        this.nomorAntrian = nomorAntrian;
    }




}


