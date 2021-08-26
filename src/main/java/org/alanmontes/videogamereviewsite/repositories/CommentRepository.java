package org.alanmontes.videogamereviewsite.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.alanmontes.videogamereviewsite.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CommentRepository extends JpaRepository<Comment, Integer>{
	Comment findById(int id);
	List<Comment> findAll();
	List<Comment> findByCreateDateTime(LocalDateTime createDateTime);
	List<Comment> findByBoardOrderByCreateDateTimeDesc(String board);
	
	@Query(value = "SELECT * FROM comment\r\n"
			+ "JOIN user \r\n"
			+ "ON comment.user_id = user.user_id\r\n"
			+ "WHERE \r\n"
			+ "comment.board =:board\r\n"
			+ "ORDER BY create_date_time DESC", nativeQuery = true)
	List<Comment> findByBoardJoinUser(@Param("board") String board);
}
