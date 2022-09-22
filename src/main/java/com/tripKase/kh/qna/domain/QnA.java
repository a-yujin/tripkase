package com.tripKase.kh.qna.domain;

import java.sql.Date;

public class QnA {
	private int questionNo; // 질문 번호
	private String questionWriter; // 질문 작성자
	private String questionType; // 질문 유형
	private String questionTitle; // 질문 제목
	private String qContents; // 질문 내용
	private Date qCreateDate; // 질문 등록일
	private String answerYN; // 답변 여부
	private String qFileName; // 질문 파일 이름
	private String qFileRename; // 질문 파일 변경된 이름
	private String qFilePath; // 질문 파일 경로
	private String answerWriter; // 답변 작성자
	private String aContents; // 답변 내용
	private Date aCreateDate; // 답변 등록일
	
	public int getQuestionNo() {
		return questionNo;
	}
	public void setQuestionNo(int questionNo) {
		this.questionNo = questionNo;
	}
	public String getQuestionWriter() {
		return questionWriter;
	}
	public void setQuestionWriter(String questionWriter) {
		this.questionWriter = questionWriter;
	}
	public String getQuestionType() {
		return questionType;
	}
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	public String getQuestionTitle() {
		return questionTitle;
	}
	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}
	public Date getqCreateDate() {
		return qCreateDate;
	}
	public void setqCreateDate(Date qCreateDate) {
		this.qCreateDate = qCreateDate;
	}
	public String getAnswerYN() {
		return answerYN;
	}
	public void setAnswerYN(String answerYN) {
		this.answerYN = answerYN;
	}
	public String getqContents() {
		return qContents;
	}
	public void setqContents(String qContents) {
		this.qContents = qContents;
	}
	public String getqFileName() {
		return qFileName;
	}
	public void setqFileName(String qFileName) {
		this.qFileName = qFileName;
	}
	public String getqFileRename() {
		return qFileRename;
	}
	public void setqFileRename(String qFileRename) {
		this.qFileRename = qFileRename;
	}
	public String getqFilePath() {
		return qFilePath;
	}
	public void setqFilePath(String qFilePath) {
		this.qFilePath = qFilePath;
	}
	public String getAnswerWriter() {
		return answerWriter;
	}
	public void setAnswerWriter(String answerWriter) {
		this.answerWriter = answerWriter;
	}
	public Date getaCreateDate() {
		return aCreateDate;
	}
	public void setaCreateDate(Date aCreateDate) {
		this.aCreateDate = aCreateDate;
	}
	public String getaContents() {
		return aContents;
	}
	public void setaContents(String aContents) {
		this.aContents = aContents;
	}
	
	@Override
	public String toString() {
		return "QnA [questionNo=" + questionNo + ", questionWriter=" + questionWriter + ", questionType=" + questionType
				+ ", questionTitle=" + questionTitle + ", qCreateDate=" + qCreateDate + ", answerYN=" + answerYN
				+ ", qContents=" + qContents + ", qFileName=" + qFileName + ", qFileRename=" + qFileRename
				+ ", qFilePath=" + qFilePath + ", answerWriter=" + answerWriter + ", aCreateDate=" + aCreateDate
				+ ", aContents=" + aContents + "]";
	}
}
