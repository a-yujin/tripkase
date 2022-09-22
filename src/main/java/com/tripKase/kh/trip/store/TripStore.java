package com.tripKase.kh.trip.store;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.tripKase.kh.trip.domain.Trip;
import com.tripKase.kh.trip.domain.TripReply;

public interface TripStore {
	// 여행소통 게시글 등록 기능
	public int insertTrip(SqlSessionTemplate session, Trip trip);
	// 여행소통 게시글 댓글 등록 기능
	public int insertTripReply(SqlSessionTemplate session, TripReply tReply);
	// 여행소통 게시판 전체 조회
	public List<Trip> selectAllTrip(SqlSessionTemplate session, int currentPage, int triplimit);
	// 여행소통 게시글 댓글 조회
	public List<TripReply> selectAllReply(SqlSessionTemplate session, int repTripNo);
	// 여행소통 게시글 상세조회
	public Trip selectListOne(SqlSessionTemplate session, int tripNo);
	// 여행소통 게시판 리스트 페이징,검색 기능
	public int selectTotalCount(SqlSessionTemplate session, String searchValue);
	// 여행소통 게시글 수정 기능
	public int updateTrip(SqlSessionTemplate session, Trip trip);
	// 여행소통 게시글 삭제 기능
	public int deleteListOne(SqlSessionTemplate session, int tripNo);
	public List<Trip> selectSearchTrip(SqlSessionTemplate session, String searchValue, int currentPage, int tripLimit);
}
