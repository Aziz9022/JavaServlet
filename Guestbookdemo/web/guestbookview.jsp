<%-- 
    Document   : guestbookview
    Created on : 30 Jan, 2025, 7:59:14 PM
    Author     : kanoo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="hibernate.Guestbook"%>
<%@page import="java.util.*"%>
<%!
 SessionFactory sf;
 org.hibernate.Session ss;
 List<hibernate.Guestbook> gbook;
%>
<%
 sf = new Configuration().configure().buildSessionFactory();
 ss= sf.openSession();
 Transaction tx=null;
 Guestbook gb=new Guestbook();
 try
 {
 tx=ss.beginTransaction();
 String name=request.getParameter("name");
 String msg=request.getParameter("msg");
 
 String dt=new java.util.Date().toString();
 gb.setVname(name);
 gb.setMsg(msg);
 gb.setMdate(dt);
 ss.save(gb);
 tx.commit();
 }
 catch(Exception e){ out.println("Error"+e.getMessage()); }
 try
 { ss.beginTransaction();
 gbook=ss.createQuery("from Guestbook").list();
 }
 catch(Exception e){ }
%>
<html>
<head>
<title>Guest View</title>
</head>
<body>
 Guest View 
 Click here to go <a href="index.html"> BACK </a>
<br><br>
<% Iterator it=gbook.iterator();
 while(it.hasNext())
 {
 Guestbook eachrecord=(Guestbook)it.next();
 out.print(eachrecord.getMdate()+" ");
 out.print(eachrecord.getVname()+"<br>");
 out.print(eachrecord.getMsg()+"<br><hr>");
 }
 %>
</body>
</html>
