package com.tripKase.kh.admin.service;

import java.util.List;

import com.tripKase.kh.admin.domain.Report;
import com.tripKase.kh.member.domain.Member;

public interface AdminService {

	List<Member> selectAllMember();

	List<Report> selectAllReport();

	Member selectOneMember(String memberId, String memberName);

	int updateMember(Member member);

}
