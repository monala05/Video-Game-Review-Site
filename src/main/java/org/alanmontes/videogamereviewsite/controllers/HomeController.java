package org.alanmontes.videogamereviewsite.controllers;

import javax.validation.Valid;

import org.alanmontes.videogamereviewsite.models.Review;
import org.alanmontes.videogamereviewsite.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
	
	ReviewService reviewService;
	
	@Autowired
	public HomeController(ReviewService reviewService) {
		this.reviewService = reviewService;
	}
	
	@GetMapping("/")
	public String showHomePage() {
		return "index";
	}
	
	@GetMapping("/reviews")
	public String showReviewsPage(Model model) {
		model.addAttribute("newReview", new Review());
		return "reviews";
	}
	
	@GetMapping("/profile")
	public String showProfilesPage() {
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
	public String showRegistrationPage() {
		return "register";
	}
	
  	@PostMapping("/registerNewReview")
	public String registerNewReview(@Valid @ModelAttribute("newReview") Review newReview, 
			BindingResult result) {
		if (result.hasErrors()) {
			return "reviews";
		}
		Review review = reviewService.save(newReview);
		System.out.println(review.getReviewId());
		return "redirect:/profile";
	}
}
