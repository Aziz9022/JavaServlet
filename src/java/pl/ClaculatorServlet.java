/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;

/**
 *
 * @author kanoo
 */
public class ClaculatorServlet extends HttpServlet {

    @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html");
    PrintWriter out = resp.getWriter();


    int res=0;
    int n1=Integer.parseInt (req. getParameter("t1"));
    int n2=Integer.parseInt (req. getParameter("t2")); 
    String opr=req.getParameter("operation");
    if (opr.equals ("+")) res=n1+n2;
if (opr.equals("-")) res=n1-n2;
if (opr.equals("*")) res=n1*n2;
if (opr.equals("/")) res=n1/n2;
if (opr.equals("%")) res=n1%n2;
out.println("<h1>"+n1+opr+n2+"="+res+"</h1>"); }
}



//To change body of generated methods, choose Tools | Templates.
    

    
    
    


