package com.tripKase.kh.room.domain;

import java.sql.Date;

public class Room {
	private int roomNo; // 숙소 순번
	private String roomName; // 숙소 이름
	private String roomArea; // 숙소 지역(전체,서울,경기도,인천 등)
	private String roomType; // 숙소 종류 (전체,모텔,호텔,펜션,리조트)
	private int roomPeople; // 숙소 인원 (입실가능 인원)
	private String roomPet; // 반려견 동반여부
	private Date checkIn; // 숙소 체크인 날짜
	private Date checkOut; // 숙소 체크아웃 날짜
	private int roomPrice; // 숙소 가격
	private String roomAddress; // 숙소 주소
	private String roomTel; // 숙소 전화번호
	private String roomMap; // 숙소 지도
	private String roomCar; // 숙소 주차 정보
	private String roomLocation; // 숙소 오시는길
	private String roomGuide; // 객실 정보
	private String roomFileName; // 숙소 변경전 사진 이름
	private String roomFileRename; // 숙소 변경후 사진 이름
	private String roomFilePath; // 숙소 사진 경로
	private String roomStatus; // 숙소 게시여부
	
	public Room() {}

	public Room(int roomNo, String roomName, String roomArea, String roomType, int roomPeople, String roomPet,
			Date checkIn, Date checkOut, int roomPrice, String roomAddress, String roomTel, String roomMap,
			String roomCar, String roomLocation, String roomGuide, String roomFileName, String roomFileRename,
			String roomFilePath, String roomStatus) {
		super();
		this.roomNo = roomNo;
		this.roomName = roomName;
		this.roomArea = roomArea;
		this.roomType = roomType;
		this.roomPeople = roomPeople;
		this.roomPet = roomPet;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.roomPrice = roomPrice;
		this.roomAddress = roomAddress;
		this.roomTel = roomTel;
		this.roomMap = roomMap;
		this.roomCar = roomCar;
		this.roomLocation = roomLocation;
		this.roomGuide = roomGuide;
		this.roomFileName = roomFileName;
		this.roomFileRename = roomFileRename;
		this.roomFilePath = roomFilePath;
		this.roomStatus = roomStatus;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getRoomArea() {
		return roomArea;
	}

	public void setRoomArea(String roomArea) {
		this.roomArea = roomArea;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public int getRoomPeople() {
		return roomPeople;
	}

	public void setRoomPeople(int roomPeople) {
		this.roomPeople = roomPeople;
	}

	public String getRoomPet() {
		return roomPet;
	}

	public void setRoomPet(String roomPet) {
		this.roomPet = roomPet;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}

	public int getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
	}

	public String getRoomAddress() {
		return roomAddress;
	}

	public void setRoomAddress(String roomAddress) {
		this.roomAddress = roomAddress;
	}

	public String getRoomTel() {
		return roomTel;
	}

	public void setRoomTel(String roomTel) {
		this.roomTel = roomTel;
	}

	public String getRoomMap() {
		return roomMap;
	}

	public void setRoomMap(String roomMap) {
		this.roomMap = roomMap;
	}

	public String getRoomCar() {
		return roomCar;
	}

	public void setRoomCar(String roomCar) {
		this.roomCar = roomCar;
	}

	public String getRoomLocation() {
		return roomLocation;
	}

	public void setRoomLocation(String roomLocation) {
		this.roomLocation = roomLocation;
	}

	public String getRoomGuide() {
		return roomGuide;
	}

	public void setRoomGuide(String roomGuide) {
		this.roomGuide = roomGuide;
	}

	public String getRoomFileName() {
		return roomFileName;
	}

	public void setRoomFileName(String roomFileName) {
		this.roomFileName = roomFileName;
	}

	public String getRoomFileRename() {
		return roomFileRename;
	}

	public void setRoomFileRename(String roomFileRename) {
		this.roomFileRename = roomFileRename;
	}

	public String getRoomFilePath() {
		return roomFilePath;
	}

	public void setRoomFilePath(String roomFilePath) {
		this.roomFilePath = roomFilePath;
	}

	public String getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}

	@Override
	public String toString() {
		return "Room [roomNo=" + roomNo + ", roomName=" + roomName + ", roomArea=" + roomArea + ", roomType=" + roomType
				+ ", roomPeople=" + roomPeople + ", roomPet=" + roomPet + ", checkIn=" + checkIn + ", checkOut="
				+ checkOut + ", roomPrice=" + roomPrice + ", roomAddress=" + roomAddress + ", roomTel=" + roomTel
				+ ", roomMap=" + roomMap + ", roomCar=" + roomCar + ", roomLocation=" + roomLocation + ", roomGuide="
				+ roomGuide + ", roomFileName=" + roomFileName + ", roomFileRename=" + roomFileRename
				+ ", roomFilePath=" + roomFilePath + ", roomStatus=" + roomStatus + "]";
	}
}
