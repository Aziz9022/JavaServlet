/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateful;

import java.sql.*;
import javax.ejb.Stateful;

/**
 *
 * @author kanoo
 */
@Stateful
public class MarksEntryBean {
    Connection con = null;
    PreparedStatement st = null;

    public void addMarks(String sname, int m1, int m2, int m3) {
        try {
            // Load Derby driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/2804", "root", "root");
            

            String query = "INSERT INTO marks (sname, marks1, marks2, marks3) VALUES (?, ?, ?, ?)";
            st = con.prepareStatement(query);
            st.setString(1, sname);
            st.setInt(2, m1);
            st.setInt(3, m2);
            st.setInt(4, m3);
            st.executeUpdate();
            System.out.println("Marks entered successfully!");
        } catch (Exception e) {
            e.printStackTrace(); // Always log full exceptions
        } finally {
            // Close resources
            try { if (st != null) st.close(); } catch (Exception e) {}
            try { if (con != null) con.close(); } catch (Exception e) {}
        }
    }
}