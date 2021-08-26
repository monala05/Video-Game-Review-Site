package org.alanmontes.videogamereviewsite.services.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.alanmontes.videogamereviewsite.models.Comment;
import org.alanmontes.videogamereviewsite.repositories.CommentRepository;
import org.alanmontes.videogamereviewsite.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
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
	public List<Comment> findByCommentLocalDateTime(LocalDateTime createDateTime) {
		return commentRepository.findByCreateDateTime(createDateTime);
	}

	@Override
	public void save(Comment comment) {
		commentRepository.save(comment);
	}

	@Override
	public List<Comment> findByBoardOrderByCreateDateTime(String board) {
		return commentRepository.findByBoardOrderByCreateDateTimeDesc(board);
	}

	@Override
	public List<Comment> findCommentsByBoardJoinUser(String board) {
		return commentRepository.findByBoardJoinUser(board);
	}

	
	
}
