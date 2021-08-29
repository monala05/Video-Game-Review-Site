package org.alanmontes.videogamereviewsite;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.alanmontes.videogamereviewsite.models.Comment;
import org.alanmontes.videogamereviewsite.models.User;
import org.alanmontes.videogamereviewsite.services.CommentService;
import org.alanmontes.videogamereviewsite.services.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class CommentIT {
	
	@Autowired
	CommentService commentService;
	@Autowired
	UserService userService;
	Comment test;
	Comment test2;
	Comment test3;
	Comment test4;
	User user;
	
	@BeforeEach
	public void setUp(){
		test = new Comment();
		test2 = new Comment();
		test3 = new Comment();
		test4 = new Comment();
		user = new User();
		
		user.setName("test");
		user.setUsername("test");
		user.setPassword("test");
		
		test.setBoard("test");
		test2.setBoard("PC");
		test3.setBoard("test3");
		test4.setBoard("test4");
		test.setUser(user);
		
		userService.save(user);
		commentService.save(test);
		commentService.save(test2);
		commentService.save(test3);
		commentService.save(test4);
	}
	
	@ParameterizedTest
	@Transactional
	@ValueSource(strings = {"PC", "test", "test3", "test4"})
	void testFindByBoard(String strings) {
		List<Comment> comments = commentService.findByBoardOrderByCreateDateTime(strings);
		
		assertEquals(strings, comments.get(0).getBoard());
	}
	
	@Test
	@Transactional
	void testFindByBoardWithUser() {
		List<Comment> comments = commentService.findCommentsByBoardJoinUser("test");
		Comment test = comments.get(0);
		
		assertEquals("test", test.getBoard());
	}
	
	@AfterEach
	public void tearDown() {

		commentService.remove(test);
		commentService.remove(test2);
		commentService.remove(test3);
		commentService.remove(test4);
		userService.delete(user);
	}
	

}
