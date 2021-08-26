<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang = en>
<head>
<meta charset="ISO-8859-1">
<!--My stylesheet-->
<link rel='stylesheet' type='text/css' media='screen' href='css/boards.css'>
<!--Icon CDN-->
<script src="https://kit.fontawesome.com/6e4d560886.js" crossorigin="anonymous"></script>
<script src="https://code.iconify.design/2/2.0.3/iconify.min.js"></script>
<!-- Bootstrap stylesheet-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
    rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<!--Google fonts-->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Baloo+Chettan+2:wght@400;600;800&display=swap" rel="stylesheet">
<title>Boards page</title>
</head>
<body>
	<%@include file="navigation.html"%>
    <div id = "main-body">
    	<div>		
    		<a href = ""><button style = "color:black;">Post</button></a>
	 	</div>
	 	
	 	<div>
	 		<span class="fab fa-xbox"></span>
	 		<a href="xboxLobby">Xbox lobby</a>
	 	</div>
	 	
	 	<div>
	 		<span class="iconify" data-icon="mdi:nintendo-switch"></span>
	 		<a href="nintendoLobby">nintendo lobby</a>
	 	</div>
	 	
	 	<div>
	 		<span class="fab fa-playstation"></span>
	 		<a href="playstationLobby">playstation lobby</a>
	 	</div>
	 	
	 	<div>
	 		<span class="fas fa-desktop"></span>
	 		<a href="pcLobby">PC lobby</a>
	 	</div>
	</div>
</body>
</html>