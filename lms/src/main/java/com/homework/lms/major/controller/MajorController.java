package com.homework.lms.major.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homework.lms.major.model.Major;
import com.homework.lms.major.service.IMajorService;

@RestController
@RequestMapping("/major")
public class MajorController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	IMajorService majorService;

	@GetMapping("")
	public void test() {
		System.out.println("MajorController");
	}
	
	@GetMapping("/")
	public List<Major> getMajor(){
		return majorService.getMajor();
		
	}
	
	@GetMapping("/{majorId}")
	public Major getMajor(@PathVariable int majorId) {
		return majorService.getMajor(majorId);
		
	}
}
