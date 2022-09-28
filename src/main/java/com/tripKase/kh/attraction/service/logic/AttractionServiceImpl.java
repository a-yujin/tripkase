package com.tripKase.kh.attraction.service.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripKase.kh.attraction.domain.AttrImgDomain;
import com.tripKase.kh.attraction.domain.Attraction;
import com.tripKase.kh.attraction.domain.AttractionImg;
import com.tripKase.kh.attraction.service.AttractionService;
import com.tripKase.kh.attraction.store.AttractionStore;

@Service
public class AttractionServiceImpl implements AttractionService {
	@Autowired
	private SqlSession session;
	
	@Autowired
	private AttractionStore attrStore;
	
	// 관광지 등록
	@Override
	public int registerAttr(Attraction attr) {
		int result = attrStore.insertAttr(session, attr);
		return result;
	}
	// 관광지-이미지 등록
	@Override
	public int registerAttrImg(AttractionImg attrImg) {
		int result = attrStore.insertAttrImg(session, attrImg);
		return result;
	}
	
	// 총 게시글 수 가져오기
	@Override
	public int getTotalCount() {
		int totalCount = attrStore.selectTotalCount(session);
		return totalCount;
	}
	
	// 관광지 목록(관리자) 조회
	@Override
	public List<Attraction> printAllAttr(int currentPage, int attrLimit) {
		List<Attraction> attrList = attrStore.selectAllAttr(session, currentPage, attrLimit);
		return attrList;
	}
	
	// 관광지 상세 조회 + 수정 화면
	@Override
	public Attraction printOneByNo(Integer attrNo) {
		Attraction attr = attrStore.selectOneByNo(session, attrNo);
		return attr;
	}
	// 관광지 상세-이미지 조회
	@Override
	public List<AttractionImg> printImgByNo(Integer attrNo) {
		List<AttractionImg> attrImgList = attrStore.selectImgByNo(session, attrNo);
		return attrImgList;
	}
	
	// 관광지 삭제
	@Override
	public int removeOneByNo(int attrNo) {
		int result = attrStore.deleteOneByNo(session, attrNo);
		return result;
	}
	
	// 관광지 수정
	@Override
	public int modifyAttr(Attraction attr) {
		int result = attrStore.updateAttr(session, attr);
		return result;
	}
	// 관광지-이미지 수정
	@Override
	public int modifyAttrImg(AttractionImg attrImg) {
		int result = attrStore.updateAttrImg(session, attrImg);
		return result;
	}
	
	// 관광지 검색 게시글 수 가져오기
	@Override
	public int getSearchCount(String searchValue, String areaValue, String [] typeValue) {
		int result = attrStore.getSearchCount(session, searchValue, areaValue, typeValue);
		return result;
	}
	
	// 관광지 검색 게시글 목록 조회
	@Override
	public List<AttrImgDomain> printSearchAttr(String searchValue, String areaValue, String [] typeValue,
			int currentPage, int attrLimit) {
		List<AttrImgDomain> attrList = attrStore.selectSearchAttr(session, searchValue, areaValue, typeValue, currentPage, attrLimit);
		return attrList;
	}
	
	// 관광지 검색 게시글 상세 조회
	@Override
	public List<AttrImgDomain> printOneAttr(Integer attrNo) {
		List<AttrImgDomain> attrImgList = attrStore.selectOneAttr(session, attrNo);
		return attrImgList;
	}

}
