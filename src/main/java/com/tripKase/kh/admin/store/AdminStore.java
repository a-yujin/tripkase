package com.tripKase.kh.admin.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.tripKase.kh.admin.domain.Report;
import com.tripKase.kh.member.domain.Member;

public interface AdminStore {

	List<Member> selectAllMember(SqlSession session);

	List<Report> selectAllReport(SqlSession session);

	Member selectOneMember(SqlSession session, String memberId, String memberName);

}
