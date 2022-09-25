package com.tripKase.kh.course.domain;

public class CourseImg {
	private int imgNo;
	private int courseNo;
	private String cFileName;
	private String cFileRename;
	private String cFilePath;
	private String locationName;
	public int getImgNo() {
		return imgNo;
	}
	public void setImgNo(int imgNo) {
		this.imgNo = imgNo;
	}
	public int getCourseNo() {
		return courseNo;
	}
	public void setCourseNo(int courseNo) {
		this.courseNo = courseNo;
	}
	public String getcFileName() {
		return cFileName;
	}
	public void setcFileName(String cFileName) {
		this.cFileName = cFileName;
	}
	public String getcFileRename() {
		return cFileRename;
	}
	public void setcFileRename(String cFileRename) {
		this.cFileRename = cFileRename;
	}
	public String getcFilePath() {
		return cFilePath;
	}
	public void setcFilePath(String cFilePath) {
		this.cFilePath = cFilePath;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	@Override
	public String toString() {
		return "CourseImg [imgNo=" + imgNo + ", courseNo=" + courseNo + ", cFileName=" + cFileName + ", cFileRename="
				+ cFileRename + ", cFilePath=" + cFilePath + ", locationName=" + locationName + "]";
	}
	
	
	
	
	
}
