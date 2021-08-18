<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!--My stylesheet-->
<link rel='stylesheet' type='text/css' media='screen' href='css/login.css'>

<!--Icon CDN-->
<script src="https://kit.fontawesome.com/6e4d560886.js" crossorigin="anonymous"></script>
<!-- Bootstrap stylesheet-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
    rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    
<!--Google fonts-->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Baloo+Chettan+2:wght@400;600;800&display=swap" rel="stylesheet">
<title>Login Page</title>
</head>
<body>
	<%@include file="navigation.html"%>
	 <div id = "main-body">
	 	<div id = "login-card" style = "border: solid">
	 		<h1>Login</h1>
	 		<div id = "login-form">
	 			<form action="" id = "login-body">
	 				<input type = "text" placeholder = "username" id = "username" name = "username" required><br>
	 				<input type = "text" placeholder = "password" id = "username" name = "username" required><br>	
	 			</form>
	 		</div>
	 		<div id ="register">
	 			<a href = "register">
	 				<button type="submit" class="btn mb-2" style="background-color:tomato; color: whitesmoke;">Not a member?</button>
	 			</a>
	 		</div>
	 	</div>
    </div>
</body>
</html>