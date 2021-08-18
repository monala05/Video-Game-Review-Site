package org.alanmontes.videogamereviewsite.repositories;

import java.util.List;

import org.alanmontes.videogamereviewsite.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Integer>{
	Game findById(int game);
	List<Game> findAll();
	List<Game> findBySystem(String system);
	List<Game> findByGenre(String genre);
}
