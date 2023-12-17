package com.homework.lms.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homework.lms.lecturecomment.model.LectureComment;
import com.homework.lms.student.model.Student;
import com.homework.lms.student.repository.IStudentRepository;

@Service
public class StudentService implements IStudentService{

	@Autowired
	IStudentRepository studentRepository;
	
	@Override
	public Student getStudent(String studentId) {
		return studentRepository.getStudent(studentId);
	}

	@Override
	public void insertStudent(Student student) {
		studentRepository.insertStudent(student);
		
	}

	@Override
	public void updateStudent(Student student) {
		studentRepository.updateStudent(student);
		
	}

	@Override
	public void deleteStudent(String studentId, String password) {
		studentRepository.deleteStudent(studentId, password);
		
	}

}
