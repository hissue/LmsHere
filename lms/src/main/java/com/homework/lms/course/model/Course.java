package com.homework.lms.course.model;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.ToString;

@Getter @Service @ToString
public class Course {
	private int courseId;
	private int lectureId;
	private String studentId;
}
