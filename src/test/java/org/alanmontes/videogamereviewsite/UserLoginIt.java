package org.alanmontes.videogamereviewsite;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.alanmontes.videogamereviewsite.models.UserLogin;
import org.alanmontes.videogamereviewsite.repositories.UserLoginRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserLoginIt {

	@Autowired
	UserLoginRepository ulr;
		
	@Test
	void testUserLoginSave() {
		UserLogin user = new UserLogin("root", "root");
		ulr.save(user);
		UserLogin user2 = new UserLogin("patricks", "patricks");
		ulr.save(user2);
		UserLogin user3 = new UserLogin("brazil", "brazil");
		ulr.save(user3);
		
		Optional<UserLogin> user4 = ulr.findById(1);
		
		assertEquals(user, user4);
	}
}
