package pojos;
// Generated Nov 26, 2018 2:51:37 PM by Hibernate Tools 4.3.1



/**
 * Klinik generated by hbm2java
 */
public class Klinik  implements java.io.Serializable {


     private String idKlinik;
     private String namaKlinik;
     private String namaRs;
     private int limitAntrian;

    public Klinik() {
    }

    public Klinik(String idKlinik, String namaKlinik, String namaRs, int limitAntrian) {
       this.idKlinik = idKlinik;
       this.namaKlinik = namaKlinik;
       this.namaRs = namaRs;
       this.limitAntrian = limitAntrian;
    }
   
    public String getIdKlinik() {
        return this.idKlinik;
    }
    
    public void setIdKlinik(String idKlinik) {
        this.idKlinik = idKlinik;
    }
    public String getNamaKlinik() {
        return this.namaKlinik;
    }
    
    public void setNamaKlinik(String namaKlinik) {
        this.namaKlinik = namaKlinik;
    }
    public String getNamaRs() {
        return this.namaRs;
    }
    
    public void setNamaRs(String namaRs) {
        this.namaRs = namaRs;
    }
    public int getLimitAntrian() {
        return this.limitAntrian;
    }
    
    public void setLimitAntrian(int limitAntrian) {
        this.limitAntrian = limitAntrian;
    }




}

