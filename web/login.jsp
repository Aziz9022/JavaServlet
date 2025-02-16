<%-- 
    Document   : login
    Created on : 12 Feb, 2025, 10:43:23 PM
    Author     : kanoo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login page</title>
    </head>
    <body>
        <sql:setDataSource var="db" driver="org.apache.derby.jdbc.ClientDriver" 
            url="jdbc:derby://localhost:1527/2804" user="root" password="root" />
        <c:set var ="username" value="${param.uname}"/>
        <c:set var ="password" value="${param.pwd}"/>
        <sql:query dataSource="${db}"var="rs">
            select password from registration where username=?
            <sql:param value="${param.uname}"/>
            
        </sql:query>
        <c:choose>
            <c:when test="${rs.rowCount>0}">
                <p> login successful</p>
                    <c:redirect url="welcome.html"/>
            </c:when >
            <c:otherwise>
                <p> login failed </p>
                <c:redirect url="register.jsp"/> 
            </c:otherwise>
        </c:choose>
    </body>
</html>