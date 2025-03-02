<%@page import="dao.StudyMaterialDao"%>
<%@page import="entity.StudyMaterial"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String userName = (String) session.getAttribute("userName");
    String userType = (String) session.getAttribute("type");
    String isActive = (String) session.getAttribute("isActive");
    String email = (String) session.getAttribute("email");

    if (userName == null || !"true".equalsIgnoreCase(isActive)) {
        response.sendRedirect("login.jsp");
    }

    String tokenId = request.getParameter("tokenId");
    StudyMaterial sm = null;
    String subject = "", fileName = "", comment = "", title = "Add New Study Material";
    try {
        if (tokenId != null && !"".equalsIgnoreCase(tokenId)) {
            StudyMaterialDao smd = new StudyMaterialDao();
            sm = smd.getStudyMaterialById(Long.parseLong(tokenId));
            subject = sm.getSubject();
            fileName = sm.getFileName();
            comment = sm.getStudyText();
            title = "Update Study Material";
        } else {
            tokenId = "-1";
        }
    } catch (Exception e) {
        e.printStackTrace();
    }


%>
<!DOCTYPE html>
<html>
    <jsp:include page="../includes/navbar.jsp">
        <jsp:param name="title" value="<%=title%>"/>
    </jsp:include>
    <body>
        <div class="container mt-5">
            <h2 class="text-center mb-4"><%=title%> </h2>

            <form action="../StudyMaterialServlet" method="POST" enctype="multipart/form-data" onsubmit="return checkStudyMaterial()">
                <div class="row d-flex justify-content-center">
                    <div class="col-sm-8">
                        <div class="mb-3">
                            <label for="subject" class="form-label">Subject</label>
                            <input type="text" class="form-control" id="subject" name="subject" value="<%=subject%>">
                        </div>
                        <div class="mb-3">
                            <label for="file" class="form-label">File</label>
                            <div class="input-group">
                                <input type="file" class="form-control" id="file" name="file" onchange="updateFileName()">
                                <input type="hidden" id="updatedFileName" name="updatedFileName" readonly value="<%=fileName%>">
                            </div>
                            <a target="_blank" id="uploadedFile" href="../studymaterials/<%=fileName%>"><%=fileName%></a>
                        </div>
                        <div class="mb-3">
                            <div class="form-floating">
                                <textarea class="form-control" placeholder="Leave a comment here" id="studyText" name="studyText" style="height: 100px"><%=comment%></textarea>
                                <label for="floatingTextarea2">Comments</label>
                            </div>
                        </div>
                        <div class="mb-3">
                            <input type="hidden" name="id" value="<%=tokenId%>" />
                            <button type="submit" class="btn btn-primary">Save</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
        <script>
            function updateFileName() {
                document.getElementById("uploadedFile").style.display = "none";
            }
        </script>
    </body>
</html>
