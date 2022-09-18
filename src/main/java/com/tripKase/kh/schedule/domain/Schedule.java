package com.tripKase.kh.schedule.domain;

import java.sql.Date;

public class Schedule {
	
	private int scheNo;
	private String scheName;
	private String scheDays;
	private String scheSeq;
	private String schePeriod;
	private String scheKategorie;
	private String scheContentsId;
	private Date scheRegDay;
	
	public int getScheNo() {
		return scheNo;
	}
	public void setScheNo(int scheNo) {
		this.scheNo = scheNo;
	}
	public String getScheName() {
		return scheName;
	}
	public void setScheName(String scheName) {
		this.scheName = scheName;
	}
	public String getScheDays() {
		return scheDays;
	}
	public void setScheDays(String scheDays) {
		this.scheDays = scheDays;
	}
	public String getScheSeq() {
		return scheSeq;
	}
	public void setScheSeq(String scheSeq) {
		this.scheSeq = scheSeq;
	}
	public String getSchePeriod() {
		return schePeriod;
	}
	public void setSchePeriod(String schePeriod) {
		this.schePeriod = schePeriod;
	}
	public String getScheKategorie() {
		return scheKategorie;
	}
	public void setScheKategorie(String scheKategorie) {
		this.scheKategorie = scheKategorie;
	}
	public String getScheContentsId() {
		return scheContentsId;
	}
	public void setScheContentsId(String scheContentsId) {
		this.scheContentsId = scheContentsId;
	}
	public Date getScheRegDay() {
		return scheRegDay;
	}
	public void setScheRegDay(Date scheRegDay) {
		this.scheRegDay = scheRegDay;
	}
	@Override
	public String toString() {
		return "Schedule [scheNo=" + scheNo + ", scheName=" + scheName + ", scheDays=" + scheDays + ", scheSeq="
				+ scheSeq + ", schePeriod=" + schePeriod + ", scheKategorie=" + scheKategorie + ", scheContentsId="
				+ scheContentsId + ", scheRegDay=" + scheRegDay + "]";
	}
	
	
}
