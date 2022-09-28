package com.tripKase.kh.trip.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.tripKase.kh.member.domain.Member;
import com.tripKase.kh.restaurant.domain.Restaurant;
import com.tripKase.kh.trip.domain.Trip;
import com.tripKase.kh.trip.domain.TripReply;
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
			@RequestParam(value="uploadFile") MultipartFile uploadFile,
			HttpServletRequest request,
			HttpSession session) {
		try {
			String tripFileName = uploadFile.getOriginalFilename();
			if(!tripFileName.equals("")) {
				Member member = (Member)session.getAttribute("loginMember");
				String tripWriter = member.getMemberNick();
				trip.setTripWriter(tripWriter);
				String tripProfile = member.getmPfpReName();
				trip.setTripProfile(tripProfile);
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
				trip.setTripCreate(new Date(System.currentTimeMillis()));
			}
			int result = tService.registerTrip(trip);
			mv.setViewName("trip/tripDetailView");
		} catch (Exception e) {
			e.printStackTrace();
		}
	return mv;
	}

	/**
	 * 여행소통 상세페이지 댓글 등록
	 * @param mv
	 * @param tReply
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/trip/addReply.tripkase", method=RequestMethod.POST)
	public ModelAndView registerTriptReply(
			ModelAndView mv,
			@ModelAttribute TripReply tripReply,
			@RequestParam("page") int page,
			HttpSession session) {
		Member member = (Member)session.getAttribute("loginMember");
		String tReplyWriter = member.getMemberNick();
		tripReply.settReplyWriter(tReplyWriter);
		String tReplyProfile = member.getmPfpReName();
		tripReply.settReplyProfile(tReplyProfile);
		int tripNo = tripReply.getRepTripNo();
		int result = tService.registerReply(tripReply);
		if(result > 0) {
			mv.setViewName("redirect:/trip/detailView.tripkase?tripNo="+tripNo+"&page="+page);
		}
		return mv;
	}
	
	/**
	 * 여행소통 게시판 리스트
	 * @param mv
	 * @param trip
	 * @param page
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/trip/tripList.tripkase", method=RequestMethod.GET)
	public ModelAndView tripListView(
			ModelAndView mv,
			@ModelAttribute Trip trip,
			@RequestParam(value="page", required=false) Integer page,
			HttpSession session) {
		
		int currentPage = (page != null) ? page : 1; // 현재 페이지 (페이지가 없으면 1 아니면 해당 페이지 번호)
		int totalCount = tService.getTotalCount(""); // 전체 개시물의 갯수 ("","")는 검색기능!
		int tripLimit = 16; // 한 페이지에 보여줄 게시글 수
		int naviLimit = 5; // 한 화면에서 보여줄 페이지 수 
		int maxPage; // 마지막 페이지 번호
		int startNavi; // 페이징 시작 번호
		int endNavi; // 페이징 끝 번호
		maxPage = (int)((double)totalCount / tripLimit + 0.95); // 0.9는 반올림하기 위해서 작성해주는 것
		startNavi = ((int)((double)currentPage/naviLimit + 0.95)-1) * naviLimit + 1;
		endNavi = startNavi + naviLimit - 1;
		if(maxPage < endNavi) {
			endNavi = maxPage;
		}
			
		List<Trip> tList = tService.printAllTrip(currentPage, tripLimit);
		if(!tList.isEmpty()) {
			mv.addObject("urlVal", "tripList"); // 검색 후 페이징 사용 시 url값이 list에서 search로 변경되지 않는 것을 해결
			mv.addObject("maxPage", maxPage);
			mv.addObject("currentPage", currentPage); // [이전], [다음] 페이징 처리 하기 위해 작성	
			mv.addObject("startNavi", startNavi);
			mv.addObject("endNavi", endNavi);
			mv.addObject("tList", tList);
		}
		mv.setViewName("trip/tripListView");
		return mv;
	}
	
	/**
	 * 게시글 검색 기능
	 * @param mv
	 * @param searchValue
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/trip/searchTrip.tripkase", method=RequestMethod.GET)
	public ModelAndView tripSearchList(
			ModelAndView mv,
			@RequestParam("searchValue") String searchValue,
			@RequestParam(value="page", required=false) Integer page) {
		int currentPage = (page != null) ? page : 1;
		int totalCount = tService.getTotalCount(searchValue); // 전체 개시물의 갯수
		int tripLimit = 16;
		int naviLimit = 5;
		int maxPage;
		int startNavi;
		int endNavi;
		maxPage = (int)((double)totalCount / tripLimit + 0.95); // 0.9는 반올림하기 위해서 작성해주는 것
		startNavi = ((int)((double)currentPage/naviLimit + 0.95)-1) * naviLimit + 1;
		endNavi = startNavi + naviLimit - 1;
		if(maxPage < endNavi) {
			endNavi = maxPage;
		} 
		List<Trip> tList = tService.printSearchTrip(searchValue, currentPage, tripLimit);
		if(!tList.isEmpty()) {
			mv.addObject("tList", tList);
		}else {
			mv.addObject("tList", null);
		}
		mv.addObject("urlVal", "searchTrip");
		mv.addObject("searchValue", searchValue);
		mv.addObject("maxPage", maxPage);
		mv.addObject("currentPage", currentPage); // [이전], [다음] 페이징 처리 하기 위해 작성	
		mv.addObject("startNavi", startNavi);
		mv.addObject("endNavi", endNavi);
		mv.setViewName("trip/tripListView");
		return mv;
	}
	
	/**
	 * 여행소통 상세페이지
	 * @param mv
	 * @param tripNo
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/trip/detailView.tripkase", method=RequestMethod.GET)
	public ModelAndView tripDetailView(
			ModelAndView mv,
			@ModelAttribute TripReply tripReply,
			@RequestParam("tripNo") int tripNo,
			@RequestParam("page") Integer page,
			HttpSession session) {
		Trip trip = tService.printListOne(tripNo);
		List<TripReply> rList = tService.printAllTripReply(tripNo);
		// 로그인 사용자 닉네임 가져오기
		Member member = (Member)session.getAttribute("loginMember");
		// 댓글 List 
		session.setAttribute("tripNo", trip.getTripNo());
		// 댓글 List를 jsp에서 사용가능하게 해주는 코드
		mv.addObject("trip", trip);
		mv.addObject("member", member);
		mv.addObject("rList", rList);
		mv.addObject("page", page);
		mv.setViewName("trip/tripDetailView");
		return mv;
	} 
	
	/**
	 * 게시글 상세페이지 수정 화면
	 * @param mv
	 * @param tripNo
	 * @return
	 */
	@RequestMapping(value="/trip/tripModifyView.tripkase", method=RequestMethod.GET)
	public ModelAndView tripModifyView(
			ModelAndView mv,
			@RequestParam("tripNo") Integer tripNo,
			@RequestParam("page") int page) {
		Trip trip = tService.printListOne(tripNo);
		mv.addObject("trip", trip);
		mv.addObject("page", page);
		mv.setViewName("trip/tripModifyView");
		return mv;
	}
	
	/**
	 * 게시글 상세페이지 수정 기능
	 * @param mv
	 * @param trip
	 * @param reloadFile
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/trip/tripModify.tripkase", method=RequestMethod.POST)
	public ModelAndView tripModify(
			ModelAndView mv,
			@ModelAttribute Trip trip,
			@RequestParam(value="reloadFile") MultipartFile reloadFile,
			@RequestParam("tripNo") Integer tripNo,
			@RequestParam("page") Integer page,
			HttpServletRequest request,
			HttpSession session) {
		String tripFileName = reloadFile.getOriginalFilename();
		if(reloadFile != null && !tripFileName.equals("")) {
			String root = request.getSession().getServletContext().getRealPath("resources");
			String savedPath = root + "\\tuploadFiles";
			File file = new File(savedPath + "\\" + trip.getTripFileRename());
			if(file.exists()) {
				file.delete();
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String tripFileRename = sdf.format(new Date(System.currentTimeMillis())) + "." + tripFileName.substring(tripFileName.lastIndexOf(".")+1);
			String tripFilePath = savedPath + "\\" + tripFileRename;
			try {
				reloadFile.transferTo(new File(tripFilePath));
				trip.setTripFileName(tripFileName);
				trip.setTripFileRename(tripFileRename);
				trip.setTripFilePath(tripFilePath);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		int result = tService.modifyTrip(trip);
		mv.setViewName("redirect:/trip/detailView.tripkase?tripNo="+tripNo+"&page="+page);
		return mv;
	}
	
	/**
	 * 여행소통 게시글 삭제
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/trip/tripRemove.tripkase", method=RequestMethod.GET)
	public String tripRemove(
			Model model,
			HttpSession session) {
		int tripNo = (Integer)session.getAttribute("tripNo");
		int result = tService.removeListOne(tripNo);
		if(result > 0) {
			session.removeAttribute("tripNo");
		}
		return "redirect:/trip/tripList.tripkase";
	}
	
	/**
	 * 댓글 삭제
	 * @param tReplyNo
	 * @return
	 */
	@RequestMapping(value="/tirp/removeReply.tripkase", method=RequestMethod.POST)
	public String removeBoardReply(
			@RequestParam("tReplyNo") Integer tReplyNo) {
		int result = tService.deleteReply(tReplyNo);
		return "redirect:/trip/tripList.tripkase";
	}
}
