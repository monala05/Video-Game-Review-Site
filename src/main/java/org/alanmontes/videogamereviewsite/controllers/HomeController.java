package org.alanmontes.videogamereviewsite.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.validation.Valid;

import org.alanmontes.videogamereviewsite.models.Comment;
import org.alanmontes.videogamereviewsite.models.CompositeModelDto;
import org.alanmontes.videogamereviewsite.models.Game;
import org.alanmontes.videogamereviewsite.models.Review;
import org.alanmontes.videogamereviewsite.models.User;
import org.alanmontes.videogamereviewsite.repositories.GameRepository;
import org.alanmontes.videogamereviewsite.security.CurrentUser;
import org.alanmontes.videogamereviewsite.services.CommentService;
import org.alanmontes.videogamereviewsite.services.GameService;
import org.alanmontes.videogamereviewsite.services.ReviewService;
import org.alanmontes.videogamereviewsite.services.UserService;
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
	
	@Autowired
	public HomeController(ReviewService reviewService, UserService userService, 
			GameService gameService, CommentService commentService) {	
		this.reviewService = reviewService;
		this.userService = userService;
		this.gameService = gameService;
		this.commentService = commentService;
	}
	
	@GetMapping("/")
	public String showHomePage() {
		return "index";
	}
	
	@GetMapping("/reviews")
	public String showReviewsPage(Model model) {
		model.addAttribute("newComposite", new CompositeModelDto());
		model.addAttribute("allReviews", reviewService.findAllGamesWithReviewAndUserJoin());
		return "reviews";
	}
	
	@GetMapping("/profile")
	public String showProfilesPage(Model model) {
		CurrentUser currentUser = (CurrentUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = currentUser.getUser();
		model.addAttribute(user);
		model.addAttribute("userReviews", gameService.findAllGamesReviewAndGameJoinWhereUser(user.getUserId()));
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
		
		logger.info("hello");
		logger.info(keyword);
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
	
  	@PostMapping("/registerNewUser")
	public String registerNewUser(@Valid @ModelAttribute("newUser") User newUser, 
			BindingResult result) {
		if (result.hasErrors()) {
			return "register";
		}
		userService.save(newUser);
		return "redirect:/login";
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
		CurrentUser currentUser = (CurrentUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = currentUser.getUser();
		comment.setBoard("PC");
		comment.setUser(user);
		
		commentService.save(comment);
		return "redirect:/pcLobby";
  	}
  	
  	@PostMapping("/registerNewReview")
	public String registerNewReview(@Valid @ModelAttribute("newComposite") 
		CompositeModelDto compositeModelDto, BindingResult result) {
		if (result.hasErrors()) {
			return "reviews";
		}
		
		//Get models to persist
		CurrentUser currentUser = (CurrentUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = currentUser.getUser();
		Game game = gameService.save(compositeModelDto.getGame());
		
		//Set foreign key models to bind review oject
		compositeModelDto.getReview().setGame(game);
		compositeModelDto.getReview().setUser(user);
		
		//Persist review with foreign key sets
		reviewService.save(compositeModelDto.getReview());
		return "redirect:/reviews";
	}
  	
  	@PostMapping()
  	public String registerNewGame(@Valid @ModelAttribute("newGame") Game newGame,
  			BindingResult result) {
  			if(result.hasErrors()) {
  				return "reviews";
  			}
  			Game game = gameService.save(newGame);
 
  		return "redirect:/reviews";
  	}
}
