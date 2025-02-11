<%-- 
    Document   : index
    Created on : 11 Feb, 2025, 8:34:08 PM
    Author     : kanoo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.Arrays" %>
<!DOCTYPE html>
<html>
<head>
    <title>Form Submission</title>
</head>
<body>
    <h2>Submitted User Information</h2>
    <%
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String gender = request.getParameter("gender");
        String[] hobbies = request.getParameterValues("hobbies");
        String email = request.getParameter("email");

        if (name != null && age != null && gender != null && email != null && hobbies != null) {
    %>
        <p><strong>Name:</strong> <%= name %></p>
        <p><strong>Age:</strong> <%= age %></p>
        <p><strong>Gender:</strong> <%= gender %></p>
        <p><strong>Hobbies:</strong> <%= String.join(", ", hobbies) %></p>
        <p><strong>Email:</strong> <%= email %></p>
    <%
        } else {
    %>
        <p>Invalid submission. Please fill in all fields.</p>
        <a href="index.jsp">Go Back</a>
    <%
        }
    %>
</body>
</html>


