package com.tripKase.kh.course.domain;

import java.sql.Date;

public class CourseReply {
	private int cReplyNo; // 여행소통 댓글 순번
	private int repCourseNo; // 여행소통 게시글 순번
	private String cReplyContents; // 여행소통 댓글 내용
	private String cReplyWriter; // 여행소통 댓글 작성자
	private Date cReplyCreate; // 여행소통 댓글 작성일
	private Date cReplyUpdate; // 여행소통 댓글 수정일
	private int cReplyCount; // 여행소통 댓글수
	private String cReplyStatus; // 여행소통 댓글 존재여부
	
	public CourseReply() {}

	public CourseReply(int cReplyNo, int repCourseNo, String cReplyContents, String cReplyWriter, Date cReplyCreate,
			Date cReplyUpdate, int cReplyCount, String cReplyStatus) {
		super();
		this.cReplyNo = cReplyNo;
		this.repCourseNo = repCourseNo;
		this.cReplyContents = cReplyContents;
		this.cReplyWriter = cReplyWriter;
		this.cReplyCreate = cReplyCreate;
		this.cReplyUpdate = cReplyUpdate;
		this.cReplyCount = cReplyCount;
		this.cReplyStatus = cReplyStatus;
	}

	public int getcReplyNo() {
		return cReplyNo;
	}

	public void setcReplyNo(int cReplyNo) {
		this.cReplyNo = cReplyNo;
	}

	public int getRepCourseNo() {
		return repCourseNo;
	}

	public void setRepCourseNo(int repCourseNo) {
		this.repCourseNo = repCourseNo;
	}

	public String getcReplyContents() {
		return cReplyContents;
	}

	public void setcReplyContents(String cReplyContents) {
		this.cReplyContents = cReplyContents;
	}

	public String getcReplyWriter() {
		return cReplyWriter;
	}

	public void setcReplyWriter(String cReplyWriter) {
		this.cReplyWriter = cReplyWriter;
	}

	public Date getcReplyCreate() {
		return cReplyCreate;
	}

	public void setcReplyCreate(Date cReplyCreate) {
		this.cReplyCreate = cReplyCreate;
	}

	public Date getcReplyUpdate() {
		return cReplyUpdate;
	}

	public void setcReplyUpdate(Date cReplyUpdate) {
		this.cReplyUpdate = cReplyUpdate;
	}

	public int getcReplyCount() {
		return cReplyCount;
	}

	public void setcReplyCount(int cReplyCount) {
		this.cReplyCount = cReplyCount;
	}

	public String getcReplyStatus() {
		return cReplyStatus;
	}

	public void setcReplyStatus(String cReplyStatus) {
		this.cReplyStatus = cReplyStatus;
	}

	@Override
	public String toString() {
		return "CourseReply [cReplyNo=" + cReplyNo + ", repCourseNo=" + repCourseNo + ", cReplyContents="
				+ cReplyContents + ", cReplyWriter=" + cReplyWriter + ", cReplyCreate=" + cReplyCreate
				+ ", cReplyUpdate=" + cReplyUpdate + ", cReplyCount=" + cReplyCount + ", cReplyStatus=" + cReplyStatus
				+ "]";
	}
}