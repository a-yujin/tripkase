package com.tripKase.kh.schedule.domain;

import java.sql.Date;

public class Schedule {
	
	private int scheduleSeq; 	//일정 순번
	private String scheduleDays;	//여행 일차
	private String scheduleName;	//일정 이름
	private Date scheduleStart; 	//여행 시작일
	private Date scheduleEnd;		//여행 마지막일
	private Date scheduleCreate;	//일정 생성일
	private String memberId;		//회원 아이디
	
	
	
	public String getScheduleDays() {
		return scheduleDays;
	}
	public void setScheduleDays(String scheduleDays) {
		this.scheduleDays = scheduleDays;
	}
	public int getScheduleSeq() {
		return scheduleSeq;
	}
	public void setScheduleSeq(int scheduleSeq) {
		this.scheduleSeq = scheduleSeq;
	}

	public String getScheduleName() {
		return scheduleName;
	}
	public void setScheduleName(String scheduleName) {
		this.scheduleName = scheduleName;
	}

	public Date getScheduleCreate() {
		return scheduleCreate;
	}
	public void setScheduleCreate(Date scheduleCreate) {
		this.scheduleCreate = scheduleCreate;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public Date getScheduleEnd() {
		return scheduleEnd;
	}
	public void setScheduleEnd(Date scheduleEnd) {
		this.scheduleEnd = scheduleEnd;
	}
	public Date getScheduleStart() {
		return scheduleStart;
	}
	public void setScheduleStart(Date scheduleStart) {
		this.scheduleStart = scheduleStart;
	}
	@Override
	public String toString() {
		return "Schedule [scheduleSeq=" + scheduleSeq + ", scheduleName=" + scheduleName + ", scheduleStart="
				+ scheduleStart + ", scheduleEnd=" + scheduleEnd + ", scheduleCreate=" + scheduleCreate + ", memberId="
				+ memberId + "]";
	}

	
	
	


	
	
	
}
