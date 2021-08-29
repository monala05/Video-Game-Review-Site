<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<title>Search Page</title>
</head>
<body>
	<%@include file="navigation.html"%>
    <div id = "main-body">
    	<div id="search">
	    	<h1>Search</h1>
			 	<form id = "bar" action="./searchForGame">
			 		<input type ="search" name="keyword" id="keyword" placeholder="search by title, genre, user, score, or system!"
			 		style="color:black;width:100%;" class ="form-control rounded"/>
			 		<input type ="submit" style="color:black;" class ="btn btn-light"/>
			 	</form>
	 	</div>
	 	
	 	<div id ="search-results">
	 			<div class = "card bg-dark">
	 			<table id="search-table" class="table">
	 				<thead>
	 					<tr>
	 						<th>Game</th>
	 						<th>Genre</th>
	 						<th>System</th>
	 						<th>Username</th>
	 						<th>Score</th>
	 						<th>Review</th>
	 						<th>Date</th>
	 					</tr>
	 				</thead>
	 				<tbody>
	 					<c:forEach items = "${searchResults}" var = "game">
	 						<tr>
	 							<td>
	 								<div>
	 								${game.gameName}
	 								<img src="${game.cover}" alt="img not found" style="width:100px; height:150px"/>
	 								</div>
	 							</td>
	 							<td>${game.genre}</td>
	 							<td>${game.system}</td>
	 							<td>${game.reviews.iterator().next().getUser().username}</td>
	 							<td>${game.reviews.iterator().next().getScore()}
	 							<td>${game.reviews.iterator().next().getReviewText()}</td>
	 							<td>${game.reviews.iterator().next().formatDate()}</td>
	 						</tr>
	 					</c:forEach>
	 				</tbody>
	 			</table>
	 			</div>
	 	</div>
	</div>
	<script>
		function myFunc(){
			document.getElementById("search-table").style.visibility = "visible";
		}
	</script>
</body>
</html>