package com.tripKase.kh.restaurant.domain;

public class ResImg {

	private int resImgNo;
	private int resNo;
	private String resFileName;
	private String resFileRename;
	private String resFilePath;
	
	public ResImg() {}

	public ResImg(int resImgNo, int resNo, String resFileName, String resFileRename, String resFilePath) {
		super();
		this.resImgNo = resImgNo;
		this.resNo = resNo;
		this.resFileName = resFileName;
		this.resFileRename = resFileRename;
		this.resFilePath = resFilePath;
	}



	public int getResImgNo() {
		return resImgNo;
	}

	public void setResImgNo(int resImgNo) {
		this.resImgNo = resImgNo;
	}

	public int getResNo() {
		return resNo;
	}

	public void setResNo(int resNo) {
		this.resNo = resNo;
	}

	public String getResFileName() {
		return resFileName;
	}

	public void setResFileName(String resFileName) {
		this.resFileName = resFileName;
	}

	public String getResFileRename() {
		return resFileRename;
	}

	public void setResFileRename(String resFileRename) {
		this.resFileRename = resFileRename;
	}

	public String getResFilePath() {
		return resFilePath;
	}

	public void setResFilePath(String resFilePath) {
		this.resFilePath = resFilePath;
	}

	@Override
	public String toString() {
		return "ResImg [resImgNo=" + resImgNo + ", resNo=" + resNo + ", resFileName=" + resFileName + ", resFileRename="
				+ resFileRename + ", resFilePath=" + resFilePath + "]";
	}
	
	
}
