<%@page import="dao.StudyMaterialDao"%>
<%@page import="dao.StudentDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Long id = Long.parseLong(request.getParameter("tokenId"));
    
    try {
        StudyMaterialDao smd = new StudyMaterialDao();
        smd.deleteStudyMaterial(id);
    } catch (Exception e) {
        
    }
    response.sendRedirect("../studyMaterial.jsp");
%>