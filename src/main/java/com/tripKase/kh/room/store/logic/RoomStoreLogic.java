package com.tripKase.kh.room.store.logic;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.tripKase.kh.room.domain.Room;
import com.tripKase.kh.room.domain.RoomImg;
import com.tripKase.kh.room.domain.RoomJoin;
import com.tripKase.kh.room.store.RoomStore;

@Repository
public class RoomStoreLogic implements RoomStore{
	// 숙소 정보 등록 기능
	@Override
	public int insertRoom(SqlSessionTemplate session, Room room) {
		int result = session.insert("RoomMapper.insertRoom", room);
		return result;
	}
	// 숙소 정보 리스트 페이징 처리 기능
	@Override
	public int selectTotalCount(SqlSessionTemplate session, String searchValue) {
		int totalCount = session.selectOne("RoomMapper.selectTotalCount", searchValue);
		return totalCount;
	}
	// 숙소 정보 리스트 기능
	@Override
	public List<Room> selectAllRoom(SqlSessionTemplate session, int currentPage, int roomLimit) {
		int offset = (currentPage-1) * roomLimit;
		RowBounds rowBounds = new RowBounds(offset, roomLimit);
		List<Room> rList = session.selectList("RoomMapper.selectAllRoom", null, rowBounds);
		return rList;
	}
	// 숙소 정보 리스트 상세 페이지
	@Override
	public Room selectDataListOne(SqlSessionTemplate session, int roomNo) {
		Room room = session.selectOne("RoomMapper.selectDataListOne", roomNo);
		return room;
	}
	// 숙소 정보 삭제 기능
	@Override
	public int deleteDataOne(SqlSessionTemplate session, int roomNo) {
		int result = session.delete("RoomMapper.deleteDataRoom", roomNo);
		return result;
	}
	@Override
	public int insertRoomImg(SqlSessionTemplate session, RoomImg roomImg) {
		int result = session.insert("RoomMapper.insertRoomImg", roomImg);
		return result;
	}
	// 숙소 사진 화면 구현
	@Override
	public List<RoomImg> roomImgDetail(SqlSessionTemplate session, int roomNo) {
		List<RoomImg> riList = session.selectList("RoomMapper.roomImgDetail", roomNo);
		return riList;
	}
	// 숙소 수정 기능
	@Override
	public int updateRoomData(SqlSessionTemplate session, Room room) {
		int result = session.update("RoomMapper.updateRoomData", room);
		return result;
	}
	// 숙소 수정 이미지
	@Override
	public int updateRoomImg(SqlSessionTemplate session, RoomImg roomImg) {
		int result = session.update("RoomMapper.updateRoomImg", roomImg);
		return result;
	}
	// 숙소 검색 리스트
	@Override
	public List<Room> selectSearchRoom(SqlSessionTemplate session, String searchValue, String areaValue,
			String[] typeValue, int personValue, String petValue, int currentPage, int roomsLimit) {
		int offset = (currentPage-1)*roomsLimit;
		RowBounds rowBounds = new RowBounds(offset, roomsLimit);
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("searchValue", searchValue);
		paramMap.put("areaValue", areaValue);
		paramMap.put("typeValue", typeValue);
		paramMap.put("personValue", personValue);
		paramMap.put("petValue", petValue);
		List<Room> rList = session.selectList("RoomMapper.selectSearchRoom", paramMap, rowBounds);
		return rList;
	}
	// 숙소 검색 리스트 페이징처리
	@Override
	public int getRoomCount(SqlSessionTemplate session, String searchValue, String areaValue, String[] typeValue, int personValue, String petValue) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("searchValue", searchValue);
		paramMap.put("areaValue", areaValue);
		paramMap.put("typeValue", typeValue);
		paramMap.put("personValue", personValue);
		paramMap.put("petValue", petValue);
		return session.selectOne("RoomMapper.selectSearchCount", paramMap);
	}
	@Override
	public int getRoomNameCount(SqlSessionTemplate session, String searchValue) {
		int nameCount = session.selectOne("RoomMapper.selectNameCount", searchValue);
		return nameCount;
	}
	@Override
	public List<RoomJoin> selectSearchName(SqlSessionTemplate session, String searchValue, int currentPage, int roomsLimit) {
		int offset = (currentPage-1) * roomsLimit;
		RowBounds rowBounds = new RowBounds(offset, roomsLimit);
		List<RoomJoin> rjList = session.selectList("RoomMapper.selectSearchName", searchValue, rowBounds);
		return rjList;
	}
	@Override
	public List<RoomImg> selectAllRoomImg(SqlSessionTemplate session, int roomNo) {
		List<RoomImg> riList = session.selectList("RoomMapper.selectAllRoomImg", roomNo);
		return riList;
	}
}
