package com.tripKase.kh.restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tripKase.kh.restaurant.domain.Restaurant;
import com.tripKase.kh.restaurant.service.RestaurantService;


@Controller
public class RestaurantController {
	
	@Autowired
	private  RestaurantService resService;

	@RequestMapping(value="/restaurant/insertRestaurant.tripkase", method=RequestMethod.GET)
	public int insertRestaurant(Restaurant restaurant) {
		
		return resService.insertRestaurant(restaurant);
	}
	
//	@GetMapping(value="/restaurant/restaurantPage.tripkase")
//	public ModelAndView restaurantPage(ModelAndView mv) {	// 맛집 기본 페이지
//		List<Restaurant> resList = resService.printAllBoard();
//		mv.addObject("resList", resList);
//		mv.setViewName("restaurant/restaurantPage");
//		return mv;
//	}
//	
//	@PostMapping(value="/resDetailView.tripkase")
//	public ModelAndView restaurantDetailView(int resNo) {	// 맛집 상세조회 페이지
//		ModelAndView mv = new ModelAndView();
//		List<Restaurant> resList = resService.printAllRestaurant(resNo);
//		mv.addObject("resList" , resList);
//		mv.setViewName("restaurant/resDetailView");
//		return mv;
//	}
	
	
//	@GetMapping(value="/resSearch.tripkase")
//	public ModelAndView restaurantSearch(		// 맛집 검색시 열리는 페이지
//		ModelAndView mv
//		, @RequestParam("searchCondition") String searchCondition
//		, @RequestParam("searchValue") String searchValue
//		, @RequestParam(value="page", defaultValue="1") int currentPage) {	// 페이지가 널이면 디폴트값을 1로 설정
//	try {
//		int totalCount = resService.getRestaurantCount(searchCondition, searchValue);
//		int boardLimit = 10;
//		int naviLimit = 5;
//		int maxPage;
//		int startNavi;
//		int endNavi;
//		maxPage = (int)((double)totalCount/boardLimit + 0.9);
//		startNavi = ((int)((double)currentPage/naviLimit+0.9)-1)*naviLimit+1;
//		endNavi = startNavi + naviLimit - 1;
//		if(maxPage < endNavi) {
//			endNavi = maxPage;
//		}
//		List<Restaurant> resList = resService.printRestaurantByValue(
//				searchCondition, searchValue, currentPage, boardLimit);
//		if(!resList.isEmpty()) {
//			mv.addObject("resList", resList);
//		}else {
//			mv.addObject("resList", null);
//		}
//		mv.addObject("urlVal", "search")
//			.addObject("searchCondition", searchCondition)
//			.addObject("searchValue", searchValue)
//			.addObject("maxPage", maxPage)
//			.addObject("currentPage", currentPage)
//			.addObject("startNavi", startNavi)
//			.addObject("endNavi", endNavi)
//			.setViewName("restaurant/listView");
//	} catch (Exception e) {
//		mv.addObject("msg", e.toString()).setViewName("common/errorPage");
//	}
//	return mv;
//	}
}
