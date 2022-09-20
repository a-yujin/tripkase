package com.tripKase.kh.restaurant.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	
	// 맛집 등록 페이지 불러오기 http://127.0.0.1:9999/restaurant/restaurantInsertPage.tripkase
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
			mv.setViewName("restaurant/restaurantMainPage");
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("msg", e.getMessage());
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	//맛집 수정 페이지
	
	

	//맛집 검색 기본 페이지 http://127.0.0.1:9999/restaurant/restaurantMainPage.tripkase
	@RequestMapping(value="/restaurant/restaurantMainPage.tripkase", method=RequestMethod.GET)
	public String restaurantMainPage() {

		return "restaurant/restaurantMainPage";
	}
	
	
	// 맛집 검색 목록 페이지
	@RequestMapping(value="/restaurant/restaurantSearch.tripkase", method=RequestMethod.GET)
	public ModelAndView restaurantSearch(
			ModelAndView mv
			, @RequestParam(value="searchValue", required = false) String searchValue
			, @RequestParam("areaValue") String areaValue
			, @RequestParam("typeValue") String [] typeValue
			, @RequestParam(value="page", required = false , defaultValue="1") int currentPage) {
			System.out.println(searchValue + ", " + areaValue  + ", " +  typeValue);
		try {
			int totalCount = resService.getRestaurantCount(searchValue, areaValue, typeValue);
			int boardLimit = 5;
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
					searchValue ,areaValue, typeValue, currentPage, boardLimit);
			if(!resList.isEmpty()) {
				mv.addObject("resList", resList);
			}else {
				mv.addObject("resList", null);
			}
			mv.addObject("urlVal", "search")
				.addObject("searchValue", searchValue)
				.addObject("areaValue", typeValue)
				.addObject("typeValue", typeValue)
				.addObject("maxPage", maxPage)
				.addObject("currentPage", currentPage)
				.addObject("startNavi", startNavi)
				.addObject("endNavi", endNavi)
				.setViewName("/restaurant/restaurantListView");
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("msg", e.toString()).setViewName("common/errorPage");
		}
		return mv;
	}
	
	
	//맛집 상세 조회
	@RequestMapping(value="/restaurant/restaurantDetailView.tripkase", method=RequestMethod.GET)
	public ModelAndView restaurantDetailView(ModelAndView mv, HttpSession session,
							@RequestParam("resNo") Integer resNo,  @RequestParam("page") Integer page) {
		try {
			Restaurant restaurant = resService.printOneByRestaurantNo(resNo);
			session.setAttribute("resNo", restaurant.getResNo());
			mv.addObject("restaurant" , restaurant);
			mv.addObject("page", page);
			mv.setViewName("restaurant/restaurantDetailView");
		} catch (Exception e) {
			mv.addObject("msg", e.toString()).setViewName("common/errorPage");
		}
		return mv;
	}
}
