package org.alanmontes.videogamereviewsite.models;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "comment")
public class Comment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "comment_id")
	private int commentId;
	
	@Column(name = "topic")
	private String topic;
	
	@Lob
	@Column(name = "comment_text")
	private String commentText;

	@Column(name = "board")
	private String board;
	
	@Column(name = "create_date_time")
	@CreationTimestamp
	private LocalDateTime createDateTime;
		
	@Column(name = "update_date")
	@UpdateTimestamp
	private LocalDateTime updateDateTime;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public String getBoard() {
		return board;
	}

	public void setBoard(String board) {
		this.board = board;
	}

	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}

	public LocalDateTime getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(LocalDateTime updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(board, commentId, commentText, createDateTime, topic, updateDateTime);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		return Objects.equals(board, other.board) && commentId == other.commentId
				&& Objects.equals(commentText, other.commentText)
				&& Objects.equals(createDateTime, other.createDateTime) && Objects.equals(topic, other.topic)
				&& Objects.equals(updateDateTime, other.updateDateTime);
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", topic=" + topic + ", commentText=" + commentText + ", board="
				+ board + ", createDateTime=" + createDateTime + ", updateDateTime=" + updateDateTime + ", user=" + user
				+ "]";
	}
	
	
	
}
