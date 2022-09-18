package com.tripKase.kh.admin.store.logic;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.tripKase.kh.admin.domain.Report;
import com.tripKase.kh.admin.store.AdminStore;
import com.tripKase.kh.member.domain.Member;

@Repository
public class AdminStoreLogic implements AdminStore {

	@Override
	public List<Member> selectAllMember(SqlSession session) {
		List<Member> mList = session.selectList("AdminMapper.selectAllMember");
		return mList;
	}
	
	@Override
	public Member selectOneMember(SqlSession session, String memberId, String memberName) {
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("memberId", memberId);
		param.put("memberName", memberName);
		Member member = session.selectOne("AdminMapper.selectOneMember", param);
		return member;
	}
	
	@Override
	public int updateMember(SqlSession session, Member member) {
		int result = session.update("AdminMapper.updateMember", member);
		return result;
	}
	

	@Override
	public List<Report> selectAllReport(SqlSession session) {
		List<Report> rList = session.selectList("AdminMapper.selectAllReport");
		return rList;
	}



}
