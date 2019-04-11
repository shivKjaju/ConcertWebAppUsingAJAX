<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirm Order</title>
<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script>
console.log("Hiding output components");
console.log("ConfirmOrder.jsp Called");
$(document).ready(function(){
	$("#authenticationElement").hide();
	$("#ConfirmPaymentBtn").click(function(e) {
	    e.preventDefault();
	    var username = document.getElementById('test1').value;
	    var password = document.getElementById('test2').value;
	    reAuthUser(username, password);
	    
	});
	$("#printBtn").click(function(e) {
	    e.preventDefault();
	    place_order_function();
	});
	$("#printTransactionDiv").hide();
});
</script>
<script>
function place_order_function(){
	var form = $("placeOrder");
	$.ajax({
		url: 'PlaceOrder',
		type: 'POST',
		data: form.serialize(),
		success: function(data){
			console.log("place_order_function called");
			alert(data);
		}
	});
}

function reAuthUser(username, password){
	$("#submitForm").hide();
	$("#authenticationElement").show();
	$("#authenticateBtn").click(function(e) {
		var user = document.getElementById('input1').value;
		var pass = document.getElementById('input2').value;
		alert(user);
		alert(pass);
		if(user === username && pass === password){
			alert("inside of if");
	    	confirm_function_1();
		}
		else{
			$("#info").text("Authentication failed please autheticate again");
			alert("FAILED");
			$("message").hide();
			reAuthUser(username,password);
		}
	});
}




function confirm_function_1(){
	//Post the required data to Bank servlet using Ajax
	$("#authenticationElement").hide();
	$("#submitForm").show();
	var form = $("#OrderForm");
	$.ajax({
		url: "../Ateam-HW3-Banking/BankServlet",
		type: 'POST',
		data: form.serialize(),
		success: function(data){
			console.log("confirm_function called");
			if (data == 0){
				$("#status").text("Transaction was not successful");
			}
			else if (data == 1){
				$("#status").text("Order has been successfully placed");
				$("#printTransactionDiv").show();
			}
		}
	});
}
</script>
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
<div class="container" id="submitForm">
	<div class="row">
		<form id="OrderForm">
			Cardholder Name:<input type=text name="cardName" id="cardName"><br>
			Card Number:<input type=text name="cardNumber"id="cardNum"><br>
			Expiry Month:<input type=text name="expMonth"id="expMonth">
			Expiry Date:<input type=text name="expDay" id="expDate"><br>
			CVV: <input type=text name="cvv" id="cardCvv"><br>
			<input type=hidden id="test1" name=auth value="${userBean.username}">
			<input type=hidden id="test2" name=authPass value="${userBean.password}">
			<input type=hidden id="test" name=totalPrice value="${scBean.totalPrice * scBean.ticketQuantity}">
			<input class="btn btn-primary" value="Confirm Payment" id="ConfirmPaymentBtn" type="button"><br>
			<a class="btn btn-danger" href="ViewAndCheckoutShoppingCart.jsp">Cancel Payment</a>
		</form>
	</div>
</div>
<div class="container">
	<div class="row">
		<!-- Display Results if success -->
		<h3 id="status"></h3>
	</div>
</div>
<div class="container" id="printTransactionDiv">
	<h4>Summary :</h4>
	<div class ="row">
		<form id="placeOrder">
			Cardholder Name: ${bankBean.user}<br>
			Card Number:${bankBean.creditCard}<br>
			Band Name :${scBean.bandName}><br>
			Ticket quantity:${scBean.ticketQuantity}<br>
			Venue : ${scBean.venueName}<br>
			Your total: ${scBean.totalPrice * scBean.ticketQuantity}<br>
			<input class="btn btn-primary" value="Print" id="printBtn" type="button"><br>
		</form>
	</div>
</div>

<div id="authenticationElement">
<h1>Please authenticate yourself</h1>
Username:<input type="text" name="username" id="input1" value=><br>
Password<input type="password" name="pass" id="input2" value=><br>
<input type="button" class="btn btn-primary" value="Authenticate" id="authenticateBtn">
</div>

<div class="container" id="message">
	<div class="row">
		<!-- Display authentication results s-->
		<h3 id="info"></h3>
	</div>
</div>

</body>
</html>