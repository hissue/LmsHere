package com.homework.lms.comment.model;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Comment {
	private int commentId;
	private String commentContent;
	private int lectureCommentId;
	private String studentId;
	private Date commentWriteDate;
}
