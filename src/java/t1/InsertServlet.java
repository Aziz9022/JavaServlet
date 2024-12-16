/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t1;


import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author kanoo
 */
public class InsertServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String uname = req.getParameter("uname");
        String password1 = req.getParameter("pwd1");
        String password2 = req.getParameter("pwd2");
        String email = req.getParameter("em");
        String country = req.getParameter("cnt");
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/2804", "root", "root");
            if (password1.equals(password2)) {
                PreparedStatement pst=con.prepareStatement("insert into registration values(?,?,?,?)");
                pst.setString(1, uname);
                pst.setString(2, password1);
                pst.setString(3, email);
                pst.setString(4, country);
                pst.executeUpdate();
                pst.close();
                con.close();
                out.println("<h1>Registeration completed</h1>");
                  RequestDispatcher rd = req.getRequestDispatcher("login.html");
                    rd.include(req, resp);
                
            } else {
                out.println("passoword mismatch");
            }

        } catch (Exception e) {
            
        }

    }

}
