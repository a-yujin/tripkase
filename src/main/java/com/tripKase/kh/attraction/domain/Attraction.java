package com.tripKase.kh.attraction.domain;

public class Attraction {
	private int attrNo; // 관광지 고유 번호
	private String attrLocation; // 관광지 지역
	private String attrName; // 관광지 이름
	private String attrTripType; // 관광지 여행 유형
	private String attrInfo; // 관광지 설명
	private String attrTel; // 관광지 전화번호
	private String attrWebsite; // 관광지 홈페이지
	private String attrAddress; // 관광지 주소
	private String attrHours; // 관광지 이용시간
	private String attrFee; // 관광지 입장료
	private String attrCar; // 관광지 주차 가능 여부
	private String attrPet; // 관광지 반려동물 동반 가능 여부
	private String attrFileName; // 관광지 사진 파일 이름
	private String attrFileRename; // 관광지 사진 파일 변경된 이름
	private String attrFilePath; // 관광지 사진 파일 경로
	private String attrShortInfo; // 관광지 한줄 설명
	private String attrStatus; // 관광지 게시 여부
	
	public int getAttrNo() {
		return attrNo;
	}
	public void setAttrNo(int attrNo) {
		this.attrNo = attrNo;
	}
	public String getAttrLocation() {
		return attrLocation;
	}
	public void setAttrLocation(String attrLocation) {
		this.attrLocation = attrLocation;
	}
	public String getAttrName() {
		return attrName;
	}
	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}
	public String getAttrTripType() {
		return attrTripType;
	}
	public void setAttrTripType(String attrTripType) {
		this.attrTripType = attrTripType;
	}
	public String getAttrInfo() {
		return attrInfo;
	}
	public void setAttrInfo(String attrInfo) {
		this.attrInfo = attrInfo;
	}
	public String getAttrTel() {
		return attrTel;
	}
	public void setAttrTel(String attrTel) {
		this.attrTel = attrTel;
	}
	public String getAttrWebsite() {
		return attrWebsite;
	}
	public void setAttrWebsite(String attrWebsite) {
		this.attrWebsite = attrWebsite;
	}
	public String getAttrAddress() {
		return attrAddress;
	}
	public void setAttrAddress(String attrAddress) {
		this.attrAddress = attrAddress;
	}
	public String getAttrHours() {
		return attrHours;
	}
	public void setAttrHours(String attrHours) {
		this.attrHours = attrHours;
	}
	public String getAttrFee() {
		return attrFee;
	}
	public void setAttrFee(String attrFee) {
		this.attrFee = attrFee;
	}
	public String getAttrCar() {
		return attrCar;
	}
	public void setAttrCar(String attrCar) {
		this.attrCar = attrCar;
	}
	public String getAttrPet() {
		return attrPet;
	}
	public void setAttrPet(String attrPet) {
		this.attrPet = attrPet;
	}
	public String getAttrFileName() {
		return attrFileName;
	}
	public void setAttrFileName(String attrFileName) {
		this.attrFileName = attrFileName;
	}
	public String getAttrFileRename() {
		return attrFileRename;
	}
	public void setAttrFileRename(String attrFileRename) {
		this.attrFileRename = attrFileRename;
	}
	public String getAttrFilePath() {
		return attrFilePath;
	}
	public void setAttrFilePath(String attrFilePath) {
		this.attrFilePath = attrFilePath;
	}
	public String getAttrShortInfo() {
		return attrShortInfo;
	}
	public void setAttrShortInfo(String attrShortInfo) {
		this.attrShortInfo = attrShortInfo;
	}
	public String getAttrStatus() {
		return attrStatus;
	}
	public void setAttrStatus(String attrStatus) {
		this.attrStatus = attrStatus;
	}
	
	@Override
	public String toString() {
		return "Attraction [attrNo=" + attrNo + ", attrLocation=" + attrLocation + ", attrName=" + attrName
				+ ", attrTripType=" + attrTripType + ", attrInfo=" + attrInfo + ", attrTel=" + attrTel
				+ ", attrWebsite=" + attrWebsite + ", attrAddress=" + attrAddress + ", attrHours=" + attrHours
				+ ", attrFee=" + attrFee + ", attrCar=" + attrCar + ", attrPet=" + attrPet + ", attrFileName="
				+ attrFileName + ", attrFileRename=" + attrFileRename + ", attrFilePath=" + attrFilePath
				+ ", attrShortInfo=" + attrShortInfo + ", attrStatus=" + attrStatus + "]";
	}
}
