package com.tripKase.kh.course.domain;

public class Course {
	private int courseNo;
	private String courseName;
	private String courseThema;
	private String courseDistance;
	private String courseFileName;
	private String courseFileRename;
	private String courseFilePath;
	private String locationName;
	private String cStatus;
	

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


	public String getCourseFileName() {
		return courseFileName;
	}


	public void setCourseFileName(String courseFileName) {
		this.courseFileName = courseFileName;
	}


	public String getCourseFileRename() {
		return courseFileRename;
	}


	public void setCourseFileRename(String courseFileRename) {
		this.courseFileRename = courseFileRename;
	}


	public String getCourseFilePath() {
		return courseFilePath;
	}


	public void setCourseFilePath(String courseFilePath) {
		this.courseFilePath = courseFilePath;
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


	@Override
	public String toString() {
		return "Course [courseNo=" + courseNo + ", courseName=" + courseName + ", courseThema=" + courseThema
				+ ", courseDistance=" + courseDistance + ", courseFileName=" + courseFileName + ", courseFileRename="
				+ courseFileRename + ", courseFilePath=" + courseFilePath + ", locationName=" + locationName
				+ ", cStatus=" + cStatus + "]";
	}


	
}
