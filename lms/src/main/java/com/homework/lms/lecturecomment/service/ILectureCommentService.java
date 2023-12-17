package com.homework.lms.lecturecomment.service;

import java.util.List;

import com.homework.lms.lecturecomment.model.LectureComment;

public interface ILectureCommentService {
	List<LectureComment> getLectureComment();
	List<LectureComment> getLectureComment(int lectureId);
	LectureComment getLectureCommentIdLectureComment(int lectureCommentId);
	void insertLectureComment(LectureComment lectureComment);
	void updateLectureComment(LectureComment lectureComment);
	void deleteLectureComment(int lectureCommentId, String studentId);
}
