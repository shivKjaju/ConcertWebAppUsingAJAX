
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="mystyle.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css
">
<title>Login Page</title>
<script>



function validateForm() {
    var x = document.forms["userForm"]["userName"].value;
    var y = document.forms["userForm"]["password"].value;
    if (x == "") {
        alert("Username must be filled out");
        return false;
    }
    
    if (y == "") {
        alert("Password must be filled out");
        return false;
    }
}

</script>
</head>
<body>
<font color="white"><h2> Login Page </h2></font>


<!-- Actual Form -->
<div class="container" id="actualForm">
<form name="userForm" action=Login onsubmit="return validateForm()" method="post">
<font color="white">User Name: <input type=text name=userName ></font><br>
<font color="white">Password: <input type=text  name=password></font><br>
<font color="white"><button type="submit">Login</button></font><br>
</form>
</div>


<!-- Navigation link = Registration Page -->
<a href="Registration.jsp">New user? click here</a><br>
<a href="resetPassword.jsp">Forgot your password.We got you!!</a>

</body>
</html>