package com.tripKase.kh.trip.service;

import java.util.List;

import com.tripKase.kh.trip.domain.Trip;
import com.tripKase.kh.trip.domain.TripReply;

public interface TripService {
	// 여행소통 게시글 등록 기능
	public int registerTrip(Trip trip);
	// 여행소통 게시글 댓글 등록 기능
	public int registerReply(TripReply tReply);
	// 여행소통 게시판 리스트 조회
	public List<Trip> printAllTrip(int currentPage, int triplimit);
	// 여행소통 게시글 댓글 조회
	public List<TripReply> printAllTripReply(int repTripNo);
	// 여행소통 게시글 상세페이지
	public Trip printListOne(Integer tripNo);
	// 여행소통 게시판 리스트 검색 기능
	public int getTotalCount(String searchValue);
	// 여행소통 게시글 수정 기능
	public int modifyTrip(Trip trip);
	// 여행소통 게시글 삭제 기능
	public int removeListOne(int tripNo);
	// 여행소통 게시글 검색 리스트
	public List<Trip> printSearchTrip(String searchValue, int currentPage, int tripLimit);
}
