package com.tripKase.kh.member.service.logic;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripKase.kh.member.domain.Member;
import com.tripKase.kh.member.service.MemberService;
import com.tripKase.kh.member.store.MemberStore;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberStore mStore;
	@Autowired
	private SqlSession session;
	
	@Override
	public int registMember(Member member) {
		int result = mStore.registerMember(session, member);
		return result;
	}

	@Override
	public Member loginMember(Member member) {
		Member mOne = mStore.memberLogin(session, member);
		return mOne;
	}

	@Override
	public Member memberOneById(String memberId) {
		Member mOne = mStore.memberOneById(session, memberId);
		return mOne;
	}

	@Override
	public int modifyMember(Member member) {
		int result = mStore.modifyMember(session, member);
		return result;
	}

	@Override
	public int removeMember(String memberId) {
		int result = mStore.removeMember(session, memberId);
		return result;
	}

	@Override
	public String findIdMember(Member member) {
		String result = mStore.findMemberId(session, member);
		return result;
	}

	@Override
	public Member findPwdMember(Member member) {
		Member mOne = mStore.findPwdMember(session, member);
		return mOne;
	}



}
