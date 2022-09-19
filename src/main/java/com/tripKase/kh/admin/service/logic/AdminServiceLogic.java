package com.tripKase.kh.admin.service.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripKase.kh.admin.domain.Report;
import com.tripKase.kh.admin.service.AdminService;
import com.tripKase.kh.admin.store.AdminStore;
import com.tripKase.kh.member.domain.Member;

@Service
public class AdminServiceLogic implements AdminService {

	@Autowired
	private SqlSession session;	
	@Autowired
	private AdminStore aStore;
	
	@Override
	public List<Member> selectAllMember() {
		List<Member> mList = aStore.selectAllMember(session);
		return mList;
	}

	@Override
	public List<Report> selectAllReport() {
		List<Report> rList = aStore.selectAllReport(session);
		return rList;
	}

	@Override
	public Member selectOneMember(String memberId, String memberName) {
		Member member = aStore.selectOneMember(session, memberId, memberName);
		return member;
	}

	@Override
	public int updateMember(Member member) {
		int result = aStore.updateMember(session, member);
		return result;
	}

	@Override
	public int deleteMember(String memberId) {
		int result = aStore.deleteMember(session, memberId);
		return result;
	}
	
}
