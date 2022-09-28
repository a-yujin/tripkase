package com.tripKase.kh.trip.domain;

import java.sql.Date;

public class TripReply {
	private int tReplyNo; // 여행소통 댓글 순번
	private int repTripNo; // 여행소통 게시글 순번
	private String tReplyContents; // 여행소통 댓글 내용
	private String tReplyWriter; // 여행소통 댓글 작성자
	private Date tReplyCreate; // 여행소통 댓글 작성일
	private Date tReplyUpdate; // 여행소통 댓글 수정일
	private int tReplyCount; // 여행소통 댓글수
	private String tReplyStatus; // 여행소통 댓글 존재여부
	private String tReplyProfile;
	
	public TripReply() {}

	public TripReply(int tReplyNo, int repTripNo, String tReplyContents, String tReplyWriter, Date tReplyCreate,
			Date tReplyUpdate, int tReplyCount, String tReplyStatus, String tReplyProfile) {
		super();
		this.tReplyNo = tReplyNo;
		this.repTripNo = repTripNo;
		this.tReplyContents = tReplyContents;
		this.tReplyWriter = tReplyWriter;
		this.tReplyCreate = tReplyCreate;
		this.tReplyUpdate = tReplyUpdate;
		this.tReplyCount = tReplyCount;
		this.tReplyStatus = tReplyStatus;
		this.tReplyProfile = tReplyProfile;
	}

	public int gettReplyNo() {
		return tReplyNo;
	}

	public void settReplyNo(int tReplyNo) {
		this.tReplyNo = tReplyNo;
	}

	public int getRepTripNo() {
		return repTripNo;
	}

	public void setRepTripNo(int repTripNo) {
		this.repTripNo = repTripNo;
	}

	public String gettReplyContents() {
		return tReplyContents;
	}

	public void settReplyContents(String tReplyContents) {
		this.tReplyContents = tReplyContents;
	}

	public String gettReplyWriter() {
		return tReplyWriter;
	}

	public void settReplyWriter(String tReplyWriter) {
		this.tReplyWriter = tReplyWriter;
	}

	public Date gettReplyCreate() {
		return tReplyCreate;
	}

	public void settReplyCreate(Date tReplyCreate) {
		this.tReplyCreate = tReplyCreate;
	}

	public Date gettReplyUpdate() {
		return tReplyUpdate;
	}

	public void settReplyUpdate(Date tReplyUpdate) {
		this.tReplyUpdate = tReplyUpdate;
	}

	public int gettReplyCount() {
		return tReplyCount;
	}

	public void settReplyCount(int tReplyCount) {
		this.tReplyCount = tReplyCount;
	}

	public String gettReplyStatus() {
		return tReplyStatus;
	}

	public void settReplyStatus(String tReplyStatus) {
		this.tReplyStatus = tReplyStatus;
	}

	public String gettReplyProfile() {
		return tReplyProfile;
	}

	public void settReplyProfile(String tReplyProfile) {
		this.tReplyProfile = tReplyProfile;
	}

	@Override
	public String toString() {
		return "TripReply [tReplyNo=" + tReplyNo + ", repTripNo=" + repTripNo + ", tReplyContents=" + tReplyContents
				+ ", tReplyWriter=" + tReplyWriter + ", tReplyCreate=" + tReplyCreate + ", tReplyUpdate=" + tReplyUpdate
				+ ", tReplyCount=" + tReplyCount + ", tReplyStatus=" + tReplyStatus + ", tReplyProfile=" + tReplyProfile
				+ "]";
	}
}