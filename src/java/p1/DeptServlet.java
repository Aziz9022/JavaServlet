/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

 /*
 * @author kanoo
 */
public class DeptServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        String dept=req.getParameter("dept");
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con= DriverManager.getConnection("jdbc:derby://localhost:1527/2804", "root", "root");
            //Statement st=con.createStatement();
            PreparedStatement pst=con.prepareStatement("select * from ROOT.EMPLOYEE where dept=?");
            pst.setString(1, dept);
            ResultSet rs=pst.executeQuery();
            out.println("<table border=2px bold> ");
            out.println("<th>ID</th><th>Name</th><th>Dept</th><th>Salary</th>");
            while (rs.next()) {   
               
                out.println("<tr><td>"+ rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td></tr>");
                
            }
            out.println("</table>");
        } catch (Exception e) {
            out.println(e);
        }

//To change body of generated methods, choose Tools | Templates.
    }

    
}
