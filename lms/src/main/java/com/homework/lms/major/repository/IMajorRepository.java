package com.homework.lms.major.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.homework.lms.major.model.Major;

@Repository
@Mapper
public interface IMajorRepository {
	List<Major> getMajor();
	Major getMajor(int majorId);
}
