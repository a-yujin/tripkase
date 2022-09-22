package com.tripKase.kh.room.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RoomController {
	
	@RequestMapping(value="/room/searchView.tripkase", method=RequestMethod.GET)
	public String roomSearchView() {
		return "room/roomSearchView";
	}
	
	@RequestMapping(value="/room/registerRoom.tripkase", method=RequestMethod.GET)
	public String roomWriteView() {
		return "room/roomWriteForm";
	}
}
