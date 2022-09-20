package com.tripKase.kh.grade.domain;

import java.sql.Date;

public class Grade {
	private int gradeNo;
	private String contentsCode;
	private int contentsNo;
	private String gradeComment;
	private int gradeStar;
	private Date gradeCreate;
	private String memberId;
	
	public int getGradeNo() {
		return gradeNo;
	}
	public void setGradeNo(int gradeNo) {
		this.gradeNo = gradeNo;
	}
	public String getContentsCode() {
		return contentsCode;
	}
	public void setContentsCode(String contentsCode) {
		this.contentsCode = contentsCode;
	}
	public int getContentsNo() {
		return contentsNo;
	}
	public void setContentsNo(int contentsNo) {
		this.contentsNo = contentsNo;
	}
	public String getGradeComment() {
		return gradeComment;
	}
	public void setGradeComment(String gradeComment) {
		this.gradeComment = gradeComment;
	}
	public int getGradeStar() {
		return gradeStar;
	}
	public void setGradeStar(int gradeStar) {
		this.gradeStar = gradeStar;
	}
	public Date getGradeCreate() {
		return gradeCreate;
	}
	public void setGradeCreate(Date gradeCreate) {
		this.gradeCreate = gradeCreate;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	@Override
	public String toString() {
		return "Grade [gradeNo=" + gradeNo + ", contentsCode=" + contentsCode + ", contentsNo=" + contentsNo
				+ ", gradeComment=" + gradeComment + ", gradeStar=" + gradeStar + ", gradeCreate=" + gradeCreate
				+ ", memberId=" + memberId + "]";
	}
	
}
