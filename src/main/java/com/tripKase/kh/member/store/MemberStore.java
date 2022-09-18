package com.tripKase.kh.member.store;

import org.apache.ibatis.session.SqlSession;

import com.tripKase.kh.member.domain.Member;

public interface MemberStore {

	public int registerMember(SqlSession session, Member member);
	
	public Member memberLogin(SqlSession session, Member member);
	
	public Member memberOneById(SqlSession session, String memberId);
	
	public int modifyMember(SqlSession session, Member member);
	
	public int removeMember(SqlSession session,String memberId);
	
	public String findMemberId(SqlSession session, Member member);
	
	public Member findPwdMember(SqlSession session, Member member);
}
