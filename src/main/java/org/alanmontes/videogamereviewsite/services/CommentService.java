package org.alanmontes.videogamereviewsite.services;

import java.time.LocalDateTime;
import java.util.List;

import org.alanmontes.videogamereviewsite.models.Comment;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {
	Comment findByCommentId(int id);
	List<Comment> findAll();
	List<Comment> findByCommentLocalDateTime(LocalDateTime createDateTime);
	List<Comment> findByBoardOrderByCreateDateTime(String board);
	List<Comment> findCommentsByBoardJoinUser(String board);
	void save(Comment comment);
}
