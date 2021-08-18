package org.alanmontes.videogamereviewsite.repositories;

import java.util.List;
import org.alanmontes.videogamereviewsite.models.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoginRepository extends JpaRepository<UserLogin, Integer>{
	
	UserLogin findByPassword(String password);
	UserLogin findByUserName(String userName);
	List<UserLogin> findAll();
}
