package com.tripKase.kh.storage.domain;


public class Storage {
	
	private int stoNo;
	private String contentsCode;
	private String contentsNo;
	private String resName;
	private String resFileRename;
	private String attrName;
	private String attrFileRename;
	private String roomName;
	private String roomFileRename;
	private String memberId;
	
	public Storage() {}

	public Storage(int stoNo, String contentsCode, String contentsNo, String resName, String resFileRename,
			String attrName, String attrFileRename, String roomName, String roomFileRename, String memberId) {
		super();
		this.stoNo = stoNo;
		this.contentsCode = contentsCode;
		this.contentsNo = contentsNo;
		this.resName = resName;
		this.resFileRename = resFileRename;
		this.attrName = attrName;
		this.attrFileRename = attrFileRename;
		this.roomName = roomName;
		this.roomFileRename = roomFileRename;
		this.memberId = memberId;
	}

	public int getStoNo() {
		return stoNo;
	}

	public void setStoNo(int stoNo) {
		this.stoNo = stoNo;
	}

	public String getContentsCode() {
		return contentsCode;
	}

	public void setContentsCode(String contentsCode) {
		this.contentsCode = contentsCode;
	}

	public String getContentsNo() {
		return contentsNo;
	}

	public void setContentsNo(String contentsNo) {
		this.contentsNo = contentsNo;
	}

	public String getResName() {
		return resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public String getResFileRename() {
		return resFileRename;
	}

	public void setResFileRename(String resFileRename) {
		this.resFileRename = resFileRename;
	}

	public String getAttrName() {
		return attrName;
	}

	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}

	public String getAttrFileRename() {
		return attrFileRename;
	}

	public void setAttrFileRename(String attrFileRename) {
		this.attrFileRename = attrFileRename;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getRoomFileRename() {
		return roomFileRename;
	}

	public void setRoomFileRename(String roomFileRename) {
		this.roomFileRename = roomFileRename;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	@Override
	public String toString() {
		return "Storage [stoNo=" + stoNo + ", contentsCode=" + contentsCode + ", contentsNo=" + contentsNo
				+ ", resName=" + resName + ", resFileRename=" + resFileRename + ", attrName=" + attrName
				+ ", attrFileRename=" + attrFileRename + ", roomName=" + roomName + ", roomFileRename=" + roomFileRename
				+ ", memberId=" + memberId + "]";
	}
	
	

}
