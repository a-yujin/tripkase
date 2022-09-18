package com.tripKase.kh.storage.domain;

public class Storage {
	
	private int stoNo;
	private String stoKategorie;
	private String stoContentsId;
	private String stoContentsName;
	private String stoContentsImage;
	private String memberId;
	
	public int getStoNo() {
		return stoNo;
	}
	public void setStoNo(int stoNo) {
		this.stoNo = stoNo;
	}
	public String getStoKategorie() {
		return stoKategorie;
	}
	public void setStoKategorie(String stoKategorie) {
		this.stoKategorie = stoKategorie;
	}
	public String getStoContentsId() {
		return stoContentsId;
	}
	public void setStoContentsId(String stoContentsId) {
		this.stoContentsId = stoContentsId;
	}
	public String getStoContentsName() {
		return stoContentsName;
	}
	public void setStoContentsName(String stoContentsName) {
		this.stoContentsName = stoContentsName;
	}
	public String getStoContentsImage() {
		return stoContentsImage;
	}
	public void setStoContentsImage(String stoContentsImage) {
		this.stoContentsImage = stoContentsImage;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	@Override
	public String toString() {
		return "Storage [stoNo=" + stoNo + ", stoKategorie=" + stoKategorie + ", stoContentsId=" + stoContentsId
				+ ", stoContentsName=" + stoContentsName + ", stoContentsImage=" + stoContentsImage + ", memberId="
				+ memberId + "]";
	}
	
	
}
