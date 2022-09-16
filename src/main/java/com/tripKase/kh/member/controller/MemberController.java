package com.tripKase.kh.member.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tripKase.kh.member.domain.Member;
import com.tripKase.kh.member.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService mService;
	
	@RequestMapping(value="/member/registerView.tripkase", method = RequestMethod.GET) // value = 사용할 url
	public String memberregisterView() {
		return "member/register"; // 스프링의 리턴타입은 String으로 정해져있음
	   }	

	@RequestMapping(value="/member/register.tripdkase", method = RequestMethod.POST)
	public ModelAndView register(ModelAndView mv, @ModelAttribute Member member) {
		 int result = mService.registMember(member);
		 if(result > 0) {
			 mv.setViewName("redirect:/home.tripkase");
		 }else {
			 mv.addObject("msg", "회원가입을 실패했습니다.");
			 mv.setViewName("redirect:home.tripkase");
		 }
		return mv;
	}

	@RequestMapping(value="/member/login.tripkase", method = RequestMethod.POST)
	public ModelAndView loginMember(
			ModelAndView mv,
			@RequestParam("memberId") String memberId,
			@RequestParam("memberPwd") String memberPwd,
			HttpServletRequest request
			) {
		Member member = new Member(memberId, memberPwd);
		
		
		
		return mv;
	}



}

