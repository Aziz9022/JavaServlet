<%-- 
    Document   : register
    Created on : 12 Feb, 2025, 10:43:40 PM
    Author     : kanoo
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head>
    <body>
        <form method="post">
            User Name: <input type="text" name="uname" required /><br>
            Password: <input type="password" name="pwd" required /><br>
            Re-Enter Password: <input type="password" name="conpwd" required /><br>
            Email: <input type="email" name="email" required /><br>
            Country: <input type="text" name="country" required /><br>
            <input type="submit" value="Submit" />
            <input type="reset" value="Reset" />
        </form>
        
        <sql:setDataSource var="db" driver="org.apache.derby.jdbc.ClientDriver" 
            url="jdbc:derby://localhost:1527/2804" user="root" password="root" />
        
        <c:if test="${pageContext.request.method eq 'POST'}">
            <c:if test="${param.pwd eq param.conpwd}">
                <sql:update dataSource="${db}" var="result">
                    INSERT INTO registration (username, password, email, country) VALUES (?, ?, ?, ?)
                    <sql:param value="${param.uname}" />
                    <sql:param value="${param.pwd}" />
                    <sql:param value="${param.email}" />
                    <sql:param value="${param.country}" />
                </sql:update>
                <c:if test="${result >= 1}">
                    <c:redirect url="index.jsp" />
                </c:if>
            </c:if>
            <c:if test="${param.pwd ne param.conpwd}">
                <p>Password Mismatch</p>
            </c:if>
        </c:if>
    </body>
</html>
