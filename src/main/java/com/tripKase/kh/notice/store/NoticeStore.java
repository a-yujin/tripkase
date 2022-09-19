package com.tripKase.kh.notice.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

import com.tripKase.kh.notice.domain.Notice;

public interface NoticeStore {
	// 공지 등록
	public int insertNotice(SqlSession session, Notice notice);

	// 총 게시글 수 가져오기
	public int selectTotalCount(SqlSessionTemplate session);

	// 공지 목록 조회
	public List<Notice> selectAllNotice(SqlSessionTemplate session, int currentPage, int noticeLimit);
	
}
