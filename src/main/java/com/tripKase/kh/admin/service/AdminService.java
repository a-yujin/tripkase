package com.tripKase.kh.admin.service;

import java.util.List;

import com.tripKase.kh.admin.domain.Report;
import com.tripKase.kh.grade.domain.Grade;
import com.tripKase.kh.member.domain.Member;
import com.tripKase.kh.notice.domain.Notice;
import com.tripKase.kh.notice.domain.NoticeReply;
import com.tripKase.kh.trip.domain.Trip;
import com.tripKase.kh.trip.domain.TripReply;

public interface AdminService {

	List<Member> selectAllMember(int currentPage, int limit);

	List<Report> selectAllReport(int currentPage, int limit);

	Member selectOneMember(String memberId, String memberName);

	int updateMember(Member member);

	int deleteMember(String memberId);

	Report selectOneReport(int reportNo);

	int deleteReport(Integer reportNo);

	Trip selectTripByNo(int cotentsNo);

	TripReply selectTripRelyByNo(int cotentsNo);

	NoticeReply selectNoticeReplyByNo(int cotentsNo);

	Grade selectGradeByNo(int cotentsNo);

	int deleteTripByNo(Integer tripNo);

	int deleteTripReplyByNo(Integer tReplyNo);

	int deleteNoticeReplyByNo(Integer qReplyNo);

	int deleteGradeByNo(Integer gradeNo);

	int getMemberTotalCount();

	int getReportTotalCount();

	int registerNotice(Notice notice);

	Notice noticeDetail(int noticeNo);

}
