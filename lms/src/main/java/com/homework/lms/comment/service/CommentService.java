package com.homework.lms.comment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homework.lms.comment.model.Comment;
import com.homework.lms.comment.repository.ICommentRepository;

@Service
public class CommentService implements ICommentService{
	@Autowired
	ICommentRepository commentRepository;

	@Override
	public List<Comment> getLectureIdComment(int lectureCommentId) {
		return commentRepository.getLectureIdComment(lectureCommentId);
	}

	@Override
	public Comment getComment(int commentId) {
		return commentRepository.getComment(commentId);
	}

	@Override
	public void insertComment(Comment comment) {
		commentRepository.insertComment(comment);
	}

	@Override
	public void updateComment(Comment comment) {
		commentRepository.updateComment(comment);
	}

	@Override
	public void deleteComment(int commentId, String studentId) {
		commentRepository.deleteComment(commentId, studentId);
	}
}
