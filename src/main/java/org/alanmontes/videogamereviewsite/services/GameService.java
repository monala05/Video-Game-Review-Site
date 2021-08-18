package org.alanmontes.videogamereviewsite.services;

import java.util.List;

import org.alanmontes.videogamereviewsite.models.Game;
import org.springframework.stereotype.Service;

@Service
public interface GameService {
	public Game findGameById(int game);
	public List<Game> findAllGames();
	public List<Game> findGamesBySystem(String system);
	public List<Game> findGamesByGenre(String genre);
}
