package org.alanmontes.videogamereviewsite.services;

import java.util.List;

import org.alanmontes.videogamereviewsite.models.Game;
import org.alanmontes.videogamereviewsite.models.User;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public interface GameService {
	public Game findGameById(int game);
	public List<Game> findAllGames();
	public List<Game> findGamesBySystem(String system);
	public List<Game> findGamesByGenre(String genre);
	public Game save(Game game);
	public void deleteGameById(int gameId);
	public List<Game> findAllGamesReviewAndGameJoinWhereUser(@Param("userId") int userId);
	public List<Game> findAllGamesBySearch(@Param("keyword") String keyword);
	public List<Game> topGamesByCritic();
}
