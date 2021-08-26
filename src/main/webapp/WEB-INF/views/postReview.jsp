<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

<title>Post Review Page</title>
</head>
<body>
	<%@include file="navigation.html"%>
    <div id = "main-body">
		<div id = "leave-review">
	            <h1>Leave a review!</h1>
	            <div id="review-form-container">
	                <form:form method = "POST" action="registerNewReview" id="review-form" modelAttribute="newReview">                      	           		
	                	<label for="score">Score</label>
	                	<form:input type="number" id="score" path="score" style="color:black"
	                	min="1" max="100"/>
	                	<form:errors path="score" cssClass="error" />
	                	
	                	<label for="comment">Comment</label>
	               		<form:textarea path="reviewText" style="color:black"/>
	               		<form:errors path="reviewText" cssClass="error"/>
	               		<input type="hidden" value="${gameId}" name ="gameId"/>
	               		<!--  
				 		<input type ="text" name="keyword" id="keyword" />
				 		-->
						<input type = "submit" value = "submit" style = "color:black"/>
	                </form:form>
	            </div>
	        </div>
        </div>
</body>
</html>