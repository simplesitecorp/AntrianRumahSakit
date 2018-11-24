/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import Pojos.Antrian;
import Util.NewHibernateUtil;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Afra Rian
 */
public class AntrianHelper {

    public AntrianHelper() {

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
            Date date) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Antrian antrian = new Antrian(namaPsn, namaRs, namaKlinik, date);
        session.saveOrUpdate(antrian);
        transaction.commit();
        session.close();
    }

}
