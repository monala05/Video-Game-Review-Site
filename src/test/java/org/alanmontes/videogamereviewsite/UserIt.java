package org.alanmontes.videogamereviewsite;

import static org.junit.jupiter.api.Assertions.*;

import org.alanmontes.videogamereviewsite.models.User;
import org.alanmontes.videogamereviewsite.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserIt {
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	void testUserSave() {
		User user1 = new User("Alan", "alan@email.com", "username");
		userRepository.save(user1);
		User user2 = new User("Patrick", "patric@email.com", "pat");
		userRepository.save(user2);
		User user3 = new User("Thiago", "thiago@email.com", "chiago");
		userRepository.save(user3);
		
		
		User user4 = userRepository.findByEmail("alan@email.com");
		assertEquals(user1, user4);
	}

}
