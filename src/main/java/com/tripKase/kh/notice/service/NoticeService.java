package com.tripKase.kh.notice.service;

import java.util.List;

import com.tripKase.kh.notice.domain.Notice;

public interface NoticeService {
	// 공지 등록
	public int registerNotice(Notice notice);

	// 총 게시글 수 가져오기
	public int getTotalCount();

	// 공지 목록 조회
	public List<Notice> printAllNotice(int currentPage, int noticeLimit);

	// 공지 상세 조회
	public Notice printOneByNo(Integer noticeNo);

}
