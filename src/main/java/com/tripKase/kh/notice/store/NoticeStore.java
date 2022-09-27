package com.tripKase.kh.notice.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.tripKase.kh.admin.domain.NoticeImg;
import com.tripKase.kh.notice.domain.Notice;
import com.tripKase.kh.notice.domain.NoticeReply;

public interface NoticeStore {
	// 공지 등록
	public int insertNotice(SqlSession session, Notice notice);

	// 총 게시글 수 가져오기
	public int selectTotalCount(SqlSession session);

	// 공지 목록 조회
	public List<Notice> selectAllNotice(SqlSession session, int currentPage, int noticeLimit);

	// 공지 상세 조회
	public Notice selectOneByNo(SqlSession session, Integer noticeNo);
	// 공지 상세 - 이미지 조회
	public List<NoticeImg> selectImgByNo(SqlSession session, Integer noticeNo);

	// 공지 댓글 등록
	public int insertNReply(SqlSession session, NoticeReply nReply);

	// 공지 댓글 조회
	public List<NoticeReply> selectAllnReply(SqlSession session, Integer noticeNo);

	// 공지 댓글 삭제
	public int deleteNReply(SqlSession session, Integer nReplyNo);
	
}
