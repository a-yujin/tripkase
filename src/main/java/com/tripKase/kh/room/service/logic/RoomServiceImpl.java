package com.tripKase.kh.room.service.logic;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripKase.kh.room.domain.Room;
import com.tripKase.kh.room.domain.RoomImg;
import com.tripKase.kh.room.domain.RoomJoin;
import com.tripKase.kh.room.service.RoomService;
import com.tripKase.kh.room.store.RoomStore;

@Service
public class RoomServiceImpl implements RoomService{
	@Autowired
	private RoomStore rStore;
	@Autowired
	private SqlSessionTemplate session;

	// 숙소 정보 추가 기능
	@Override
	public int registerRoom(Room room) {
		int result = rStore.insertRoom(session, room);
		return result;
	}
	// 숙소 정보 리스트 페이징 처리 기능
	@Override
	public int getTotalCount(String searchValue) {
		int totalCount = rStore.selectTotalCount(session, searchValue);
		return totalCount;
	}
	// 숙소 정보 리스트 기능
	@Override
	public List<Room> printAllRoom(int currentPage, int roomLimit) {
		List<Room> rList = rStore.selectAllRoom(session, currentPage, roomLimit);
		return rList;
	}
	// 숙소 정보 상세 페이지
	@Override
	public Room printOneData(int roomNo) {
		Room room = rStore.selectDataListOne(session, roomNo);
		return room;
	}
	// 숙소 정보 삭제 기능
	@Override
	public int removeDataOne(int roomNo) {
		int result = rStore.deleteDataOne(session, roomNo);
		return result;
	}
	// 숙소 사진 등록
	@Override
	public int registerRoomImg(RoomImg roomImg) {
		int result = rStore.insertRoomImg(session, roomImg);
		return result;
	}
	// 숙소 사진 화면 구현
	@Override
	public List<RoomImg> roomImgDetail(int roomNo) {
		List<RoomImg> riList = rStore.roomImgDetail(session, roomNo);
		return riList;
	}
	// 숙소 수정 기능
	@Override
	public int updateRoomData(Room room) {
		int result = rStore.updateRoomData(session, room);
		return result;
	}
	// 숙소 수정 이미지
	@Override
	public int updateRoomImg(RoomImg roomImg) {
		int result = rStore.updateRoomImg(session, roomImg);
		return result;
	}
	// 숙소 검색 리스트 페이징처리
	@Override
	public int getRoomCount(String searchValue, String areaValue, String[] typeValue, int personValue, String petValue) {
		int result = rStore.getRoomCount(session, searchValue, areaValue, typeValue, personValue, petValue);
		return result;
	}
	// 숙소 검색 리스트
	@Override
	public List<Room> printSearchRoom(String searchValue, String areaValue, String[] typeValue, int personValue, String petValue, int currentPage, int roomsLimit) {
		List<Room> rList = rStore.selectSearchRoom(session, searchValue, areaValue, typeValue, personValue, petValue, currentPage, roomsLimit);
		return rList;
	}
	
	// 숙소 이름 검색 리스트 페이징 처리
	@Override
	public int getRoomNameCount(String searchValue) {
		int result = rStore.getRoomNameCount(session, searchValue);
		return result;
	}
	// 숙소 이름 검색
	@Override
	public List<RoomJoin> printSearchName(String searchValue, int currentPage, int roomsLimit) {
		List<RoomJoin> rjList = rStore.selectSearchName(session, searchValue, currentPage, roomsLimit);
		return rjList;
	}
	@Override
	public List<RoomImg> printSearchImg(int roomNo) {
		List<RoomImg> riList = rStore.selectAllRoomImg(session, roomNo);
		return riList;
	}
}
