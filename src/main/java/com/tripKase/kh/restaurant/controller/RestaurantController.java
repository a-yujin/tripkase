package com.tripKase.kh.restaurant.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.tripKase.kh.restaurant.domain.Restaurant;
import com.tripKase.kh.restaurant.service.RestaurantService;


@Controller
public class RestaurantController {
	
	@Autowired
	private  RestaurantService resService;
	
	// 맛집 등록 페이지 불러오기
	@RequestMapping(value="/restaurant/restaurantInsertPage.tripkase", method=RequestMethod.GET)
	public String restaurantInsertPage() {
		return "restaurant/restaurantInsertPage";
	}

	// 맛집 등록 메소드
	@RequestMapping(value="/restaurant/insertRestaurant.tripkase", method=RequestMethod.POST)
	public ModelAndView insertRestaurant(
			ModelAndView mv
			, @ModelAttribute Restaurant restaurant
			, @RequestParam(value="resUploadFile", required=false) MultipartFile uploadFile
			,HttpServletRequest request) {
		
		try {
			String resFilename = uploadFile.getOriginalFilename();
			if(!resFilename.equals("")) {
				/////////////////////////////////////////////////
				String root = request.getSession().getServletContext().getRealPath("resources");
				String savePath = root + "\\resUploadFiles";
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				String resFileRename
					= sdf.format(new Date(System.currentTimeMillis()))+"."
						+ resFilename.substring(resFilename.lastIndexOf(".")+1);
				// 이름 바꿔주는 메소드
				File file = new File(savePath);
				if(!file.exists()) {
					file.mkdir();
				}
				//////////////////////////////////////////////////
				String resFilepath = savePath + "\\" + resFileRename;
				uploadFile.transferTo(new File(resFilepath)); 
				// 파일을 buploadFiles 경로에 저장하는 메소드
				restaurant.setResFilename(resFilename);
				restaurant.setResFileRename(resFileRename);
				restaurant.setResFilepath(resFilepath);
			}
			int result = resService.insertRestaurant(restaurant);
			mv.setViewName("redirect:/restaurant/restaurantMainPage.tripkase");
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("msg", e.getMessage());
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	

	//맛집 검색 기본 페이지
	@RequestMapping(value="/restaurant/restaurantMainPage.tripkase", method=RequestMethod.GET)
	public String restaurantMainPage() {

		return "restaurant/restaurantMainPage";
	}
	
	// 맛집 검색 목록 페이지
	@RequestMapping(value="/restaurant/restaurantSearch.tripkase", method=RequestMethod.GET)
	public ModelAndView restaurantSearch(
		ModelAndView mv
		, @RequestParam("searchCondition") String searchCondition
		, @RequestParam("searchValue") String searchValue
		, @RequestParam(value="page", defaultValue="1") int currentPage) {	// 페이지가 널이면 디폴트값을 1로 설정
	try {
		int totalCount = resService.getRestaurantCount(searchCondition, searchValue);
		int boardLimit = 10;
		int naviLimit = 5;
		int maxPage;
		int startNavi;
		int endNavi;
		maxPage = (int)((double)totalCount/boardLimit + 0.9);
		startNavi = ((int)((double)currentPage/naviLimit+0.9)-1)*naviLimit+1;
		endNavi = startNavi + naviLimit - 1;
		if(maxPage < endNavi) {
			endNavi = maxPage;
		}
		List<Restaurant> resList = resService.printRestaurantByValue(
				searchCondition, searchValue, currentPage, boardLimit);
		if(!resList.isEmpty()) {
			mv.addObject("resList", resList);
		}else {
			mv.addObject("resList", null);
		}
		mv.addObject("urlVal", "search")
			.addObject("searchCondition", searchCondition)
			.addObject("searchValue", searchValue)
			.addObject("maxPage", maxPage)
			.addObject("currentPage", currentPage)
			.addObject("startNavi", startNavi)
			.addObject("endNavi", endNavi)
			.setViewName("restaurant/restaurantListView");
	} catch (Exception e) {
		mv.addObject("msg", e.toString()).setViewName("common/errorPage");
	}
	return mv;
	}
	
	
	//맛집 상세 조회
	@RequestMapping(value="/restaurant/restaurantDetailView.tripkase", method=RequestMethod.POST)
	public ModelAndView restaurantDetailView(ModelAndView mv, Integer resNo) {
		try {
			Restaurant restaurant = resService.printOneByRestaurantNo(resNo);
			mv.addObject("restaurant" , restaurant);
			mv.setViewName("restaurant/resDetailView");
		} catch (Exception e) {
			mv.addObject("msg", e.toString()).setViewName("common/errorPage");
		}
		return mv;
	}
}
