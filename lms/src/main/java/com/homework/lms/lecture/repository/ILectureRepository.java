package com.homework.lms.lecture.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.homework.lms.lecture.model.Lecture;

@Repository
@Mapper
public interface ILectureRepository {
	List<Lecture> getLecture();
	List<Lecture> getLecture(int majorId);
}
