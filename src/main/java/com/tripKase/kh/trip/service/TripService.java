package com.tripKase.kh.trip.service;

import java.util.List;

import com.tripKase.kh.trip.domain.Trip;

public interface TripService {
	// 여행소통 게시글 등록 기능
	public int registerTrip(Trip trip);
	// 여행소통 게시판 리스트 조회 기능
	public List<Trip> printAllTrip(int currentPage, int limit);
	// 여행소통 게시글 상세페이지
	public Trip printListOne(int tripNo);
	// 여행소통 게시판 리스트 검색 기능
	public int getTotalCount(String searchCondition, String searchValue);
}
