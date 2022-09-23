package com.tripKase.kh.storage.domain;


public class Storage {
	
	private int stoNo;
	private String contentsCode;
	private String contentsNo;
	private String resName;
	private String resFilepath;
	private String attrName;
	private String attrFilePath;
	private String roomName;
	private String roomFilePath;
	private String memberId;
	

	public Storage(int stoNo, String contentsCode, String contentsNo, String resName, String resFilepath,
			String attrName, String attrFilePath, String roomName, String roomFilePath, String memberId) {
		super();
		this.stoNo = stoNo;
		this.contentsCode = contentsCode;
		this.contentsNo = contentsNo;
		this.resName = resName;
		this.resFilepath = resFilepath;
		this.attrName = attrName;
		this.attrFilePath = attrFilePath;
		this.roomName = roomName;
		this.roomFilePath = roomFilePath;
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
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getResFilepath() {
		return resFilepath;
	}
	public void setResFilepath(String resFilepath) {
		this.resFilepath = resFilepath;
	}
	public String getAttrName() {
		return attrName;
	}
	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}
	public String getAttrFilePath() {
		return attrFilePath;
	}
	public void setAttrFilePath(String attrFilePath) {
		this.attrFilePath = attrFilePath;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getRoomFilePath() {
		return roomFilePath;
	}
	public void setRoomFilePath(String roomFilePath) {
		this.roomFilePath = roomFilePath;
	}
	@Override
	public String toString() {
		return "Storage [stoNo=" + stoNo + ", contentsCode=" + contentsCode + ", contentsNo=" + contentsNo
				+ ", resName=" + resName + ", resFilepath=" + resFilepath + ", attrName=" + attrName + ", attrFilePath="
				+ attrFilePath + ", roomName=" + roomName + ", roomFilePath=" + roomFilePath + ", memberId=" + memberId
				+ "]";
	}
	

}














//package com.tripKase.kh.storage.domain;
//
//public class Storage {
//	
//	private int stoNo;
//	private String contentsCode;
//	private String contentsId;
//	private String memberId;
//	
//	public int getStoNo() {
//		return stoNo;
//	}
//	public void setStoNo(int stoNo) {
//		this.stoNo = stoNo;
//	}
//	public String getContentsCode() {
//		return contentsCode;
//	}
//	public void setContentsCode(String contentsCode) {
//		this.contentsCode = contentsCode;
//	}
//	public String getContentsId() {
//		return contentsId;
//	}
//	public void setContentsId(String contentsId) {
//		this.contentsId = contentsId;
//	}
//	public String getMemberId() {
//		return memberId;
//	}
//	public void setMemberId(String memberId) {
//		this.memberId = memberId;
//	}
//	
//	
//	@Override
//	public String toString() {
//		return "Storage [stoNo=" + stoNo + ", contentsCode=" + contentsCode + ", contentsId=" + contentsId
//				+ ", memberId=" + memberId + "]";
//	}
//	
//}
