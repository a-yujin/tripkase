package com.tripKase.kh.admin.domain;

import java.sql.Date;

public class Report {
	private int reportNo; //신고 순번
	private String commonType; // 게시글, 댓글, 평점 분류
	private int commonNo; //게시글, 댓글, 평점 순번
	private String reportType; //신고 종류
	private String reportTitle; //신고 제목
	private String reportContents; //신고 내용
	private Date reportDate; //신고일
	private String memberId; //신고자
	
	
	public String getMemberId() {
		return memberId;
	}
	
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	public int getReportNo() {
		return reportNo;
	}
	public void setReportNo(int reportNo) {
		this.reportNo = reportNo;
	}
	public String getCommonType() {
		return commonType;
	}
	public void setCommonType(String commonType) {
		this.commonType = commonType;
	}
	public int getCommonNo() {
		return commonNo;
	}
	public void setCommonNo(int commonNo) {
		this.commonNo = commonNo;
	}
	public String getReportType() {
		return reportType;
	}
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
	public String getReportTitle() {
		return reportTitle;
	}
	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}
	public String getReportContents() {
		return reportContents;
	}
	public void setReportContents(String reportContents) {
		this.reportContents = reportContents;
	}
	public Date getReportDate() {
		return reportDate;
	}
	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}
	
	@Override
	public String toString() {
		return "Report [reportNo=" + reportNo + ", commonType=" + commonType + ", commonNo=" + commonNo
				+ ", reportType=" + reportType + ", reportTitle=" + reportTitle + ", reportContents=" + reportContents
				+ ", reportDate=" + reportDate + ", memberId="+memberId+"]";
	}
	
	
	
	
	
}
