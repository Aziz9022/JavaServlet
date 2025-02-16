<%-- 
    Document   : EL
    Created on : 12 Feb, 2025, 12:10:00 AM
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
        Welcome, ${param.name}<br>
        Session value is ${sessionScope.user}<br>
        Cookie name is ${cookie.name.value}<br>
    </body>
</html>