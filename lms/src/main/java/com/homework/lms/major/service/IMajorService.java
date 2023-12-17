package com.homework.lms.major.service;

import java.util.List;

import com.homework.lms.major.model.Major;

public interface IMajorService {
	List<Major> getMajor();
	Major getMajor(int majorId);
}
