package com.tripKase.kh.room.domain;

public class RoomJoin {
	private int roomImgNo;
	private int roomNo; // 숙소 순번
	private String roomType; // 숙소 종류 (전체,모텔,호텔,펜션,리조트)
	private String roomArea; // 숙소 지역(전체,서울,경기도,인천 등)
	private String roomName; // 숙소 이름
	private String roomAddress; // 숙소 주소
	private String roomPrice; // 숙소 가격
	private String roomTel; // 숙소 전화번호
	private int roomPerson; // 숙소 인원 (입실가능 인원)
	private String roomPet; // 반려견 동반여부
	private String roomCar; // 숙소 주차 정보
	private String roomLocation; // 숙소 오시는길
	private String roomGuide; // 객실 정보
	private String roomStatus; // 숙소 게시여부
	private String roomFileName;
	private String roomFileRename;
	private String roomFilePath;
	
	public RoomJoin() {}

	public RoomJoin(int roomImgNo, int roomNo, String roomType, String roomArea, String roomName, String roomAddress,
			String roomPrice, String roomTel, int roomPerson, String roomPet, String roomCar, String roomLocation,
			String roomGuide, String roomStatus, String roomFileName, String roomFileRename, String roomFilePath) {
		super();
		this.roomImgNo = roomImgNo;
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.roomArea = roomArea;
		this.roomName = roomName;
		this.roomAddress = roomAddress;
		this.roomPrice = roomPrice;
		this.roomTel = roomTel;
		this.roomPerson = roomPerson;
		this.roomPet = roomPet;
		this.roomCar = roomCar;
		this.roomLocation = roomLocation;
		this.roomGuide = roomGuide;
		this.roomStatus = roomStatus;
		this.roomFileName = roomFileName;
		this.roomFileRename = roomFileRename;
		this.roomFilePath = roomFilePath;
	}

	public int getRoomImgNo() {
		return roomImgNo;
	}

	public void setRoomImgNo(int roomImgNo) {
		this.roomImgNo = roomImgNo;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getRoomArea() {
		return roomArea;
	}

	public void setRoomArea(String roomArea) {
		this.roomArea = roomArea;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getRoomAddress() {
		return roomAddress;
	}

	public void setRoomAddress(String roomAddress) {
		this.roomAddress = roomAddress;
	}

	public String getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(String roomPrice) {
		this.roomPrice = roomPrice;
	}

	public String getRoomTel() {
		return roomTel;
	}

	public void setRoomTel(String roomTel) {
		this.roomTel = roomTel;
	}

	public int getRoomPerson() {
		return roomPerson;
	}

	public void setRoomPerson(int roomPerson) {
		this.roomPerson = roomPerson;
	}

	public String getRoomPet() {
		return roomPet;
	}

	public void setRoomPet(String roomPet) {
		this.roomPet = roomPet;
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

	public String getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
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

	@Override
	public String toString() {
		return "RoomJoin [roomImgNo=" + roomImgNo + ", roomNo=" + roomNo + ", roomType=" + roomType + ", roomArea="
				+ roomArea + ", roomName=" + roomName + ", roomAddress=" + roomAddress + ", roomPrice=" + roomPrice
				+ ", roomTel=" + roomTel + ", roomPerson=" + roomPerson + ", roomPet=" + roomPet + ", roomCar="
				+ roomCar + ", roomLocation=" + roomLocation + ", roomGuide=" + roomGuide + ", roomStatus=" + roomStatus
				+ ", roomFileName=" + roomFileName + ", roomFileRename=" + roomFileRename + ", roomFilePath="
				+ roomFilePath + "]";
	}
}
