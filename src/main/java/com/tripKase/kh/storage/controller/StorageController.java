package com.tripKase.kh.storage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tripKase.kh.member.domain.Member;
import com.tripKase.kh.storage.service.StorageService;

@Controller
public class StorageController {

//	@Autowired
//	private StorageService stoService;
//	
//	@RequestMapping(value = "/storage/storageView.tripkase", method = RequestMethod.GET)
//	public ModelAndView storageView(ModelAndView mv, HttpServletRequest request) {
//
//		HttpSession session = request.getSession();
//		Member member = (Member) session.getAttribute("loginMember");
//		String memberId = member.getMemberId();
//		Member mOne = stoService.(memberId);
//		if (mOne != null) {
//			mv.addObject("mOne", mOne);
//			mv.setViewName("/storage/storageMainPage");
//		} else {
//			mv.addObject("msg", "회원정보가 없습니다.");
//			mv.setViewName("common/errorPage");
//		}
//		return mv;
//	}
}
