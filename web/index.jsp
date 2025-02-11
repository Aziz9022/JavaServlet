<%-- 
    Document   : form
    Created on : 11 Feb, 2025, 8:34:20 PM
    Author     : kanoo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
    <title>User Form</title>
    <script>
        function validateForm() {
            let name = document.forms["userForm"]["name"].value;
            let age = document.forms["userForm"]["age"].value;
            let email = document.forms["userForm"]["email"].value;
            let hobbies = document.querySelectorAll('input[name="hobbies"]:checked');
            let gender = document.querySelector('input[name="gender"]:checked');

            if (name === "") {
                alert("Name is required.");
                return false;
            }

            if (age === "" || isNaN(age) || age <= 0) {
                alert("Please enter a valid age.");
                return false;
            }

            const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            if (!emailRegex.test(email)) {
                alert("Please enter a valid email address.");
                return false;
            }

            if (hobbies.length === 0) {
                alert("Please select at least one hobby.");
                return false;
            }

            if (!gender) {
                alert("Please select your gender.");
                return false;
            }

            return true;
        }
    </script>
</head>
<body>
    <h2>User Information Form</h2>
    <form name="userForm" action="confirm.jsp" method="post" onsubmit="return validateForm();">
        Name: <input type="text" name="name" /><br><br>
        Age: <input type="text" name="age" /><br><br>
        Gender: 
        <input type="radio" name="gender" value="Male" /> Male
        <input type="radio" name="gender" value="Female" /> Female<br><br>
        Hobbies: 
        <input type="checkbox" name="hobbies" value="Reading" /> Reading
        <input type="checkbox" name="hobbies" value="Traveling" /> Traveling
        <input type="checkbox" name="hobbies" value="Sports" /> Sports<br><br>
        Email: <input type="text" name="email" /><br><br>
        <input type="submit" value="Submit" />
    </form>
</body>
</html>


