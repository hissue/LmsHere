package com.homework.lms.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.homework.lms.student.model.Student;
import com.homework.lms.student.service.IStudentService;

@RestController
public class StudentController {
	@Autowired
	IStudentService studentService;
	
	@GetMapping("/login")
	public  String login() {
		return "login";
	}
	
	@PostMapping("/signin")
	public String singIn(@RequestBody Student student) {
		studentService.insertStudent(student);
		return "ok";
	}
	
	@GetMapping("/mypage/{studentId}")
	public Student getMyPage(@PathVariable String studentId) {
		return studentService.getStudent(studentId);
		
	}
	
	@PatchMapping("/mypage/update")
	public String updateStudent(@RequestBody Student student){
		studentService.updateStudent(student);
		return "ok";
	}
	
	@DeleteMapping("/mypage/delete/{studentId}/{password}")
	public String deleteStudent(@PathVariable String studentId, @PathVariable String password){
		studentService.deleteStudent(studentId, password);
		return "ok";
	}
}
