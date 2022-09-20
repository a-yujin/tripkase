package com.tripKase.kh.member.store;

import org.apache.ibatis.session.SqlSession;

import com.tripKase.kh.member.domain.Member;

public interface MemberStore {

	public int registerMember(SqlSession session, Member member);
	
	public Member memberLogin(SqlSession session, Member member);
	
	public Member memberOneById(SqlSession session, String memberId);
	
	public int modifyMember(SqlSession session, Member member);
	
	public int removeMember(SqlSession session,String memberId);
	
	public Member findMemberId(SqlSession session, String memberName, String memberEmail);
	
	public Member findPwdMember(SqlSession session, String memberId, String memberEmail);
	
}
