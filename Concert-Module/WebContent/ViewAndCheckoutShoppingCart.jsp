<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shopping Cart</title>
<style>
table{
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr: {
  background-color: #dddddd;
}
</style>
</head>
<body>
<nav class="navbar navbar-inverse">
 	<div class="container-fluid">
 		<ul class="nav navbar-nav">
 			<li class="active"><a href="CustomerHomePage.jsp">Home</a></li>	
 		</ul>
 		<ul class="nav navbar-nav navbar-right">
 			<li><a href="Login.jsp"><span class="glyphicon glyphicon-log-out"></span>Logout</a></li>
 		</ul>
 	</div>
 </nav>		
<h2>Your shopping list</h2>
<table>
<thead>
<tr>
	<th>Concert</th>
	<th>Ticket Quantity</th>
	<th>Venue</th>
	<th>Total Seats</th>
	<th>Total Price</th>
	<th>Checkout</th>
	<th>Delete</th>
</tr>
</thead>
<tbody>
	<tr>
	<th class="text-center"><c:out value="${scBean.bandName}"/></th>
	<th class="text-center"><c:out value="${scBean.ticketQuantity}"/></th>
	<th class="text-center"><c:out value="${scBean.venueName}"/></th>
	<th class="text-center"><c:out value="${scBean.availableSeats}"/></th>
	<th class="text-center"><c:out value="${scBean.totalPrice * scBean.ticketQuantity}"/></th>
	<th class="text-center">
	<form action="ConfirmOrder.jsp" method="post">
	<input type="hidden" name="concertName" value="<c:out value="${scBean.bandName}"/>">
	<input type="hidden" name="ticketQuantity" value="<c:out value="${scBean.ticketQuantity}"/>">
	<input type="hidden" name="venueName" value="<c:out value="${scBean.venueName}"/>">
	<input type="hidden" name="availableSeats" value="<c:out value="${scBean.availableSeats}"/>">
	<input type="hidden" name="totalPrice" value="<c:out value="${scBean.totalPrice * scBean.ticketQuantity}"/>">
	<input type="hidden" name="delete" value="removeCart">
	<input class="btn btn-primary" value="Check Out " type=submit>
	</form>
	</th>
	<th class="text-center">
	<form action="UpdateShoppingCart" method="post">
	<input type="hidden" name="concertName" value="<c:out value="${scBean.bandName}"/>">
	<input type="hidden" name="qty" value="<c:out value="${scBean.ticketQuantity}"/>">
	<input type="hidden" name="venueName" value="<c:out value="${scBean.venueName}"/>">
	<input type="hidden" name="availableSeats" value="<c:out value="${scBean.availableSeats}"/>">
	<input type="hidden" name="price" value="<c:out value="${scBean.totalPrice * scBean.ticketQuantity}"/>">
	<input type="hidden" name="delete" value="<c:out value="${0}"/>">
	<input class="btn btn-danger" value="Remove From Cart" type=submit>
	</form>
	</th>
	</tr>
</tbody>
</table>
</body>
</html>