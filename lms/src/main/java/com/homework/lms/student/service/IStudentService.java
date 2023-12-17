package com.homework.lms.student.service;

import com.homework.lms.student.model.Student;

public interface IStudentService {
	Student getStudent(String studentId);
	void insertStudent(Student student);
	void updateStudent(Student student);
	void deleteStudent(String studentId, String password);
}
