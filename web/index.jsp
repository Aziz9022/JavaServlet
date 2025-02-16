<%-- 
    Document   : index
    Created on : 12 Feb, 2025, 12:09:03 AM
    Author     : kanoo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            session.setAttribute("user","Admin");
            Cookie ck=new Cookie("name","myCookie");
            response.addCookie(ck);
        %>
        <form action="EL.jsp">
            Enter Name <input type="text" name="name" /><br>
            <input type="submit" value="Submit" />
        </form>
        <a href="ArithmeticOP.jsp">Arithmetic Operator</a><br>
        <a href="ConditionalOP.jsp">Conditional Operator</a><br>
        <a href="LogicalOP.jsp">Logical Operator</a><br>
        <a href="RelationalOP.jsp">Relational Operator</a><br>
    </body>
</html>