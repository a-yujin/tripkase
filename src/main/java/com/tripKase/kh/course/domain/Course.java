package com.tripKase.kh.course.domain;

public class Course {
	private int courseNo;
	private String courseName;
	private String courseThema;
	private String courseDistance;
	private String locationName;
	private String cStatus;
	private String courseInfo;
	public int getCourseNo() {
		return courseNo;
	}
	public void setCourseNo(int courseNo) {
		this.courseNo = courseNo;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseThema() {
		return courseThema;
	}
	public void setCourseThema(String courseThema) {
		this.courseThema = courseThema;
	}
	public String getCourseDistance() {
		return courseDistance;
	}
	public void setCourseDistance(String courseDistance) {
		this.courseDistance = courseDistance;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public String getcStatus() {
		return cStatus;
	}
	public void setcStatus(String cStatus) {
		this.cStatus = cStatus;
	}
	public String getCourseInfo() {
		return courseInfo;
	}
	public void setCourseInfo(String courseInfo) {
		this.courseInfo = courseInfo;
	}
	
	@Override
	public String toString() {
		return "Course [courseNo=" + courseNo + ", courseName=" + courseName + ", courseThema=" + courseThema
				+ ", courseDistance=" + courseDistance + ", locationName=" + locationName + ", cStatus=" + cStatus
				+ ", courseInfo=" + courseInfo + "]";
	}
	
}
