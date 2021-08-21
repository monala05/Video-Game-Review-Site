package org.alanmontes.videogamereviewsite.models;

public class CompositeModelDto{
	private Game game;
	private Review review;
	
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	public Review getReview() {
		return review;
	}
	public void setReview(Review review) {
		this.review = review;
	}
	
	
}
