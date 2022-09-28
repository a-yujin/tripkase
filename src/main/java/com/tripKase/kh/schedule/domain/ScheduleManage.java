package com.tripKase.kh.schedule.domain;

import com.tripKase.kh.attraction.domain.Attraction;
import com.tripKase.kh.attraction.domain.AttractionImg;
import com.tripKase.kh.restaurant.domain.ResImg;
import com.tripKase.kh.restaurant.domain.Restaurant;
import com.tripKase.kh.room.domain.Room;
import com.tripKase.kh.room.domain.RoomImg;

public class ScheduleManage {

	private int scheduleNo;	//일차
	private String scheduleSeq; 	//일정 순번
	private String scheduleDays;	//일차
	private String contetnsType;	//컨텐츠 분류
	private int contetnsNo;			//컨텐츠 순번
	private Restaurant restaurant;
	private ResImg resImg;
	private Attraction attraction;
	private AttractionImg attractionImg;
	private Room room;
	private RoomImg roomImg;
	

	
	
	
	public int getScheduleNo() {
		return scheduleNo;
	}





	public void setScheduleNo(int scheduleNo) {
		this.scheduleNo = scheduleNo;
	}





	public String getScheduleSeq() {
		return scheduleSeq;
	}





	public void setScheduleSeq(String scheduleSeq) {
		this.scheduleSeq = scheduleSeq;
	}





	public String getScheduleDays() {
		return scheduleDays;
	}





	public void setScheduleDays(String scheduleDays) {
		this.scheduleDays = scheduleDays;
	}





	public String getContetnsType() {
		return contetnsType;
	}





	public void setContetnsType(String contetnsType) {
		this.contetnsType = contetnsType;
	}





	public int getContetnsNo() {
		return contetnsNo;
	}





	public void setContetnsNo(int contetnsNo) {
		this.contetnsNo = contetnsNo;
	}





	public Restaurant getRestaurant() {
		return restaurant;
	}





	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}





	public ResImg getResImg() {
		return resImg;
	}





	public void setResImg(ResImg resImg) {
		this.resImg = resImg;
	}





	public Attraction getAttraction() {
		return attraction;
	}





	public void setAttraction(Attraction attraction) {
		this.attraction = attraction;
	}





	public AttractionImg getAttractionImg() {
		return attractionImg;
	}





	public void setAttractionImg(AttractionImg attractionImg) {
		this.attractionImg = attractionImg;
	}





	public Room getRoom() {
		return room;
	}





	public void setRoom(Room room) {
		this.room = room;
	}





	public RoomImg getRoomImg() {
		return roomImg;
	}





	public void setRoomImg(RoomImg roomImg) {
		this.roomImg = roomImg;
	}





	@Override
	public String toString() {
		return "ScheduleManage [scheduleNo=" + scheduleNo + ", scheduleSeq=" + scheduleSeq + ", scheduleDays="
				+ scheduleDays + ", contetnsType=" + contetnsType + ", contetnsNo=" + contetnsNo + ", restaurant="
				+ restaurant + ", resImg=" + resImg + ", attraction=" + attraction + ", attractionImg=" + attractionImg
				+ ", room=" + room + ", roomImg=" + roomImg + "]";
	}

	
	
	
	
	
}
