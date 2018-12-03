/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import helper.pasienHelper;
import pojos.Pasien;

/**
 *
 * @author Bernadette Chrestella - bernadettechrestella@gmail.com
 */
public class testAddPasien {

    public static void main(String[] args){
            String userNamePsn = "yova";
            String passwordPsn = "yova123";
            int nikPsn = 456731;
            String namaPsn = "Yovanda";
            String alamatPsn = "Paingan Jaya";
            int telpPsn = 963214;
            String emailPsn = "Pria";
            Pasien test = new Pasien(userNamePsn, passwordPsn, nikPsn, namaPsn, alamatPsn, telpPsn, emailPsn);
            pasienHelper helper = new pasienHelper();
            helper.addNewPasien(userNamePsn, passwordPsn, nikPsn, namaPsn, alamatPsn, telpPsn, emailPsn);
    }
}
