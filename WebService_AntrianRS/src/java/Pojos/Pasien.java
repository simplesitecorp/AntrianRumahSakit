package Pojos;
// Generated Nov 23, 2018 2:54:14 PM by Hibernate Tools 4.3.1



/**
 * Pasien generated by hbm2java
 */
public class Pasien  implements java.io.Serializable {


     private String userNamePsn;
     private String passwordPsn;
     private int nikPsn;
     private String namaPsn;
     private String alamatPsn;
     private int telpPsn;
     private String emailPsn;

    public Pasien() {
    }

    public Pasien(String userNamePsn, String passwordPsn, int nikPsn, String namaPsn, String alamatPsn, int telpPsn, String emailPsn) {
       this.userNamePsn = userNamePsn;
       this.passwordPsn = passwordPsn;
       this.nikPsn = nikPsn;
       this.namaPsn = namaPsn;
       this.alamatPsn = alamatPsn;
       this.telpPsn = telpPsn;
       this.emailPsn = emailPsn;
    }
   
    public String getUserNamePsn() {
        return this.userNamePsn;
    }
    
    public void setUserNamePsn(String userNamePsn) {
        this.userNamePsn = userNamePsn;
    }
    public String getPasswordPsn() {
        return this.passwordPsn;
    }
    
    public void setPasswordPsn(String passwordPsn) {
        this.passwordPsn = passwordPsn;
    }
    public int getNikPsn() {
        return this.nikPsn;
    }
    
    public void setNikPsn(int nikPsn) {
        this.nikPsn = nikPsn;
    }
    public String getNamaPsn() {
        return this.namaPsn;
    }
    
    public void setNamaPsn(String namaPsn) {
        this.namaPsn = namaPsn;
    }
    public String getAlamatPsn() {
        return this.alamatPsn;
    }
    
    public void setAlamatPsn(String alamatPsn) {
        this.alamatPsn = alamatPsn;
    }
    public int getTelpPsn() {
        return this.telpPsn;
    }
    
    public void setTelpPsn(int telpPsn) {
        this.telpPsn = telpPsn;
    }
    public String getEmailPsn() {
        return this.emailPsn;
    }
    
    public void setEmailPsn(String emailPsn) {
        this.emailPsn = emailPsn;
    }




}


