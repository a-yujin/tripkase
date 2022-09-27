package com.tripKase.kh.room.controller;

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
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.tripKase.kh.room.domain.Room;
import com.tripKase.kh.room.domain.RoomImg;
import com.tripKase.kh.room.domain.RoomJoin;
import com.tripKase.kh.room.service.RoomService;
import com.tripKase.kh.trip.domain.Trip;

@Controller
public class RoomController {
	@Autowired
	private RoomService rService;
	
	/**
	 * 숙소 검색 화면
	 * @return
	 */
	@RequestMapping(value="/room/searchView.tripkase", method=RequestMethod.GET)
	public String roomSearchView() {
		return "room/roomSearchView";
	}
	
	/**
	 * 숙소 등록 화면 (관리자)
	 * @return
	 */
	@RequestMapping(value="/room/registerRoom.tripkase", method=RequestMethod.GET)
	public String roomWriteView() {
		return "room/roomWriteForm";
	}
	
	/**
	 * 숙소 등록 기능 (관리자)
	 * @param mv
	 * @param room
	 * @param uploadFile
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/room/roomDataPush.tripkase", method=RequestMethod.POST)
	public ModelAndView registRoom(
			ModelAndView mv,
			@ModelAttribute Room room,
			@RequestParam(value="uploadFile", required=false) List<MultipartFile> uploadFile,
			@RequestParam("roomAddress1") String address1,
			@RequestParam("roomAddress2") String address2,
			MultipartHttpServletRequest multipartRequest,
			HttpServletRequest request) {
		room.setRoomAddress(address1 + "," + address2);
		int imgNo = 1;
		RoomImg roomImg = null;
		int result = rService.registerRoom(room);
		for(MultipartFile mf : uploadFile) {
			String roomFileName = mf.getOriginalFilename();
			if(!roomFileName.equals("")) {
				String root = request.getSession().getServletContext().getRealPath("resources");
				String savePath = root + "\\ruploadFiles";
				SimpleDateFormat simpledf = new SimpleDateFormat("yyyyMMddHHmmSS");
				String roomFileRename = simpledf.format(new Date(System.currentTimeMillis())) + "." + roomFileName.substring(roomFileName.lastIndexOf(".")+1);
				File file = new File(savePath);
				if(!file.exists()) {
					file.mkdir();
				}
				try {
					mf.transferTo(new File(savePath+"\\"+roomFileRename));
					String roomFilePath = savePath+"\\"+roomFileRename;
					roomImg = new RoomImg();
					roomImg.setRoomFileName(roomFileName);
					roomImg.setRoomFileRename(roomFileRename);
					roomImg.setRoomFilePath(roomFilePath);
					imgNo = imgNo + 1;
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			int result2 = rService.registerRoomImg(roomImg);
			mv.setViewName("redirect:/room/roomDataList.tripkase");
		}
		return mv;
	}
	
	/**
	 * 숙소 정보 리스트 기능 화면 (관리자)
	 * @param mv
	 * @param room
	 * @param page
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/room/roomDataList.tripkase", method=RequestMethod.GET)
	public ModelAndView roomDataList(
			ModelAndView mv,
			@ModelAttribute Room room,
			@RequestParam(value="page", required=false) Integer page,
			HttpSession session) {
		int currentPage = (page != null) ? page : 1; // 현재 페이지 (페이지가 없으면 1 아니면 해당 페이지 번호)
		int totalCount = rService.getTotalCount(""); // 전체 개시물의 갯수 ("","")는 검색기능!
		int roomLimit = 10; // 한 페이지에 보여줄 게시글 수
		int naviLimit = 5; // 한 화면에서 보여줄 페이지 수 
		int maxPage; // 마지막 페이지 번호
		int startNavi; // 페이징 시작 번호
		int endNavi; // 페이징 끝 번호
		maxPage = (int)((double)totalCount / roomLimit + 0.95); // 0.9는 반올림하기 위해서 작성해주는 것
		startNavi = ((int)((double)currentPage/naviLimit + 0.95)-1) * naviLimit + 1;
		endNavi = startNavi + naviLimit - 1;
		if(maxPage < endNavi) {
			endNavi = maxPage;
		}
			
		List<Room> rList = rService.printAllRoom(currentPage, roomLimit);
		if(!rList.isEmpty()) {
			mv.addObject("urlValue", "roomDataList"); // 검색 후 페이징 사용 시 url값이 list에서 search로 변경되지 않는 것을 해결
			mv.addObject("maxPage", maxPage);
			mv.addObject("currentPage", currentPage); // [이전], [다음] 페이징 처리 하기 위해 작성	
			mv.addObject("startNavi", startNavi);
			mv.addObject("endNavi", endNavi);
			mv.addObject("rList", rList);
		}
		mv.setViewName("room/roomDataList");
		return mv;
	}
	
	/**
	 * 숙소 정보 상세 페이지(관리자)
	 * @param mv
	 * @param roomNo
	 * @param page
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/room/roomDataDetailView.tripkase", method=RequestMethod.GET)
	public ModelAndView roomDataDetailView(
			ModelAndView mv,
			@RequestParam("roomNo") int roomNo,
			@RequestParam("page") Integer page,
			HttpSession session) {
		Room room = rService.printOneData(roomNo);
		List<RoomImg> riList = rService.roomImgDetail(roomNo);
		session.setAttribute("roomNo", room.getRoomNo());
		mv.addObject("room", room);
		mv.addObject("riList", riList);
		mv.addObject("page", page);
		mv.setViewName("room/roomDataDetail");
		return mv;
	}
	
	/**
	 * 숙소 정보 삭제 기능
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/room/roomDataRemove.tripkase", method=RequestMethod.GET)
	public String roomDataRemove(
			Model model,
			HttpSession session) {
		int roomNo = (Integer)session.getAttribute("roomNo");
		int result = rService.removeDataOne(roomNo);
		if(result > 0) {
			session.removeAttribute("roomNo");
		}
		return "redirect:/room/roomDataList.tripkase";
	}
	
	/**
	 * 게시글 상세페이지 수정 화면
	 * @param mv
	 * @param roomNo
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/room/roomDataModifyView.tripkase", method=RequestMethod.GET)
	public ModelAndView roomDataModifyView(
			ModelAndView mv,
			@RequestParam("roomNo") Integer roomNo,
			@RequestParam(value="page", required=false) Integer page) {
		int currentPage = (page != null) ? page : 1;
		Room room = rService.printOneData(roomNo);
		List<RoomImg> riList = rService.roomImgDetail(roomNo);
		mv.addObject("room", room);
		mv.addObject("riList", riList);
		mv.addObject("page", page);
		mv.setViewName("/room/roomDataModify");
		return mv;
	}
	
	/**
	 * 숙소 게시글 수정 기능
	 * @param mv
	 * @param room
	 * @param reloadFile
	 * @param roomImgNoArray
	 * @param roomFileRenameArray
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/room/updateRoomData.tripkase", method=RequestMethod.POST)
	public ModelAndView updateRoomData(
			ModelAndView mv,
			@ModelAttribute Room room,
			@RequestParam("roomNo") Integer roomNo,
			@RequestParam("page") Integer page,
			@RequestParam(value="reloadFile", required=false) List<MultipartFile> reloadFile,
			@RequestParam("roomImgNo") int[] roomImgNoArray,
			@RequestParam("roomFileRename") String[] roomFileRenameArray,
			@RequestParam("roomAddress1") String address1,
			@RequestParam("roomAddress2") String address2,
			HttpServletRequest request) {
		int num = 0;
		int currentPage = (page != null) ? page : 1;
		room.setRoomAddress(address1 + "," + address2);
		RoomImg roomImg = null;
		int result1 = rService.updateRoomData(room);
		for(MultipartFile mf : reloadFile) {
			String roomFileName = mf.getOriginalFilename();
			if(!roomFileName.equals("")) {
				String root = request.getSession().getServletContext().getRealPath("resources");
				String savePath = root + "\\ruploadFiles";
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				String rFileRename = roomFileRenameArray[num];
				File file = new File(savePath + "\\" + rFileRename);
				if(file.exists()) {
					file.delete();
				}
				String roomFileRename = sdf.format(new Date(System.currentTimeMillis())) + num + "." + roomFileName.substring(roomFileName.lastIndexOf(".")+1);
				file = new File(savePath);
				try {
					mf.transferTo(new File(savePath + "\\" + roomFileRename));
					String roomFilePath = savePath + "\\" + roomFileRename;
					roomImg = new RoomImg();
					roomImg.setRoomFileName(roomFileName);
					roomImg.setRoomFileRename(roomFileRename);
					roomImg.setRoomFilePath(roomFilePath);
					int roomImgNo = roomImgNoArray[num];
					roomImg.setRoomImgNo(roomImgNo);
					num = num + 1;
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				int result2 = rService.updateRoomImg(roomImg);
				mv.setViewName("redirect:/room/roomDataList.tripkase");
			}
		}
		return mv;
	}
	
	/**
	 * 숙소 이름 검색 리스트 (사용자)
	 * @param mv
	 * @param searchValue
	 * @param currentPage
	 * @return
	 */
	@RequestMapping(value="/room/roomNameSearch.tripkase", method=RequestMethod.GET)
	public ModelAndView roomNameSearch(
			ModelAndView mv,
			@RequestParam("searchValue") String searchValue,
			@RequestParam(value="page", required=false, defaultValue="1") int currentPage,
			HttpSession session) {
		int totalCount = rService.getRoomNameCount(searchValue);
		int roomsLimit = 5;
		int naviLimit = 5;
		int maxPage;
		int startNavi;
		int endNavi;
		maxPage = (int)((double)totalCount/roomsLimit+0.95);
		startNavi = ((int)((double)currentPage/naviLimit+0.95)-1)*naviLimit+1;
		endNavi = startNavi + naviLimit -1;
		if(maxPage < endNavi) {
			endNavi = maxPage;
		}
		List<RoomJoin> rjList = rService.printSearchName(searchValue, currentPage, roomsLimit);
		if(!rjList.isEmpty()) {
			mv.addObject("rjList", rjList);
		}else {
			mv.addObject("rjList", null);
		}
		mv.addObject("searchValue", searchValue);
		mv.addObject("maxPage", maxPage);
		mv.addObject("currentPage", currentPage);
		mv.addObject("startNavi", startNavi);
		mv.addObject("endNavi", endNavi);
		mv.setViewName("room/roomSearchList");
		return mv;
	}
}
