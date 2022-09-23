package com.tripKase.kh.trip.store.logic;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.tripKase.kh.trip.domain.Trip;
import com.tripKase.kh.trip.domain.TripReply;
import com.tripKase.kh.trip.store.TripStore;

@Repository
public class TripStoreLogic implements TripStore{
	// 여행소통 게시글 등록 기능
	@Override
	public int insertTrip(SqlSessionTemplate session, Trip trip) {
		int result = session.insert("TripMapper.insertTrip", trip);
		return result;
	}
	
	// 여행소통 게시글 댓글 등록 기능
	@Override
	public int insertTripReply(SqlSessionTemplate session, TripReply tReply) {
		int result = session.insert("TripReplyMapper.insertTripReply", tReply);
		return result;
	}

	// 여행소통 게시판 전체 조회
	@Override
	public List<Trip> selectAllTrip(SqlSessionTemplate session, int currentPage, int triplimit) {
		int offset = (currentPage-1) * triplimit;
		RowBounds rowBounds = new RowBounds(offset, triplimit);
		List<Trip> tList = session.selectList("TripMapper.selectAllTrip", null, rowBounds);
		return tList;
	}
	
	// 여행소통 게시글 댓글 조회
	@Override
	public List<TripReply> selectAllReply(SqlSessionTemplate session, int repTripNo) {
		List<TripReply> tList = session.selectList("TripReplyMapper.selectAllTripReply", repTripNo);
		return tList;
	}

	// 여행소통 게시글 상세 조회
	@Override
	public Trip selectListOne(SqlSessionTemplate session, int tripNo) {
		Trip trip = session.selectOne("TripMapper.selectListOne", tripNo);
		return trip;
	}
	
	// 여행소통 게시판 리스트 페이징,검색 기능
	@Override
	public int selectTotalCount(SqlSessionTemplate session, String searchValue) {
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("searchValue", searchValue);
		int totalCount = session.selectOne("TripMapper.selectTotalCount", paramMap);
		return totalCount;
	}
	
	// 여행소통 게시글 수정 기능
	@Override
	public int updateTrip(SqlSessionTemplate session, Trip trip) {
		int result = session.update("TripMapper.updateTrip", trip);
		return result;
	}

	// 여행소통 게시글 삭제 기능
	@Override
	public int deleteListOne(SqlSessionTemplate session, int tripNo) {
		int result = session.delete("TripMapper.deleteTrip", tripNo);
		return result;
	}
	
	// 여행소통 검색 기능
	@Override
	public List<Trip> selectSearchTrip(SqlSessionTemplate session, String searchValue, int currentPage, int tripLimit) {
		int offset = (currentPage-1) * tripLimit;
		RowBounds rowBounds = new RowBounds(offset, tripLimit);
		List<Trip> tList = session.selectList("TripMapper.selectSearchTrip", searchValue, rowBounds);
		return tList;
	}
	
	// 여행소통 게시글 조회 기능
	@Override
	public int updateTripCount(SqlSessionTemplate session, int tripNo) {
		int result = session.update("TripMapper.updateCount", tripNo);
		return result;
	}
}
