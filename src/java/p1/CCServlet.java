/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.ejb.EJB;
import p1.CCBeanLocal;

/**
 *
 * @author kanoo
 */
public class CCServlet extends HttpServlet {

    @EJB
    CCBeanLocal obj;

    public void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        double amt = Double.parseDouble(request.getParameter("amt"));
        String ch = request.getParameter("type");
        if (ch.equals("r2d")) {
            out.println("<h1>" + amt + " Rupees = " + obj.r2d(amt) + " Dollors</h1>");
        }
        if (ch.equals("d2r")) {
            out.println("<h1>" + amt + " Dollors = " + obj.d2r(amt) + " Rupees</h1>");
        }
    }
}

