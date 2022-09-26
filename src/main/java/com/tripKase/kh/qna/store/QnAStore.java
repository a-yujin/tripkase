package com.tripKase.kh.qna.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.tripKase.kh.qna.domain.QnA;

public interface QnAStore {

	int insertQna(SqlSession session, QnA qna);

	List<QnA> selectAllQna(SqlSession session, String memberId);

	int getQnATotalCount(SqlSession session,String memberId);

}
