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
import pojos.Pasien;
import util.NewHibernateUtil;

/**
 *
 * @author Bernadette Chrestella - bernadettechrestella@gmail.com
 */
public class pasienHelper {

    public pasienHelper() {

    }

    public List<Pasien> getAllPasien() {
        List<Pasien> result = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        String query = "from Pasien p";
        Query q = session.createQuery(query);
        result = q.list();
        session.close();
        return result;

    }

    public void addNewPasien(String userNamePsn, String passwordPsn,
            int nikPsn,
            String namaPsn,
            String alamatPsn,
            int telpPsn,
            String emailPsn) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Pasien pasien = new Pasien(userNamePsn, passwordPsn, nikPsn, namaPsn, alamatPsn, telpPsn, emailPsn);
        session.saveOrUpdate(pasien);
        transaction.commit();
        session.close();
    }

    public Pasien login1(String userNamePsn, String passwordPsn) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        String q = "From Pasien p where p.userNamePsn=:userNamePsn AND p.passwordPsn =:passwordPsn";

        Query query = session.createQuery(q);
        query.setParameter("userNamePsn", userNamePsn);
        query.setParameter("passwordPsn", passwordPsn);

        return (Pasien) query.uniqueResult();
    }

    public List<Pasien> searchPasien(
            String userNamePsn,
            String passwordPsn) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String query = "from Pasien where userNamePsn=:userNamePsn AND passwordPsn=:passwordPsn";
        Query q = session.createQuery(query);
        q.setParameter("userNamePsn", userNamePsn);
        q.setParameter("passwordPsn", passwordPsn);
        List<Pasien> list = q.list();
        tx.commit();
        session.close();
        if (list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }
}
