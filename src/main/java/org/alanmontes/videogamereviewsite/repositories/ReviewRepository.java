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
	
	@Query(value = "SELECT ROUND(AVG(r.score), 1) AS average_score, r.review_id, r.create_date_time, r.review_text, r.score,r.update_date_time,r.game_id,r.user_id,\r\n"
			+ "u.user_id,u.email,u.name,u.password,u.user_role,u.username,u.system,\r\n"
			+ "g.game_id,g.cover,g.game_name,g.genre,g.metacritic_score,g.summary,g.system  \r\n"
			+ "FROM review AS r\r\n"
			+ "JOIN user AS u\r\n"
			+ "ON u.user_id = r.user_id\r\n"
			+ "JOIN game AS g\r\n"
			+ "ON g.game_id = r.game_id\r\n"
			+ "GROUP BY g.game_id\r\n"
			+ "ORDER BY average_score DESC;", nativeQuery = true)
	List<Review> findbyAvgUserScore();
	
	@Query(value = "SELECT * FROM review\r\n"
			+ "JOIN user ON review.user_id = user.user_id\r\n"
			+ "JOIN game ON game.game_id = review.game_id\r\n"
			+ "WHERE review.user_id = :userId\r\n"
			+ "ORDER BY review.create_date_time DESC;", nativeQuery = true)
	List<Review> findAllReviewAndGameJoinWhereUser(@Param("userId") int userId);
}
