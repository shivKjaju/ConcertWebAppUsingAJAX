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
<!--Library for jQuery Popperjs, JS, This is for the dropdown menu bar-->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<title>Customer Review</title>
</head>


<script type="text/javascript">
function setReview(){
	var form = $("#reviewForm");
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
			}
			
			}
		});
}
</script>


<script>
$(document).ready(function(){
	$("#reviewBtn").click(function(e) {
	    setReview();
	});
});
</script>

<body>
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
	<a class = "navbar-brand">CinemaBros</a>
	<div class = "collapse navbar-collapse">
		<ul class = 'navbar-nav mr-auto'>
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
		<form action = "VenueAndConcertSearchQuery" class = "form-inline">
			<input class="form-control mr-sm-2" type="search" placeholder="Search Concert" aria-label="Search" name="query">
    		<input class="btn btn-outline-info my-2 my-sm-0" type="submit">
		</form>
	</div>
</nav>	
<h3>Concert and Venue Review</h3>
<div class = container-fluid>
<form action=CustomerReview method="POST" id="reviewForm">
	<h5>Concert :<c:out value="${csrBean.bandName }"/></h5>
	<h5>Venue:<c:out value="${csrBean.venueName}"/></h5>
	  <div class="form-group">
	    <label for="rating1">Rating</label>
	    <select class="form-control" name="rating1">
	      <option>1</option>
	      <option>2</option>
	      <option>3</option>
	      <option>4</option>
	      <option>5</option>
	    </select>
	  </div>
	  <div class="form-group">
	    <label for="textarea1">Review</label>
	    <textarea class="form-control" name="textarea1" rows="3"></textarea>
	  </div>
	  
	<input type="hidden" name = "bandName"value="${csrBean.bandName }">	
	<input type="hidden" name = "venueName"value="${csrBean.venueName }">
</form>
<input type="button" class="btn btn-primary" value="Add Rating and Review" id="reviewBtn">
<a class = "btn btn-danger" href=ConcertDetailsSelection.jsp>Cancel</a>
</div>
</body>
</html>