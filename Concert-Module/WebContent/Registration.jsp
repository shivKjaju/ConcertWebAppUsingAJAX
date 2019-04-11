<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" type="text/css" href="mystyle.css">
<title>Register Here</title>
<script>
function validateForm() {
    var x = document.forms["registerForm"]["userName"].value;
    var y = document.forms["registerForm"]["password"].value;
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
<font color="white"><h2> Registration Page</h2></font>

<!-- Registration Form -->
<div class="container">
<form name=registerForm action=Registration onsubmit="return validateForm()" method="post">
<font color="white">First Name:</font><input type=text name=firstName>
<font color="white">Last Name:</font><input type=text name=lastName><br>
<font color="white">Email Id:</font><input type=text name=emailId><br>
<font color="white">Address:</font><input type=text name=address><br>
<font color="white">City:</font><input type=text name=city><br>
<font color="white">State:</font><input type=text name=state><br>
<font color="white">Postal Code:</font><input type=text name=pCode><br>\
<font color="white">Phone number:</font><input type=text name=pNumber><br>
<font color="white">Birthday:</font><input type=text name=bDay><br>
<font color="white">Type:</font><input type=text name=type><br>
<font color="white">Status:</font><input type=text name=status><br>
<font color="white">Username:</font><input type=text name=userName><br>
<font color="white">Password:</font><input type=text name=password><br>
<button type=submit>Register</button><br> 
</form>
</div>
</body>
</html>