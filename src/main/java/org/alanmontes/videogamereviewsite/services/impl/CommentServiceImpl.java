package org.alanmontes.videogamereviewsite.services.impl;

import java.sql.Date;
import java.util.List;

import org.alanmontes.videogamereviewsite.models.Comment;
import org.alanmontes.videogamereviewsite.repositories.CommentRepository;
import org.alanmontes.videogamereviewsite.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;

public class CommentServiceImpl implements CommentService{
	CommentRepository commentRepository;
	
	@Autowired
	public CommentServiceImpl(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}
	
	@Override
	public Comment findByCommentId(int id) {
		return commentRepository.findById(id);
	}

	@Override
	public List<Comment> findAll() {
		return commentRepository.findAll();
	}

	@Override
	public List<Comment> findByCommentDate(Date date) {
		return commentRepository.findByDate(date);
	}

}
