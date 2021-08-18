package org.alanmontes.videogamereviewsite.models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "game")
public class Game {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "game_id")
	private int gameId;
	
	@Column(name = "game_name")
	private String gameName;
	
	@Column(name = "system")
	private String system;
	
	@Column(name = "genre")
	private String genre;
	
	@OneToMany(mappedBy = "game")
	private Set<Review> reviews = new HashSet<>();
	
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "favorite_game",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> users;
    
	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Set<Review> getReviews() {
		return reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}

	@Override
	public int hashCode() {
		return Objects.hash(gameId, gameName, genre, reviews, system);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		return gameId == other.gameId && Objects.equals(gameName, other.gameName) && Objects.equals(genre, other.genre)
				&& Objects.equals(reviews, other.reviews) && Objects.equals(system, other.system);
	}

	@Override
	public String toString() {
		return "Game [gameId=" + gameId + ", gameName=" + gameName + ", system=" + system + ", genre=" + genre
				+ ", reviews=" + reviews + "]";
	}
	
	
}
