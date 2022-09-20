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
import com.tripKase.kh.grade.domain.Grade;
import com.tripKase.kh.member.domain.Member;
import com.tripKase.kh.notice.domain.NoticeReply;
import com.tripKase.kh.qna.domain.QnA;
import com.tripKase.kh.trip.domain.Trip;
import com.tripKase.kh.trip.domain.TripReply;

@Controller
public class AdminController {

	@Autowired
	AdminService aService;
	
	
	//관리자 메인페이지 뷰
	@RequestMapping(value="/admin/adminMainPage.tripkase")
	public String mainPageView() {
		return "/admin/adminMain";
	}
	
	
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
	@RequestMapping(value="/admin/reportDetail.tripkase")
	public ModelAndView reportDetail(
			ModelAndView mv
			,@RequestParam("reportNo") int reportNo) {
			
			//신고 객체 가져오기
			Report report = aService.selectOneReport(reportNo);
			
			//컨텐츠 타입, 컨텐츠 순번 가져오기
			String cotentsType = report.getCommonType();
			int cotentsNo = report.getCommonNo();
			
			//게시글 신고면 여행 게시글 정보가져오고 디테일로 넘기기
			if(cotentsType.equals("게시글")) {
				Trip trip = aService.selectTripByNo(cotentsNo);
				mv.addObject("trip",trip);
			//여행 신고면 여행 게시글의 댓글 가져오고 디테일로 넘기기
			} else if(cotentsType.equals("여행 댓글")) {
				TripReply tripReply  = aService.selectTripRelyByNo(cotentsNo);
				mv.addObject("tripReply",tripReply);
			//문의 신고면 문의 게시글의 댓글 가져오고 디테일로 넘기기
			} else if(cotentsType.equals("공지 댓글")) {
				NoticeReply noticeReply  = aService.selectNoticeReplyByNo(cotentsNo);
				mv.addObject("noticeReply",noticeReply);
			//평점 신고면 평점 가져오고 디테일로 넘기기
			} else if (cotentsType.equals("평점")) {
				Grade grade = aService.selectGradeByNo(cotentsNo);
				mv.addObject("grade",grade);
			}
			mv.addObject("report",report);
			mv.setViewName("/admin/reportDetail");
		return mv;
	}
	
	//신고 컨텐츠(게시글, 댓글, 평점) 삭제
	@RequestMapping(value="/admin/deleteContents.tripkase")
	public ModelAndView deleteContents(
			ModelAndView mv
			,@RequestParam("reportNo") Integer reportNo
			,@RequestParam(value="tripNo", required=false) Integer tripNo
			,@RequestParam(value="tReplyNo", required=false) Integer tReplyNo
			,@RequestParam(value="nReplyNo", required=false) Integer nReplyNo
			,@RequestParam(value="gradeNo", required=false) Integer gradeNo
			) {
		//해당 컨텐츠로 찾아가 삭제하기
		if(tripNo != null) {
			int result = aService.deleteTripByNo(tripNo);
		} else if (tReplyNo != null) {
			int result = aService.deleteTripReplyByNo(tReplyNo);
		} else if (nReplyNo != null) {
			int result = aService.deleteNoticeReplyByNo(nReplyNo);
		} else if (gradeNo != null) {
			int result = aService.deleteGradeByNo(gradeNo);
		}
		//해당 컨텐츠를 삭제하면 신고 완료 처리(신고삭제)
			int result = aService.deleteReport(reportNo);
			mv.setViewName("redirect:/admin/reportList.tripkase");
		return mv;
	}
	
	//공지 조회
	public ModelAndView noticeList(
			ModelAndView mv) {
		
		return mv;
	}
	
	//공지 상세 조회
	
	//공지 등록
	
	//공지 수정
	
	//공지 삭제
	
	//문의 조회
	
	//문의 상세 조회
	
	//문의 답변 등록
	
		
}
