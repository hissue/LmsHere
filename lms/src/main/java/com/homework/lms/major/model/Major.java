package com.homework.lms.major.model;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.ToString;

@Getter @Service @ToString
public class Major {
	private int majorId;
	private String majorName;
}
