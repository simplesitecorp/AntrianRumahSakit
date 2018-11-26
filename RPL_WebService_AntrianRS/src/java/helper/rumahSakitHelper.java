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
import pojos.RumahSakit;
import util.NewHibernateUtil;

/**
 *
 * @author Bernadette Chrestella - bernadettechrestella@gmail.com
 */
public class rumahSakitHelper {

    public rumahSakitHelper() {

    }

    public List<RumahSakit> getAllRumahSakit() {
        List<RumahSakit> result = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        String query = "from RumahSakit r";
        Query q = session.createQuery(query);
        result = q.list();
        session.close();
        return result;

    }

    public void addNewRumahSakit(String userNameRs, String passwordRs,
            String namaRs,
            String alamatRs,
            int telpRs,
            String emailRs) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        RumahSakit rumahSakit = new RumahSakit(userNameRs, passwordRs, namaRs, alamatRs, telpRs, emailRs);
        session.saveOrUpdate(rumahSakit);
        transaction.commit();
        session.close();
    }
}
