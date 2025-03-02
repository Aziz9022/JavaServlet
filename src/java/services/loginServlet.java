package services;

import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.HibernateUtil;

@WebServlet(name = "loginServlet", urlPatterns = {"/loginServlet"})
public class loginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Session hbSession = null;
        Transaction transaction = null;
        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            hbSession = HibernateUtil.getSessionFactory().openSession();

            Query query = hbSession.createQuery("FROM User WHERE email = :email");
            query.setParameter("email", email);
            User existingUser = (User) query.uniqueResult();

            if (existingUser == null) {
                response.sendRedirect("login.jsp?msg=user_not_found");
                return;
            }

            query = hbSession.createQuery("FROM User WHERE email = :email and password = :password");
            query.setParameter("email", email);
            query.setParameter("password", password);
            existingUser = (User) query.uniqueResult();

            if (existingUser == null) {
                response.sendRedirect("login.jsp?msg=user_password_error");
                return;
            }
            
            HttpSession userSession = request.getSession();
            userSession.setAttribute("email", email);
            userSession.setAttribute("userName", existingUser.getUserName());
            userSession.setAttribute("userId", existingUser.getId());
            userSession.setAttribute("isActive", existingUser.getIsActive());
            userSession.setAttribute("type", existingUser.getType());
            response.sendRedirect("dashboard.jsp");

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error in Login : " + e);
            response.sendRedirect("login.jsp?msg=error&reason=exception");
        } finally {
            if (hbSession != null && hbSession.isOpen()) {
                hbSession.close();
            }
        }

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
