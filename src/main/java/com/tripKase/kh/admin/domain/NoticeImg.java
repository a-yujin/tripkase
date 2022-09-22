package com.tripKase.kh.admin.domain;

public class NoticeImg {
	private int imgNo;
	private int noticeNo;
	private String nFileName;
	private String nFileRename;
	private String nFilePath;
	
	public int getImgNo() {
		return imgNo;
	}
	public void setImgNo(int imgNo) {
		this.imgNo = imgNo;
	}
	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	public String getnFileName() {
		return nFileName;
	}
	public void setnFileName(String nFileName) {
		this.nFileName = nFileName;
	}
	public String getnFileRename() {
		return nFileRename;
	}
	public void setnFileRename(String nFileRename) {
		this.nFileRename = nFileRename;
	}
	public String getnFilePath() {
		return nFilePath;
	}
	public void setnFilePath(String nFilePath) {
		this.nFilePath = nFilePath;
	}
	
	@Override
	public String toString() {
		return "NoticeImg [imgNo=" + imgNo + ", noticeNo=" + noticeNo + ", nFileName=" + nFileName + ", nFileRename="
				+ nFileRename + ", nFilePath=" + nFilePath + "]";
	}
	
	
}
