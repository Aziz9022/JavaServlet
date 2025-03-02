<%@page import="dao.StudentDao"%>
<%@page import="entity.User"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String userName = (String) session.getAttribute("userName");
    String userType = (String) session.getAttribute("type");
    String isActive = (String) session.getAttribute("isActive");
    String email = (String) session.getAttribute("email");
    if (userName == null || !"teacher".equals(userType)) {
        response.sendRedirect("login.jsp");
    }

    List<User> studentList = null;

    try {
        StudentDao student = new StudentDao();
        studentList = student.getStudents();
    } catch (Exception e) {
        e.printStackTrace();
    }
%>
<!DOCTYPE html>
<html>
    <jsp:include page="includes/navbar.jsp">
        <jsp:param name="title" value="Students"/>
    </jsp:include>
    <body>
        <div class="container mt-5">
            <h2 class="text-center mb-4">Students</h2>
            <div class="row justify-content-center">
                <div class="col-sm-12 col-md-10">
                    <table class="table table-bordered">
                        <thead>
                            <tr class="text-center">
                                <th>Name</th>
                                <th>Email</th>
                                <th>Status</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                if (studentList.size() > 0) {
                                    for (User u : studentList) {
                            %>
                            <tr>
                                <td><%=u.getUserName()%></td>
                                <td><%=u.getEmail()%></td>
                                <td align="center"><%=!"true".equalsIgnoreCase(u.getIsActive()) ? "<span class='badge bg-danger'>Inactive</span>" : "<span class='badge bg-success'>Active</span>"%></td>
                                <td align="center"> 
                                    <%
                                        if (!"true".equalsIgnoreCase(u.getIsActive())) {
                                    %>
                                    <a href="ChangeStatusServlet?status=true&studentId=<%=u.getId()%>" class="btn btn-sm btn-primary">Allow</a>
                                    <%
                                        }
                                    %>
                                    <a href="ChangeStatusServlet?status=cancel&studentId=<%=u.getId()%>" class="btn btn-sm btn-danger">Reject</a>
                                </td>
                            </tr>
                            <%
                                    }
                                }
                            %>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
