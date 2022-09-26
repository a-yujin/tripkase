package com.tripKase.kh.restaurant.domain;

public class Restaurant {
	
	private int resNo;
	private String resName;
	private String resType;
	private String resArea;
	private String resTel;
	private String resDayoff;
	private String resMainmenu;
	private String resDetail;
	private String resMap;
	private String resStatus;
	private String resAddress;
	private String resFileName;
	private String resFileRename;
	private String resFilePath;
	private String memberId;
	
	
	public Restaurant() {}
	
	public Restaurant(int resNo, String resName, String resType, String resArea, String resTel, String resDayoff,
			String resMainmenu, String resDetail, String resMap, String resStatus, String resAddress,
			String resFileName, String resFileRename, String resFilePath, String memberId) {
		super();
		this.resNo = resNo;
		this.resName = resName;
		this.resType = resType;
		this.resArea = resArea;
		this.resTel = resTel;
		this.resDayoff = resDayoff;
		this.resMainmenu = resMainmenu;
		this.resDetail = resDetail;
		this.resMap = resMap;
		this.resStatus = resStatus;
		this.resAddress = resAddress;
		this.resFileName = resFileName;
		this.resFileRename = resFileRename;
		this.resFilePath = resFilePath;
		this.memberId = memberId;
	}
	public int getResNo() {
		return resNo;
	}
	public void setResNo(int resNo) {
		this.resNo = resNo;
	}
	public String getResName() {
		return resName;
	}
	public void setResName(String resName) {
		this.resName = resName;
	}
	public String getResType() {
		return resType;
	}
	public void setResType(String resType) {
		this.resType = resType;
	}
	public String getResArea() {
		return resArea;
	}
	public void setResArea(String resArea) {
		this.resArea = resArea;
	}
	public String getResTel() {
		return resTel;
	}
	public void setResTel(String resTel) {
		this.resTel = resTel;
	}
	public String getResDayoff() {
		return resDayoff;
	}
	public void setResDayoff(String resDayoff) {
		this.resDayoff = resDayoff;
	}
	public String getResMainmenu() {
		return resMainmenu;
	}
	public void setResMainmenu(String resMainmenu) {
		this.resMainmenu = resMainmenu;
	}
	public String getResDetail() {
		return resDetail;
	}
	public void setResDetail(String resDetail) {
		this.resDetail = resDetail;
	}
	public String getResMap() {
		return resMap;
	}
	public void setResMap(String resMap) {
		this.resMap = resMap;
	}
	public String getResStatus() {
		return resStatus;
	}
	public void setResStatus(String resStatus) {
		this.resStatus = resStatus;
	}
	public String getMemberId() {
		return memberId;
	}	
	public String getResAddress() {
		return resAddress;
	}
	public void setResAddress(String resAddress) {
		this.resAddress = resAddress;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
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
		return "Restaurant [resNo=" + resNo + ", resName=" + resName + ", resType=" + resType + ", resArea=" + resArea
				+ ", resTel=" + resTel + ", resDayoff=" + resDayoff + ", resMainmenu=" + resMainmenu + ", resDetail="
				+ resDetail + ", resMap=" + resMap + ", resStatus=" + resStatus + ", resAddress=" + resAddress
				+ ", resFileName=" + resFileName + ", resFileRename=" + resFileRename + ", resFilePath=" + resFilePath
				+ ", memberId=" + memberId + "]";
	}
	
	
	

	
	
	
	
}
