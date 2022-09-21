package com.tripKase.kh.admin.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.tripKase.kh.admin.domain.NoticeImg;
import com.tripKase.kh.admin.domain.Report;
import com.tripKase.kh.grade.domain.Grade;
import com.tripKase.kh.member.domain.Member;
import com.tripKase.kh.notice.domain.Notice;
import com.tripKase.kh.notice.domain.NoticeReply;
import com.tripKase.kh.trip.domain.Trip;
import com.tripKase.kh.trip.domain.TripReply;

public interface AdminStore {

	List<Member> selectAllMember(SqlSession session,int currentPage, int boardLimit);

	List<Report> selectAllReport(SqlSession session,int currentPage, int boardLimit);

	Member selectOneMember(SqlSession session, String memberId, String memberName);

	int updateMember(SqlSession session, Member member);

	int deleteMember(SqlSession session, String memberId);

	Report selectOneReport(SqlSession session, int reportNo);

	int deleteReport(SqlSession session, Integer reportNo);

	Trip selectTripByNo(SqlSession session, int cotentsNo);

	TripReply selectTripRelyByNo(SqlSession session, int cotentsNo);

	NoticeReply selectNoticeReplyByNo(SqlSession session, int cotentsNo);

	Grade selectGradeByNo(SqlSession session, int cotentsNo);

	int deleteTripByNo(SqlSession session, Integer tripNo);

	int deleteTripReplyByNo(SqlSession session, Integer tReplyNo);

	int deleteNoticeReplyByNo(SqlSession session, Integer nReplyNo);

	int deleteGradeByNo(SqlSession session, Integer gradeNo);

	int getMemberTotalCount(SqlSession session);

	int getReportTotalCount(SqlSession session);

	int registerNotice(SqlSession session, Notice notice);

	Notice noticeDetail(SqlSession session, int noticeNo);

	List<NoticeImg> noticeImgDetail(SqlSession session, int noticeNo);

	int registerNoticeImg(SqlSession session, NoticeImg noticeImg);

	int updateNotice(SqlSession session, Notice notice);

	int updateNoticeImg(SqlSession session, NoticeImg noticeImg);
}
