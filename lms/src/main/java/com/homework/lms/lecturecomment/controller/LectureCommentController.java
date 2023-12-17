package com.homework.lms.lecturecomment.controller;

import java.security.Principal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homework.lms.lecturecomment.model.LectureComment;
import com.homework.lms.lecturecomment.service.ILectureCommentService;

@RestController
@RequestMapping("/lecturecomment")
public class LectureCommentController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ILectureCommentService lectureCommentService;
	
	@GetMapping("")
	public void test() {
		System.out.println("LectureCommentController");
	}
	
	@GetMapping("/")
	public List<LectureComment> getLectureComment(){
		return lectureCommentService.getLectureComment();
	}
	
	@GetMapping("/{lectureId}")
	public List<LectureComment> getLectureComment(@PathVariable int lectureId) {
		return lectureCommentService.getLectureComment(lectureId);
	}
	
	@GetMapping("/lecture/{lectureCommentId}")
	public LectureComment getLectureCommentIdLectureComment(@PathVariable int lectureCommentId) {
		return lectureCommentService.getLectureCommentIdLectureComment(lectureCommentId);
		
	}

	@PostMapping("/insert")
	public String insertLectureComment(@RequestBody LectureComment lectureComment) {
		logger.info("insertLectureComment " + lectureComment.toString());
		lectureCommentService.insertLectureComment(lectureComment);
		return "ok";
	}
	
	@PatchMapping("/update")
	public String updateLectureComment(@RequestBody LectureComment lectureComment) {
		logger.info("updateLectureComment " + lectureComment.toString());
		lectureCommentService.updateLectureComment(lectureComment);
		return "ok";
	}
	
//	@DeleteMapping("/delete/{lectureCommentId}/{studentId}")
	@DeleteMapping("/delete/{lectureCommentId}")
//	public String deleteLectureComment(@PathVariable int lectureCommentId, @PathVariable String studentId) {
	public String deleteLectureComment(@PathVariable int lectureCommentId, Principal principal) {
		logger.info("deleteLectureComment " + lectureCommentId);
		lectureCommentService.deleteLectureComment(lectureCommentId, principal.getName());
		return "ok";
	}
}
