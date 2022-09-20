package com.tripKase.kh.member.domain;

import java.sql.Date;

public class Member {

	private String memberId;		// 회원 아이디
	private String memberPwd;		// 회원 비밀번호
	private String memberEmail;		// 회원 이메일
	private String memberName;		// 회원 이름
	private String memberNick;		// 회원 닉네임
	private String memberBd;		// 회원 생년월일
	private String memberGrade;		// 회원 등급
	private String memberGender;	// 회원 성별
	private String memberPhone;		// 회원 연락처
	private String mPfpName;		// 회원 프로필 사진 이름
	private String mPfpReName;		// 회원 프로필 사진 이름2
	private String mPfpPath;		// 회원 프포필 사진 경로
	private Date mRegisterDate;		// 회원 가입 날짜
	private String mStatus;			// 회원 상태
	private String adminYN;			// 관리자 상태
	
	
	public Member(String memberId, String memberPwd) {
		super();
		this.memberId = memberId;
		this.memberPwd = memberPwd;
	}
	
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPwd() {
		return memberPwd;
	}
	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberNick() {
		return memberNick;
	}
	public void setMemberNick(String memberNick) {
		this.memberNick = memberNick;
	}
	public String getMemberBd() {
		return memberBd;
	}
	public void setMemberBd(String memberBd) {
		this.memberBd = memberBd;
	}
	public String getMemberGrade() {
		return memberGrade;
	}
	public void setMemberGrade(String memberGrade) {
		this.memberGrade = memberGrade;
	}
	public String getMemberGender() {
		return memberGender;
	}
	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public String getmPfpName() {
		return mPfpName;
	}
	public void setmPfpName(String mPfpName) {
		this.mPfpName = mPfpName;
	}
	public String getmPfpReName() {
		return mPfpReName;
	}
	public void setmPfpReName(String mPfpReName) {
		this.mPfpReName = mPfpReName;
	}
	public String getmPfpPath() {
		return mPfpPath;
	}
	public void setmPfpPath(String mPfpPath) {
		this.mPfpPath = mPfpPath;
	}
	public Date getmRegisterDate() {
		return mRegisterDate;
	}
	public void setmRegisterDate(Date mRegisterDate) {
		this.mRegisterDate = mRegisterDate;
	}
	public String getmStatus() {
		return mStatus;
	}
	public void setmStatus(String mStatus) {
		this.mStatus = mStatus;
	}
	public String getAdminYN() {
		return adminYN;
	}
	public void setAdminYN(String adminYN) {
		this.adminYN = adminYN;
	}
	
	
	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberPwd=" + memberPwd + ", memberEmail=" + memberEmail
				+ ", memberName=" + memberName + ", memberNick=" + memberNick + ", memberBd=" + memberBd
				+ ", memberGrade=" + memberGrade + ", memberGender=" + memberGender + ", memberPhone=" + memberPhone
				+ ", mPfpName=" + mPfpName + ", mPfpReName=" + mPfpReName + ", mPfpPath=" + mPfpPath
				+ ", mRegisterDate=" + mRegisterDate + ", mStatus=" + mStatus + ", adminYN=" + adminYN + "]";
	}
}
