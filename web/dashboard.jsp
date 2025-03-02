<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String userName = (String) session.getAttribute("userName");
    String userType = (String) session.getAttribute("type");
    String isActive = (String) session.getAttribute("isActive");
    String email = (String) session.getAttribute("email");
    if (userName == null) {
        response.sendRedirect("login.jsp");
    }

%>
<!DOCTYPE html>
<html>
    <jsp:include page="includes/navbar.jsp">
        <jsp:param name="title" value="Dashboard"/>
    </jsp:include>
    <body>
        <div class="container mt-5">
            <h2 class="text-center mb-4">Welcome, <%=userName%> <br><span class="text-danger"><%=!"true".equals(isActive) ? "Please Ask Your Professor to Activate Your account." : ""%></span></h2>
            <div class="row d-flex justify-content-between <%=!"true".equals(isActive) ? "d-none" : ""%>">
                <!-- Study Material Card -->

                <div class="col-md-4 col-sm-6" style="cursor: pointer">
                    <a href="studyMaterial.jsp" style="text-decoration: none !important">
                        <div class="card text-center shadow p-3 mb-4 border-0">
                            <div class="card-body">
                                <h4 class="card-title" >📚 Study Material</h4>
                            </div>
                        </div>
                    </a>
                </div>
                <!-- Quiz Card -->
                <div class="col-md-4 col-sm-6" style="cursor: pointer">
                    <a href="quiz.jsp" style="text-decoration: none !important">
                        <div class="card text-center shadow p-3 mb-4 border-0">
                            <div class="card-body">
                                <h4 class="card-title">📝 Quiz</h4>
                            </div>
                        </div>
                    </a>
                </div>

                <!-- Result Card -->
                <div class="col-md-4 col-sm-6" style="cursor: pointer">
                    <a href="results.jsp" style="text-decoration: none !important">
                        <div class="card text-center shadow p-3 mb-4 border-0">
                            <div class="card-body">
                                <h4 class="card-title">📊 Result </h4>
                            </div>
                        </div>
                    </a>
                </div>

                <div class="col-md-4 col-sm-6 <%="teacher".equalsIgnoreCase(userType) ? "" : "d-none"%>" style="cursor: pointer">
                    <a href="students.jsp" style="text-decoration: none !important">
                        <div class="card text-center shadow p-3 mb-4 border-0">
                            <div class="card-body">
                                <h4 class="card-title">🧑‍🎓 Students</h4>
                            </div>
                        </div>
                    </a>
                </div>
            </div>
        </div>
    </body>
</html>
