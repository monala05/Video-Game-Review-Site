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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "game")
public class Game {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "game_id")
	private int gameId;
	
	@Size(min=1, max=25, message="Title must be between 1 and 100 characters.")
	@NotNull
	@Column(name = "game_name")
	private String gameName;
	
	@Column(name = "system")
	private String system;
	
	@Column(name = "genre")
	private String genre;
	
	@Lob
	@Column(name = "summary")
	private String summary;
	
	@Column(name = "cover")
	private String cover;
	
	@Min(value=1, message="must be equal or greater than 1")  
    @Max(value=100, message="must be equal or less than 100")  
	@Column(name = "metacritic_score")
	private int metacriticScore;
	
	@OneToMany(mappedBy = "game")
	private Set<Review> reviews = new HashSet<>();
	
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "favorite_game",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> users;
    
    public Game() {}
    

	public Game(String gameName, String system, String genre, String summary, String cover,
			int metacriticScore) {
		this.gameName = gameName;
		this.system = system;
		this.genre = genre;
		this.summary = summary;
		this.cover = cover;
		this.metacriticScore = metacriticScore;
	}



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



	public String getSummary() {
		return summary;
	}



	public void setSummary(String summary) {
		this.summary = summary;
	}



	public String getCover() {
		return cover;
	}



	public void setCover(String cover) {
		this.cover = "images/" + cover;
	}



	public int getMetacriticScore() {
		return metacriticScore;
	}



	public void setMetacriticScore(int metacriticScore) {
		this.metacriticScore = metacriticScore;
	}



	public Set<Review> getReviews() {
		return reviews;
	}



	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}



	public Set<User> getUsers() {
		return users;
	}



	public void setUsers(Set<User> users) {
		this.users = users;
	}



	@Override
	public int hashCode() {
		return Objects.hash(cover, gameId, gameName, genre, metacriticScore, summary, system);
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
		return Objects.equals(cover, other.cover) && gameId == other.gameId && Objects.equals(gameName, other.gameName)
				&& Objects.equals(genre, other.genre) && metacriticScore == other.metacriticScore
				&& Objects.equals(summary, other.summary) && Objects.equals(system, other.system);
	}



	@Override
	public String toString() {
		return "Game [gameId=" + gameId + ", gameName=" + gameName + ", system=" + system + ", genre=" + genre
				+ ", summary=" + summary + ", cover=" + cover + ", reviews=" + reviews + ", users=" + users + "]";
	}
	
    
}
