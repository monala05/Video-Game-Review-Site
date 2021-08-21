package org.alanmontes.videogamereviewsite.repositories;

import java.util.List;

import org.alanmontes.videogamereviewsite.models.Game;
import org.alanmontes.videogamereviewsite.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReviewRepository extends JpaRepository<Review, Integer>{
	Review findById(int id);
	List<Review> findAll();
	List<Review> findByScore(int score);
	@Query(value = "SELECT review.review_id, user.user_id, user.name, "
			+ "game.game_id, game.game_name, game.genre, game.system ,"
			+ "review.score, review.review_text\r\n"
			+ "FROM review \r\n"
			+ "Inner JOIN game \r\n"
			+ "ON game.game_id = review.game_id\r\n"
			+ "INNER JOIN user\r\n"
			+ "ON user.user_id = review.user_id", nativeQuery = true)
	List<Review> findAllWithGameAndUserJoin();
}
