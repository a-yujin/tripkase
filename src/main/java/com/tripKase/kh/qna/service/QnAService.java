package com.tripKase.kh.qna.service;

import java.util.List;

import com.tripKase.kh.qna.domain.QnA;

public interface QnAService {

	int insertQna(QnA qna);

	List<QnA> selectAllQna(String memberId, int currentPage, int boardLimit );

	int getQnATotalCount(String memberId);

	QnA selectByNo(int qnaNo);

	int deleteQnaByNo(int qnaNo);

}
