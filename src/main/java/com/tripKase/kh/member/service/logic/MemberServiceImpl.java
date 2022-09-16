package com.tripKase.kh.member.service.logic;

import org.mybatis.spring.SqlSessionTemplate;

import com.tripKase.kh.member.domain.Member;
import com.tripKase.kh.member.service.MemberService;
import com.tripKase.kh.member.store.MemberStore;

public class MemberServiceImpl implements MemberService {

	private MemberStore mStore;
	private SqlSessionTemplate session;
	
	@Override
	public int registMember(Member member) {
		int result = mStore.registerMember(session, member);
		return result;
	}

}
