package com.homework.lms.student.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
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
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	IStudentService studentService;
	
	@GetMapping("/login")
	public  String login() {
		return "login";
	}
	
	@GetMapping("/mypage/{studentId}")
	public Student getMyPage(@PathVariable String studentId) {
		return studentService.getStudent(studentId);
		
	}
	
	@PostMapping("/signin")
	public String singIn(@RequestBody Student student) {
		
		PasswordEncoder pwEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		String encodedPw = pwEncoder.encode(student.getPassword());
		student.setPassword(encodedPw);
		
		logger.info("singIn " + student.toString());
		studentService.insertStudent(student);
		return "ok";
	}
	
	@PatchMapping("/mypage/update")
	public String updateStudent(@RequestBody Student student){
		logger.info("updateStudent " + student.toString());
		studentService.updateStudent(student);
		return "ok";
	}
	
	@DeleteMapping("/mypage/delete/{studentId}/{password}")
	public String deleteStudent(@PathVariable String studentId, @PathVariable String password){
		logger.info("deleteStudent " + studentId);
		studentService.deleteStudent(studentId, password);
		return "ok";
	}
}
