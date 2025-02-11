<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Intrinsic Objects</h1>
        <%
            String a = request.getContentType();
            String b = request.getLocalAddr();
            String c = request.getLocalName();
            %>
            <h2>Request Objects</h2>
            Content type-<%= a%><br>
            Local Address-<%= b %><br>
            Local Name<%= c %><br>
        <%
            String e = response.getCharacterEncoding();
            String f = response.getContentType();
            int g = response.getStatus();
            %>
            <h2>Response Objects</h2>
            Character Encoding-<%= e %><br>
            Content type-<%= f %><br>
            Status-<%= g %><br>
        <%
            int h = out.getBufferSize();
            int i = out.hashCode();
            boolean j = out.isAutoFlush();
            %>
            <h2>Out Objects</h2>
            Buffer Size-<%= h %><br>
            Hash Code-<%= i %><br>
            Auto Flush-<%= j %><br>
        <%
            long k=session.getCreationTime();
                String formattedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(k));
            String l=session.getId();
            boolean m=session.isNew();
            %>
            <h2>Session Objects</h2>
            Creation Time-<%= formattedDate  %><br>
            ID-<%= l %><br>
            Is New-<%= m %><br>
    </body>
</html>
