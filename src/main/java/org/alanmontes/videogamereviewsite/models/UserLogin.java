package org.alanmontes.videogamereviewsite.models;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_login")
public class UserLogin {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int id;
	
	@Column(name = "username")
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	private String userRole;
	
	@OneToOne
	@JoinColumn(name = "user_id" )
	private User user;

	public UserLogin() {
		this.userRole = "ROLE_USER";
	}
	
	public UserLogin(String userName, String password) {
		this();
		this.password = password;
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserLogin [id=" + id + ", userName=" + userName + ", password=" + password + ", userRole=" + userRole
				+ ", user=" + user + "]";
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, password, user, userName, userRole);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserLogin other = (UserLogin) obj;
		return id == other.id && Objects.equals(password, other.password) && Objects.equals(user, other.user)
				&& Objects.equals(userName, other.userName) && Objects.equals(userRole, other.userRole);
	}
	

}
