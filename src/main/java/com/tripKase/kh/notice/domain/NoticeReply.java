package com.tripKase.kh.notice.domain;

import java.sql.Date;

public class NoticeReply {
	private int nReplyNo; // 공지 댓글 번호
	private int refNoticeNo; // 참고 공지 번호
	private String nReplyWriter; // 공지 댓글 작성자
	private String nReplyContents; // 공지 댓글 내용
	private Date nReCreateDate; // 공지 등록일
	private Date nReUpdateDate; // 공지 수정일
	private int nReplyCount; // 공지 댓글 수
	private String nReplyStatus; // 공지 댓글 게시 여부
	
	public int getnReplyNo() {
		return nReplyNo;
	}
	public void setnReplyNo(int nReplyNo) {
		this.nReplyNo = nReplyNo;
	}
	public int getRefNoticeNo() {
		return refNoticeNo;
	}
	public void setRefNoticeNo(int refNoticeNo) {
		this.refNoticeNo = refNoticeNo;
	}
	public String getnReplyWriter() {
		return nReplyWriter;
	}
	public void setnReplyWriter(String nReplyWriter) {
		this.nReplyWriter = nReplyWriter;
	}
	public String getnReplyContents() {
		return nReplyContents;
	}
	public void setnReplyContents(String nReplyContents) {
		this.nReplyContents = nReplyContents;
	}
	public Date getnReCreateDate() {
		return nReCreateDate;
	}
	public void setnReCreateDate(Date nReCreateDate) {
		this.nReCreateDate = nReCreateDate;
	}
	public Date getnReUpdateDate() {
		return nReUpdateDate;
	}
	public void setnReUpdateDate(Date nReUpdateDate) {
		this.nReUpdateDate = nReUpdateDate;
	}
	public int getnReplyCount() {
		return nReplyCount;
	}
	public void setnReplyCount(int nReplyCount) {
		this.nReplyCount = nReplyCount;
	}
	public String getnReplyStatus() {
		return nReplyStatus;
	}
	public void setnReplyStatus(String nReplyStatus) {
		this.nReplyStatus = nReplyStatus;
	}
	
	@Override
	public String toString() {
		return "NoticeReply [nReplyNo=" + nReplyNo + ", refNoticeNo=" + refNoticeNo + ", nReplyWriter=" + nReplyWriter
				+ ", nReplyContents=" + nReplyContents + ", nReCreateDate=" + nReCreateDate + ", nReUpdateDate="
				+ nReUpdateDate + ", nReplyCount=" + nReplyCount + ", nReplyStatus=" + nReplyStatus + "]";
	}
}
