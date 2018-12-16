/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import helper.antrianHelper;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojos.Antrian;

/**
 *
 * @author Bernadette Chrestella - bernadettechrestella@gmail.com
 */
public class testNomorAntrian {

    public static void main(String[] args) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String tanggal = "2018-12-06";
            Date date;
            date = format.parse(tanggal);
            String namaPsn = "Yovanda";
            String namaRs = "RS Dr. Yap";
            String namaKlinik = "Mata";
//            int nomorAntrian = 0;
            Antrian test = new Antrian(namaPsn, namaRs, namaKlinik, date, 0);
            antrianHelper helper = new antrianHelper();
            helper.addNewAntrian(namaRs, namaRs, namaKlinik, date, 0);
//            helper.addNomorAntrian(namaRs, namaKlinik, date);
    } catch (ParseException ex) {
            Logger.getLogger(testCariAntrian.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
