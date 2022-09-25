package com.tripKase.kh.room.store;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.tripKase.kh.room.domain.Room;
import com.tripKase.kh.room.domain.RoomImg;

public interface RoomStore {
	// 숙소 정보 등록 기능
	public int insertRoom(SqlSessionTemplate session, Room room);
	// 숙소 정보 리스트 페이징 처리 기능
	public int selectTotalCount(SqlSessionTemplate session, String searchValue);
	// 숙소 정보 리스트 기능	
	public List<Room> selectAllRoom(SqlSessionTemplate session, int currentPage, int roomLimit);
	// 숙소 정보 리스트 상세페이지
	public Room selectDataListOne(SqlSessionTemplate session, int roomNo);
	// 숙소 정보 삭제 기능
	public int deleteDataOne(SqlSessionTemplate session, int roomNo);
	// 숙소 사진 추가 기능
	public int insertRoomImg(SqlSessionTemplate session, RoomImg roomImg);
	// 숙소 사진 화면 구현
	public List<RoomImg> roomImgDetail(SqlSessionTemplate session, int roomNo);
	// 숙소 수정 기능
	public int updateRoomData(SqlSessionTemplate session, Room room);
	// 숙소 수정 이미지
	public int updateRoomImg(SqlSessionTemplate session, RoomImg roomImg);
}
