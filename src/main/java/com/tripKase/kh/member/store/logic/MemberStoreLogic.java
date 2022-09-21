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
		Member mOne = session.selectOne("MemberMapper.selectLoginMember", member);
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
	public Member findMemberId(SqlSession session, String memberName, String memberEmail) {
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("memberName", memberName);
		param.put("memberEmail", memberEmail);
		Member result = session.selectOne("MemberMapper.findMemberId", param );
		return result;
	}

	@Override
	public Member findPwdMember(SqlSession session, String memberId, String memberEmail) {
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("memberId", memberId);
		param.put("memberEmail", memberEmail);
		Member member = session.selectOne("MemberMapper.findMemberPwd", param);
		return member;
	}

	@Override
	public int countPost(SqlSession session, String memberNick) {
		int countpost = session.selectOne("MemberMapper.countPost", memberNick);
		return countpost;
	}
}














