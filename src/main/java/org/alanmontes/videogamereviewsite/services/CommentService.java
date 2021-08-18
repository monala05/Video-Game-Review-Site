package org.alanmontes.videogamereviewsite.services;

import java.sql.Date;
import java.util.List;

import org.alanmontes.videogamereviewsite.models.Comment;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {
	Comment findByCommentId(int id);
	List<Comment> findAll();
	List<Comment> findByCommentDate(Date date);
}
