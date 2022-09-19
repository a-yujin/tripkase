package com.tripKase.kh.trip.store;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.tripKase.kh.trip.domain.Trip;

public interface TripStore {
	// 여행소통 게시글 등록 기능
	public int insertTrip(SqlSessionTemplate session, Trip trip);
	// 여행소통 게시글 상세조회
	public Trip selectListOne(SqlSessionTemplate session, int tripNo);
	// 여행소통 게시판 리스트 페이징,검색 기능
	public int selectTotalCount(SqlSessionTemplate session, String searchCondition, String searchValue);
	// 여행소통 게시판 전체 조회
	public List<Trip> selectAllTrip(SqlSessionTemplate session, int currentPage, int limit);
}
