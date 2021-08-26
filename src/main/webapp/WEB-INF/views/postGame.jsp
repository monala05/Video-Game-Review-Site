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

<title>Post Game Page</title>
</head>
<body>
	<%@include file="navigation.html"%>
    <div id = "main-body">
    
		<div id = "game-form-container">
            <h1>Leave a review!</h1>
            <div id="">
                <form:form method = "POST" action="registerNewGame" id="game-form" modelAttribute="newGame">            
                   	<label for="name">Name</label>
                   	<form:input type="text" id="gameName" path="gameName" style="color:black"/>
                   	<form:errors path="gameName" cssClass="error" />
                   	
                   	<label for="name">Cover</label>
                   	<form:input type="text" id="gameCover" path="cover" style="color:black"/>
                   	<form:errors path="cover" cssClass="error" />
                   	
                   	<label for="genre">Genre</label>
                   	<form:input type="text" id="genre" path="genre" style="color:black"/>
                   	<form:errors path="genre" cssClass="error" />
                   	
                   	<label for="system">System</label>
                   	<form:input type="text" id="system" path="system" style="color:black"/>
                   	<form:errors path="system" cssClass="error"/>  
                   	           		
                	<label for="score">Metacritic Score</label>
                	<form:input type="number" id="metacriticScore" path="metacriticScore" style="color:black"
                	min="1" max="100"/>
                	<form:errors path="metacriticScore" cssClass="error" />
                	
                	<label for="comment">Summary</label>
               		<form:textarea id="summary" path="summary" style="color:black"/>
               		<form:errors path="summary" cssClass="error"/>
               
					<input type = "submit" value = "submit" style = "color:black"/>
                </form:form>
            </div>
        </div>
        
	</div>
</body>
</html>