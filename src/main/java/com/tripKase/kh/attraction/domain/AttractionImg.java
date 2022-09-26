package com.tripKase.kh.attraction.domain;

public class AttractionImg {
	private int attrImgNo; // 관광지 사진 번호
	private int refAttrNo; // 참고 관광지 번호
	private String attrFileName; // 관광지 사진 파일 이름
	private String attrFileRename; // 관광지 사진 파일 변경된 이름
	private String attrFilePath; // 관광지 사진 파일 경로
	
	public int getAttrImgNo() {
		return attrImgNo;
	}
	public void setAttrImgNo(int attrImgNo) {
		this.attrImgNo = attrImgNo;
	}
	public int getRefAttrNo() {
		return refAttrNo;
	}
	public void setRefAttrNo(int refAttrNo) {
		this.refAttrNo = refAttrNo;
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
	
	@Override
	public String toString() {
		return "AttractionImg [attrImgNo=" + attrImgNo + ", refAttrNo=" + refAttrNo + ", attrFileName=" + attrFileName
				+ ", attrFileRename=" + attrFileRename + ", attrFilePath=" + attrFilePath + "]";
	}
}
