package com.homework.lms.major.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homework.lms.major.model.Major;
import com.homework.lms.major.repository.IMajorRepository;

@Service
public class MajorService implements IMajorService{

	@Autowired
	IMajorRepository majorRepository;
	
	@Override
	public List<Major> getMajor() {
		return majorRepository.getMajor();
	}

	@Override
	public Major getMajor(int majorId) {
		return majorRepository.getMajor(majorId);
	}

}
