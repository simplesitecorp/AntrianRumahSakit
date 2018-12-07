/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Antrian;
import util.NewHibernateUtil;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Bernadette Chrestella - bernadettechrestella@gmail.com
 */
public class antrianHelper {

    public antrianHelper() {

    }

    public List<Antrian> getAllAntrian() {
        List<Antrian> result = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        String query = "from Antrian a";
        Query q = session.createQuery(query);
        result = q.list();
        session.close();
        return result;

    }

    public void addNewAntrian(String namaPsn, String namaRs,
            String namaKlinik,
            Date date,
            int nomorAntrian) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Antrian antrian = new Antrian(namaPsn, namaRs, namaKlinik, date, 0);
        session.saveOrUpdate(antrian);
        transaction.commit();
        session.close();
    }
//    
//    public int getNomorAntrianTerakhir(String namaRs, namaKlinik, date){
//        
//    }
}
