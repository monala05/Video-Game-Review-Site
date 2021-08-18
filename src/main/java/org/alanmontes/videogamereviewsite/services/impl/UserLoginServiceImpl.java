package org.alanmontes.videogamereviewsite.services.impl;

import java.util.List;
import java.util.Optional;

import org.alanmontes.videogamereviewsite.models.UserLogin;
import org.alanmontes.videogamereviewsite.repositories.UserLoginRepository;
import org.alanmontes.videogamereviewsite.services.UserLoginService;
import org.springframework.stereotype.Service;

@Service
public class UserLoginServiceImpl implements UserLoginService{

	private UserLoginRepository ulr;
	
	public UserLoginServiceImpl(UserLoginRepository ulr) {
		this.ulr = ulr;
	}
	
	@Override
	public UserLogin findByUserPassword(String password) {
		
		return ulr.findByPassword(password);
	}

	@Override
	public UserLogin findByUserName(String userName) {
		return ulr.findByUserName(userName);
	}
	
	@Override
	public void save(UserLogin userLogin) {
		ulr.save(userLogin);
	}

	@Override
	public List<UserLogin> findAllUserLogins() {
		// TODO Auto-generated method stub
		return null;
	}

}
