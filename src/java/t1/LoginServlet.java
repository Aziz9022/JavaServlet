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
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/2804", "root", "root");
            PreparedStatement pst = con.prepareStatement("Select password from REGISTRATION where username=?");
            pst.setString(1, uname);
            ResultSet rs = pst.executeQuery();
             if (rs.next()) {
                String dbPassword = rs.getString("password");
                if (dbPassword.equals(pwd)) {
                    RequestDispatcher rd = req.getRequestDispatcher("welcome.html");
                    rd.forward(req, resp);
                } else {
                    out.println("<h3>Incorrect password! Redirecting to Login...</h3>");
                                        RequestDispatcher rd = req.getRequestDispatcher("login.html");
                    rd.include(req, resp);
                }
            } else {
                  out.println("<h3>User does not exist! Redirecting to Registration...</h3>"); 
                RequestDispatcher rd = req.getRequestDispatcher("index.html");
                rd.forward(req, resp);
             
            }

        } catch (Exception e) {
            
        }

//To change body of generated methods, choose Tools | Templates.
    }

}
