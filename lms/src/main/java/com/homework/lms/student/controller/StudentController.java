package com.homework.lms.student.controller;

import java.security.Principal;
import java.util.Map;

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
	
	// 로그인 실패 시 모두 이곳으로 return		
	@GetMapping("/login")
	public  String login() {
		return "login";
	}
	
	@GetMapping("/mypage")
	public Student getMyPage(Principal principal, @PathVariable String studentId) {
		System.out.println(">>"+principal.getName()+"<<");
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
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@DeleteMapping("/mypage/delete")
	public String deleteStudent(Principal principal, @RequestBody Map<String, String> request){
		String studentId = principal.getName();
		String password = request.get("password");
		String dbpw = studentService.getStudent(studentId).getPassword();
		
		logger.info("deleteStudent " + studentId);
		if(password != null && passwordEncoder.matches(password, dbpw)) {//matches(password, dbpw) >> password:평문, dbpw : db로부터 갖고 온 비번
			studentService.deleteStudent(studentId, dbpw);
		}
		
		return "ok";
	}
}
