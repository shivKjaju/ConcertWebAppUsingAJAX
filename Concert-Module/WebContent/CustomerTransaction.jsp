<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Transaction</title>
<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-inverse">
 	<div class="container-fluid">
 	    <ul class="nav navbar-nav">
 			<form action=ViewOrders>
					<input class="nav-link" value="View your orders" type="submit">
					<input type="hidden" value="${user}" name="ViewOrder">
			</form>
 		</ul>
 		<ul class="nav navbar-nav navbar-right">	
 			<li><a href="Login.jsp"><span class="glyphicon glyphicon-log-out"></span>Logout</a></li>	
 		</ul>
 	</div>
</nav>
<h2>Your Order</h2>
<ul>
	<li>Band name:${scBean.bandName}</li>
	<li>Ticket quantity: ${scBean.ticketQuantity}</li>
	<li>Price per ticket: ${scBean.totalPrice}</li>
	<li>Venue : ${scBean.venueName}</li>
	<strong>Your total: ${scBean.totalPrice * scBean.ticketQuantity}</strong>
</ul>
<div class="container">
	<div class="row">
		<form action = "CustomerTransactionConfirmation" method = "post">
			Cardholder Name:<input type=text name="cardName"><br>
			Card Number:<input type=text name="cardNumber"><br>
			Expiry Month:<input type=text name="expMonth">
			Expiry Date:<input type=text name="expDay"><br>
			CVV: <input type=text name="cvv"><br>
			<input class="btn btn-primary" value="Confirm Payment" type="submit"><br>
			<a class="btn btn-danger" href="ViewAndCheckoutShoppingCart.jsp">Cancel Payment</a>
		</form>
	</div>
</div>

</body>
</html>