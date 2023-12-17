package com.homework.lms.comment.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.homework.lms.comment.model.Comment;

@Repository
@Mapper
public interface ICommentRepository {
	List<Comment> getLectureIdComment(int lectureCommentId);
	Comment getComment(int commentId);
	void insertComment(Comment comment);
	void updateComment(Comment comment);
	void deleteComment(@Param("commentId") int commentId, @Param("studentId") String studentId);
	
}
