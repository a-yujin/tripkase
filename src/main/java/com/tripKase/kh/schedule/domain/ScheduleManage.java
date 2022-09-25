package com.tripKase.kh.schedule.domain;

import com.tripKase.kh.restaurant.domain.Restaurant;

public class ScheduleManage {

	private int scheduleNo;	//일차
	private String scheduleSeq; 	//일정 순번
	private String scheduleDays;	//일차
	private String contetnsType;	//컨텐츠 분류
	private int contetnsNo;			//컨텐츠 순번
	private Restaurant restaurant;
	
	public Restaurant getRestaurnat() {
		return restaurant;
	}
	public void setRestaurnat(Restaurant restaurnat) {
		this.restaurant = restaurnat;
	}
	public String getScheduleSeq() {
		return scheduleSeq;
	}
	public void setScheduleSeq(String scheduleSeq) {
		this.scheduleSeq = scheduleSeq;
	}
	public String getScheduleDays() {
		return scheduleDays;
	}
	public void setScheduleDays(String scheduleDays) {
		this.scheduleDays = scheduleDays;
	}
	public int getScheduleNo() {
		return scheduleNo;
	}
	public void setScheduleNo(int scheduleNo) {
		this.scheduleNo = scheduleNo;
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
	@Override
	public String toString() {
		return "ScheduleManage [scheduleNo=" + scheduleNo + ", scheduleSeq=" + scheduleSeq + ", scheduleDays="
				+ scheduleDays + ", contetnsType=" + contetnsType + ", contetnsNo=" + contetnsNo + ", restaurnat="
				+ restaurant + "]";
	}
	
	
	
	
}
