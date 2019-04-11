<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Concert Details</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css
">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css
">
<style>
.checked {
  color: orange;
}
</style>
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

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js
">
</script>

<script>
$(document).ready(function(){
	console.log("hiding");
	$("#btnCart").click(function(e) {
	    e.preventDefault();
	    getData();
	});
	$("#divCheckbox").hide();
});
</script>

<script type="text/javascript">

function getData(){
	var form = $("#shoppingForm");
	// Send request to the update shopping cart
		$.ajax({
			type: form.attr('method'),
			url: form.attr('action'),
			data: form.serialize(),
			success: function (data) {
			console.log(data);
			alert(data);
			if(data == 0){
				
				$("#status").text("No more seats available");
			}
			
			if(data == 1){
				$("#status").text("Successful");
				$("#divCheckbox").show();
				
				
			}
			
			if(data == 2){
				
				//$("#divCheckbox").show();
				$("#status").text("Your order has been Deleted");
			}
			
			
			}
		
		});
}

function getData_1(){
	var form = $("#shoppingForm1");
	// Send request to the update shopping cart
		$.ajax({
			type: form.attr('method'),
			url: form.attr('action'),
			data: form.serialize(),
			success: function (data) {
			console.log(data);
			alert(data);
			if(data == 0){
				
				$("#status").text("No more seats available");
			}
			
			if(data == 1){
				$("#status").text("Successful");
				$("#divCheckbox").show();
				
			}
			
			if(data == 2){
				
				//$("#divCheckbox").show();
				$("#status").text("Your order has been Deleted");
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
 			<li class="active"><a href="CustomerHomePage.jsp">Home</a></li>
 		    <li><a href="ConcertSearchResults.jsp">Back</a></li>	
 		</ul>
 		 <ul class="nav navbar-nav navbar-right">	
 			<li><a href="ViewAndCheckoutShoppingCart.jsp"><span class="glyphicon glyphicon-shopping-cart"></span>Shopping Cart</a></li>	
 		</ul>
 	</div>
 </nav>		
 
<h1>Concert Details</h1>
 <table>

<thead>
<tr>
	<th>Concert Name</th>
	<th>Band Detail</th>
	<th>Venue name</th>
	<th>Available Seats</th>
	<th>Rating</th>
	<th>Type of Seats</th>
	<th>Review</th>
	<th>Price</th>
	<th>Quantity</th>
	<th>Add Review</th>
</tr>
</thead>
<tbody>
	<tr>
	<th class="text-center"><c:out value="${csrBean.bandName }"/></th>
	<th class="text-center"><c:out value="${csrBean.desc }"/></th>
	<th class="text-center"><c:out value="${csrBean.venueName }"/></th>
	<th class="text-center"><c:out value="${csrBean.availableSeats }"/></th>
	<th class="text-center"><c:out value="${csrBean.rating }"/></th>
	<th class="text-center"><c:out value="${csrBean.typeOfSeats}"/></th>
	<th class="text-center"><c:out value="${csrBean.review}"/></th>
	<th class="text-center"><c:out value="${csrBean.price}"/></th>
	<th class="text-center">
		<form action="UpdateShoppingCart" method="POST" id="shoppingForm">
			<input type="hidden" name="concertName" id = "bname" value="${csrBean.bandName }">
			<input type="hidden" name="description" id = "description" value="${csrBean.desc  }">
			<input type="hidden" name="venueName" id = "vname" value="${csrBean.venueName  }">
			<input type="hidden" name="availableSeats" id = "aseats" value="${csrBean.availableSeats  }">
			<input type="hidden" name="rating" id = "ratings" value="${csrBean.rating}">
			<input type="hidden" name="typeOfSeats" id = "toseats" value="${csrBean.typeOfSeats }">
			<input type="hidden" name="review" id = "reviews" value="${csrBean.review}">
			<input type="hidden" name="price" id = "prices" value="${csrBean.price}">
			<input type="text" name="qty" id="quantity" value=>
			<input type="hidden" name="delete" id="del"value="${0}">
			<input type="button" class="btn btn-primary" value="Add to Cart" id="btnCart">
		</form>
	</th>
	<th class="text-center">
		<form action="CustomerReview.jsp" method="POST" id="reviewForm">
			<input type="hidden" name="concertName" id = "bname" value="${csrBean.bandName }">
			<input type="hidden" name="description" id = "description" value="${csrBean.desc  }">
			<input type="hidden" name="venueName" id = "vname" value="${csrBean.venueName  }">
			<input type="hidden" name="availableSeats" id = "aseats" value="${csrBean.availableSeats  }">
			<input type="hidden" name="rating" id = "ratings" value="${csrBean.rating}">
			<input type="hidden" name="typeOfSeats" id = "toseats" value="${csrBean.typeOfSeats }">
			<input type="hidden" name="review" id = "reviews" value="${csrBean.review}">
			<input type="hidden" name="price" id = "prices" value="${csrBean.price}">
			<input type="hidden" name="qty" id="quantity" value="${0}">
			<input type="hidden" name="delete" id="del"value="${0}">
			<a href= "CustomerReview.jsp" type="button" class="btn btn-primary" id="reviewBtn">Add Review</a>
		</form>
	</th>
	</tr>
</tbody>
</table>
<p id="status"> </p>


<div id="divCheckbox" class="container-fluid">
	<div class = row>
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
				<th class="text-center"><c:out value="${csrBean.bandName}"/></th>
				<th class="text-center"><c:out value="${scBean.ticketQuantity}"/></th>
				<th class="text-center"><c:out value="${csrBean.venueName}"/></th>
				<th class="text-center"><c:out value="${csrBean.availableSeats}"/></th>
				<th class="text-center"><c:out value="${csrBean.price * scBean.ticketQuantity}"/></th>
				<th class="text-center">
			<form action="ConfirmOrder.jsp" method="post">
				<input type="hidden" name="concertName" value="<c:out value="${scBean.bandName}"/>">
				<input type="hidden" name="ticketQuantity" value="<c:out value="${scBean.ticketQuantity}"/>">
				<input type="hidden" name="venueName" value="<c:out value="${scBean.venueName}"/>">
				<input type="hidden" name="availableSeats" value="<c:out value="${scBean.availableSeats}"/>">
				<input type="hidden" name="totalPrice" value="<c:out value="${scBean.totalPrice * scBean.ticketQuantity}"/>">
				<input type="hidden" name="delete" value="removeCart">
				<input class="btn btn-primary" value="Check Out " type="submit" id="submitBtn" >
			</form>
			</th>
			<th class="text-center">
			<form action="UpdateShoppingCart" method="POST" id="shoppingForm1">
				<input type="hidden" name="concertName" value="<c:out value="${csrBean.bandName}"/>">
				<input type="hidden" name="qty" value="<c:out value="${scBean.ticketQuantity}"/>">
				<input type="hidden" name="venueName" value="<c:out value="${csrBean.venueName}"/>">
				<input type="hidden" name="availableSeats" value="<c:out value="${csrBean.availableSeats}"/>">
				<input type="hidden" name="price" value="<c:out value="${csrBean.price * scBean.ticketQuantity}"/>">
				<input type="hidden" name="delete" id="del" value="<c:out value="${1}"/>">
				<input type="hidden" name="delete1" id="del" value="<c:out value="${csrBean.price}"/>">
			<input class="btn btn-danger" value="Remove From Cart" type="button" id="delBtn" onClick="getData_1()">
			</form>
			</th>
			</tr>
		</tbody>
		</table>
	</div>
</div>
</body>
</html>