package com.tripKase.kh.storage.controller;

import java.util.HashMap;
import java.util.List;

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
	
//	/**
//	 * 보관함 데이터 불러오기
//	 * @param session 세션 정보
//	 * @return 보관함데이터 리스트
//	 */
//	@RequestMapping(value = "/storage/getStorageData.tripkase")
//	public List<Storage> getStorageData(HttpSession session) {
//		Member member = (Member)session.getAttribute("loginMember");
//		String memberId = member.getMemberId();
//
//		return  stoService.getStorageData(memberId);
//	}

	/**
	 *  보관함 등록
	 * @param session 세션 정보 / paramMap 컨텐츠코드, 컨텐츠넘버, 멤버아이디
	 * @return mv > 인서트한 결과값
	 */
	@RequestMapping(value="/storage/insertStorage.tripkase", method = RequestMethod.POST)
	public ModelAndView insertStorage(ModelAndView mv, @RequestParam HashMap<String, Object> paramMap, HttpSession session){
		try {
			Member member = (Member)session.getAttribute("loginMember");
			String memberId = member.getMemberId();
			paramMap.put("memberId", memberId);
			int result = stoService.insertStorage(paramMap);
//			System.out.println(paramMap);
			if(result > 0) {
				mv.setViewName("storage/storageMainPage");
			}
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("msg", e.getMessage()).setViewName("common/errorPage");
		}
		return mv;
	}
	
	
	/**
	 *  보관함에서 컨텐츠 삭제
	 * 
	 * 
	 */
	@RequestMapping(value="/storage/deleteStorage.tripkase", method=RequestMethod.GET)
	public ModelAndView deleteStorage(ModelAndView mv, HttpSession session, @RequestParam("stoNo") Integer stoNo) {
		try {
			int result = stoService.deleteStorage(stoNo);
			System.out.println(stoNo);
			if(result > 0) {
				session.removeAttribute("stoNo");
				mv.setViewName("storage/storageMainPage");				
			}
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("msg", e.getMessage()).setViewName("common/errorPage");
		}
		return mv;
	}
	


	
	@RequestMapping(value = "/storage/storageView.tripkase", method=RequestMethod.GET)
	public ModelAndView showStorageView(ModelAndView mv, HttpSession session) {
		try {
			Member member = (Member)session.getAttribute("loginMember");
			String memberId = member.getMemberId();
			List<Storage> resDataList = stoService.getResDataByMemberId(memberId);
			List<Storage> roomDataList = stoService.getRoomDataByMemberId(memberId);
			List<Storage> attrDataList = stoService.getAttrDataByMemberId(memberId);
			//System.out.println(resDataList);
			mv.addObject("resDataList",resDataList);
			mv.addObject("roomDataList",roomDataList);
			mv.addObject("attrDataList",attrDataList);
			mv.setViewName("storage/storageMainPage");
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("msg", e.getMessage()).setViewName("common/errorPage");
		}
		return mv;
	}
	
	
	
//	내가 만든 겟스토리지데이터 마크원버전
//	@RequestMapping(value = "/storage/storageView.tripkase", method=RequestMethod.GET)
//	public ModelAndView getStorageData(ModelAndView mv, HttpSession session) {
//		Member member = (Member)session.getAttribute("loginMember");
//		String memberId = member.getMemberId();
//		List<Storage> stoList = stoService.getStorageData(memberId);
//		mv.addObject("stoList",stoList);
//		System.out.println(stoList);
//		mv.setViewName("storage/storageMainPage");
//		return mv;
//	}


}
