package com.tripKase.kh.attraction.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.tripKase.kh.attraction.domain.Attraction;
import com.tripKase.kh.attraction.domain.AttractionImg;

public interface AttractionStore {
	// 관광지 등록
	int insertAttr(SqlSession session, Attraction attr);
	// 관광지-이미지 등록
	int insertAttrImg(SqlSession session, AttractionImg attrImg);
	
	// 총 게시글 수 가져오기
	int selectTotalCount(SqlSession session);
	
	// 관광지 목록(관리자) 조회
	List<Attraction> selectAllAttr(SqlSession session, int currentPage, int attrLimit);
	
	// 관광지 상세 + 수정 화면
	Attraction selectOneByNo(SqlSession session, Integer attrNo);
	// 관광지 상세-이미지 조회
	List<AttractionImg> selectImgByNo(SqlSession session, Integer attrNo);

}
