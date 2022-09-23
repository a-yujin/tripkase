package com.tripKase.kh.notice.store.logic;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.tripKase.kh.admin.domain.NoticeImg;
import com.tripKase.kh.notice.domain.Notice;
import com.tripKase.kh.notice.domain.NoticeReply;
import com.tripKase.kh.notice.store.NoticeStore;

@Repository
public class NoticeStoreLogic implements NoticeStore {
	// 공지 등록
	@Override
	public int insertNotice(SqlSession session, Notice notice) {
		int result = session.insert("NoticeMapper.insertNotice", notice);
		return result;
	}

	// 총 게시글 수 가져오기
	@Override
	public int selectTotalCount(SqlSession session) {
		int totalCount = session.selectOne("NoticeMapper.selectTotalCount");
		return totalCount;
	}

	// 공지 목록 조회
	@Override
	public List<Notice> selectAllNotice(SqlSession session, int currentPage, int noticeLimit) {
		int offset = (currentPage-1)*noticeLimit;
		RowBounds rowBounds = new RowBounds(offset, noticeLimit);
		List<Notice> nList = session.selectList("NoticeMapper.selectAllNotice", null, rowBounds);
		return nList;
	}

	// 공지 상세 조회
	@Override
	public Notice selectOneByNo(SqlSession session, Integer noticeNo) {
		Notice notice = session.selectOne("NoticeMapper.selectOneByNo", noticeNo);
		return notice;
	}
	// 공지 상세 이미지 조회
	@Override
	public List<NoticeImg> selectImgByNo(SqlSession session, Integer noticeNo) {
		List<NoticeImg> nImgList = session.selectList("NoticeMapper.selectImgByNo", noticeNo);
		return nImgList;
	}

	// 공지 댓글 등록
	@Override
	public int insertNReply(SqlSession session, NoticeReply nReply) {
		int result = session.insert("NoticeMapper.insertNReply", nReply);
		return result;
	}

}