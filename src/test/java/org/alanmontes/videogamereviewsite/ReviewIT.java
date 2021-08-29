package org.alanmontes.videogamereviewsite;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

import org.alanmontes.videogamereviewsite.models.Comment;
import org.alanmontes.videogamereviewsite.models.Game;
import org.alanmontes.videogamereviewsite.models.Review;
import org.alanmontes.videogamereviewsite.models.User;
import org.alanmontes.videogamereviewsite.services.CommentService;
import org.alanmontes.videogamereviewsite.services.GameService;
import org.alanmontes.videogamereviewsite.services.ReviewService;
import org.alanmontes.videogamereviewsite.services.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class ReviewIT {
	
	@Autowired
	ReviewService reviewService;
	@Autowired
	UserService userService;
	@Autowired
	GameService gameService;
	@Autowired
	CommentService commentService;
	
	User user;
	Review review;
	Game game;
	Comment comment;
	int reviewId;
	int gameId;
	
	Logger logger = LoggerFactory.getLogger(GameIT.class);
	
	@BeforeEach
	public void setUp() {
		user = new User();
		user.setUsername("test");
		user.setPassword("test");
		user.setName("test");
		
		review = new Review();
		review.setScore(80);
		review.setUser(user);
		reviewId = review.getReviewId();
		
		
		userService.save(user);
		reviewService.save(review);
	}
	
	//Custom query
	@Test
	@Transactional
	void testDeleteById() {
		reviewService.deleteReviewsByGameId(reviewId);
		Review test = reviewService.findByReviewId(reviewId);
		assertNull(test);
	}
	
	//Custom query
	@Test
	@Transactional
	void testFindAllReviewsWithUser() {
		List<Review> test = reviewService.findAllGamesWithReviewAndUserJoin();
		logger.info("testing");
		logger.info(test.get(0).toString());
		//This query sorts by review id. 
		Review retrieved = test.get(0);		
		assertEquals(34, test.get(0).getScore());
	}
	
	//Custom query
	@Test
	@Transactional
	void testFindByScore(){
		List<Review> tests = reviewService.findByScore(80); 
		assertTrue(tests.get(0).getScore() == 80);
	}
	
	//Custom query
	@Test
	@Transactional
	void testFindReviewsByUser() {
		//My database has a user with id = 7
		List<Review> test = reviewService.findAllGamesReviewAndGameJoinWhereUser(7);
		assertEquals(9, test.get(0).getReviewId());
	}
	
	@AfterEach
	public void tearDown() {
		reviewService.deleteReviewsByGameId(reviewId);
		userService.delete(user);
	}
}
