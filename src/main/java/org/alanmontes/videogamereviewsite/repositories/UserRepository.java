package org.alanmontes.videogamereviewsite.repositories;

import java.util.List;
import java.util.Optional;

import org.alanmontes.videogamereviewsite.models.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Integer> {
	
	User findByEmail(String email);
	List<User> findAll();
	User findByUsername(String username);
}
