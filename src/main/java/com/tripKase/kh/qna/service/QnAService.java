package com.tripKase.kh.qna.service;

import java.util.List;

import com.tripKase.kh.qna.domain.QnA;

public interface QnAService {

	int insertQna(QnA qna);

	List<QnA> selectAllQna(String memberId);

	int getQnATotalCount(String memberId);

}
