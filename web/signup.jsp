<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String userName = (String) session.getAttribute("userName");
    if (userName != null && !userName.isEmpty()) {
        response.sendRedirect("dashboard.jsp");
    }

    String msg = request.getParameter("msg");
    String userErr = "", emailErr = "", passErr = "", cmfPassErr = "";

    if (msg != null) {
        if (msg.equals("invalid_name")) {
            userErr = "Please enter a valid name with minimum 6 characters";
        } else if (msg.equals("invalid_email")) {
            emailErr = "Please enter a valid email";
        } else if (msg.equals("weak_password")) {
            passErr = "Password must be at least 6 characters!";
        } else if (msg.equals("pass_not_match")) {
            cmfPassErr = "Password and Confirm password do not match!";
        } else if (msg.equals("email_exists")) {
            emailErr = "User with this email exist.";
        }
    }


%>
<!DOCTYPE html>
<html>
    <jsp:include page="includes/navbar.jsp">
        <jsp:param name="title" value="SignUp"/>
    </jsp:include>
    <body>
        <div class="container mt-4">
            <div class="row justify-content-center">
                <div class="col-md-6">
                    <div class="card p-4">
                        <h3 class="text-center mb-4">Sign Up</h3>
                        <form action="signupServlet" method="POST" >
                            <!-- Name Field -->
                            <div class="mb-3">
                                <label for="name" class="form-label">Full Name</label>
                                <input type="text" class="form-control" id="name" name="name" required autocomplete="off">
                                <span class="text-danger"><%=userErr%></span>
                            </div>

                            <!-- Email Field -->
                            <div class="mb-3">
                                <label for="email" class="form-label">Email Address</label>
                                <input type="text" class="form-control" id="email" name="email" required autocomplete="off">
                                <span class="text-danger"><%=emailErr%></span>
                            </div>

                            <!-- Password Field -->
                            <div class="mb-3">
                                <label for="password" class="form-label">Password</label>
                                <input type="password" class="form-control" id="password" name="password" required autocomplete="off"> 
                                <span class="text-danger"><%=passErr%></span>
                            </div>

                            <!-- Confirm Password Field -->
                            <div class="mb-3">
                                <label for="confirmPassword" class="form-label">Confirm Password</label>
                                <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" required autocomplete="off">
                                <small id="passwordError" class="text-danger"></small>
                                <span class="text-danger"><%=cmfPassErr%></span>
                            </div>

                            <!-- Submit Button -->
                            <div class="d-grid">
                                <button type="submit" class="btn btn-primary">Sign Up</button>
                            </div>

                            <!-- Already have an account? -->
                            <div class="text-center mt-3">
                                <small>Already have an account? <a href="login.jsp">Login</a></small>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
