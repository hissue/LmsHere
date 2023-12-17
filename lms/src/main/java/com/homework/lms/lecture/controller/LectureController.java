package com.homework.lms.lecture.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homework.lms.lecture.model.Lecture;
import com.homework.lms.lecture.service.ILectureService;

@RestController
@RequestMapping("/lecture")
public class LectureController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ILectureService lectureService;
	
	@GetMapping("")
	public void test() {
		System.out.println("LectureController");
	}
	
	@GetMapping("/")
	public List<Lecture> getLecture(){
		return lectureService.getLecture();
	}
	
	@GetMapping("/{majorId}")
	public List<Lecture> getLecture(@PathVariable int majorId){
		return lectureService.getLecture(majorId);
		
	}
}
