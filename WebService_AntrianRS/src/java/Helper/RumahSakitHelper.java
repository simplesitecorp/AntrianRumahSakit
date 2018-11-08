/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import Pojos.RumahSakit;
import Util.NewHibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Afra Rian
 */
public class RumahSakitHelper {
    
    public RumahSakitHelper() {
        
    }
    
    public List<RumahSakit> getAllRumahSakit(){
        List<RumahSakit> result = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        String query = "from RumahSakit r";
        Query q = session.createQuery(query);
        result = q.list();
        session.close();
        return result;
        
    }
    
}
