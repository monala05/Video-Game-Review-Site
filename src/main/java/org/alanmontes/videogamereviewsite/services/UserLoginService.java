package org.alanmontes.videogamereviewsite.services;

import java.util.List;
import java.util.Optional;

import org.alanmontes.videogamereviewsite.models.UserLogin;

public interface UserLoginService {
	public UserLogin findByUserPassword(String password);
	public UserLogin findByUserName(String userName);
	public List<UserLogin> findAllUserLogins();
	public void save(UserLogin userLogin);
}
