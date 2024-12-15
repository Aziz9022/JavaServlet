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
public class AvgServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con= DriverManager.getConnection("jdbc:derby://localhost:1527/2804", "root", "root");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select avg(salary) as AVG_Salary from employee  ");
            out.println("<table>");
            while (rs.next()) {  
                out.println("<h1>Average salary :"+rs.getString(1)+"</h1>");
                out.println("<br>");
            }
            
            
             out.println("</table>");
            
            
            
            
        } catch (Exception e) {
            out.println(e);
        }


//To change body of generated methods, choose Tools | Templates.
    }

   
}
