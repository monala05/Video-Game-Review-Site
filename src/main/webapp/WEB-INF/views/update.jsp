<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang=en>
<head>
<meta charset="ISO-8859-1">
<!--My stylesheet-->
<link rel='stylesheet' type='text/css' media='screen' href='css/search.css'>
<!--Icon CDN-->
<script src="https://kit.fontawesome.com/6e4d560886.js" crossorigin="anonymous"></script>
<!-- Bootstrap stylesheet-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
    rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<!--Google fonts-->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Baloo+Chettan+2:wght@400;600;800&display=swap" rel="stylesheet">

<title>Update Game</title>
</head>
<body>
	<%@include file="navigation.html"%>
    <div id = "main-body">
    
		<div id = "update-form-container">
	        <form action="updateUser" method="post" >
			<div>
				<label>Username:</label>
				<input type="text" name="username" style = "color: black;"/>
			</div>
			<div>
				<label>name:</label>
				<input type="text" name="name" style = "color: black;"/>
			</div>
			<div>
				<label>email:</label>
				<input type="text" name="email" style = "color: black;"/>
			</div>
			<div>
				<label>password:</label>
				<input type="text" name="password" style = "color: black;"/>
			</div>			
			<div>
				<input type="submit" value="Submit" style = "color: black;"/>
			</div>
			</form>
        </div>
        
	</div>
</body>
</html>