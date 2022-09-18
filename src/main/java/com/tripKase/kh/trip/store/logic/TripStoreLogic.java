package com.tripKase.kh.trip.store.logic;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.tripKase.kh.trip.domain.Trip;
import com.tripKase.kh.trip.store.TripStore;

@Repository
public class TripStoreLogic implements TripStore{
	// 여행소통 게시글 등록
	@Override
	public int insertTrip(SqlSessionTemplate session, Trip trip) {
		int result = session.insert("TripMapper.insertTrip", trip);
		return result;
	}

	// 여행소통 게시글 상세 조회
	@Override
	public Trip selectListOne(SqlSessionTemplate session, int tripNo) {
		Trip trip = session.selectOne("selectListOne", tripNo);
		return trip;
	}

}
