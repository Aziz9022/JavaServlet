/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
/**
 *
 * @author kanoo
 */
public class SessionServlet extends HttpServlet {
public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
    {
        PrintWriter out=response.getWriter();
        HttpSession session=request.getSession(true);
        
        session.setAttribute("username","Aziz");
        session.setAttribute("isLoggedIn",true);
        
        String username=(String) session.getAttribute("username");
        boolean isLoggedIn=(Boolean) session.getAttribute("isLoggedIn");
        String sessionId=session.getId();
        out.println("Session Id:"+sessionId);
        
        boolean isNewsession=session.isNew();
        out.println("Is new Session:"+isNewsession);
        
        long creationTime=session.getCreationTime();
        Date creationTime2=new Date(creationTime);
        out.println("Session creation time:"+creationTime2);
        
        out.println("Username:"+username);
        out.println("Is Logged In:"+isLoggedIn);
        
        boolean attributeexists=session.getAttribute("isLoggedIn")!=null;
        out.println("IsLoggedIn attribute exist5s:"+attributeexists);
        
        session.removeAttribute("isLoggedIn:");
        
        boolean attributeexists1=session.getAttribute("isLoggedIn")!=null;
        out.println("IsLoggedIn attribute exist5s:"+attributeexists1);
        
        long lastAccessedTime=session.getCreationTime();
        Date lastAccessedTime2=new Date(lastAccessedTime);
        out.println("Last accessed time:"+lastAccessedTime2);
        
        boolean sessionInvalidated=session.isNew();
        out.println("Is session invalidated:"+sessionInvalidated);
        
        session.invalidate();
        
}
}
