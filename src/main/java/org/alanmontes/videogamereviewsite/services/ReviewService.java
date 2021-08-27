package org.alanmontes.videogamereviewsite.services;

import java.util.List;

import org.alanmontes.videogamereviewsite.models.Review;

public interface ReviewService {
	public Review findByReviewId(int id);
	public List<Review> findAll();
	public List<Review> findByScore(int score);
	public Review save(Review review);
	public List<Review> findAllGamesWithReviewAndUserJoin();
	public void deleteReviewsByGameId(int gameId);
	public List<Review> findAllGamesReviewAndGameJoinWhereUser(int id);
	public List<Review> findReviewByAverageUserScore();
}
