package org.alanmontes.videogamereviewsite.repositories;

import java.sql.Date;
import java.util.List;

import org.alanmontes.videogamereviewsite.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer>{
	Comment findById(int id);
	List<Comment> findAll();
	List<Comment> findByDate(Date date);
	
}
