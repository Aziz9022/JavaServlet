/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t1;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

/**
 *
 * @author kanoo
 */
public class CreateTableServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con= DriverManager.getConnection("jdbc:derby://localhost:1527/2804","root","root");
            Statement st=con.createStatement();
            String sql = "CREATE TABLE registration ("
            
            + "  username VARCHAR(255), "
            + "  password VARCHAR(255), "
            + "  email VARCHAR(255), "
            + "  country VARCHAR(255) "
            + ")";

         st.executeUpdate(sql);
        } catch (Exception e) {
            out.println(e);
        }
    }

}
