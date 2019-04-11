<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="customerStyle.css">
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
<title>Home page</title>
</head>
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
 <!-- Carousel Bootstrap -->
<div class = container-fluid>
	<div class = row>
		<div class = "col-md-12">
			<div id ="carousel" class="carousel slide" data-ride="carousel">
				<ol class = "carousel-indicators">
					<li data-target="#indicators" data-slide-to="0" class="active"></li>
					<li data-target="#indicators" data-slide-to="1" ></li>
					<li data-target="#indicators" data-slide-to="2" ></li>
				</ol>
				<div class ="carousel-inner">
					<div class="carousel-item active">
						<img class="d-block w-100" src="images/afterglow-background-beautiful-552791.jpg" alt="Sunrise">
						<div class="carousel-caption d-none d-md-block">
							<h5>Sunrise</h5>
							<p>Rise and Shine Boys and Girls</p>
						</div>
					</div>
					<div class="carousel-item">
						<img class="d-block w-100" src="images/background-background-image-clouds-1054289.jpg" alt="Dream">
						<div class="carousel-caption d-none d-md-block">
							<h5>Dream</h5>
							<p>Stop Dreaming </p>
						</div>
					</div>
					<div id = "Desk" class="carousel-item">
						<img class="d-block w-100" src="images/desktop-2325627_1920.jpg" alt="Desk">
						<div class="carousel-caption d-none d-md-block">
							<h5>Desk</h5>
							<p>Clutter and Declutter</p>
						</div>
					</div>
				</div>
				<a class="carousel-control-prev" href="#indicators" role="button" data-slide="prev">
					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a>
				<a class="carousel-control-next" href="#indicators" role="button" data-slide="next">
					<span class="carousel-control-next-icon" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>
		</div>
	</div>
	<div id="jumbo" class="jumbotron-fluid">
		<h1 class="display-5">Cinema Bros</h1>
		<p class="lead">The place to get to your dream concert with just a click!</p>
	</div>
</div>
</body>
</html>