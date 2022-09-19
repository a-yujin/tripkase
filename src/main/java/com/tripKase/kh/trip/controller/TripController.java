package com.tripKase.kh.trip.controller;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
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

import com.tripKase.kh.trip.domain.Trip;
import com.tripKase.kh.trip.service.TripService;

@Controller
public class TripController {
	@Autowired
	private TripService tService;
	
	/**
	 * 여행소통 게시글 등록 화면
	 * @return
	 */
	@RequestMapping(value="/trip/writeView.tripkase", method=RequestMethod.GET)
	public String tripWriteView() {
		return "trip/tripWriteForm";
	}
	
	/**
	 * 여행소통 게시글 등록
	 * @param mv
	 * @param trip
	 * @param uploadFile
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/trip/tripDetail.tripkase", method=RequestMethod.POST)
	public ModelAndView registTrip(
			ModelAndView mv,
			@ModelAttribute Trip trip,
			@RequestParam(value="uploadFile", required=false) MultipartFile uploadFile,
			HttpServletRequest request) {
		try {
			String tripFileName = uploadFile.getOriginalFilename();
			if(!tripFileName.equals("")) {
				// 사진 저장 경로
				String root = request.getSession().getServletContext().getRealPath("resources");
				String savePath = root + "\\tuploadFiles";
				// 이름이 같은 다른 사진 저장 가능하게 하기
				SimpleDateFormat simpledf = new SimpleDateFormat("yyyyMMddHHmmSS");
				String tripFileRename = simpledf.format(new Date(System.currentTimeMillis())) + "." + tripFileName.substring(tripFileName.lastIndexOf(".")+1);
				File file = new File(savePath);
				// 해당 경로에 폴더 확인 후 없으면 생성
				if(!file.exists()) {
					file.mkdir();
				}
				uploadFile.transferTo(new File(savePath+"\\"+tripFileRename));
				String tripFilePath = savePath+"\\"+tripFileRename;
				trip.setTripFileName(tripFileName);
				trip.setTripFileRename(tripFileRename);
				trip.setTripFilePath(tripFilePath);
			}
			int result = tService.registerTrip(trip);
			mv.setViewName("trip/tripDetailView");
		} catch (Exception e) {
			e.printStackTrace();
		}
	return mv;
	}

	@RequestMapping(value="/trip/tripList.tripkase", method=RequestMethod.GET)
	public ModelAndView tripListView(
			ModelAndView mv,
			@RequestParam(value="page", required=false) Integer page) {
		int currentPage = (page != null) ? page : 1;
		int totalCount = tService.getTotalCount("", ""); // 전체 개시물의 갯수
				int tripLimit = 10;
				int naviLimit = 5;
				int maxPage;
				int startNavi;
				int endNavi;
				maxPage = (int)((double)totalCount / tripLimit + 0.9); // 0.9는 반올림하기 위해서 작성해주는 것
				startNavi = ((int)((double)currentPage/naviLimit + 0.9)-1) * naviLimit + 1;
				endNavi = startNavi + naviLimit - 1;
				if(maxPage < endNavi) {
					endNavi = maxPage;
				} // 오류방지
				
				// 게시판 리스트
				List<Trip> tList = tService.printAllTrip(currentPage, tripLimit);
				if(!tList.isEmpty()) {
					mv.addObject("urlValue", "list"); // 검색 후 페이징 사용 시 url값이 list에서 search로 변경되지 않는 것을 해결
					mv.addObject("maxPage", maxPage);
					mv.addObject("currentPage", currentPage); // [이전], [다음] 페이징 처리 하기 위해 작성	
					mv.addObject("startNavi", startNavi);
					mv.addObject("endNavi", endNavi);
					mv.addObject("tList", tList);
				}
		mv.setViewName("trip/tripListView");
		return mv;
	}

	@RequestMapping(value="/trip/detailView.tripkase", method=RequestMethod.GET)
	public ModelAndView tripDetailView(
			ModelAndView mv,
			@RequestParam("tripNo") int tripNo,
			HttpSession session) {
		Trip trip = tService.printListOne(tripNo);
		session.setAttribute("tripNo", trip.getTripNo());
		mv.addObject("trip", trip);
		mv.setViewName("trip/tripDetailView");
		return mv;
	}
}
