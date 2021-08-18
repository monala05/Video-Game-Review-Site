package org.alanmontes.videogamereviewsite.services.impl;

import java.util.List;

import org.alanmontes.videogamereviewsite.models.Review;
import org.alanmontes.videogamereviewsite.repositories.ReviewRepository;
import org.alanmontes.videogamereviewsite.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService{
	
	ReviewRepository reviewRepository;
	
	@Autowired
	public ReviewServiceImpl(ReviewRepository reviewRepository) {
		this.reviewRepository = reviewRepository;
	}
	
	@Override
	public Review findByReviewId(int id) {
		return reviewRepository.findById(id);
	}

	@Override
	public List<Review> findAll() {
		return reviewRepository.findAll();
	}

	@Override
	public List<Review> findByScore(int score) {
		return reviewRepository.findByScore(score);
	}

	@Override
	public Review save(Review review) {
		return reviewRepository.save(review);
	}

}
