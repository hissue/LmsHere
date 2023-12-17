package com.homework.lms.lecture.service;

import java.util.List;

import com.homework.lms.lecture.model.Lecture;

public interface ILectureService {
	List<Lecture> getLecture();
	List<Lecture> getLecture(int majorId);
}
