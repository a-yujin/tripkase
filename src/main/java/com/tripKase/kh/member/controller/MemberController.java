package com.tripKase.kh.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	public String memberRegisterView() {
		return "member/register"; // 스프링의 리턴타입은 String으로 정해져있음
	   }	
	
	@RequestMapping(value="/member/modifyView.tripkase", method = RequestMethod.GET) // value = 사용할 url
	public String membermodifyView() {
		return "member/modify"; // 스프링의 리턴타입은 String으로 정해져있음
	   }	
	
	@RequestMapping(value="/member/findIdView.tripkase", method = RequestMethod.GET) // value = 사용할 url
	public String memberfindId() {
		return "member/findId"; // 스프링의 리턴타입은 String으로 정해져있음
	   }	
	
	@RequestMapping(value="/member/findPwdView.tripkase", method = RequestMethod.GET) // value = 사용할 url
	public String memberfindPwd() {
		return "member/findPwd"; // 스프링의 리턴타입은 String으로 정해져있음
	   }	

	// 회원가입 o
	@RequestMapping(value="/member/register.tripkase", method = RequestMethod.POST)
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
	
	// 로그인 o
	@RequestMapping(value="/member/login.tripkase", method = RequestMethod.POST)
	public ModelAndView memberLogin(
			ModelAndView mv,
			@RequestParam("memberId") String memberId,
			@RequestParam("memberPwd") String memberPwd,
			HttpServletRequest request
			) {
		Member member = new Member(memberId, memberPwd);
		Member loginMember = mService.loginMember(member);
		if(loginMember != null) {
			HttpSession session = request.getSession(); 
			session.setAttribute("loginMember", loginMember);
			mv.setViewName("redirect:/home.tripkase");
		}else {
			mv.addObject("msg","회원정보없음");
			mv.setViewName("common.errorPage");
		}
		return mv;
	}
	
	// 로그아웃 o
	@RequestMapping(value="member/logout.tripkase", method = RequestMethod.GET)
	public ModelAndView memberLogout(
			ModelAndView mv,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session != null) {
			session.invalidate();
			mv.setViewName("redirect:/home.tripkase");
		}else {
			mv.addObject("msg","로그아웃 실패");
			mv.setViewName("common.errorPage");
		}
		return mv;
	}
	
	// 아이디 찾기 - 왜 안돼?
	@RequestMapping(value="/member/findId.tripkase", method = RequestMethod.POST)
	public String findIdMember(
			@RequestParam("memberName") String memberName,
			@RequestParam("memberEmail") String memberEmail,
			HttpServletRequest request) {
		Member member = new Member(memberName,memberEmail);
		String findId = mService.findIdMember(member);
		
		if(findId == null) {
			request.setAttribute("alertMsg", "일치하는 회원정보가 없습니다.");
			return "redirect:/home.tripkase";
		}else {
			request.setAttribute("arlertMsg", memberName + "회원님의 아이디는 \"" + member.getMemberId() + "입니다.");
			return "/member/findId_ok";
		}
	}
	
	// 비밀번호 찾기
	@RequestMapping(value="member/findPwd.tripkase")
	public Member findPwdMember(
			@RequestParam("memberId") String memberId,
			@RequestParam("memberEmail") String memberEmail,
			HttpServletRequest request
			) {
		Member member = new Member(memberId, memberEmail);
		Member mOne = mService.findPwdMember(member);
		if(mOne != null ) {
			request.setAttribute("alertMsg", "회원님의 이메일로 비밀번호를 전송하였습니다.");
		}else {
			request.setAttribute("alertMsg", "일치하는 회원 정보가 없습니다.");
		}
		return mOne;
	}
	
	
	
	// 마이페이지 o
	@RequestMapping(value="/member/mypage.tripkase", method = RequestMethod.GET)
	public ModelAndView memberMyPage(
			ModelAndView mv,
			HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("loginMember");
		String memberId = member.getMemberId();
		Member mOne = mService.memberOneById(memberId);
		if( mOne != null) {
		mv.addObject("mOne", mOne);
		mv.setViewName("/member/myPage");
	}else {
		mv.addObject("msg","회원정보가 없습니다.");
		mv.setViewName("common/errorPage");
	}
		return mv;
	}
	
	// 정보수정 o
	@RequestMapping(value="/member/modify.tripkase", method = RequestMethod.GET)
	public ModelAndView modifyMember(
			ModelAndView mv,
			@ModelAttribute Member member
			) {
		try {
		int result = mService.modifyMember(member);
		if(result > 0) {
			mv.setViewName("redirect:/member/mypage.tripkase");
		}else{
			mv.addObject("msg", "회원 정보가 수정되지 않았습니다.");
			mv.setViewName("common/errorPage");
		}
		}catch (Exception e) {
			mv.addObject("msg", e.getMessage());
			mv.setViewName("common/errorPage");
	}
		return mv;
}
	// 회원 삭제 o
	@RequestMapping(value="/member/removeMember.tripkase", method = RequestMethod.GET)
	public ModelAndView removeMember(
			ModelAndView mv,
			HttpSession session) {
		try {
		Member member = (Member)session.getAttribute("loginMember");
		String memberId = member.getMemberId();
		int result = mService.removeMember(memberId);
		mv.setViewName("redirect:/member/logout.tripkase");
		}catch (Exception e) {
			mv.addObject("msg", e.getMessage());
			mv.setViewName("common.errorPage");
		}
		return mv;
	}
}































