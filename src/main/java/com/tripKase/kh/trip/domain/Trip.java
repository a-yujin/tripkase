package com.tripKase.kh.trip.domain;

import java.sql.Date;

public class Trip {
	private int tripNo; // 여행소통 순번
	private String tripTitle; // 여행소통 게시글 제목
	private String tripContents; // 여행소통 게시글 내용
	private String tripWriter; // 여행소통 게시글 작성자
	private Date tripCreate; // 여행소통 게시글 작성일
	private Date tripUpdate; // 여행소통 게시글 수정일
	private String tripFileName; // 여행소통 변경전 첨부파일 이름
	private String tripFileRename; // 여행소통 변경후 첨부파일 이름
	private String tripFilePath; // 여행소통 첨부파일 경로
	private String tripStatus; // 여행소통 게시글 존재여부
	private String tripCount; // 여행소통 게시글 수
	private String tripLike; // 여행소통 게시글 좋아요 수
	private String tripShow; // 여행소통 게시글 조회수
	
	public Trip() {}

	public Trip(int tripNo, String tripTitle, String tripContents, String tripWriter, Date tripCreate, Date tripUpdate,
			String tripFileName, String tripFileRename, String tripFilePath, String tripStatus, String tripCount,
			String tripLike, String tripShow) {
		super();
		this.tripNo = tripNo;
		this.tripTitle = tripTitle;
		this.tripContents = tripContents;
		this.tripWriter = tripWriter;
		this.tripCreate = tripCreate;
		this.tripUpdate = tripUpdate;
		this.tripFileName = tripFileName;
		this.tripFileRename = tripFileRename;
		this.tripFilePath = tripFilePath;
		this.tripStatus = tripStatus;
		this.tripCount = tripCount;
		this.tripLike = tripLike;
		this.tripShow = tripShow;
	}

	public int getTripNo() {
		return tripNo;
	}

	public void setTripNo(int tripNo) {
		this.tripNo = tripNo;
	}

	public String getTripTitle() {
		return tripTitle;
	}

	public void setTripTitle(String tripTitle) {
		this.tripTitle = tripTitle;
	}

	public String getTripContents() {
		return tripContents;
	}

	public void setTripContents(String tripContents) {
		this.tripContents = tripContents;
	}

	public String getTripWriter() {
		return tripWriter;
	}

	public void setTripWriter(String tripWriter) {
		this.tripWriter = tripWriter;
	}

	public Date getTripCreate() {
		return tripCreate;
	}

	public void setTripCreate(Date tripCreate) {
		this.tripCreate = tripCreate;
	}

	public Date getTripUpdate() {
		return tripUpdate;
	}

	public void setTripUpdate(Date tripUpdate) {
		this.tripUpdate = tripUpdate;
	}

	public String getTripFileName() {
		return tripFileName;
	}

	public void setTripFileName(String tripFileName) {
		this.tripFileName = tripFileName;
	}

	public String getTripFileRename() {
		return tripFileRename;
	}

	public void setTripFileRename(String tripFileRename) {
		this.tripFileRename = tripFileRename;
	}

	public String getTripFilePath() {
		return tripFilePath;
	}

	public void setTripFilePath(String tripFilePath) {
		this.tripFilePath = tripFilePath;
	}

	public String getTripStatus() {
		return tripStatus;
	}

	public void setTripStatus(String tripStatus) {
		this.tripStatus = tripStatus;
	}

	public String getTripCount() {
		return tripCount;
	}

	public void setTripCount(String tripCount) {
		this.tripCount = tripCount;
	}

	public String getTripLike() {
		return tripLike;
	}

	public void setTripLike(String tripLike) {
		this.tripLike = tripLike;
	}

	public String getTripShow() {
		return tripShow;
	}

	public void setTripShow(String tripShow) {
		this.tripShow = tripShow;
	}

	@Override
	public String toString() {
		return "Trip [tripNo=" + tripNo + ", tripTitle=" + tripTitle + ", tripContents=" + tripContents
				+ ", tripWriter=" + tripWriter + ", tripCreate=" + tripCreate + ", tripUpdate=" + tripUpdate
				+ ", tripFileName=" + tripFileName + ", tripFileRename=" + tripFileRename + ", tripFilePath="
				+ tripFilePath + ", tripStatus=" + tripStatus + ", tripCount=" + tripCount + ", tripLike=" + tripLike
				+ ", tripShow=" + tripShow + "]";
	}
}
