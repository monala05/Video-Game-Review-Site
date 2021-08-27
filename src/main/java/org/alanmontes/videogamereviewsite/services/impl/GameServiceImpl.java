package org.alanmontes.videogamereviewsite.services.impl;

import java.util.List;

import org.alanmontes.videogamereviewsite.models.Game;
import org.alanmontes.videogamereviewsite.repositories.GameRepository;
import org.alanmontes.videogamereviewsite.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService{
	
	GameRepository gameRepository;
	
	@Autowired
	public GameServiceImpl(GameRepository gameRepository) {
		this.gameRepository = gameRepository;
	}
	
	@Override
	public Game findGameById(int game) {
		return gameRepository.findById(game);
	}

	@Override
	public List<Game> findAllGames() {
		return gameRepository.findAll();
	}

	@Override
	public List<Game> findGamesBySystem(String system) {
		return gameRepository.findBySystem(system);
	}

	@Override
	public List<Game> findGamesByGenre(String genre) {
		return gameRepository.findByGenre(genre);
	}

	@Override
	public Game save(Game game) {
		return gameRepository.save(game);
	}

	@Override
	public List<Game> findAllGamesReviewAndGameJoinWhereUser(int userId) {
		return gameRepository.findAllReviewAndGameJoinWhereUser(userId);
	}

	@Override
	public List<Game> findAllGamesBySearch(String keyword) {
		return gameRepository.search(keyword);
	}

	@Override
	public List<Game> topGamesByCritic() {
		return gameRepository.topGamesByCritic();
	}

	@Override
	public void deleteGameById(int gameId) {
		gameRepository.deleteById(gameId);
		
	}


}
