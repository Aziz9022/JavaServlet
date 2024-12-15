/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1;
import java.sql.*;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;

/**
 *
 * @author kanoo
 */
public class DeleteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        String name=req.getParameter("name");
        try {
             Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con= DriverManager.getConnection("jdbc:derby://localhost:1527/2804", "root", "root");
            Statement st=con.createStatement();
            PreparedStatement pst=con.prepareStatement("delete from employee where empid =?");
            pst.setString(1, name);
            int i =pst.executeUpdate();
            pst.close();
            if (i>0) {
                  out.println("<h1>row deleted</h1>");
                
            } else {
                  out.println("<h1>Employ not found</h1>");
            }
            
        } catch (Exception e) {
            out.println(e);
        }
        
        

//To change body of generated methods, choose Tools | Templates.
    }

    
}
