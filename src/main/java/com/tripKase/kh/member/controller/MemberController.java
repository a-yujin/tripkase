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

	@RequestMapping(value = "/member/registerView.tripkase", method = RequestMethod.GET) // value = 사용할 url
	public String memberRegisterView() {
		return "member/register"; // 스프링의 리턴타입은 String으로 정해져있음
	}

	@RequestMapping(value = "/member/loginView.tripkase", method = RequestMethod.GET) // value = 사용할 url
	public String memberLoginView() {
		return "member/login"; // 스프링의 리턴타입은 String으로 정해져있음
	}

	@RequestMapping(value = "/member/modifyView.tripkase", method = RequestMethod.GET) // value = 사용할 url
	public String membermodifyView() {
		return "member/modify"; // 스프링의 리턴타입은 String으로 정해져있음
	}

	@RequestMapping(value = "/member/findIdView.tripkase", method = RequestMethod.GET) // value = 사용할 url
	public String memberfindId() {
		return "member/findId"; // 스프링의 리턴타입은 String으로 정해져있음
	}

	@RequestMapping(value = "/member/findPwdView.tripkase", method = RequestMethod.GET) // value = 사용할 url
	public String memberfindPwd() {
		return "member/findPwd"; // 스프링의 리턴타입은 String으로 정해져있음
	}

	// 회원가입 o
	@RequestMapping(value = "/member/register.tripkase", method = RequestMethod.POST)
	public ModelAndView register(ModelAndView mv, @ModelAttribute Member member) {
		int result = mService.registMember(member);
		if (result > 0) {
			mv.setViewName("redirect:/home.tripkase");
		} else {
			mv.addObject("msg", "회원가입을 실패했습니다.");
			mv.setViewName("redirect:home.tripkase");
		}
		return mv;
	}

	// 로그인 o
	@RequestMapping(value = "/member/login.tripkase", method = RequestMethod.POST)
	public ModelAndView memberLogin(ModelAndView mv, @RequestParam("memberId") String memberId,
			@RequestParam("memberPwd") String memberPwd, HttpServletRequest request) {
		Member member = new Member(memberId, memberPwd);
		Member loginMember = mService.loginMember(member);
		if (loginMember != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", loginMember);
			mv.setViewName("redirect:/home.tripkase");
		} else {
			mv.addObject("msg", "회원정보없음");
			mv.setViewName("common.errorPage");
		}
		return mv;
	}

	// 로그아웃 o
	@RequestMapping(value = "/member/logout.tripkase", method = RequestMethod.GET)
	public ModelAndView memberLogout(ModelAndView mv, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session != null) {
			session.invalidate();
			mv.setViewName("redirect:/home.tripkase");
		} else {
			mv.addObject("msg", "로그아웃 실패");
			mv.setViewName("common.errorPage");
		}
		return mv;
	}

	// 아이디 찾기 o
	@RequestMapping(value = "/member/findId.tripkase", method = RequestMethod.POST)
	public String findIdMember(
			@RequestParam("memberName") String memberName,
			@RequestParam("memberEmail") String memberEmail, 
			HttpServletRequest request) {
		Member member = mService.findIdMember(memberName, memberEmail);
		if (member == null) {
			return "/member/findId_no";
		} else {
			request.setAttribute("Msg", memberName + "님 회원님의 아이디는 " + member.getMemberId() + "입니다.");
			return "/member/findId_ok";
		}
	}

	
	  // 비밀번호 찾기 o
	  @RequestMapping(value="member/findPwd.tripkase", method = RequestMethod.POST) 
	  public String findPwdMember(
		  @RequestParam("memberId") String memberId,
		  @RequestParam("memberEmail") String memberEmail, 
		  HttpServletRequest request ) {
		  Member member = mService.findPwdMember(memberId, memberEmail);
		  if(member != null ) {
			  request.setAttribute("Msg", member.getMemberName() + "님 회원님의 비밀번호는 " + member.getMemberEmail()+ "로 전송되었습니다.");
			  return "/member/findPwd_ok";
		  }else {
			  request.setAttribute("alertMsg", "일치하는 회원 정보가 없습니다."); } 
		  	  return "/member/findPwd_no";
	  }
	 

	// 마이페이지 o
	@RequestMapping(value = "/member/myinfo.tripkase", method = RequestMethod.GET)
	public ModelAndView memberMyInfo(ModelAndView mv, HttpServletRequest request) {

		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("loginMember");
		String memberId = member.getMemberId();
		Member mOne = mService.memberOneById(memberId);
		if (mOne != null) {
			mv.addObject("mOne", mOne);
			mv.setViewName("/member/myinfo");
		} else {
			mv.addObject("msg", "회원정보가 없습니다.");
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	// 마이페이지 o
	@RequestMapping(value = "/member/myPage.tripkase", method = RequestMethod.GET)
	public ModelAndView memberMyPage(ModelAndView mv, HttpServletRequest request) {

		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("loginMember");
		String memberId = member.getMemberId();
		Member mOne = mService.memberOneById(memberId);
		if (mOne != null) {
			mv.addObject("mOne", mOne);
			mv.setViewName("/member/myPage");
		} else {
			mv.addObject("msg", "회원정보가 없습니다.");
			mv.setViewName("common/errorPage");
		}
		return mv;
	}

	// 정보수정 o
	@RequestMapping(value = "/member/modify.tripkase", method = RequestMethod.GET)
	public ModelAndView modifyMember(ModelAndView mv, @ModelAttribute Member member) {
		try {
			int result = mService.modifyMember(member);
			if (result > 0) {
				mv.setViewName("redirect:/member/mypage.tripkase");
			} else {
				mv.addObject("msg", "회원 정보가 수정되지 않았습니다.");
				mv.setViewName("common/errorPage");
			}
		} catch (Exception e) {
			mv.addObject("msg", e.getMessage());
			mv.setViewName("common/errorPage");
		}
		return mv;
	}

	// 회원 삭제 o
	@RequestMapping(value = "/member/removeMember.tripkase", method = RequestMethod.GET)
	public ModelAndView removeMember(ModelAndView mv, HttpSession session) {
		try {
			Member member = (Member) session.getAttribute("loginMember");
			String memberId = member.getMemberId();
			int result = mService.removeMember(memberId);
			mv.setViewName("redirect:/member/logout.tripkase");
		} catch (Exception e) {
			mv.addObject("msg", e.getMessage());
			mv.setViewName("common.errorPage");
		}
		return mv;
	}
	
	// 회원 등급 - 1. id값으로 게시물  & 댓글 작성한거 count로 가져오기 메소드? 2. 가져온거로 업데이트 메소드?
	@RequestMapping(value="/member/memberGrade.tripkase", method = RequestMethod.POST) // 보여줄 페이지가 없는데 value 어떻게 해야하나?
	public ModelAndView memberGrade(
			ModelAndView mv,
			HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("loginMember");
		String memberNick = member.getMemberNick();
		int countPost = mService.countPost(memberNick);
		//int countReply = mService.countReply(memberId);
		
		
		return mv;
	}
}

















