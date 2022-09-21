package com.tripKase.kh.notice.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

import com.tripKase.kh.notice.domain.Notice;

public interface NoticeStore {
	// 공지 등록
	public int insertNotice(SqlSession session, Notice notice);

	// 총 게시글 수 가져오기
	public int selectTotalCount(SqlSession session);

	// 공지 목록 조회
	public List<Notice> selectAllNotice(SqlSession session, int currentPage, int noticeLimit);

	// 공지 상세 조회
	public Notice selectOneByNo(SqlSession session, Integer noticeNo);
	
}
