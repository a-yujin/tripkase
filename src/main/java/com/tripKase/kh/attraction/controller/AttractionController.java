package com.tripKase.kh.attraction.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AttractionController {
	@RequestMapping(value="/attraction/searchView.tripkase", method=RequestMethod.GET)
	public String showAttrSearch(){
		return "attraction/attrSearch";
	}
	
//	@RequestMapping(value="/attraction/search.tripkase", method=RequestMethod.POST)
//	public void searchAttr() {
//		
//	}
}
