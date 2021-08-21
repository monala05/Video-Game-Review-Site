package org.alanmontes.videogamereviewsite.services.impl;

import java.util.List;
import java.util.Optional;

import org.alanmontes.videogamereviewsite.models.User;
import org.alanmontes.videogamereviewsite.repositories.UserRepository;
import org.alanmontes.videogamereviewsite.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

	private UserRepository userRepository;
	private PasswordEncoder pswdEncoder;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository, PasswordEncoder pswdEncoder) {
		this.userRepository = userRepository;
		this.pswdEncoder = pswdEncoder;
	}
	
	@Override
	public User findUserById(int id) {
		Optional<User> optUser = userRepository.findById(id);
		if (optUser.isPresent()) {
			return optUser.get();
		}
		return null;
	}
	
	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	@Override
	public User save(User user) {
		user.setPassword(pswdEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
}