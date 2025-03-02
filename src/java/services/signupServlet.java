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

@WebServlet(name = "signupServlet", urlPatterns = {"/signupServlet"})
public class signupServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String cpassword = request.getParameter("confirmPassword");

        Session hbSession = null;
        Transaction transaction = null;

        try {
            // Validate input fields
            if (name == null || name.trim().isEmpty()) {
                response.sendRedirect("signup.jsp?msg=invalid_name");
                return;
            }
            if (email == null || email.trim().isEmpty()
                    || !email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                response.sendRedirect("signup.jsp?msg=invalid_email");
                return;
            }
            if (password == null || password.length() < 6) {
                response.sendRedirect("signup.jsp?msg=weak_password");
                return;
            }
            if (!password.equals(cpassword)) {
                response.sendRedirect("signup.jsp?msg=pass_not_match");
                return;
            }

            hbSession = HibernateUtil.getSessionFactory().openSession();

            Query query = hbSession.createQuery("FROM User WHERE email = :email");
            query.setParameter("email", email);
            User existingUser = (User) query.uniqueResult();

            if (existingUser != null) {
                response.sendRedirect("signup.jsp?msg=email_exists");
                return;
            }

            transaction = hbSession.beginTransaction();

            User user = new User();
            user.setUserName(name);
            user.setEmail(email);
            user.setPassword(password);
            user.setIsActive("false");
            user.setType("student");

            hbSession.save(user);
            transaction.commit();

            response.sendRedirect("login.jsp?msg=success");  // Successful signup

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();  // Rollback if an error occurs
            }
            e.printStackTrace();
            response.sendRedirect("signup.jsp?msg=error&reason=exception");
        } finally {
            if (hbSession != null && hbSession.isOpen()) {
                hbSession.close(); // Close Hibernate hbSession
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
