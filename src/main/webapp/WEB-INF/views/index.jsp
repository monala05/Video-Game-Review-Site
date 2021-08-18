<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

        <div id = "popular-games" class = "vertical-flex"`>
            <div id = "popular-games-title"><h1>Current popular game reviews</h1></div>
            <div id = "current-pop-games" class = "horizontal-flex">

                <div>
                    <div class = "horizontal-flex center-game-title"><p>Game 1</p></div>
                    <div>
                       <img src="resources/skyward.jpg" alt="skyward sword: legend of zelda"  
                       style = "margin-right: 30px;border-radius: 10px;"> 
                    </div>
                </div>

                <div>
                    <div class = "horizontal-flex center-game-title"><p>Game 2</p></div>
                    <div>
                        <img src="resources/dead.jpg" alt="Cowboy game" 
                        style="margin-right: 30px; border-radius: 10px;">
                    </div>
                </div>

                <div>
                    <div class = "horizontal-flex center-game-title"><p>Game 3</p></div>
                    <div>
                        <img src="resources/hades.jpg" alt="Greek game" 
                        style="border-radius: 10px;">
                    </div>
                </div>

            </div>

        </div>

        <div id = "review-table" class = "recent-reviews">
            <table class="table">
                <thead class="thead-dark">
                  <tr>
                    <th scope="col" colspan = "2">Recent game reviews</th>
                    <th scope = "col">Critic review</th>
                    <th scopre = "col">User Review</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <th scope="row">1</th>
                    <td>MineCraft</td>
                    <td>100%</td>
                    <td>5/5</td>
                  </tr>
                  <tr>
                    <th scope="row">2</th>
                    <td>MK11</td>
                    <td>90%</td>
                    <td>4/5</td>
                  </tr>
                  <tr>
                    <th scope="row">3</th>
                    <td>Mario Golf</td>
                    <td>75%</td>
                    <td>2/5</td>
                  </tr>
                </tbody>
              </table>
        </div>

        <div id = "game-demos">
            <div id = "demo-title"><p>Cool demos!</p></div>
            <div id = "gifs">
                <div id = "demo-one">
                    <p>Game 1</p>
                    <iframe width="560" height="315" src="https://www.youtube.com/embed/o1igaMv46SY" 
                    title="YouTube video player" frameborder="0" 
                    allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" 
                    allowfullscreen></iframe>
                </div>
                <div id = "demo-two">
                    <p>Game 2</p>
                    <iframe width="560" height="315" src="https://www.youtube.com/embed/1O6Qstncpnc?controls=0" 
                    title="YouTube video player" frameborder="0" 
                    allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
                     allowfullscreen></iframe>
                </div>
            </div>
        </div>
    </div>
</body>
</html>