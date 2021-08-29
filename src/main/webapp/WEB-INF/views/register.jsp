 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang=en>
<head>
<meta charset="ISO-8859-1">
<!--My stylesheet-->
<link rel='stylesheet' type='text/css' media='screen' href='css/register.css'>
<!--Icon CDN-->
<script src="https://kit.fontawesome.com/6e4d560886.js" crossorigin="anonymous"></script>
<!-- Bootstrap stylesheet-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
    rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous"> 
<!--Google fonts-->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Baloo+Chettan+2:wght@400;600;800&display=swap" rel="stylesheet">
<title>Register</title>
</head>
<body>
	<%@include file = "navigation.html"%>
	 <div id = "main-body">
		 <div id="form-container" class = "card bg-dark">
		  	<div class = "card-header"><h1>Registration Page</h1></div>
			<form:form action="registerNewUser" method="post" modelAttribute="newUser" class = "card-body">
			<div class = "seperate">
				<label>Username:</label>
				<form:input type="text" path="username" name="username" style = "color: black;"/>
				<form:errors path="username" cssClass="error" />
			</div>
			<div class = "seperate">
				<label>Password:</label>
				<form:input type="text" path="password" name="password" style = "color: black;"/>
				<form:errors path="password" cssClass="error" />
			</div>
			<div class = "seperate">
				<label>name:</label>
				<form:input type="text" path="name" name="name" style = "color: black;"/>
				<form:errors path="username" cssClass="error" />
			</div>
			<div class = "seperate">
				<label>email:</label>
				<form:input type="text" path="email" name="email" style = "color: black;"/>
				<form:errors path="password" cssClass="error" />
			</div>
			
			<div style="display:flex;justify-content:center;">
				<input type="submit" value="Submit" class="btn btn-primary"/>
			</div>
			</form:form>
			<a href="/login"><button class ="btn btn-danger">Cancel?</button></a>
		 </div>
	 </div>
</body>
</html>