/*
Write a servlet program to search for an employee by their ID in the employee table and 
display their details. The employee ID should be entered by the user via an HTML form.
 */
package p1;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;


/**
 *
 * @author kanoo
 */
public class SearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        String ID = req.getParameter("ID");
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/2804", "root", "root");
            PreparedStatement pst=con.prepareStatement("select * from ROOT.employee where empid=?");
            pst.setString(1, ID);
            ResultSet rs=pst.executeQuery();
             out.println("<table border=2px bold> ");
            out.println("<th>ID</th><th>Name</th><th>Dept</th><th>Salary</th>");
            while (rs.next()) {      
                
                out.println("<tr><td>"+ rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td></tr>");
                
                
            }
            
            out.println("</table>");
            
            rs.close();
            pst.close();
            con.close();
        } catch (Exception e) {
            out.println(e);
        }




//To change body of generated methods, choose Tools | Templates.
    }

    
}
