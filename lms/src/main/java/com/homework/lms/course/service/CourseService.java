package com.homework.lms.course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homework.lms.course.model.Course;
import com.homework.lms.course.repository.ICourseRepository;

@Service
public class CourseService implements ICourseService{

	@Autowired
	ICourseRepository courseRepository;
	
	@Override
	public List<Course> getCourse(String studentId) {
		return courseRepository.getCourse(studentId);
	}

	@Override
	public void insertCourse(Course course) {
		courseRepository.insertCourse(course);
	}

	@Override
	public int deleteCourse(String studentId, int courseId) {
		return courseRepository.deleteCourse(studentId, courseId);
	}

}
