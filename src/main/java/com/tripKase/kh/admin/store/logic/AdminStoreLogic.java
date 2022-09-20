package com.tripKase.kh.admin.store.logic;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.tripKase.kh.admin.domain.Report;
import com.tripKase.kh.admin.store.AdminStore;
import com.tripKase.kh.grade.domain.Grade;
import com.tripKase.kh.member.domain.Member;
import com.tripKase.kh.notice.domain.Notice;
import com.tripKase.kh.notice.domain.NoticeReply;
import com.tripKase.kh.trip.domain.Trip;
import com.tripKase.kh.trip.domain.TripReply;

@Repository
public class AdminStoreLogic implements AdminStore {

	@Override
	public List<Member> selectAllMember(SqlSession session, int currentPage, int limit) {
		int offset = (currentPage-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Member> mList = session.selectList("AdminMapper.selectAllMember", null, rowBounds);
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
	public int deleteMember(SqlSession session, String memberId) {
		int result = session.update("AdminMapper.deleteMember", memberId);
		return result;
	}
	
	@Override
	public List<Report> selectAllReport(SqlSession session,int currentPage, int limit) {
		int offset = (currentPage-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Report> rList = session.selectList("AdminMapper.selectAllReport",null,rowBounds);
		return rList;
	}

	@Override
	public Report selectOneReport(SqlSession session, int reportNo) {
		Report report = session.selectOne("AdminMapper.selectOneReport", reportNo);
		return report;
	}


	@Override
	public Trip selectTripByNo(SqlSession session, int cotentsNo) {
		Trip trip = session.selectOne("AdminMapper.selectTripByNo", cotentsNo);
		return trip;
	}


	@Override
	public TripReply selectTripRelyByNo(SqlSession session, int cotentsNo) {
		TripReply tripReply = session.selectOne("AdminMapper.selectTripRelyByNo", cotentsNo);
		return tripReply;
	}


	@Override
	public NoticeReply selectNoticeReplyByNo(SqlSession session, int cotentsNo) {
		NoticeReply noticeReply = session.selectOne("AdminMapper.selectNoticeReplyByNo", cotentsNo);
		return noticeReply;
	}

	@Override
	public Grade selectGradeByNo(SqlSession session, int cotentsNo) {
		Grade grade = session.selectOne("AdminMapper.selectGradeByNo", cotentsNo);
		return grade;
	}
	
	@Override
	public int deleteReport(SqlSession session, Integer reportNo) {
		int result = session.delete("AdminMapper.deleteReport",reportNo);
		return result;
	}

	@Override
	public int deleteTripByNo(SqlSession session, Integer tripNo) {
		int result = session.delete("AdminMapper.deleteTripByNo",tripNo);
		return result;
	}

	@Override
	public int deleteTripReplyByNo(SqlSession session, Integer tReplyNo) {
		int result = session.delete("AdminMapper.deleteTripReplyByNo",tReplyNo);
		return result;
	}

	@Override
	public int deleteNoticeReplyByNo(SqlSession session, Integer nReplyNo) {
		int result = session.delete("AdminMapper.deleteNoticeReplyByNo",nReplyNo);
		return result;
	}

	@Override
	public int deleteGradeByNo(SqlSession session, Integer gradeNo) {
		int result = session.delete("AdminMapper.deleteGradeByNo",gradeNo);
		return result;
	}

	@Override
	public int getMemberTotalCount(SqlSession session) {
		int result = session.selectOne("AdminMapper.getMemberTotalCount");
		return result;
	}

	@Override
	public int getReportTotalCount(SqlSession session) {
		int result = session.selectOne("AdminMapper.getReportTotalCount");
		return result;
	}

	@Override
	public int registerNotice(SqlSession session, Notice notice) {
		int result = session.insert("AdminMapper.registerNotice",notice);
		return result;
	}

	@Override
	public Notice noticeDetail(SqlSession session, int noticeNo) {
		Notice notice = session.selectOne("AdminMapper.noticeDetail", noticeNo);
		return notice;
	}
}
