package dao;

import entity.User;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import utility.HibernateUtil;

 
public class StudentDao {

    public List<User> getStudents() {
        List<User> userList = null;
        Session hbSession = null;
        try {
            hbSession = HibernateUtil.getSessionFactory().openSession();  
            Query query = hbSession.createQuery("FROM User WHERE type='student' "); 
            userList = query.list();  
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (hbSession != null && hbSession.isOpen()) {
                hbSession.close(); 
            }
        }
        return userList;
    }
}
