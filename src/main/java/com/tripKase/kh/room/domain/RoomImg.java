package com.tripKase.kh.room.domain;

public class RoomImg {
	private int roomImgNo;
	private int roomNo;
	private String roomFileName;
	private String roomFileRename;
	private String roomFilePath;
	
	public RoomImg() {}

	public RoomImg(int roomImgNo, int roomNo, String roomFileName, String roomFileRename, String roomFilePath) {
		super();
		this.roomImgNo = roomImgNo;
		this.roomNo = roomNo;
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
		return "RoomImg [roomImgNo=" + roomImgNo + ", roomNo=" + roomNo + ", roomFileName=" + roomFileName
				+ ", roomFileRename=" + roomFileRename + ", roomFilePath=" + roomFilePath + "]";
	}
}
