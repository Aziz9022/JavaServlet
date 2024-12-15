/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author kanoo
 */
public class AddCookieServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String name = req.getParameter("user");
        String value = req.getParameter("value");
        Cookie ck = new Cookie(name, value);
        resp.addCookie(ck);
        out.println("Cookie added");
        RequestDispatcher rd = req.getRequestDispatcher("newjsp.jsp");
        rd.include(req, resp);
//To change body of generated methods, choose Tools | Templates.
    }
    
}
