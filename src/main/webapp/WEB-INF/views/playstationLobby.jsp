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
	   	<div id="comment-container">
	    	<h1>Playstation Discussion</h1>
	   		<a href = "./boards"><button>Back to main lobby</button></a>
	   
	         <div id = "review-table" class = "reviews">
	             <table id="myTable" class = "font-family: Baloo Chettan 2, cursive">
	                  <c:forEach items="${playstationComments}" var="comment">
	                 		<tr>
	                 			<td>${comment.user.getUsername()} ${comment.createDateTime}</td>
	                     		<td>${comment.topic} ${comment.commentText}</td>
	                 		</tr>
	             		</c:forEach>
	              </table>
	    	</div>
		</div>
		       
	   <h2>What are your thoughts on your favorite games?</h2>
		<div>		
    		<form:form action = "registerNewPlaystationComment" method = "POST" modelAttribute = "newComment">
    			<label for = "topic">Topic</label>
    			<form:input type = "text" id = "about" name = "about" path = "topic"/>
    			<form:errors path= "topic" cssClass="error" /><br>
    			
    			<label for = "comment">Thoughts</label><br>
    			<form:textarea id ="comment" name = "comment" path = "commentText" rows ="5" cols = "80" style = "color: black;"></form:textarea>
    			<form:errors path="commentText" cssClass="error" /><br>
    			
    			<input type = "submit"/>
    		</form:form>
	 	</div>
	</div>
</body>
</html>