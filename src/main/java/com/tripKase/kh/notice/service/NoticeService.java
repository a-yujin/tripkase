package com.tripKase.kh.notice.service;

import java.util.List;

import com.tripKase.kh.admin.domain.NoticeImg;
import com.tripKase.kh.notice.domain.Notice;
import com.tripKase.kh.notice.domain.NoticeReply;

public interface NoticeService {
	// 총 게시글 수 가져오기
	public int getTotalCount();

	// 공지 목록 조회
	public List<Notice> printAllNotice(int currentPage, int noticeLimit);

	// 공지 상세 조회
	public Notice printOneByNo(Integer noticeNo);
	// 공지 상세 - 이미지 조회
	public List<NoticeImg> printImgByNo(Integer noticeNo);

	// 공지 댓글 등록
	public int registerNReply(NoticeReply nReply);

	// 공지 댓글 조회
	public List<NoticeReply> printAllnReply(Integer noticeNo);

	// 공지 댓글 삭제
	public int deleteNReply(Integer nReplyNo);

}
