package org.alanmontes.videogamereviewsite.repositories;

import java.util.List;
import org.alanmontes.videogamereviewsite.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GameRepository extends JpaRepository<Game, Integer>{
	Game findById(int game);
	List<Game> findAll();
	List<Game> findBySystem(String system);
	List<Game> findByGenre(String genre);
	@Query(value = "SELECT * FROM game \r\n"
			+ "JOIN review \r\n"
			+ "ON game.game_id = review.game_id\r\n"
			+ "WHERE user_id = :userId", nativeQuery = true)
	List<Game> findAllReviewAndGameJoinWhereUser(@Param("userId") int userId);
	
	@Query(value = "SELECT * FROM game AS g\r\n"
			+ "JOIN review r\r\n"
			+ "ON r.game_id = g.game_id\r\n"
			+ "JOIN user u\r\n"
			+ "ON u.user_id = r.user_id\r\n"
			+ "WHERE g.game_name = :keyword \r\n"
			+ "OR g.genre = :keyword \r\n"
			+ "OR g.system = :keyword \r\n"
			+ "OR r.score = :keyword \r\n"
			+ "OR u.username = :keyword \r\n"
			+ "ORDER BY r.create_date_time DESC", nativeQuery = true)
	List<Game> search(@Param("keyword") String keyword);
	
	@Query(value ="SELECT * FROM game\r\n"
			+ "ORDER BY metacritic_score DESC\r\n"
			+ "LIMIT 5", nativeQuery = true)
	List<Game> topGamesByCritic();
	
}
