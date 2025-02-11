<%-- 
    Document   : register
    Created on : 11 Feb, 2025, 8:39:55 PM
    Author     : kanoo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> JSP Page</title>
    </head>
    <body>
        <form >
            User Name<input type="text" name="uname" value="" /><br>
            Password<input type="password" name="pwd" value="" /><br>
            Re-Enter Password<input type="password" name="conpwd" value="" /><br>
            Email<input type="text" name="email" value="" /><br>
            Country<input type="text" name="country" value="" /><br>
            <input type="submit" value="Submit" />
            <input type="reset" value="Reset" />
        </form>
        
         <%
            try
            {
                   Class.forName("org.apache.derby.jdbc.ClientDriver");
                   Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/2804","root","root");
                   String uname=request.getParameter("uname");
                   String pwd1=request.getParameter("pwd");
                   String pwd2=request.getParameter("conpwd");
                   String email=request.getParameter("email");
                   String country=request.getParameter("country");
                   if(pwd1.equals(pwd2))
                   {
                       PreparedStatement pst=con.prepareStatement("Insert into registration values(?,?,?,?)");
                       pst.setString(1,uname);
                       pst.setString(2,pwd1);
                       pst.setString(3,email);
                       pst.setString(4,country);
                       pst.executeUpdate();
                       %>
                       <%="Record Inserted"%>
                       <%
                   }
                   else
                       out.println("Password Mismatch");
            }catch(Exception e)
{out.println(e);}
        %>
    </body>
</html>