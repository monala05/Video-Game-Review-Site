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
	@Query(value = "SELECT * FROM review \r\n"
			+ "INNER JOIN game \r\n"
			+ "ON game.game_id = review.review_id\r\n"
			+ "INNER JOIN user \r\n"
			+ "ON user.user_id = review.user_id\r\n"
			+ "ORDER BY create_date_time DESC", nativeQuery = true)
	List<Review> findAllWithGameAndUserJoin();
}
