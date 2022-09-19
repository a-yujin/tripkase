package com.tripKase.kh.notice.service.logic;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripKase.kh.notice.domain.Notice;
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

}
