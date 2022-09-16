package com.tripKase.kh.member.store.logic;

import org.apache.ibatis.session.SqlSession;

import com.tripKase.kh.member.domain.Member;
import com.tripKase.kh.member.store.MemberStore;

public class MemberStoreLogic implements MemberStore {

	@Override
	public int registerMember(SqlSession session, Member member) {
		int result = session.insert("MemberMapper.registerMember", member); 
		return result;
	}

}
