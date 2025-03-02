<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String title = request.getParameter("title");
    String userName = (String) session.getAttribute("userName");
%>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><%=title == null || title.isEmpty() ? "" : title%></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<nav class="navbar bg-primary navbar-expand-lg  "  data-bs-theme="dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="/StudyEase">StudyEase</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarText">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <!-- Add more nav links here if needed -->
            </ul>
            <% if (userName != null && !userName.isEmpty()) {%>
            <div class="dropdown">
                <button class="btn btn-light dropdown-toggle" type="button" id="userDropdown" data-bs-toggle="dropdown" aria-expanded="false">
                    <%= userName%>
                </button>
                <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="userDropdown">
                    <li><a class="dropdown-item" href="logout.jsp">Logout</a></li>
                </ul>
            </div>
            <% }%>
        </div>
    </div>
</nav>
