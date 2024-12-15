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
public class SessionVisitServlet extends HttpServlet {
private int counter;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        HttpSession session=req.getSession(true);
        if (session.isNew()) {
            out.println("<h1> THIS IS THE FIRST TIME U VISSTED THIS WEBSITE</h1>");
            ++counter;
            
        } else {
            synchronized(SessionVisitServlet.this){
            if(counter==10){
            session.invalidate();
            counter=0;
            req.getSession(false);
            }else{
            out.println("<h1>You have visited this page "+(++counter)+" times. </h1>");
            }
            }
        }















//To change body of generated methods, choose Tools | Templates.
    }

   
}
