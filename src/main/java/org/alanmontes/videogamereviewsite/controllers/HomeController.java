package org.alanmontes.videogamereviewsite.controllers;

import javax.validation.Valid;

import org.alanmontes.videogamereviewsite.models.CompositeModelDto;
import org.alanmontes.videogamereviewsite.models.Game;
import org.alanmontes.videogamereviewsite.models.Review;
import org.alanmontes.videogamereviewsite.models.User;
import org.alanmontes.videogamereviewsite.security.CurrentUser;
import org.alanmontes.videogamereviewsite.services.GameService;
import org.alanmontes.videogamereviewsite.services.ReviewService;
import org.alanmontes.videogamereviewsite.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
	
	ReviewService reviewService;
	UserService userService;
	GameService gameService;
	
	@Autowired
	public HomeController(ReviewService reviewService, UserService userService, 
			GameService gameService) {	
		this.reviewService = reviewService;
		this.userService = userService;
		this.gameService = gameService;
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
	
	@GetMapping("/search")
	public String showSearchPage() {
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
	
//	@GetMapping()
//	public String getUserDetails(Model model) {
//		CurrentUser currentUser = (CurrentUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		User user = currentUser.getUser();
//		model.addAttribute(user);
//		return "profile";
//	}
	
  	@PostMapping("/registerNewUser")
	public String registerNewUser(@Valid @ModelAttribute("newUser") User newUser, 
			BindingResult result) {
		if (result.hasErrors()) {
			return "register";
		}
		User user = userService.save(newUser);
		return "redirect:/login";
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
		Review review = reviewService.save(compositeModelDto.getReview());
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
