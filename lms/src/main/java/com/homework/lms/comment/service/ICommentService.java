package com.homework.lms.comment.service;

import java.util.List;

import com.homework.lms.comment.model.Comment;

public interface ICommentService {
	List<Comment> getLectureIdComment(int lectureCommentId);
	Comment getComment(int commentId);
	void insertComment(Comment comment);
	void updateComment(Comment comment);
	void deleteComment(int commentId, String studentId);
}
