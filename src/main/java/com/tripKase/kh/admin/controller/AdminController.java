package com.tripKase.kh.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tripKase.kh.admin.domain.Report;
import com.tripKase.kh.admin.service.AdminService;
import com.tripKase.kh.member.domain.Member;

@Controller
public class AdminController {

	@Autowired
	AdminService aService;
	
	@RequestMapping(value="/admin/memberAll.tripkase", method=RequestMethod.GET)
	public ModelAndView selectAllMember(
			ModelAndView mv) {
		List<Member> mList = aService.selectAllMember();
		return mv;
	}
	
	@RequestMapping(value="/admin/memberOne.tripkase", method=RequestMethod.GET)
	public ModelAndView selectOneMember(
			ModelAndView mv
			,@RequestParam("memberId") String memberId
			,@RequestParam("memberName") String memberName
			) {
		Member member = aService.selectOneMember(memberId, memberName);
		return mv;
	}
	

	public ModelAndView memberDetail(
			ModelAndView mv
			,@RequestParam("memberId") String memberId) {
		return mv;
	}
	
	
	@RequestMapping(value="/admin/reportList.tripkase", method=RequestMethod.GET)
	public ModelAndView ReportList(
			ModelAndView mv) {
		List<Report> rList = aService.selectAllReport();
		try {
			mv.addObject("rList", rList);
			mv.setViewName("/admin/reportList");
		} catch (Exception e) {
			mv.addObject("msg",e.toString());
		}
		return mv;
	}
	
		
}
