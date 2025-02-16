<%-- 
    Document   : ConditionalOP
    Created on : 12 Feb, 2025, 12:11:37 AM
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
        <h1>Conditional Operator</h1>
        The result of 10>2: "${(10<2)?'greater':'lesser'}";
    </body>
</html>
