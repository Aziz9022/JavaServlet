<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String userName = (String) session.getAttribute("userName");
    if (userName != null && !userName.isEmpty()) {
        response.sendRedirect("dashboard.jsp");
    }
    String msg = request.getParameter("msg");
%>
<!DOCTYPE html>
<html lang="en">
    <jsp:include page="includes/navbar.jsp">
        <jsp:param name="title" value="Login"/>
    </jsp:include>
    <body>
        <%
            if (msg != null && "success".equals(msg)) {
        %>
        <div class="alert alert-success mt-2" role="alert">
            Sign-up successful! You can now log in to your account.
        </div>
        <%
        } else if (msg != null && "user_not_found".equals(msg)) {
        %>
        <div class="alert alert-danger mt-2" role="alert">
            No account found with this email. Please check your email and try again or <a href="signup.jsp">sign up here</a>.
        </div>
        <%
        } else if (msg != null && "user_password_error".equals(msg)) {
        %>
        <div class="alert alert-danger mt-2" role="alert">
            Incorrect password. Please try again.
        </div>
        <%
            }
        %>



        <div class="container mt-4">
            <div class="row justify-content-center">
                <div class="col-md-5">
                    <div class="card shadow-lg p-4">
                        <h3 class="text-center mb-4">Login</h3>
                        <form action="loginServlet" method="POST">
                            <!-- Email Field -->
                            <div class="mb-3">
                                <label for="email" class="form-label">Email Address</label>
                                <input type="email" class="form-control" id="email" name="email" required autocomplete="on">
                            </div>

                            <!-- Password Field -->
                            <div class="mb-3">
                                <label for="password" class="form-label">Password</label>
                                <input type="password" class="form-control" id="password" name="password" required autocomplete="off">
                            </div>

                            <!-- Submit Button -->
                            <div class="d-grid">
                                <button type="submit" class="btn btn-primary">Login</button>
                            </div>

                            <!-- Signup Link -->
                            <div class="text-center mt-3">
                                <small>Don't have an account? <a href="signup.jsp">Sign Up</a></small>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
