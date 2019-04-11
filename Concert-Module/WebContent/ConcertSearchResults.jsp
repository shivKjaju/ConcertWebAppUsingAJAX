<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css
">
</head>
<body>

<nav class="navbar navbar-inverse">
 	<div class="container-fluid">
 		<ul class="nav navbar-nav">
 			<li class="active"><a href="ViewOrders.jsp">Go back</a></li>
 		</ul>
 		 <ul class="nav navbar-nav navbar-right">	
 			<li><a href="Login.jsp"><span class="glyphicon glyphicon-log-out"></span>Logout</a></li>	
 		</ul>
 	</div>
</nav>	

<h1>Your results </h1>

<table>
<thead>
<tr>
	<th>Concert Name</th>
	<th>Address</th>
	<th>Available seats</th>
	<th>Details</th>
</tr>
</thead>
<c:forEach items="${SearchResultList}" var="i">
<tbody>
	<tr>
	<th class="text-center"><c:out value="${i.conc.movieName}"/></th>
	<th class="text-center"><c:out value="${i.ven.address}"/></th>
	<th class="text-center"><c:out value="${i.ven.totalSeats}"/></th>
	<th class="text-center">
		<form action="ConcertSearchResults" method="post">
		<input type="hidden" name="concertname" value="<c:out value="${i.conc.movieName}"/>">
		<input type="hidden" name="address" value="<c:out value="${i.ven.address}"/>">
		<input type="hidden" name="seats" value="<c:out value="${i.ven.totalSeats}"/>">
		<input class="btn btn-info " type="submit" value="View Details">
		</form>
	</th>
	</tr>
</tbody>
</c:forEach>
</table>


</body>
</html>



