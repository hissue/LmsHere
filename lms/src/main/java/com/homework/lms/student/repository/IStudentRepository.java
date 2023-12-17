package com.homework.lms.student.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.homework.lms.student.model.Student;

@Repository
@Mapper
public interface IStudentRepository {
	Student getStudent(String studentId);
	void insertStudent(Student student);
	void updateStudent(Student student);
	void deleteStudent(String studentId, String password);
}
