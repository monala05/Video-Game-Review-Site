<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

        <div id = "leave-review">
            <h1>Leave a review!</h1>
            <div id="review-form-container">
                <form:form method = "POST" action="registerNewReview" id = "review-form" modelAttribute = "newReview">
                	<div style = "color:black">
                    	<label for="score">Score:</label>
                    	<form:input type="number" id ="score" path ="score"/>
                    	<form:errors path="score" cssClass="error" />
                    </div>
                    <div style = "color:black">
                    	<label for="comment">Comment</label>
                   		<form:input type="text" path="reviewText"/>
                   		<form:errors path="reviewText" cssClass="error"/>
  					</div>
  					<div>
                    	<input type = "submit" value = "submit"/>
                    </div>
                </form:form>
            </div>
        </div>

        <div id = "review-container">
            <h1>Fresh reviews</h1>
            <h3>top 20</h3>
            <div id = "review-table" class = "reviews">
                <table id="myTable" class = "font-family: Baloo Chettan 2, cursive">
                	<caption>Last 20 reviews submitted</caption>
                    <tr>
                        <th id="game-column" style="width: 150px;">Game</th>
                        <th id="console-column" style="width: 150px;">Console</th>
                        <th id="sccore-column" style="width: 150px;">Critic score</th>
                    </tr>
                  </table>

            </div>
        </div>
    </div>
</body>
</body>
</html>