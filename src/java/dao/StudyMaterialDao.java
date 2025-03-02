package dao;

import entity.StudyMaterial;
import entity.User;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.HibernateUtil;

public class StudyMaterialDao {

    public List<StudyMaterial> getStudyMaterial() {
        List<StudyMaterial> userList = null;
        Session hbSession = null;
        try {
            hbSession = HibernateUtil.getSessionFactory().openSession();  // Open session
            Query query = hbSession.createQuery("FROM StudyMaterial"); // Boolean condition fixed
            userList = query.list();  // Use list() in Hibernate 4
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (hbSession != null && hbSession.isOpen()) {
                hbSession.close(); // Close session in finally block
            }
        }
        return userList;
    }

    public boolean saveStudyMaterial(String subject, String fileName, String studyText, Long id) {
        Session hbSession = null;
        Transaction transaction = null;
        boolean isSuccess = false;

        try {
            hbSession = HibernateUtil.getSessionFactory().openSession();
            transaction = hbSession.beginTransaction();

            StudyMaterial sm;

            if (id != null) {
                sm = (StudyMaterial) hbSession.get(StudyMaterial.class, id);
                if (sm == null) {
                    System.out.println("StudyMaterial with ID " + id + " not found. Creating a new one.");
                    sm = new StudyMaterial(); // Create a new instance if not found
                }
            } else {
                sm = new StudyMaterial(); // Create a new instance for a new record
            }

            // Set/update values
            sm.setSubject(subject);
            sm.setFileName(fileName);
            sm.setStudyText(studyText);
            sm.setUploadTime(new Date());

            hbSession.saveOrUpdate(sm); // Save if new, update if exists
            transaction.commit();
            isSuccess = true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (hbSession != null && hbSession.isOpen()) {
                hbSession.close();
            }
        }
        return isSuccess;
    }

    public StudyMaterial getStudyMaterialById(Long id) {
        Session hbSession = null;
        StudyMaterial sm = null;
        try {
            hbSession = HibernateUtil.getSessionFactory().openSession();
            Query query = hbSession.createQuery("FROM StudyMaterial sm WHERE sm.id = :id");
            query.setParameter("id", id);
            sm = (StudyMaterial) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (hbSession != null && hbSession.isOpen()) {
                hbSession.close();
            }
        }
        return sm;
    }

    public void deleteStudyMaterial(Long id) {
        Session hbSession = null;
        Transaction transaction = null;
        try {
            hbSession = HibernateUtil.getSessionFactory().openSession();
            transaction = hbSession.beginTransaction();

            StudyMaterial sm = (StudyMaterial) hbSession.get(StudyMaterial.class, id);
            if (sm != null) {
                hbSession.delete(sm);
                transaction.commit();
            } else {
                System.out.println("StudyMaterial with ID " + id + " not found.");
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (hbSession != null && hbSession.isOpen()) {
                hbSession.close();
            }
        }
    }

}
