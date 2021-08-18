package org.alanmontes.videogamereviewsite.services.impl;

import org.alanmontes.videogamereviewsite.models.UserLogin;
import org.alanmontes.videogamereviewsite.repositories.UserLoginRepository;
import org.alanmontes.videogamereviewsite.security.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
/*
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
*/
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl {//implements UserDetailsService {
	
	UserLoginRepository userLoginRepository;
	
	@Autowired
	public UserDetailsServiceImpl(UserLoginRepository userLoginRepository) {
		this.userLoginRepository = userLoginRepository;
	}
	
	/*
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserLogin userLogin = userLoginRepository.findByUserName(username);
		if (userLogin == null) {
			throw new UsernameNotFoundException("User not found.");
		}
		return new CurrentUser(userLogin);

	}
	*/
 

}
