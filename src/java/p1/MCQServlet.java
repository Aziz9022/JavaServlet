/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.sql.*;

/**
 *
 * @author kanoo
 */
public class MCQServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try {

            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/2804", "root", "root");
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Quiz");
            ResultSet rs = stmt.executeQuery();

            out.println("<html><body>");
            out.println("<h2>Quiz: Answer the following questions:</h2>");
            out.println("<form action='ResultServlet' method='post'>");

            int count = 1;
            while (rs.next()) {
                out.println("<p>" + count + ". " + rs.getString("question") + "</p>");
                out.println("<input type='radio' name='" + rs.getInt("Qno") + "' value='" + rs.getString("option1") + "'>" + rs.getString("option1") + "<br>");
                out.println("<input type='radio' name='" + rs.getInt("Qno") + "' value='" + rs.getString("option2") + "'>" + rs.getString("option2") + "<br>");
                out.println("<input type='radio' name='" + rs.getInt("Qno") + "' value='" + rs.getString("option3") + "'>" + rs.getString("option3") + "<br>");
                out.println("<input type='radio' name='" + rs.getInt("Qno") + "' value='" + rs.getString("option4") + "'>" + rs.getString("option4") + "<br>");
                count++;
            }

            out.println("<br><input type='submit' value='Submit'>");
            out.println("</form>");
            out.println("</body></html>");
        } catch (Exception e) {
            out.println("Database query error" + e.getMessage());
        }
    }

//To change body of generated methods, choose Tools | Templates.
}
