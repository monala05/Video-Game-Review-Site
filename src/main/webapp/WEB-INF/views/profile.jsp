<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
            <h1 style = "margin-bottom: 20px;">Username</h1>
            <i class="fas fa-user-astronaut" style = "font-size: 140px;"></i>
            <form action=""></form>
            <div id = "user-details">
                <form>
                    <div class="form-group row info">
                      <label for="staticEmail" class="col-sm-2 col-form-label">Name</label>
                      <div class="col-sm-10">
                        <input type="text" readonly class="form-control-plaintext" id="staticName" value="Alan Montes">
                      </div>
                    </div>

                    <div class="form-group row info">
                        <label for="staticEmail" class="col-sm-2 col-form-label">Email</label>
                        <div class="col-sm-10">
                          <input type="text" readonly class="form-control-plaintext" id="staticEmail" value="alan@example.com">
                        </div>
                    </div>

                    
                    <div class="form-group row info">
                        <label for="staticEmail" class="col-sm-2 col-form-label">System</label>
                        <div class="col-sm-10">
                          <input type="text" readonly class="form-control-plaintext" id="staticSystem" value="Xbox">
                        </div>
                    </div>

                    <button type="submit" class="btn mb-2" style="background-color:tomato; color: whitesmoke;">Update account</button>

                 </form>
        
            </div>
        </div>

        <div id = "review-table" class = "user-reviews">
            <h1 class = "header-fonts" style="font-size: 68px;">Username's reviews</h1>
            <table class="table">
                <thead class="thead-dark">
                  <tr>
                    <th scope="col" colspan = "2">Game</th>
                    <th scope="col" width = "10%">User score</th>
                    <th scopre="col">User Review</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <th scope="row">CyberPunk 2077</th>
                    <td>
                        <img src="resources/punk.jpeg" alt="Video game not found" class = "thumbnail">
                    </td>
                    <td class="score-container">
                        <div class = "score">100%</div>
                    </td>
                    <td>Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
                        Proin consequat lorem ut elit tincidunt, nec blandit enim convallis. 
                        Sed feugiat aliquam augue, eu dapibus erat viverra ut. 
                        Vestibulum mattis velit mauris, non gravida felis volutpat accumsan.
                         Curabitur gravida, felis et rutrum posuere, quam lorem convallis ante, 
                         sed mattis nibh enim sit amet nunc.</td>
                  </tr>
                  <tr>
                    <th scope="row">Call of Duty: Black Ops Cold War</th>
                    <td>
                        <img src="resources/cod.jpeg" alt="Video game not found" class = "thumbnail">
                    </td>
                    <td class="score-container">
                        <div class = "score">98%</div>
                    </td>
                    <td>Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
                        Proin consequat lorem ut elit tincidunt, nec blandit enim convallis. 
                        Sed feugiat aliquam augue, eu dapibus erat viverra ut. 
                        Vestibulum mattis velit mauris, non gravida felis volutpat accumsan.
                         Curabitur gravida, felis et rutrum posuere, quam lorem convallis ante, 
                         sed mattis nibh enim sit amet nunc.</td>
                  </tr>
                  <tr>
                    <th scope="row">The world ends with you</th>
                    <td>
                        <img src="resources/world.jfif" alt="Video game not found" class = "thumbnail">
                    </td>
                    <td class = "score-container">
                        <div class = "score">85%</div>
                    </td>
                    <td>Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
                        Proin consequat lorem ut elit tincidunt, nec blandit enim convallis. 
                        Sed feugiat aliquam augue, eu dapibus erat viverra ut. 
                        Vestibulum mattis velit mauris, non gravida felis volutpat accumsan.
                         Curabitur gravida, felis et rutrum posuere, quam lorem convallis ante, 
                         sed mattis nibh enim sit amet nunc.</td>
                  </tr>
                </tbody>
              </table>
        </div>
    </div>
</body>
</html>