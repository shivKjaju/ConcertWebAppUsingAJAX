<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirmation Page</title>
</head>
<body>
<nav class="navbar navbar-inverse">
 	<div class="container-fluid">
 		<ul class="nav navbar-nav">
 			<li class="active"><a href="CustomerHomePage.jsp">Home</a></li>
 			<li><form action=ViewOrders>
					<input class="nav-link" value="View your orders" type="submit">
					<input type="hidden" value="${user}" name="ViewOrder">
				</form></li>	
 		</ul>
 		<ul class="nav navbar-nav navbar-right">
 			<li><a href="Login.jsp"><span class="glyphicon glyphicon-log-out"></span>Logout</a></li>
 		</ul>
    </div>
    </nav>
<strong>Your Transaction Failed! Please check your credit card information.</strong>    		
</body>
</html>