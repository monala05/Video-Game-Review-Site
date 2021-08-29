package org.alanmontes.videogamereviewsite.models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="user")
public class User{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;
	
	@NotNull
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Size(min=2, max=25, message="Username must be between 2 and 25 characters.")
	@NotNull
	@Column(name = "username", unique = true)
	private String username;
	
	@Size(min=2, max=100, message="Password must be between 2 and 50 characters.")
	@NotNull
	@Column(name = "password")
	private String password;
	
	private String system;
	
	private String userRole;
	
	@OneToMany(mappedBy = "user")
	private Set<Review> review = new HashSet<>();
	
	@OneToMany(mappedBy = "user")
	private Set<Comment> comment = new HashSet<>();
	
	@ManyToMany(mappedBy = "users")
	private Set<Game> games = new HashSet<>();
	
	public User() {
		this.userRole = "ROLE_USER";
	}
	
	
	public User(String name, String email, String username, String password, String system) {
		super();
		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
		this.system = system;
	}


	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserRole() {
		return userRole;
	}


	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}


	public Set<Review> getReview() {
		return review;
	}

	public void setReview(Set<Review> review) {
		this.review = review;
	}

	public Set<Comment> getComment() {
		return comment;
	}

	public void setComment(Set<Comment> comment) {
		this.comment = comment;
	}

	public String getSystem() {
		return system;
	}


	public void setSystem(String system) {
		this.system = system;
	}


	public Set<Game> getGames() {
		return games;
	}

	public void setGames(Set<Game> games) {
		this.games = games;
	}

	@Override
	public int hashCode() {
		return Objects.hash(comment, email, name, password, system, userId, userRole, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(comment, other.comment) && Objects.equals(email, other.email)
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password)
				&& Objects.equals(system, other.system) && userId == other.userId
				&& Objects.equals(userRole, other.userRole) && Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", username=" + username
				+ ", password=" + password + ", system=" + system + ", userRole=" + userRole + ", review=" + review
				+ ", comment=" + comment + ", games=" + games + "]";
	}

	
}
