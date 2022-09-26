package com.tripKase.kh.qna.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.tripKase.kh.qna.domain.QnA;
import com.tripKase.kh.qna.store.QnAStore;

@Repository
public class QnAStoreLogic implements QnAStore{

	@Override
	public int insertQna(SqlSession session, QnA qna) {
		int result = session.insert("QnAMapper.insertQna", qna);
		return result;
	}

	@Override
	public List<QnA> selectAllQna(SqlSession session, String memberId) {
		List<QnA> qList = session.selectList("QnAMapper.insertQna", memberId);
		return null;
	}

	@Override
	public int getQnATotalCount(SqlSession session,String memberId) {
		int result = session.selectOne("QnAMapper.getQnATotalCount", memberId);
		return result;
	}

}
