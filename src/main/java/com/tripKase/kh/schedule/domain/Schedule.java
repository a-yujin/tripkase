package com.tripKase.kh.schedule.domain;

import java.sql.Date;

public class Schedule {
	
	private String scheSeq; 		//일정 순번
	private String scheDays;		//일차
	private int scheNo;				//일정 순번
	private String contetnsType;	//컨텐츠 분류
	private int contetnsNo;			//컨텐츠 순번
	private String scheName;		//일정 이름
	private String schePeriod;		//일정 기간
	private Date scheCreate;		//일정 생성일
	private String memberId;		//회원 아이디
	public String getScheSeq() {
		return scheSeq;
	}
	public void setScheSeq(String scheSeq) {
		this.scheSeq = scheSeq;
	}
	public String getScheDays() {
		return scheDays;
	}
	public void setScheDays(String scheDays) {
		this.scheDays = scheDays;
	}
	public int getScheNo() {
		return scheNo;
	}
	public void setScheNo(int scheNo) {
		this.scheNo = scheNo;
	}
	public String getContetnsType() {
		return contetnsType;
	}
	public void setContetnsType(String contetnsType) {
		this.contetnsType = contetnsType;
	}
	public int getContetnsNo() {
		return contetnsNo;
	}
	public void setContetnsNo(int contetnsNo) {
		this.contetnsNo = contetnsNo;
	}
	public String getScheName() {
		return scheName;
	}
	public void setScheName(String scheName) {
		this.scheName = scheName;
	}
	public String getSchePeriod() {
		return schePeriod;
	}
	public void setSchePeriod(String schePeriod) {
		this.schePeriod = schePeriod;
	}
	public Date getScheCreate() {
		return scheCreate;
	}
	public void setScheCreate(Date scheCreate) {
		this.scheCreate = scheCreate;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	@Override
	public String toString() {
		return "Schedule [scheSeq=" + scheSeq + ", scheDays=" + scheDays + ", scheNo=" + scheNo + ", contetnsType="
				+ contetnsType + ", contetnsNo=" + contetnsNo + ", scheName=" + scheName + ", schePeriod=" + schePeriod
				+ ", scheCreate=" + scheCreate + ", memberId=" + memberId + "]";
	}

	
	
	
}
