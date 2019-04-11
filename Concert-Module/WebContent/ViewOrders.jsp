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
<title>View Order</title>
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
				<a class = "nav-link" href="Login.jsp">Logout</a>
			</li>
		</ul>
	</div>
</nav>
<div class = "container-fluid">
	<h3>Recent Orders</h3>
	<div class = row>
		<div class = col-md-12>
		<table>
			<thead>
			<tr>
				<th>Order Number</th>
				<th>Total Price</th>
				<th>Ordered Date</th>
				<th>Details</th>
			</tr>
			</thead>
			<c:forEach items="${ViewOrder}" var="i">
			<tbody>
				<tr>
				<th class="text-center"><c:out value="${i.id}"/></th>
				<th class="text-center"><c:out value="${i.totalCost}"/></th>
				<th class="text-center"><c:out value="${i.orderDate}"/></th>
				<th class="text-center">
					<form action="ManageOrder" method="post">
					<input type="hidden" name="orderId" value="<c:out value="${i.id}"/>">
					<input type="hidden" name="totalCost" value="<c:out value="${i.totalCost}"/>">
					<input type="hidden" name="orderDate" value="<c:out value="${i.orderDate}"/>">
					<input class="btn btn-info " type="submit" value="View">
					</form>
				</th>
				</tr>
			</tbody>
			</c:forEach>
		</table>
		</div>
	</div>
</div>
</body>
</html>