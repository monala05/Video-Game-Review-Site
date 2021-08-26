<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang = en>
<head> 
<meta charset="ISO-8859-1">
<!--My stylesheet-->
<link rel='stylesheet' type='text/css' media='screen' href='css/reviews.css'>

<!--Icon CDN-->
<script src="https://kit.fontawesome.com/6e4d560886.js" crossorigin="anonymous"></script>

<!-- Bootstrap stylesheet-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
    rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<!--Google fonts-->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Baloo+Chettan+2:wght@400;600;800&display=swap" rel="stylesheet">
<title>Review page</title>
</head>
<body>
	<%@include file="navigation.html"%>
    <div id = "main-body">
       	<div id = "review-container">
           <h1>Fresh reviews</h1>
           <h3>top 20</h3>
           <div id = "review-table" class = "reviews">
               <table id="myTable" class = "font-family: Baloo Chettan 2, cursive">
               	<caption>Last 20 reviews submitted</caption>
                   <tr>
					   <th id="game-column" style="width: 150px;">UserName</th>
                       <th id="game-column" style="width: 150px;">Game</th>
                       <th id="genre-column" style="width: 150px;">Genre</th>
                       <th id="console-column" style="width: 150px;">Console</th>
                       <th id="sccore-column" style="width: 150px;">User score</th>
                       <th id ="review-comment" style="width:150px;">Review</th>
                   </tr>
                   <c:forEach items="${allReviews}" var="review">
                   <tr>
                   		<td>${review.user.getUsername()}</td>
                   		<td>
                   			${review.game.getGameName()} <br>
                   			<img src="${review.game.getCover()}" style="width:100px;height:150px;" alt = "img not found"/>
                   		</td>
                   		<td>${review.game.getGenre()}</td>
                   		<td>${review.game.getSystem()}</td>
                   		<td>${review.score}</td>
                       	<td>${review.reviewText}</td>
                   	</tr>
               		</c:forEach>
                </table>
           </div>
           
           <sec:authorize access="hasRole('ADMIN')">
	           <div>
	     	  	<h1>Post game</h1><a href="/postGame"><input type = "button" value="Post" style="color:black;"></a>
	           </div>
		   </sec:authorize>
           
           
           <div id="games-table">
           	 	<table id="search-table">
	 				<thead>
	 					<tr>
	 						<th>Game</th>
	 						<th>Genre</th>
	 						<th>System</th>
	 						<th>Metacritic Score</th>
	 						<th>Summary</th>
	 						<th></th>
	 					</tr>
	 				</thead>
	 				<tbody>
	 					<c:forEach items = "${allGames}" var = "game">
	 						<tr>
	 							<td>${game.gameName}
                   		  		<img src ="${game.cover}" style="width:150px;height:250px;" alt="not found"/></td>
	 							<td>${game.genre}</td>
	 							<td>${game.system}</td>
	 							<td>${game.metacriticScore}</td>
	 							<td>${game.summary}</td>
	 							<td>
	 								<a href="postReview?gameId=${game.gameId}"><input type="button" value = "Make a review" style = "color:black;"/></a>
	 								
	 								<form action="deleteReview" method="POST">
	 									<input type="hidden" value="${game.gameId}" name ="gameId">
	 									<input type="submit" value = "Delete" class = "btn-danger"/>
	 								</form>
	 							</td>
	 						</tr>
	 					</c:forEach>
	 				</tbody>
	 			</table>
           </div>
       </div>
   </div>
</body>
</body>
</html>