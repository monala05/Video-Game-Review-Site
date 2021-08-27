package org.alanmontes.videogamereviewsite.repositories;

import java.util.List;

import org.alanmontes.videogamereviewsite.models.Game;
import org.alanmontes.videogamereviewsite.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReviewRepository extends JpaRepository<Review, Integer>{
	Review findById(int id);
	List<Review> findAll();
	List<Review> findByScore(int score);
	@Modifying
	@Query(value = "DELETE FROM review\r\n"
			+ "WHERE review.game_id =:gameId", nativeQuery = true)
	void deleteByGameIds(@Param("gameId") int gameId);	
	
	@Query(value = "SELECT * FROM review\r\n"
			+ "JOIN user \r\n"
			+ "ON review.user_id = user.user_id\r\n"
			+ "JOIN game\r\n"
			+ "ON review.game_id = game.game_id\r\n"
			+ "ORDER BY review.review_id DESC", nativeQuery = true)
	List<Review> findAllWithGameAndUserJoin();
}
