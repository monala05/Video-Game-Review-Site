<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang = en>
<head>
<meta charset="ISO-8859-1">
<!--My stylesheet-->
<link rel='stylesheet' type='text/css' media='screen' href='css/boards.css'>
<!--Icon CDN-->
<script src="https://kit.fontawesome.com/6e4d560886.js" crossorigin="anonymous"></script>
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
    
    	<h1 style="margin-top: 1em;">xbox Discussion</h1>
	   	<a href = "./boards"><button style="color:black; margin-bottom:5px" class="btn btn-light">Back to main lobby</button></a>
	   	<a href="#submit-form"><button style="color:black; margin-bottom:20px;" class ="btn btn-light">Make a post</button></a>
    	<div id="comment-container" style = "width:70%;">
	         <div id = "review-table" class = "reviews bg-light">
	             <table id="myTable" class = "table">
	             			<tr>
	             				<th style= "width:25%" class = "text-dark">User</th>
	             				<th class = "text-dark">Comment</th>
	             			</tr>
	                  <c:forEach items="${xboxComments}" var="comment">
	                 		<tr>
	                 			<td>
	                 				<div class = "text-dark">${comment.user.getUsername()} </div>
	                 				<div class = "text-dark">${comment.createDateTime}</div>
	                 			</td>
	                     		<td class = "text-dark">${comment.topic} ${comment.commentText}</td>
	                 		</tr>
	             		</c:forEach>
	              </table>
	    	</div>
		</div>
		       
	   <h2>What are your thoughts on your favorite games?</h2>
		<div id="submit-form">		
    		<form:form action = "registerNewXboxComment" method = "POST" modelAttribute = "newComment">
    			<label for = "topic">Topic</label><br>
    			<form:input type = "text" id = "about" name = "about" path = "topic" style="color:black;"/>
    			<form:errors path= "topic" cssClass="error" /><br>
    			
    			<label for = "comment">Thoughts</label><br>
    			<form:textarea id ="comment" name = "comment" path = "commentText" rows ="5" cols ="80" style="color:black;"></form:textarea>
    			<form:errors path="commentText" cssClass="error" /><br>
    			
    			<input type = "submit" style="color:black;"/>
    		</form:form>
	 	</div>
	</div>
</body>
</html>