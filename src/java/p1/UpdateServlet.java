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
public class UpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        String id=req.getParameter("ID");
        int Sal=Integer.parseInt(req.getParameter("Salary"));
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con= DriverManager.getConnection("jdbc:derby://localhost:1527/2804", "root", "root");
            
            PreparedStatement pst=con.prepareStatement("Update employee set salary=? where empid=?");
            pst.setInt(1, Sal);
            pst.setString(2, id);
            pst.executeUpdate();
            pst.close();
            out.println("table updated ");
        } catch (Exception e) {
            out.println(e);
        }


//To change body of generated methods, choose Tools | Templates.
    }

    

}
