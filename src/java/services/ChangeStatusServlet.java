package services;

import entity.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.HibernateUtil;

@WebServlet(name = "ChangeStatusServlet", urlPatterns = {"/ChangeStatusServlet"})
public class ChangeStatusServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sId = request.getParameter("studentId");
        String status = request.getParameter("status");
        Session hbSession = null;
        Transaction transaction = null;
        try {
            hbSession = HibernateUtil.getSessionFactory().openSession();
            transaction = hbSession.beginTransaction();

            Query query = hbSession.createQuery("UPDATE User SET isActive = :status WHERE id = :id");
            query.setParameter("status", status);
            query.setParameter("id", Long.parseLong(sId));
            int updatedRows = query.executeUpdate();

            transaction.commit();
            System.out.println("Updated Rows: " + updatedRows);

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error in Change Status: " + e);
        } finally {
            if (hbSession != null && hbSession.isOpen()) {
                hbSession.close();
            }
        }

        response.sendRedirect("students.jsp");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
