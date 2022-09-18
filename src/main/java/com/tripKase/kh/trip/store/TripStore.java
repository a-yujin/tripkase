package com.tripKase.kh.trip.store;

import org.mybatis.spring.SqlSessionTemplate;

import com.tripKase.kh.trip.domain.Trip;

public interface TripStore {
	// 여행소통 게시글 등록
	public int insertTrip(SqlSessionTemplate session, Trip trip);
	// 여행소통 게시글 상세조회
	public Trip selectListOne(SqlSessionTemplate session, int tripNo);
}
