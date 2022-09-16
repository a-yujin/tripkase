package com.tripKase.kh.trip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TripController {
	/**
	 * 여행소통 게시글 등록 화면
	 * @return
	 */
	@RequestMapping(value="/trip/writeView.tripkase", method=RequestMethod.GET)
	public String tripWriteView() {
		return "trip/tripWriteForm";
	}
}
