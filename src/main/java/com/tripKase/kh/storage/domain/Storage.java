package com.tripKase.kh.storage.domain;


public class Storage {
	
	private int stoNo;
	private String contentsCode;
	private String contentsNo;
	private String resName;
	private String resFileRename;
	private String memberId;
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
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	@Override
	public String toString() {
		return "Storage [stoNo=" + stoNo + ", contentsCode=" + contentsCode + ", contentsNo=" + contentsNo
				+ ", resName=" + resName + ", resFileRename=" + resFileRename + ", memberId=" + memberId + "]";
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
