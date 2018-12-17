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
            Date tanggal,
            int nomorAntrian) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Antrian antrian = new Antrian(namaPsn, namaRs, namaKlinik, tanggal, nomorAntrian);
        session.saveOrUpdate(antrian);
        transaction.commit();
        session.close();
    }

    public int addNomorAntrian(
            String namaRs,
            String namaKlinik,
            Date tanggal) {
        List<Antrian> list = searchAntrian(
            namaRs, namaKlinik, tanggal);
        
        int nomorAntrian = list.size()+1;
//        Session session = NewHibernateUtil.getSessionFactory().openSession();
//        Transaction tx = session.beginTransaction();
//        String query = "from Antrian where namaRs=:namaRs AND namaKlinik=:namaKlinik AND tanggal=:tanggal";
//        Query q = session.createQuery(query);
//        q.setParameter("namaRs", namaRs);
//        q.setParameter("namaKlinik", namaKlinik);
//        q.setParameter("tanggal", tanggal);
//        List<Antrian> list = q.list();
//        antrian = list.size()+1;
        return nomorAntrian;
//        List<Antrian> hasil = null;
//        int result;
//        Session session = NewHibernateUtil.getSessionFactory().openSession();
//        String query = "from Antrian a";
//        Query q = session.createQuery(query);
//        hasil = q.list();
//        result = hasil.size()+1;
//        session.close();
//        return result;
    }

    public List<Antrian> searchAntrian(
            String namaRs,
            String namaKlinik,
            Date tanggal) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String query = "from Antrian where namaRs=:namaRs AND namaKlinik=:namaKlinik AND tanggal=:tanggal";
        Query q = session.createQuery(query);
        q.setParameter("namaRs", namaRs);
        q.setParameter("namaKlinik", namaKlinik);
        q.setParameter("tanggal", tanggal);
        List<Antrian> list = q.list();
        tx.commit();
        session.close();
        if (list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }
}
