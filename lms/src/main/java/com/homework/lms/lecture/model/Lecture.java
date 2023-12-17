package com.homework.lms.lecture.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Lecture {
	private int lectureId;
	private String lectureName;
	private String lectureLocation;
	private String lectureTime;
	private int lectureCredit;
	private int studentGrade;
	private int majorId;
}
