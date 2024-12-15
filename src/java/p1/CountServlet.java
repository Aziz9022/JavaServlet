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
public class CountServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con= DriverManager.getConnection("jdbc:derby://localhost:1527/2804", "root", "root");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select count(empname) as total_employee from ROOT.employee ");
            while (rs.next()) {                
                out.println("<h1> total count of employee: "+ rs.getString(1) + "</h1>");
            }
                rs.close();
                st.close();
        } catch (Exception e) {
            out.println(e);
        }
        

//To change body of generated methods, choose Tools | Templates.
    }

   
}
