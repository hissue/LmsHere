package com.homework.lms.course.service;

import java.util.List;

import com.homework.lms.course.model.Course;

public interface ICourseService {
	List<Course> getCourse(String studentId);
	void insertCourse(Course course);
	int deleteCourse(String studentId, int courseId);
}
