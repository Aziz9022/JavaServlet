<%@page import="java.text.SimpleDateFormat"%>
<%@page import="dao.StudyMaterialDao"%>
<%@page import="java.util.List"%>
<%@page import="entity.StudyMaterial"%>
<%@page isELIgnored="false" %>
<%
    String userName = (String) session.getAttribute("userName");
    String userType = (String) session.getAttribute("type");
    String isActive = (String) session.getAttribute("isActive");
    String email = (String) session.getAttribute("email");

    if (userName == null || "false".equalsIgnoreCase(isActive)) {
        response.sendRedirect("login.jsp");
    }

    List<StudyMaterial> studyMaterialList = null;

    try {
        StudyMaterialDao sm = new StudyMaterialDao();
        studyMaterialList = sm.getStudyMaterial();
        request.setAttribute("studyMaterialList", studyMaterialList);
    } catch (Exception e) {
        e.printStackTrace();
    }

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <jsp:include page="includes/navbar.jsp">
        <jsp:param name="title" value="Study Material"/>
    </jsp:include>
    <body>
        <div class="container mt-5">
            <h2 class="text-center mb-4">Study Material</h2>
            <div class="row justify-content-center">
                <div class="col-sm-12 col-md-10">
                    <c:if test="${sessionScope.type eq 'teacher'}">
                        <a href="teacher/addStudyMaterial.jsp" class="btn btn-sm btn-primary mb-2">Add</a>
                    </c:if>

                    <table class="table table-bordered">
                        <thead>
                            <tr class="text-center">
                                <th>Subject ${userType}</th>
                                <th>Comment</th>
                                <th>Uploaded On</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:choose>
                                <c:when test="${not empty studyMaterialList}">
                                    <c:forEach var="s" items="${studyMaterialList}">
                                        <tr>
                                            <!-- Subject -->
                                            <td align="center">${s.subject}</td>
                                            <td align="center">${s.studyText}</td>

                                            <!-- Upload Time -->
                                            <td align="center">
                                                <fmt:formatDate value="${s.uploadTime}" pattern="dd-MM-yyyy HH:mm:ss"/>
                                            </td>

                                            <!-- Action Buttons -->
                                            <td align="center">
                                                <a href="studymaterials/${s.fileName}" target="_blank" class="btn btn-sm btn-dark">
                                                    <i class="fas fa-eye"></i> View
                                                </a>

                                                <!-- Show "Edit" and "Delete" only for teachers -->
                                                <c:if test="${sessionScope.type eq 'teacher'}">
                                                    <a href="teacher/addStudyMaterial.jsp?tokenId=${s.id}" class="btn btn-sm btn-warning">
                                                        <i class="fas fa-edit"></i> Edit
                                                    </a>

                                                    <a href="teacher/deleteStudyMaterial.jsp?tokenId=${s.id}" class="btn btn-sm btn-danger">
                                                        <i class="fas fa-trash"></i> Delete
                                                    </a>
                                                </c:if>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </c:when>
                                <c:otherwise>
                                    <!-- Show message when there are no study materials -->
                                    <tr>
                                        <td colspan="4" class="text-center text-muted">No study materials available.</td>
                                    </tr>
                                </c:otherwise>
                            </c:choose>
                        </tbody>

                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
