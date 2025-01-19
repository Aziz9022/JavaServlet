/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kanoo
 */
public class ResultServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        int score = 0;

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/2804", "root", "root");
            PreparedStatement stmt = conn.prepareStatement("SELECT Qno, correct_answer FROM Quiz");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String userAnswer = request.getParameter(Integer.toString(rs.getInt("Qno")));
                String correctAnswer = rs.getString("correct_answer");

                if (userAnswer != null && userAnswer.equals(correctAnswer)) {
                    score++;
                }
            }

            out.println("<html><body>");
            out.println("<h2>Your Score: " + score + " / 10</h2>");
            out.println("<a href='MCQServlet'>Take the quiz again</a>");
            out.println("</body></html>");
        } catch (Exception e) {
            out.println("Database query error" + e.getMessage());
        }
    }

//To change body of generated methods, choose Tools | Templates.
}


