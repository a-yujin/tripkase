package com.tripKase.kh.notice.store.logic;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.tripKase.kh.notice.domain.Notice;
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
	public int selectTotalCount(SqlSessionTemplate session) {
		int totalCount = session.selectOne("NoticeMapper.selectTotalCount");
		return 0;
	}

	// 공지 목록 조회
	@Override
	public List<Notice> selectAllNotice(SqlSessionTemplate session, int currentPage, int noticeLimit) {
		int offset = (currentPage-1)*noticeLimit;
		RowBounds rowBounds = new RowBounds(offset, noticeLimit);
		List<Notice> nList = session.selectList("NoticeMapper.selectAllNotice", null, rowBounds);
		return nList;
	}

}