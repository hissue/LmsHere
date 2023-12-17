package com.homework.lms.lecturecomment.model;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class LectureComment {
	private int lectureCommentId;
	private String lectureCommentContent;
	private int lectureCommentStarScore;
	private Date lectureWriteDate;
	private int courseId;
	private int lectureId;
	private String studentId;
}
