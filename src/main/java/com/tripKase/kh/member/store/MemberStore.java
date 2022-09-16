package com.tripKase.kh.member.store;

import org.apache.ibatis.session.SqlSession;

import com.tripKase.kh.member.domain.Member;

public interface MemberStore {

	public int registerMember(SqlSession session, Member member);
}
