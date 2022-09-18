package com.tripKase.kh.member.store.logic;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.tripKase.kh.member.domain.Member;
import com.tripKase.kh.member.store.MemberStore;

@Repository
public class MemberStoreLogic implements MemberStore {

	@Override
	public int registerMember(SqlSession session, Member member) {
		int result = session.insert("MemberMapper.registerMember", member); 
		return result;
	}

	@Override
	public Member memberLogin(SqlSession session, Member member) {
		Member mOne = session.selectOne("MemberMapper.selectLoingMember", member);
		return mOne;
	}

	@Override
	public Member memberOneById(SqlSession session, String memberId) {
		Member mOne = session.selectOne("MemberMapper.selectOneMemberById", memberId);
		return mOne;
	}

	@Override
	public int modifyMember(SqlSession session, Member member) {
		int result = session.update("MemberMapper.updateMember", member);
		return result;
	}

	@Override
	public int removeMember(SqlSession session, String memberId) {
		int result = session.delete("MemberMapper.removeMember", memberId);
		return result;
	}

	@Override
	public String findMemberId(SqlSession session, Member member) {
		String result = session.selectOne("MemberMapper.findMemberId", member);
		return result;
	}

	@Override
	public Member findPwdMember(SqlSession session, Member member) {
		Member mOne = session.selectOne("MemberMapper.findMemberPwd", member);
		return mOne;
	}



}
