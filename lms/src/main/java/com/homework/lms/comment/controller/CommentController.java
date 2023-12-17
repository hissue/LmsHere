package com.homework.lms.comment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homework.lms.comment.model.Comment;
import com.homework.lms.comment.service.ICommentService;

@RestController
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	ICommentService commentService;

	@GetMapping("")
	public void test() {
		System.out.println("CommentController");
	}
	
	@GetMapping("/lecture/{lectureCommentId}")
	public List<Comment> getLectureIdComment(@PathVariable int lectureCommentId){
		System.out.println("lectureCommentId : " + lectureCommentId);
		return commentService.getLectureIdComment(lectureCommentId);
	}
	
	@GetMapping("/{commentId}")
	public Comment getComment(@PathVariable int commentId){
		return commentService.getComment(commentId);
	}
	
	@PostMapping("/insert")
	public String insertComment(@RequestBody Comment comment) {
		commentService.insertComment(comment);
		return "ok";
	}
	
	@PatchMapping("/update")
	public String updateComment(@RequestBody Comment comment) {
		commentService.updateComment(comment);
		return "ok";
	}
	
	@DeleteMapping("/delete/{commentId}/{studentId}")
	public String deleteComment(@PathVariable int commentId, @PathVariable String studentId) {
		commentService.deleteComment(commentId, studentId);
		return "ok";
	}
}
