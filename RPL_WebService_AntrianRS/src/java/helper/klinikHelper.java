/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Klinik;
import util.NewHibernateUtil;

/**
 *
 * @author Bernadette Chrestella - bernadettechrestella@gmail.com
 */
public class klinikHelper {

    public klinikHelper() {

    }

    public List<Klinik> getAllKlinik() {
        List<Klinik> result = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        String query = "from Klinik k";
        Query q = session.createQuery(query);
        result = q.list();
        session.close();
        return result;

    }

    public void addNewKlinik(String idKlinik, String namaKlinik,
            String namaRs,
            int limitAntrian) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Klinik klinik = new Klinik(idKlinik, namaKlinik, namaRs, limitAntrian);
        session.saveOrUpdate(klinik);
        transaction.commit();
        session.close();
    }
}
