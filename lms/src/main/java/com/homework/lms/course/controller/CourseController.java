package com.homework.lms.course.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homework.lms.course.model.Course;
import com.homework.lms.course.service.ICourseService;

@RestController
@RequestMapping("/course")
public class CourseController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ICourseService courseService;
	
	@GetMapping("")
	public void test(){
		System.out.println("courseService");
	} 
	
	@GetMapping("/{studentId}")
	public List<Course> getCourse(@PathVariable String studentId){
		return courseService.getCourse(studentId);
	} 
	
	@PostMapping("/insert")
	public String insertCourse(@RequestBody Course course) {
		logger.info("insertCourse " + course.toString());
		courseService.insertCourse(course);
		return "ok";
	}

	@DeleteMapping("/delete/{courseId}/{studentId}")
	public String deleteCourse(@PathVariable String studentId, @PathVariable int courseId) {
		logger.info("deleteCourse " + courseId);
		courseService.deleteCourse(studentId, courseId);
		return "ok";
	}
}
