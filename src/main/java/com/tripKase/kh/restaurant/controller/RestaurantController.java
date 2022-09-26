package com.tripKase.kh.restaurant.controller;

import java.io.File;
import java.io.IOException;
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
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.tripKase.kh.restaurant.domain.ResImg;
import com.tripKase.kh.restaurant.domain.Restaurant;
import com.tripKase.kh.restaurant.service.RestaurantService;


@Controller
public class RestaurantController {
	
	@Autowired
	private  RestaurantService resService;
	
	/**
	 * 맛집 등록 페이지 (관리자)
	 * @return String
	 */
	@RequestMapping(value="/restaurant/restaurantInsertPage.tripkase", method=RequestMethod.GET)
	public String restaurantInsertPage() {
		return "restaurant/restaurantInsertPage";
	}

	/**
	 * 맛집 등록 기능 (관리자)
	 * @param mv
	 * @param restaurant
	 * @param uploadFile
	 * @param request
	 * @param multipartRequest
	 * @return ModelAndView
	 */
	@RequestMapping(value="/restaurant/insertRestaurantData.tripkase", method=RequestMethod.POST)
	public ModelAndView insertRestaurant(
			ModelAndView mv
			, @ModelAttribute Restaurant restaurant
			, @RequestParam(value="uploadFile", required=false) List<MultipartFile> uploadFile
			,HttpServletRequest request, MultipartHttpServletRequest multipartRequest) {
		try {
			int imgNo = 1;
			ResImg resImg = null;
			int result = resService.insertRestaurant(restaurant);
			for(MultipartFile mf : uploadFile) {
				String resFileName = mf.getOriginalFilename();
				if(!resFileName.equals("")) {
					String root = request.getSession().getServletContext().getRealPath("resources");
					String savePath = root + "\\resUploadFiles";
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmSS");
					String resFileRename = sdf.format(new Date(System.currentTimeMillis()))+"."
							+ resFileName.substring(resFileName.lastIndexOf(".")+1);
					File file = new File(savePath);
					if(!file.exists()) {
						file.mkdir();
					}
					mf.transferTo(new File(savePath+"\\"+resFileRename));
					String resFilePath = savePath + "\\" + resFileRename;
					resImg = new ResImg();
					resImg.setResFileName(resFileName);
					resImg.setResFileRename(resFileRename);
					resImg.setResFilePath(resFilePath);
					imgNo = imgNo + 1;
				}
					int result2 = resService.insertRestaurantImg(resImg);
					mv.setViewName("redirect:/restaurant/restaurantMainPage.tripkase");
			}
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				mv.addObject("msg", e.toString()).setViewName("common/errorPage");
		}
		return mv;
	}
	
	
	//맛집 삭제
	@RequestMapping(value="/restaurant/deleteRestaurant.tripkase", method=RequestMethod.GET)
	public String deleteRestaurant(HttpSession session) {
		try {
			int resNo = Integer.parseInt(session.getAttribute("resNo").toString());
			int result = resService.deleteRestaurant(resNo);
			if(result > 0) {
				session.removeAttribute("resNo");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/restaurant/restaurantMainPage.tripkase";
	}
	

	//맛집 검색 기본 페이지 http://127.0.0.1:9999/restaurant/restaurantMainPage.tripkase
	@RequestMapping(value="/restaurant/restaurantMainPage.tripkase", method=RequestMethod.GET)
	public String restaurantMainPage() {

		return "restaurant/restaurantMainPage";
	}
	
	
	// 맛집 검색 목록 페이지
	@RequestMapping(value="/restaurant/restaurantSearch.tripkase", method=RequestMethod.GET)
	public ModelAndView restaurantSearch(
			ModelAndView mv
			, @RequestParam(value="searchValue", required = false) String searchValue	// 텍스트로 입력한 가게이름 검색 값
			, @RequestParam("areaValue") String areaValue								// 지역검색 값
			, @RequestParam("typeValue") String [] typeValue							// 맛집 종류 (ex 한식 일식) 체크박스 필터 거친값을 리스트로 가져옴
			, @RequestParam(value="page", required = false , defaultValue="1") int currentPage
			) {
		try {
			int totalCount = resService.getRestaurantCount(searchValue, areaValue, typeValue);	// 맛집 필터 검색시 나오는 수 가져오는 함수
			int boardLimit = 5;		// 보이는 갯수 5개로 제한
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
			mv.addObject("urlVal", "restaurantSearch")
				.addObject("searchValue", searchValue)
				.addObject("areaValue", areaValue)
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
			mv.addObject("restaurant" , restaurant);
			mv.addObject("page", page);
			mv.setViewName("restaurant/restaurantDetailView");
		} catch (Exception e) {
			mv.addObject("msg", e.toString()).setViewName("common/errorPage");
		}
		return mv;
	}
	
	/** 관리자 맛집 검색 필터 페이지
	 * 
	 *	 
	 */
	@RequestMapping(value="/restaurant/resAdminSearchPage.tripkase", method=RequestMethod.GET)
	public String restaurantAdminSearchPage() {
		return "restaurant/resAdminSearchView";
	}
	
	
	/** 관리자 맛집 검색 조회
	 *	 
	 * 
	 */
		@RequestMapping(value="/restaurant/restaurantAdminSearchView.tripkase", method=RequestMethod.GET)
		public ModelAndView restaurantAdminSearch(
				ModelAndView mv
				, @RequestParam(value="searchValue", required = false) String searchValue
				, @RequestParam("areaValue") String areaValue		
				, @RequestParam("typeValue") String [] typeValue							
				, @RequestParam(value="page", required = false , defaultValue="1") int currentPage
				) {
			try {
				int totalCount = resService.getRestaurantCount(searchValue, areaValue, typeValue);
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
						searchValue ,areaValue, typeValue, currentPage, boardLimit);
				if(!resList.isEmpty()) {
					mv.addObject("resList", resList);
				}else {
					mv.addObject("resList", null);
				}
				mv.addObject("urlVal", "restaurantSearch")
					.addObject("searchValue", searchValue)
					.addObject("areaValue", areaValue)
					.addObject("typeValue", typeValue)
					.addObject("maxPage", maxPage)
					.addObject("currentPage", currentPage)
					.addObject("startNavi", startNavi)
					.addObject("endNavi", endNavi)
					.setViewName("/restaurant/resAdminListView");
			} catch (Exception e) {
				e.printStackTrace();
				mv.addObject("msg", e.toString()).setViewName("common/errorPage");
			}
			return mv;
		}
		
		
		/** 관리자 수정 / 삭제 페이지
		 * 	
		 */
		@RequestMapping(value="/restaurant/modifyRestaurantView.tripkase", method=RequestMethod.GET)
		public ModelAndView restaurantModifyView(ModelAndView mv,
				@RequestParam("resNo") Integer resNo,
				@RequestParam("page") int page) {
			try {
				Restaurant restaurant = resService.printOneByRestaurantNo(resNo);
				mv.addObject("restaurant",restaurant)
					.addObject("page",page)
					.setViewName("restaurant/restaurantUpdatePage");
			} catch (Exception e) {
				e.printStackTrace();
				mv.addObject("msg", e.toString()).setViewName("common/errorPage");
			}
		return mv;
		}
		
		
		/**
		 * 맛집 수정 기능 (관리자)
		 * @param mv
		 * @param restaurant
		 * @param uploadFile
		 * @param request
		 * @param multipartRequest
		 * @return ModelAndView
		 */
		@RequestMapping(value="/restaurant/updateRestaurantData.tripkase", method=RequestMethod.POST)
		public ModelAndView updateRestaurant(
				ModelAndView mv
				, @ModelAttribute Restaurant restaurant
				, @RequestParam(value="uploadFile", required=false) List<MultipartFile> uploadFile
				,HttpServletRequest request, MultipartHttpServletRequest multipartRequest) {
			try {
				int imgNo = 1;
				ResImg resImg = null;
				int result = resService.updateRestaurant(restaurant);
				for(MultipartFile mf : uploadFile) {
					String resFileName = mf.getOriginalFilename();
					if(!resFileName.equals("")) {
						String root = request.getSession().getServletContext().getRealPath("resources");
						String savePath = root + "\\resUploadFiles";
						SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmSS");
						String resFileRename = sdf.format(new Date(System.currentTimeMillis()))+"."
								+ resFileName.substring(resFileName.lastIndexOf(".")+1);
						File file = new File(savePath);
						if(!file.exists()) {
							file.mkdir();
						}
						mf.transferTo(new File(savePath+"\\"+resFileRename));
						String resFilePath = savePath + "\\" + resFileRename;
						resImg = new ResImg();
						resImg.setResFileName(resFileName);
						resImg.setResFileRename(resFileRename);
						resImg.setResFilePath(resFilePath);
						imgNo = imgNo + 1;
					}
						int result2 = resService.updateRestaurantImg(resImg);
						mv.setViewName("redirect:/restaurant/restaurantMainPage.tripkase");
				}
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (Exception e) {
					mv.addObject("msg", e.toString()).setViewName("common/errorPage");
			}
			return mv;
		}
}
