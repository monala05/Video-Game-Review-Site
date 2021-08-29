package org.alanmontes.videogamereviewsite.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.alanmontes.videogamereviewsite.models.Comment;
import org.alanmontes.videogamereviewsite.models.CompositeModelDto;
import org.alanmontes.videogamereviewsite.models.Game;
import org.alanmontes.videogamereviewsite.models.Review;
import org.alanmontes.videogamereviewsite.models.User;
import org.alanmontes.videogamereviewsite.security.CurrentUser;
import org.alanmontes.videogamereviewsite.services.CommentService;
import org.alanmontes.videogamereviewsite.services.GameService;
import org.alanmontes.videogamereviewsite.services.ReviewService;
import org.alanmontes.videogamereviewsite.services.UserService;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	ReviewService reviewService;
	UserService userService;
	GameService gameService;
	CommentService commentService;
	Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	//Injecting all of the app's services to the controller in order to manipulate database
	@Autowired
	public HomeController(ReviewService reviewService, UserService userService, 
			GameService gameService, CommentService commentService) {	
		this.reviewService = reviewService;
		this.userService = userService;
		this.gameService = gameService;
		this.commentService = commentService;
	}
	
	@GetMapping("/")
	public String showHomePage(Model model) {
		//Add review attributes to populate tables in homepage
		model.addAttribute("criticReviews", gameService.topGamesByCritic());
		model.addAttribute("userReviews", reviewService.findReviewByAverageUserScore());
		return "index";
	}
	
	@GetMapping("/reviews")
	public String showReviewsPage(Model model) {
		//Add review and game list objects to populate reviews.jsp
		model.addAttribute("allReviews", reviewService.findAllGamesWithReviewAndUserJoin());
		model.addAttribute("allGames", gameService.findAllGames());
		return "reviews";
	}
	
	@GetMapping("/postReview")
	public String showReviewPage(@RequestParam("gameId")int gameId,Model model) {
		//Makes a review available to bind request data to model
		model.addAttribute("newReview", new Review());
		model.addAttribute("gameId", gameId);
		return "postReview";
	}
	
  	@PostMapping("/registerNewReview")
	public String registerNewReview(@Valid @ModelAttribute("newReview") Review review,
			@RequestParam("gameId") int gameId, BindingResult result,
		HttpSession session) {
		if (result.hasErrors()) {
			return "reviews";
		}
		
		//Get models to persist
		CurrentUser currentUser = (CurrentUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = currentUser.getUser();	
		Game game = gameService.findGameById(gameId);
		
		//binds user and game to review model to populate foreign keys with 
		//correct user and game
		review.setUser(user);
		review.setGame(game);
		
		reviewService.save(review);
		return "redirect:/reviews";
	}
  	
  	@PostMapping("deleteGame")
  	public String deleteGame(@RequestParam("gameId") int gameId) {
  		//Delete all reviews for that game first, then delete by id
  		reviewService.deleteReviewsByGameId(gameId);
  		gameService.deleteGameById(gameId);
  		return"redirect:/reviews";
  	}
  	
	@GetMapping("/profile")
	public String showProfilesPage(Model model) {
		CurrentUser currentUser = (CurrentUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = currentUser.getUser();
		model.addAttribute(user);
		
		//Find all games for current user
		model.addAttribute("userReviews", reviewService.findAllGamesReviewAndGameJoinWhereUser(user.getUserId()));
		return "profile";
	}
	
	@GetMapping("/boards")
	public String showBoardsPage() {
		return"boards";
	}
	
	@GetMapping("/search")
	public String showSearchPage() {
		return "search";
	}
	
	@GetMapping("/searchForGame")
	public String showSearchResults(@RequestParam String keyword, Model model) {
	
		model.addAttribute("searchResults", gameService.findAllGamesBySearch(keyword));
		return "search";
	}
	
	@GetMapping("/login")
	public String showLoginPage(Model model) {
		return "login";
	}
	
	@GetMapping("/register")
	public String showRegistrationPage(Model model) {
		model.addAttribute("newUser", new User());
		return "register";
	}
	
	@GetMapping("update")
	public String showUpdatePage(Model model) {
		CurrentUser currentUser = (CurrentUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = currentUser.getUser();
		
		//make user available for post controller to use
		model.addAttribute(user);
		return "update";
	}
	
	@GetMapping("/pcLobby")
	public String showPcLobbyPage(Model model) {
		model.addAttribute("newComment", new Comment());
		model.addAttribute("pcComments", commentService.findCommentsByBoardJoinUser("PC"));
		return "pcLobby";
	}
	
	@GetMapping("/nintendoLobby")
	public String showNintendoLobbyPage(Model model) {
		model.addAttribute("newComment", new Comment());
		model.addAttribute("nintendoComments", commentService.findCommentsByBoardJoinUser("Nintendo"));
		return"nintendoLobby";
	}
	
	/*all lobby controllers make a comment object avaialable for post mapping
	 * then they display comments related to that page finding by name
	 */
	@GetMapping("/xboxLobby")
	public String showXboxLobbyPage(Model model) {
		model.addAttribute("newComment", new Comment());
		model.addAttribute("xboxComments", commentService.findCommentsByBoardJoinUser("Xbox"));
		return "xboxLobby";
	}
	
	@GetMapping("/playstationLobby")
	public String showPlaystationLobbyPage(Model model) {
		model.addAttribute("newComment", new Comment());
		model.addAttribute("playstationComments", commentService.findCommentsByBoardJoinUser("Playstation"));
		return "playstationLobby";
	}
	
	@GetMapping("/postGame")
	public String howPostGamePage(Model model) {
		model.addAttribute("newGame", new Game());
		return "postGame";
	}

	
  	@PostMapping("/registerNewUser")
	public String registerNewUser(@Valid @ModelAttribute("newUser") User newUser, 
			BindingResult result) {
		if (result.hasErrors()) {
			return "register";
		}
		userService.save(newUser);
		return "redirect:/login";
	}
  	
  	@PostMapping("updateUser")
  	public String updateUser(@RequestParam("username") String username, 
  			@RequestParam("name") String name, @RequestParam("email") String email,
  			@RequestParam("password") String password) {
  		
  			CurrentUser currentUser = (CurrentUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
  			User user = currentUser.getUser();
		
			user.setUsername(username);
			user.setName(name);
			user.setEmail(email);
			user.setPassword(password);
			userService.save(user);
  		return "redirect:/profile";
  	}
	
  	@PostMapping("/registerNewXboxComment")
  	public String registerNewXboxComment(@Valid @ModelAttribute("newComment") Comment comment,
			BindingResult result) {
		if (result.hasErrors()) {
			return "xboxLobby";
		}
		CurrentUser currentUser = (CurrentUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = currentUser.getUser();
		comment.setBoard("Xbox");
		comment.setUser(user);
		
		commentService.save(comment);
		return "redirect:/xboxLobby";
  	}
  	
  	@PostMapping("/registerNewPlaystationComment")
  	public String registerNewPlaystationComment(@Valid @ModelAttribute("newComment") Comment comment,
			BindingResult result) {
		if (result.hasErrors()) {
			return "xboxLobby";
		}
		CurrentUser currentUser = (CurrentUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = currentUser.getUser();
		comment.setBoard("Playstation");
		comment.setUser(user);
		
		commentService.save(comment);
		return "redirect:/playstationLobby";
  	}
  	
  	@PostMapping("/registerNewNintendoComment")
  	public String registerNewNintendoComment(@Valid @ModelAttribute("newComment") Comment comment,
			BindingResult result) {
		if (result.hasErrors()) {
			return "nintendoLobby";
		}
		CurrentUser currentUser = (CurrentUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = currentUser.getUser();
		comment.setBoard("Nintendo");
		comment.setUser(user);
		
		commentService.save(comment);
		return "redirect:/nintendoLobby";
  	}
  	
  	@PostMapping("/registerNewPcComment")
  	public String registerNewPcComment(@Valid @ModelAttribute("newComment") Comment comment,
			BindingResult result) {
		if (result.hasErrors()) {
			return "pcLobby";
		}
		
		//Get Current user from security context
		CurrentUser currentUser = (CurrentUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = currentUser.getUser();
		comment.setBoard("PC");
		comment.setUser(user);
		
		commentService.save(comment);
		return "redirect:/pcLobby";
  	}
  	
  	@PostMapping("registerNewGame")
  	public String registerNewGame(@Valid @ModelAttribute("newGame") Game newGame,
  			BindingResult result) {
  			if(result.hasErrors()) {
  				return "index";
  			}
  			gameService.save(newGame);
  		return "redirect:/reviews";
  	}
}
