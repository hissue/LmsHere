package com.homework.lms.course.controller;

import java.security.Principal;
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
	
	@GetMapping("/")
	public List<Course> getCourse(Principal principal){
		return courseService.getCourse(principal.getName());
	} 
	
	@PostMapping("/insert")
	public String insertCourse(@RequestBody Course course) {
		logger.info("insertCourse " + course.toString());
		courseService.insertCourse(course);
		return "ok";
	}

//	@DeleteMapping("/delete/{courseId}/{studentId}")
	@DeleteMapping("/delete/{courseId}")
//	public String deleteCourse(@PathVariable String studentId, @PathVariable int courseId) {
	public String deleteCourse(@PathVariable int courseId, Principal principal) {

		logger.info("deleteCourse " + courseId);
		courseService.deleteCourse(principal.getName(), courseId);
		return "ok";
	}
}
