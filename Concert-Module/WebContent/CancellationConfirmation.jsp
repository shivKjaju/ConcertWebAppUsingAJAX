<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<!--Library for jQuery Popperjs, JS, This is for the dropdown menu bar-->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<title>Order Cancelled</title>
</head>
<body>
<nav class="navbar navbar-expand-md navbar-light bg-light">
	<a class = "navbar-brand">CinemaBros</a>
	<div class = "collapse navbar-collapse">
		<ul class = 'navbar-nav mr-auto'>
			<li class = "nav-item active">
				<a class = "nav-link" href="CustomerHomePage.jsp">Home</a>
			</li>
			<li class = "nav-item dropdown">
				<a class="nav-link dropdown-toggle"href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				Orders
				</a>
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
	<div class ="row">
		<div class = "col-md-12">
			<table class="table table-hover">
				<thead>
					<tr>
						<th scope="col">Shows</th>
						<th scope="col">Venue</th>
						<th scope="col">Concert Time</th>
						<th scope="col">Quantity</th>
						<th scope="col">Credit Card Account</th>
						<th scope="col">Refund Amount</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th scope="row">${cancelOrderTransaction.conc.movieName}</th>
						<td>${cancelOrderTransaction.ven.name}</td>
						<td>${cancelOrderTransaction.perf.StartTime}</td>
						<td>${cancelOrderTransaction.quantity}</td>
						<td>${cancelOrderTransaction.order.CreditCardNumber}</td>
						<td>${cancelOrderTransaction.quantity * cancelOrderTransaction.tvp.TicketPrice}</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
</body>
</html>