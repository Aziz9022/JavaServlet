/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl;


import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
/**
 *
 * @author kanoo
 */
@WebServlet(name = "NewServlet", urlPatterns = {"/LoginServlet"})
public class NewServlet extends HttpServlet {

 
     
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String USERNAME = "admin";
            String PASSWORD = "password123";
            // Get username and password from the form
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            // Check credentials
            if (USERNAME.equals(username) && PASSWORD.equals(password)) {
                System.err.println("HEER");
                out.println("<h1>Hello, " + username + "!</h1>");
            } else {
                System.err.println("HER2");
                out.println("<h1>Login failed. Invalid username or password.</h1>");
            }
            out.println("<a href='login.html'>Go back to Login</a>");

        } catch (Exception e) {

            out.println(e);

        }
    }

}
