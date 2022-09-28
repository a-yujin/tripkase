package com.tripKase.kh.attraction.store.logic;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.tripKase.kh.attraction.domain.Attraction;
import com.tripKase.kh.attraction.domain.AttractionImg;
import com.tripKase.kh.attraction.store.AttractionStore;

@Repository
public class AttractionStoreLogic implements AttractionStore {
	// 관광지 등록
	@Override
	public int insertAttr(SqlSession session, Attraction attr) {
		int result = session.insert("AttrMapper.insertAttr", attr);
		return result;
	}
	// 관광지-이미지 등록
	@Override
	public int insertAttrImg(SqlSession session, AttractionImg attrImg) {
		int result = session.insert("AttrMapper.insertAttrImg", attrImg);
		return result;
	}
	
	// 총 게시글 수 가져오기
	@Override
	public int selectTotalCount(SqlSession session) {
		int totalCount = session.selectOne("AttrMapper.selectTotalCount");
		return totalCount;
	}
	
	// 관광지 목록(관리자) 조회
	@Override
	public List<Attraction> selectAllAttr(SqlSession session, int currentPage, int attrLimit) {
		int offset = (currentPage-1)*attrLimit;
		RowBounds rowBounds = new RowBounds(offset, attrLimit);
		List<Attraction> attrList = session.selectList("AttrMapper.selectAllAttr", null, rowBounds);
		return attrList;
	}
	
	// 관광지 상세 조회 + 수정 화면
	@Override
	public Attraction selectOneByNo(SqlSession session, Integer attrNo) {
		Attraction attr = session.selectOne("AttrMapper.selectOneByNo", attrNo);
		return attr;
	}
	// 관광지 상세-이미지 조회
	@Override
	public List<AttractionImg> selectImgByNo(SqlSession session, Integer attrNo) {
		List<AttractionImg> attrImgList = session.selectList("AttrMapper.selectImgByNo", attrNo);
		return attrImgList;
	}
	
	// 관광지 삭제
	@Override
	public int deleteOneByNo(SqlSession session, int attrNo) {
		int result = session.delete("AttrMapper.deleteAttr", attrNo);
		return result;
	}
	
	// 관광지 수정
	@Override
	public int updateAttr(SqlSession session, Attraction attr) {
		int result = session.update("AttrMapper.updateAttr", attr);
		return result;
	}
	// 관광지-이미지 수정
	@Override
	public int updateAttrImg(SqlSession session, AttractionImg attrImg) {
		int result = session.update("AttrMapper.updateAttrImg", attrImg);
		return result;
	}
	
	// 관광지 검색 게시글 수 가져오기
	@Override
	public int getSearchCount(SqlSession session, String searchValue, String areaValue, String [] typeValue) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("searchValue", searchValue);
		paramMap.put("areaValue", areaValue);
		paramMap.put("typeValue", typeValue);
		int searchCount = session.selectOne("AttrMapper.getSearchCount", paramMap);
		return searchCount;
	}
	
	// 관광지 검색 게시글 목록 조회
	@Override
	public List<Attraction> selectSearchAttr(SqlSession session, String searchValue, String areaValue, String [] typeValue,
			int currentPage, int attrLimit) {
		int offset = (currentPage-1)*attrLimit;
		RowBounds rowBounds = new RowBounds(offset, attrLimit);
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("searchValue", searchValue);
		paramMap.put("areaValue", areaValue);
		paramMap.put("typeValue", typeValue);
		List<Attraction> attrList = session.selectList("AttrMapper.selectSearchAttr", paramMap, rowBounds);
		return attrList;
	}

}
