<%-- 
    Document   : login
    Created on : 11 Feb, 2025, 8:38:51 PM
    Author     : kanoo
--%>
<%@page contentType="text/html"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            try
            {
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/2804","root","root");
                String uname=request.getParameter("uname");
                String pwd=request.getParameter("pwd");
                PreparedStatement pst=con.prepareStatement("Select password from registration where username='"+uname+"'");
                ResultSet rs=pst.executeQuery();
                if(rs.next())    
                {
                    if(rs.getString(1).equals(pwd))
                    {
                        %>
                        <%@include file="welcome.html" %>
                        <%
                    }
                    else
                    {
                        %>
                        <h1>LOGIN FAILED</h1>
                        <%@include file="index.jsp" %>
                        <%
                    }
                }
else
{
%>
<%="User doesn't Exists"%>
<%@include file="index.jsp"%>
<%
            }    
            }catch(Exception e)
{
out.println(e);
}
            
        %>
    </body>
</html>
