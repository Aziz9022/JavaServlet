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
public class CookieVisitServlet extends HttpServlet {

   private int i=1;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        String k=String.valueOf(i);
        Cookie c=new Cookie("visit",k);
        resp.addCookie(c);
        int j = Integer.parseInt(c.getValue());
        if(j==1){
        out.println("<h1> you have visited website for the first time </h1>");
        
        }else{
            synchronized(CookieVisitServlet.this){
        out.println("<h1> you have visited "+i+ " times </h1>");
            }
        }
        i++;
}
   
}
