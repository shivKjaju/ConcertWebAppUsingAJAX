<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!--Bootstrap Library -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<title>Order Cancel Process</title>
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
<nav class="navbar navbar-expand-md navbar-light bg-light">
	<a class = "navbar-brand">CinemaBros</a>
	<div class = "collapse navbar-collapse">
		<ul class = 'navbar-nav mr-auto'>
			<li class = "nav-item active">
				<a class = "nav-link" href="CustomerHomePage.jsp">Home</a>
			</li>
			<li class = "nav-item">
				<form action=ViewOrders>
					<input class="nav-link" value="View your orders" type="submit">
					<input type="hidden" value="${user}" name="ViewOrder">
				</form>
			</li>
			<li class = "nav-item">
				<a class = "nav-link" href="Login.jsp">Logout</a>
			</li>
		</ul>
	</div>
</nav>
<div class = "container-fluid">
	<h3>Cancel Order</h3>
	<div class = "row">
		<div class = "col-md-12">
			<table>
			<thead>
			<tr>
				<th>Order Item Number</th>
				<th>Performance ID</th>
				<th>Quantity</th>
				<th>Venue </th>
				<th>Concert</th>
				<th>Ticket Type</th>
				<th>Ticket Price</th>
				<th>Cancel Item</th>
			</tr>
			</thead>
			<tbody>
				<tr>
				<th class="text-center"><c:out value="${cancelOrder.id}"/></th>
				<th class="text-center"><c:out value="${cancelOrder.performanceId}"/></th>
				<th class="text-center"><c:out value="${cancelOrder.quantity}"/></th>
				<th class="text-center"><c:out value="${cancelOrder.ven.name}"/></th>
				<th class="text-center"><c:out value="${cancelOrder.conc.movieName}"/></th>
				<th class="text-center"><c:out value="${cancelOrder.ticketType.seatName}"/></th>
				<th class="text-center"><c:out value="${cancelOrder.tvp.TicketPrice}"/></th>
				<th class="text-center">
					<form action="CancelOrderTransaction" method="post">
					<input type="hidden" name="orderItemId" value="<c:out value="${cancelOrder.id}"/>">
					<input type="hidden" name="performanceId" value="<c:out value="${cancelOrder.performanceId}"/>">
					<input type="hidden" name="quantity" value="<c:out value="${cancelOrder.quantity}"/>">
					<input type="hidden" name="venueName" value="<c:out value="${cancelOrder.ven.name}"/>">
					<input type="hidden" name="movieName" value="<c:out value="${cancelOrder.conc.movieName}"/>">
					<input type="hidden" name="ticketType" value="<c:out value="${cancelOrder.ticketType.seatName}"/>">
					<input type="hidden" name="TicketPrice" value="<c:out value="${cancelOrder.tvp.TicketPrice}"/>">
					<input class="btn btn-danger " type="submit" value="Confirm Cancellation">
					</form>
				</th>
				</tr>
			</tbody>
		</table>
		<a class = "btn btn-primary" href="ManageOrder.jsp">Discard Cancel</a>
		</div>
	</div>
</div>
</body>
</html>