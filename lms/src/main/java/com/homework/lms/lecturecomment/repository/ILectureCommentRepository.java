package com.homework.lms.lecturecomment.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.homework.lms.lecturecomment.model.LectureComment;

@Repository
@Mapper
public interface ILectureCommentRepository {
	List<LectureComment> getLectureComment();
	List<LectureComment> getLectureComment(int lectureId);
	LectureComment getLectureCommentIdLectureComment(int lectureCommentId);
	void insertLectureComment(LectureComment lectureComment);
	void updateLectureComment(LectureComment lectureComment);
	void deleteLectureComment(@Param("lectureCommentId") int lectureCommentId, @Param("studentId") String studentId);
}
