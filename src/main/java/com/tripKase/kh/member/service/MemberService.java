package com.tripKase.kh.member.service;

import com.tripKase.kh.member.domain.Member;

public interface MemberService {

	public int registMember(Member member);
	
	public Member loginMember(Member member);
	
	public Member memberOneById(String memberId);
	
	public int modifyMember(Member member);
	
	public int removeMember(String memberId);
	
	public String findIdMember(Member member);
	
	public Member findPwdMember(Member member);
	

}
