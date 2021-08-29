package org.alanmontes.videogamereviewsite;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.alanmontes.videogamereviewsite.models.Game;
import org.alanmontes.videogamereviewsite.services.GameService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
class GameIT {
	
	@Autowired
	private GameService gameService;
	Game game;
	Game game2;
	
	Logger logger = LoggerFactory.getLogger(GameIT.class);
	
	@BeforeEach
	public void setUp() throws Exception{
		game = new Game();
		game.setGameName("test");
		game.setMetacriticScore(98);;
		game.setSystem("xbox");
		
		game2 = new Game();
		game2.setGameName("test2");
		game2.setMetacriticScore(90);
		game2.setSystem("playstation");
		
		gameService.save(game);
		gameService.save(game2);
	}
	
	@Test
	void testFindBySystem() {
		List<Game> test = gameService.findGamesBySystem("xbox");
		assertTrue(test.contains(game));
	}
	
	
	/*
	 * Custom query test
	 */
	@Test 
	@Transactional
	void testSearch() {
		//Game objects gameName field is set to test, search finds by
		//name, system, score, username, or genre
		//My database includes a game named Hades with gameId = 2
		//Search has to be connected to a review and a user to work
		//If you want to test, you would have to either upload a game through 
		//the website as admin, or creat a review game and user connected via foreign key
		List<Game> test = gameService.findAllGamesBySearch("Hades");
		Game hades = gameService.findGameById(2);
		
		for(Game game: test) {
			logger.info(test.toString());
		}
		
		assertTrue(test.contains(hades));
	}
	
	
	/*
	 * Custom query test
	 */
	@Test
	@Transactional
	void testTop5Games() {
		List<Game> test =gameService.topGamesByCritic();
		
		logger.info(" "+test.size());
		Game testGame1 = test.get(0);
		Game testGame2 = test.get(test.size() - 1);
		/*test if returned list is no more than 5 items
		 * and test if the top score is greater than or equal to bottom score
		 */
		assertTrue(test.size() <= 5 && 
				testGame1.getMetacriticScore() >= testGame2.getMetacriticScore());
		
	}
	

	@AfterEach
	public void tearDown(){
		gameService.deleteGameById(game.getGameId());
		gameService.deleteGameById(game2.getGameId());
	}
}
