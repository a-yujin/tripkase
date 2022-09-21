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
	public List<Trip> selectAllTrip(SqlSessionTemplate session, int currentPage, int limit) {
		int offset = (currentPage-1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		// parameter 값이 있으면 작성 (쿼리문에서 #{ } 해서 넘겨주는 값 = parameter) 필요 없으면 null
		List<Trip> tList = session.selectList("TripMapper.selectAllTrip", null, rowBounds);
		return tList;
	}
	
	// 여행소통 게시글 댓글 조회
	@Override
	public List<TripReply> selectAllReply(SqlSessionTemplate session, int tripNo) {
		List<TripReply> tList = session.selectList("TripReplyMapper.selectAllTripReply", tripNo);
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
	public int selectTotalCount(SqlSessionTemplate session, String searchCondition, String searchValue) {
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("searchCondition", searchCondition);
		paramMap.put("searchValue", searchValue);
		int totalCount = session.selectOne("TripMapper.selectTotalCount", paramMap);
		return totalCount;
	}
}
