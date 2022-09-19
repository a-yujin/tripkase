package com.tripKase.kh.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.ModelAndView;

import com.tripKase.kh.admin.domain.Report;
import com.tripKase.kh.admin.service.AdminService;
import com.tripKase.kh.member.domain.Member;

@Controller
public class AdminController {

	@Autowired
	AdminService aService;
	
	//회원 검색 폼으로 이동
	@RequestMapping(value="/admin/memberSelectForm.tripkase", method=RequestMethod.GET)
	public ModelAndView memberSelectView(
			ModelAndView mv) {
		mv.setViewName("admin/memberSelectForm");
		return mv;
	}
	
	//개별 회원 조회
	@RequestMapping(value="/admin/memberOne.tripkase", method=RequestMethod.GET)
	public ModelAndView selectOneMember(
			ModelAndView mv
			,@RequestParam("memberId") String memberId
			,@RequestParam("memberName") String memberName
			) {
		Member member = aService.selectOneMember(memberId, memberName);
		try {
			mv.addObject("member",member);
			mv.setViewName("admin/memberList");
		} catch (Exception e) {
			mv.addObject("msg",e.toString());
			mv.setViewName("/common/errorPage");
		}
		return mv;
	}
	
	//전체 회원 조회
	@RequestMapping(value="/admin/memberAll.tripkase", method=RequestMethod.GET)
	public ModelAndView selectAllMember(
			ModelAndView mv) {
		List<Member> mList = aService.selectAllMember();
		try {
			mv.addObject("mList",mList);
			mv.setViewName("admin/memberList");
		} catch (Exception e) {
			mv.addObject("msg",e.toString());
			mv.setViewName("/common/errorPage");
		}
		return mv;
	}
	
	
	//회원 상세 조회
	@RequestMapping(value="/admin/memberDetail.tripkase", method=RequestMethod.GET)
	public ModelAndView memberDetail(
			ModelAndView mv
			,@RequestParam("memberId") String memberId
			,@RequestParam("memberName") String memberName
			) {
		System.out.println(memberId);
		System.out.println(memberName);
		Member member = aService.selectOneMember(memberId, memberName);
		try {
			mv.addObject("member",member);
			mv.setViewName("admin/memberDetail");
		} catch (Exception e) {
			mv.addObject("msg",e.toString());
			mv.setViewName("/common/errorPage");
		}
		return mv;
	}
	
	//회원 정보 수정
	@RequestMapping(value="/admin/updateMember.tripkase", method=RequestMethod.POST)
	public ModelAndView updateMember(
			ModelAndView mv
			, @ModelAttribute Member member) {
		try {
			int result = aService.updateMember(member);
			mv.setViewName("redirect:/admin/memberAll.tripkase");
		} catch (Exception e) {
			mv.addObject("msg",e.toString());
			mv.setViewName("/common/errorPage");
		}
		return mv;
	}
	
	//회원 정보 삭제
	@RequestMapping(value="/admin/deleteMember.tripkase")
	public ModelAndView deleteMember(
			ModelAndView mv
			,@RequestParam("memberId") String memberId) {
		try {
			int result = aService.deleteMember(memberId);
			mv.setViewName("redirect:/admin/memberAll.tripkase");
		} catch (Exception e) {
			mv.addObject("msg",e.toString());
			mv.setViewName("/common/errorPage");
		}
		return mv;
		
	}
	
	
	//신고 전체 조회
	@RequestMapping(value="/admin/reportList.tripkase", method=RequestMethod.GET)
	public ModelAndView ReportList(
			ModelAndView mv) {
		List<Report> rList = aService.selectAllReport();
		try {
			mv.addObject("rList", rList);
			mv.setViewName("/admin/reportList");
		} catch (Exception e) {
			mv.addObject("msg",e.toString());
			mv.setViewName("/common/errorPage");
		}
		return mv;
	}
	
	//신고 상세 조회
	
	
	//신고 컨텐츠(게시글, 댓글, 평점) 삭제
	
	//공지 조회
	
	//공지 상세 조회
	
	//공지 등록
	
	//공지 수정
	
	//공지 삭제
	
	//문의 조회
	
	//문의 상세 조회
	
	//문의 답변 등록
	
		
}
