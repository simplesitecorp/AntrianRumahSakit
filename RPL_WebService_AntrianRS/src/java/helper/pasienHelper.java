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
    public pasienHelper(){
        
    }
    
    public List<Pasien> getAllPasien(){
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
            String emailPsn){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Pasien pasien = new Pasien(userNamePsn, passwordPsn, nikPsn, namaPsn, alamatPsn, telpPsn, emailPsn);
        session.saveOrUpdate(pasien);
        transaction.commit();
        session.close();
    }
}
