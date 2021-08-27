<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang = "en">
<head>
<meta charset="ISO-8859-1">
<!--My stylesheet-->
<link rel='stylesheet' type='text/css' media='screen' href='css/profile.css'>

<!--Icon CDN-->
<script src="https://kit.fontawesome.com/6e4d560886.js" crossorigin="anonymous"></script>
<!-- Bootstrap stylesheet-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
    rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    
<!--Google fonts-->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Baloo+Chettan+2:wght@400;600;800&display=swap" rel="stylesheet">
<title>Profile Page</title>
</head>
<body>
	<%@include file="navigation.html"%>
	 <div id = "main-body">
        <div id = "profile-card">
            <h1 style = "margin-bottom: 20px;">${user.getUsername()}</h1>
            <i class="fas fa-user-astronaut" style = "font-size: 140px;"></i>
            <div id = "user-details">
        		<h1>${user.name}</h1>
        		<h1>${user.email}</h1>
        		<h1>${user.userRole}</h1>
        		<h1>System</h1>
            </div>
            <div><a href="./update"><input type="button" value ="update" class="btn-primary"/></a></div>
            <div><a href="./logout"><input type="button" value="logout" class="btn-danger"/></a></div>
        </div>

        <div id = "review-table" class = "user-reviews">
            <h1 class = "header-fonts" style="font-size: 68px;">${user.getUsername()}'s reviews</h1>
            <table class="table">
                <thead class="thead-dark">
                  <tr>
                    <th scope="col" colspan = "2">Game</th>
                    <th scope="col" width = "10%">User score</th>
                    <th scope="col">User Review</th>
                  </tr>
                </thead>
                <tbody>
                  <c:forEach items="${userReviews}" var="review">
                  <tr>
                    <th scope="row">${review.game.getGameName()}</th>
                    <td>
                        <img src="${review.game.getCover()}" alt="Video game not found" class = "thumbnail">
                    </td>
                    <td class="score-container">
                        <div class = "score">${review.score}%</div>
                    </td>
                    <td>${review.reviewText}</td>
                  </tr>
                  </c:forEach>
                </tbody>
              </table>
        </div>
    </div>
</body>
</html>