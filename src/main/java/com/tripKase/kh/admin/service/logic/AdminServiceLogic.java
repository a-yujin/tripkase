package com.tripKase.kh.admin.service.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripKase.kh.admin.domain.NoticeImg;
import com.tripKase.kh.admin.domain.Report;
import com.tripKase.kh.admin.service.AdminService;
import com.tripKase.kh.admin.store.AdminStore;
import com.tripKase.kh.grade.domain.Grade;
import com.tripKase.kh.member.domain.Member;
import com.tripKase.kh.notice.domain.Notice;
import com.tripKase.kh.notice.domain.NoticeReply;
import com.tripKase.kh.qna.domain.QnA;
import com.tripKase.kh.trip.domain.Trip;
import com.tripKase.kh.trip.domain.TripReply;

@Service
public class AdminServiceLogic implements AdminService {

	@Autowired
	private SqlSession session;	
	@Autowired
	private AdminStore aStore;
	
	@Override
	public List<Member> selectAllMember(int currentPage, int boardLimit) {
		List<Member> mList = aStore.selectAllMember(session,currentPage,boardLimit);
		return mList;
	}

	@Override
	public List<Report> selectAllReport(int currentPage, int boardLimit) {
		List<Report> rList = aStore.selectAllReport(session,currentPage,boardLimit);
		return rList;
	}
	
	@Override
	public List<QnA> selectAllQnA(int currentPage, int boardLimit) {
		List<QnA> qList = aStore.selectAllQnA(session,currentPage,boardLimit);
		return qList;
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

	@Override
	public Report selectOneReport(int reportNo) {
		Report report = aStore.selectOneReport(session, reportNo);
		return report;
	}

	@Override
	public int deleteReport(Integer reportNo) {
		int result = aStore.deleteReport(session, reportNo);
		return result;
	}

	@Override
	public Trip selectTripByNo(int cotentsNo) {
		Trip trip = aStore.selectTripByNo(session, cotentsNo);
		return trip;
	}

	@Override
	public TripReply selectTripRelyByNo(int cotentsNo) {
		TripReply tripReply = aStore.selectTripRelyByNo(session, cotentsNo);
		return tripReply;
	}

	@Override
	public NoticeReply selectNoticeReplyByNo(int cotentsNo) {
		NoticeReply noticeReply = aStore.selectNoticeReplyByNo(session, cotentsNo);
		return noticeReply;
	}

	@Override
	public Grade selectGradeByNo(int cotentsNo) {
		Grade grade = aStore.selectGradeByNo(session, cotentsNo);
		return grade;
	}

	@Override
	public int deleteTripByNo(Integer tripNo) {
		int result = aStore.deleteTripByNo(session, tripNo);
		return result;
	}

	@Override
	public int deleteTripReplyByNo(Integer tReplyNo) {
		int result = aStore.deleteTripReplyByNo(session, tReplyNo);
		return result;
	}

	@Override
	public int deleteNoticeReplyByNo(Integer nReplyNo) {
		int result = aStore.deleteNoticeReplyByNo(session, nReplyNo);
		return result;
	}

	@Override
	public int deleteGradeByNo(Integer gradeNo) {
		int result = aStore.deleteGradeByNo(session, gradeNo);
		return result;
	}

	@Override
	public int getMemberTotalCount() {
		int result = aStore.getMemberTotalCount(session);
		return result;
	}

	@Override
	public int getReportTotalCount() {
		int result = aStore.getReportTotalCount(session);
		return result;
	}
	
	@Override
	public int getTotalQnACount() {
		int result = aStore.getTotalQnACount(session);
		return result;
	}

	@Override
	public int registerNotice(Notice notice) {
		int result = aStore.registerNotice(session,notice);
		return result;
	}

	@Override
	public Notice noticeDetail(int noticeNo) {
		Notice notice = aStore.noticeDetail(session, noticeNo);
		return notice;
	}

	@Override
	public int registerNoticeImg(NoticeImg noticeImg) {
		int result = aStore.registerNoticeImg(session,noticeImg);
		return result;
	}

	@Override
	public List<NoticeImg> noticeImgDetail(int noticeNo) {
		List<NoticeImg> niList = aStore.noticeImgDetail(session, noticeNo);
		return niList;
	}

	@Override
	public int updateNotice(Notice notice) {
		int result = aStore.updateNotice(session,notice);
		return result;
	}

	@Override
	public int updateNoticeImg(NoticeImg noticeImg) {
		int result = aStore.updateNoticeImg(session,noticeImg);
		return result;
	}

	@Override
	public int deleteNotice(int noticeNo) {
		int result = aStore.deleteNotice(session, noticeNo);
		return result;
	}

	@Override
	public QnA selectOneQnA(int qnaNo) {
		QnA qna = aStore.selectOneQnA(session, qnaNo);
		return qna;
	}

	@Override
	public int registerAnswer(QnA qna) {
		int result = aStore.registerAnswer(session, qna);
		return result;
	}


	
}
