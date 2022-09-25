package com.tripKase.kh.notice.service.logic;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripKase.kh.admin.domain.NoticeImg;
import com.tripKase.kh.notice.domain.Notice;
import com.tripKase.kh.notice.domain.NoticeReply;
import com.tripKase.kh.notice.service.NoticeService;
import com.tripKase.kh.notice.store.NoticeStore;

@Service
public class NoticeServiceImpl implements NoticeService{
	@Autowired
	private SqlSessionTemplate session;
	
	@Autowired
	private NoticeStore nStore;

	// 공지 등록
	@Override
	public int registerNotice(Notice notice) {
		int result = nStore.insertNotice(session, notice);
		return result;
	}

	// 총 게시글 수 가져오기
	@Override
	public int getTotalCount() {
		int totalCount = nStore.selectTotalCount(session);
		return totalCount;
	}
	
	// 공지 목록 조회
	@Override
	public List<Notice> printAllNotice(int currentPage, int noticeLimit) {
		List<Notice> nList = nStore.selectAllNotice(session, currentPage, noticeLimit);
		return nList;
	}

	// 공지 상세 조회
	@Override
	public Notice printOneByNo(Integer noticeNo) {
		Notice notice = nStore.selectOneByNo(session, noticeNo);
		return notice;
	}
	// 공지 상세 - 이미지 조회
	@Override
	public List<NoticeImg> printImgByNo(Integer noticeNo) {
		List<NoticeImg> nImgList = nStore.selectImgByNo(session, noticeNo);
		return nImgList;
	}

	// 공지 댓글 등록
	@Override
	public int registerNReply(NoticeReply nReply) {
		int result = nStore.insertNReply(session, nReply);
		return result;
	}

	// 공지 댓글 조회
	@Override
	public List<NoticeReply> printAllnReply(Integer noticeNo) {
		List<NoticeReply> nReplyList = nStore.selectAllnReply(session, noticeNo);
		return nReplyList;
	}

	// 공지 댓글 수정
	@Override
	public int modifyNReply(NoticeReply nReply) {
		int result = nStore.updateNReply(session, nReply);
		return result;
	}

}
