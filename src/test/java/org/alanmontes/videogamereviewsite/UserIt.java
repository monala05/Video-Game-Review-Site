package org.alanmontes.videogamereviewsite;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.alanmontes.videogamereviewsite.models.User;
import org.alanmontes.videogamereviewsite.services.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class UserIt {
	
	@Autowired
	private UserService userService;
	
	User user;
	User user2;
	int userID;
	int user2ID;	
	
	@BeforeEach
	public void setUp() throws Exception{
		user = new User("Patrick", "patrick@email.com", "pat", "pat", "xbox");
		userService.save(user);
		user2 = new User("Thiago", "thiago@email.com", "chiago", "thiago", "playstation");
		userService.save(user2);
		userID = user.getUserId();
	}
	
	@Test
	@Transactional
	void findByUsername() {
		User user3 = userService.findByUsername("pat");
		User user4 = userService.findUserById(userID);
		assertEquals(user3, user4);
	}
	
	@Test 
	@Transactional
	void findAll(){
		List<User> users = userService.findAll();
		assertTrue(users.contains(user));
	}
	
	
	@Test
	@Transactional
	void testUserSave() {
		User user4 = userService.findUserByEmail("patrick@email.com");
		assertEquals(user, user4);
	}
	
	@AfterEach
	public void tearDown() {
		userService.delete(user);
		userService.delete(user2);
	}

}
