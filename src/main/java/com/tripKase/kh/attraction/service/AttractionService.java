package com.tripKase.kh.attraction.service;

import java.util.List;

import com.tripKase.kh.attraction.domain.AttrImgDomain;
import com.tripKase.kh.attraction.domain.Attraction;
import com.tripKase.kh.attraction.domain.AttractionImg;

public interface AttractionService {
	// 관광지 등록
	int registerAttr(Attraction attr);
	// 관광지-이미지 등록
	int registerAttrImg(AttractionImg attrImg);
	
	// 총 게시글 수 가져오기
	int getTotalCount();
	
	// 관광지 목록(관리자) 조회
	List<Attraction> printAllAttr(int currentPage, int attrLimit);
	
	// 관광지 상세 조회 + 수정 화면
	Attraction printOneByNo(Integer attrNo);
	// 관광지 상세-이미지 조회
	List<AttractionImg> printImgByNo(Integer attrNo);
	
	// 관광지 삭제
	int removeOneByNo(int attrNo);
	
	// 관광지 수정
	int modifyAttr(Attraction attr);
	// 관광지-이미지 수정
//	int modifyAttrImg(AttractionImg attrImg);
	
	// 관광지 검색 게시글 수 가져오기
	int getSearchCount(String searchValue, String areaValue, String [] typeValue);
	
	// 관광지 검색 게시글 목록 조회
	List<AttrImgDomain> printSearchAttr(String searchValue, String areaValue, String [] typeValue,
			int currentPage, int attrLimit);
	
	// 관광지 검색 게시글 상세 조회
	List<AttrImgDomain> printOneAttr(Integer attrNo);

}
