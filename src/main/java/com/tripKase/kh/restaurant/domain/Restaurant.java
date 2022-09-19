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
	private String resFilename;
	private String resFileRename;
	private String resFilepath;
	private String resMap;
	private String resStatus;
	private String resAddress;
	private String memberId;
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
	public String getResFilename() {
		return resFilename;
	}
	public void setResFilename(String resFilename) {
		this.resFilename = resFilename;
	}
	public String getResFileRename() {
		return resFileRename;
	}
	public void setResFileRename(String resFileRename) {
		this.resFileRename = resFileRename;
	}
	public String getResFilepath() {
		return resFilepath;
	}
	public void setResFilepath(String resFilepath) {
		this.resFilepath = resFilepath;
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
	@Override
	public String toString() {
		return "Restaurant [resNo=" + resNo + ", resName=" + resName + ", resType=" + resType + ", resArea=" + resArea
				+ ", resTel=" + resTel + ", resDayoff=" + resDayoff + ", resMainmenu=" + resMainmenu + ", resDetail="
				+ resDetail + ", resFilename=" + resFilename + ", resFileRename=" + resFileRename + ", resFilepath="
				+ resFilepath + ", resMap=" + resMap + ", resStatus=" + resStatus + ", resAddress=" + resAddress
				+ ", memberId=" + memberId + "]";
	}
	

	
	
	
	
}
