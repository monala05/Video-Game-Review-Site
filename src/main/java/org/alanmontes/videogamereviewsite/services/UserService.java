package org.alanmontes.videogamereviewsite.services;

import java.util.List;

import org.alanmontes.videogamereviewsite.models.User;
public interface UserService {
	
	public List<User> findAll();
	public User findUserById(int id);
	public User findUserByEmail(String email);
	public User save(User user);
	User findByUsername(String username);
}
