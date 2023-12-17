package com.homework.lms.student.model;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Student {
	private String studentId;
	private String studentName;
	private String studentEmail;
	private String studentAddress;
	private String studentPhoneNumber;
	private int studentGrade;
	private Date studentAdmissionYear;
	private int majorId;
	private String password;
	private int roleId;
}
