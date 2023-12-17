package com.homework.lms.course.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.homework.lms.course.model.Course;

@Repository
@Mapper
public interface ICourseRepository {
		List<Course> getCourse(@Param("studentId") String studentId);
		void insertCourse(Course course);
		int deleteCourse(@Param("studentId") String studentId, @Param("courseId") int courseId);
}
