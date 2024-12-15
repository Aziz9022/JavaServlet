/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author kanoo
 */
public class WelcomeServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String st = req.getParameter("t1");
        out.println("<h1>Hello  " + st + "  !</h1>");

    }

}
