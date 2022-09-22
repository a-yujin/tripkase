package com.tripKase.kh.notice.domain;

import java.sql.Date;

public class Notice {
	private int noticeNo; // 공지 번호
	private String noticeWriter; // 공지 작성자
	private String noticeType; // 공지 유형
	private String noticeTitle; // 공지 제목
	private Date nCreateDate; // 공지 등록일
	private Date nUpdateDate; // 공지 수정일
	private String nContents; // 공지 내용
	private String nFileName; // 공지 파일 이름
	private String nFileRename; // 공지 파일 변경된 이름
	private String nFilePath; // 공지 파일 경로
	private int noticeCount; // 공지 게시글 수(삭제 예정)
	private String noticeStatus; // 공지 게시 여부
	private int imgNo;
	
	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	public String getNoticeWriter() {
		return noticeWriter;
	}
	public void setNoticeWriter(String noticeWriter) {
		this.noticeWriter = noticeWriter;
	}
	public String getNoticeType() {
		return noticeType;
	}
	public void setNoticeType(String noticeType) {
		this.noticeType = noticeType;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public Date getnCreateDate() {
		return nCreateDate;
	}
	public void setnCreateDate(Date nCreateDate) {
		this.nCreateDate = nCreateDate;
	}
	public Date getnUpdateDate() {
		return nUpdateDate;
	}
	public void setnUpdateDate(Date nUpdateDate) {
		this.nUpdateDate = nUpdateDate;
	}
	public String getnContents() {
		return nContents;
	}
	public void setnContents(String nContents) {
		this.nContents = nContents;
	}
	public String getnFileName() {
		return nFileName;
	}
	public void setnFileName(String nFileName) {
		this.nFileName = nFileName;
	}
	public String getnFileRename() {
		return nFileRename;
	}
	public void setnFileRename(String nFileRename) {
		this.nFileRename = nFileRename;
	}
	public String getnFilePath() {
		return nFilePath;
	}
	public void setnFilePath(String nFilePath) {
		this.nFilePath = nFilePath;
	}
	public int getNoticeCount() {
		return noticeCount;
	}
	public void setNoticeCount(int noticeCount) {
		this.noticeCount = noticeCount;
	}
	public String getNoticeStatus() {
		return noticeStatus;
	}
	public void setNoticeStatus(String noticeStatus) {
		this.noticeStatus = noticeStatus;
	}
	public int getImgNo() {
		return imgNo;
	}
	public void setImgNo(int imgNo) {
		this.imgNo = imgNo;
	}
	
	@Override
	public String toString() {
		return "Notice [noticeNo=" + noticeNo + ", noticeWriter=" + noticeWriter + ", noticeType=" + noticeType
				+ ", noticeTitle=" + noticeTitle + ", nCreateDate=" + nCreateDate + ", nUpdateDate=" + nUpdateDate
				+ ", nContents=" + nContents + ", nFileName=" + nFileName + ", nFileRename=" + nFileRename
				+ ", nFilePath=" + nFilePath + ", noticeCount=" + noticeCount + ", noticeStatus=" + noticeStatus
				+ ", imgNo=" + imgNo + "]";
	}
}
