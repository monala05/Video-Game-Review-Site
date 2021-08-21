package org.alanmontes.videogamereviewsite.repositories;

import java.util.List;
import java.util.Optional;

import org.alanmontes.videogamereviewsite.models.Game;
import org.alanmontes.videogamereviewsite.models.User;
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
}
