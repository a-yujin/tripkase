package com.tripKase.kh.storage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tripKase.kh.member.domain.Member;
import com.tripKase.kh.storage.domain.Storage;
import com.tripKase.kh.storage.service.StorageService;

@Controller
public class StorageController {

	@Autowired
	private StorageService stoService;
	
	/**
	 * 보관함 데이터 불러오기
	 * @param session 세션 정보
	 * @return 보관함데이터 리스트
	 */
	@RequestMapping(value = "/storage/getStorageData.tripkase")
	public List<Storage> getStorageData(HttpSession session) {
		Member member = (Member)session.getAttribute("loginMember");
		String memberId = member.getMemberId();

		return stoService.getStorageData(memberId);
	}
	
//	@RequestMapping(value="/storage/insertStorage.tripkase", method = RequestMethod.GET)
//	public ModelAndView insertStorage(ModelAndView mv, @RequestParam("contentsCode") String contentsCode,
//														@RequestParam("contentsId") String contentsId){
//		try {
//			int result = stoService.insertStorage(contentsCode, contentsId);
//			
//		} catch (Exception e) {
//
//		}
//		
//		return mv;
//	}
	
	@RequestMapping(value="/storage/storageView.tripkase", method = RequestMethod.GET)
	public String storageMainView() {
		return "storage/storageMainPage";
	}
}
