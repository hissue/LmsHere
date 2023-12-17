package com.homework.lms.lecture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homework.lms.lecture.model.Lecture;
import com.homework.lms.lecture.repository.ILectureRepository;

@Service
public class LectureService implements ILectureService{

	@Autowired
	ILectureRepository lectureReopository;
	
	@Override
	public List<Lecture> getLecture() {
		return lectureReopository.getLecture();
	}

	@Override
	public List<Lecture> getLecture(int majorId) {
		return lectureReopository.getLecture(majorId);
	}

}
