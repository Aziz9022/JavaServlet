<%-- 
    Document   : employee
    Created on : 12 Feb, 2025, 12:20:47 AM
    Author     : kanoo
--%>

<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Employee</title>
</head>
<body>
    <h2>Employee Update Status</h2>
    <%
        int id = Integer.parseInt(request.getParameter("id"));
  
        String name = request.getParameter("name");
       
        String dept = request.getParameter("dept");
       int salary = Integer.parseInt(request.getParameter("sal"));


        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/2804", "root", "root");

            String sql = "UPDATE employee SET empname = ?, dept = ?, salary = ? WHERE empid = ?";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, name);
            pst.setString(2, dept);
            pst.setInt(3, salary);
     
            pst.setInt(4,id);
            
            int updated =pst.executeUpdate();
            if(updated!=0){
                out.println("<h1> SALARY UPDATED</h1>");
            }
            else{
                out.println("<h1> Employee does not exists</h1>");
            }
            
        } catch (Exception e) {
            out.println("<p>Error: " + e.getMessage() + "</p>");
        } 
    %>
</body>
</html>