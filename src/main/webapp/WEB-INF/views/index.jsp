<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang = en>
<head>
<meta charset="ISO-8859-1">
<!--My stylesheet-->
<link rel='stylesheet' type='text/css' media='screen' href='css/home.css'>
<!--Icon CDN-->
<script src="https://kit.fontawesome.com/6e4d560886.js" crossorigin="anonymous"></script>
<!-- Bootstrap stylesheet-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
    rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<!--Google fonts-->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Baloo+Chettan+2:wght@400;600;800&display=swap" rel="stylesheet">
<title>Video game review site</title>
</head>
<body>
	<%@include file="navigation.html"%>
	
	  <div id = "main-body" class="center">
        <div id = "popular-games" class = "vertical-flex">
            <div id = "popular-games-title"><h1>Current popular game reviews</h1></div>
            <div id = "current-pop-games" class = "horizontal-flex">
            
                <div class="card bg-dark">
                    <div class = "horizontal-flex center-game-title card-header" ><p>Legend of Zelda: Skyward Sword</p></div>
                    <div class="card-body">
                       <img src="images/skyward.jpg" alt="skyward sword: legend of zelda"  
                       style ="border-radius: 10px;"> 
                    </div>
                </div>

                <div class="card bg-dark">
                    <div class = "horizontal-flex center-game-title card-header"><p>Read Dead Redemption 2</p></div>
                    <div class="card-body">
                        <img src="images/dead.jpg" alt="Cowboy game" 
                        style="border-radius: 10px;">
                    </div>
                </div>
                
                <div class="card bg-dark">
                    <div class="horizontal-flex center-game-title card-header"><p>Hades</p></div>
                    <div class="card-body">
                        <img src="images/hades.jpg" alt="Greek game" 
                         style="border-radius: 10px;">
                    </div>
                </div>

            </div>

        </div>
		
        <div id = "review-table" class = "recent-reviews card bg-dark">
        	<div class="card-header"><h2>Best games according to Metacritic</h2></div>
            <table class="table card-body">
                <thead class="thead-dark">
                  <tr>
                    <th scope="col">Game</th>
                    <th scope="col">Metacritic score</th>
                    <th scope="col">Summary</th>
                  </tr>
                </thead>
                <tbody>
                	<c:forEach items="${criticReviews}" var="review">
	                    <tr>
	                   		<td>
	                   			${review.gameName}
	                   			<img src="${review.cover}" alt = "pic"
	                   			style="width:100px;height:150px;">
	                   		</td>
	                   		<td><div class = "score">${review.metacriticScore}</div></td>
	                   		<td>${review.summary}</td>
	                   	</tr>
               	    </c:forEach>
                </tbody>
              </table>
        </div>
        
        <div id = "review-table" class = "recent-reviews card bg-dark">
			<div class="card-header"><h2>Best reviewed by our users</h2></div>
            <table class="table card-body">
                <thead class="thead-dark">
                  <tr>
                    <th scope="col">Game</th>
                    <th scope="col" width="18%">Average user score</th>
                    <th scope="col">Summary</th>
                  </tr>
                </thead>
                <tbody>
                	<c:forEach items="${userReviews}" var="review">
	                    <tr>
	                   		<td>
	                   			${review.game.getGameName()}
	                   			<img src="${review.game.getCover()}" alt = "pic" style="width:100px;height:150px;">
	                   		</td>
	                   		<td><div class = "score">${review.averageScore}</div></td>
	                   		<td>${review.game.getSummary()}</td>
	                   	</tr>
               	    </c:forEach>
                </tbody>
              </table>
        </div>        

        <div id = "game-demos">
            <div id = "demo-title" class = ""><h1>Upcoming games</h1></div>
            <div id = "gifs">
                <div id = "demo-one" class = "card bg-dark">
                    <div class = "card-header"><h2>FIFA 22</h2></div>
                    <div class="card-body">
	                    <iframe width="560" height="315" src="https://www.youtube.com/embed/o1igaMv46SY" 
	                    title="YouTube video player" frameborder="0" 
	                    allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" 
	                    allowfullscreen></iframe>
                    </div>
                </div>
                <div id = "demo-two" class = "card bg-dark">
                    <div class="card-header"><h2>Hogwarts Legacy</h2></div>
                    <div class="card-body">
	                    <iframe width="560" height="315" src="https://www.youtube.com/embed/1O6Qstncpnc?controls=0" 
	                    title="YouTube video player" frameborder="0" 
	                    allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
	                     allowfullscreen></iframe>
                     </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>