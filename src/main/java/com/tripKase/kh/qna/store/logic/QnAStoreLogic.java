package com.tripKase.kh.qna.store.logic;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
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
	public List<QnA> selectAllQna(SqlSession session, String memberId,int currentPage, int boardLimit) {
		int offset = (currentPage-1)*boardLimit;
		RowBounds rowBounds = new RowBounds(offset, boardLimit);
		List<QnA> qList = session.selectList("QnAMapper.selectAllQna", memberId, rowBounds);
		return qList;
	}

	@Override
	public int getQnATotalCount(SqlSession session,String memberId) {
		int result = session.selectOne("QnAMapper.getQnATotalCount", memberId);
		return result;
	}

	@Override
	public QnA selectByNo(SqlSession session, int qnaNo) {
		QnA qna = session.selectOne("QnAMapper.selectByNo", qnaNo);
		return qna;
	}

	@Override
	public int deleteQnaByNo(SqlSession session, int qnaNo) {
		int result = session.delete("QnAMapper.deleteQnaByNo",qnaNo);
		return result;
	}

}
