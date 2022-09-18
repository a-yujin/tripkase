package com.tripKase.kh.trip.service.logic;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripKase.kh.trip.domain.Trip;
import com.tripKase.kh.trip.service.TripService;
import com.tripKase.kh.trip.store.TripStore;

@Service
public class TripServiceImpl implements TripService {
	@Autowired
	private TripStore tStore;
	@Autowired
	private SqlSessionTemplate session;
	
	// 여행소통 게시글 등록
	@Override
	public int registerTrip(Trip trip) {
		int result = tStore.insertTrip(session, trip);
		return result;
	}
	
	// 여행소통 게시글 상세페이지 조회
	@Override
	public Trip printListOne(int tripNo) {
		Trip trip = tStore.selectListOne(session, tripNo);
		return trip;
	}

	@Override
	public int getTotalCount(String searchCondition, String searchValue) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Trip> printAllTrip(int currentPage, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

}