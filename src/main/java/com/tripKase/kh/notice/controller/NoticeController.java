package com.tripKase.kh.notice.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tripKase.kh.admin.domain.NoticeImg;
import com.tripKase.kh.member.domain.Member;
import com.tripKase.kh.notice.domain.Notice;
import com.tripKase.kh.notice.domain.NoticeReply;
import com.tripKase.kh.notice.service.NoticeService;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService nService;
	
	/**
	 * 공지 목록 조회
	 * @param mv
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/notice/list.tripkase", method=RequestMethod.GET)
	public ModelAndView showNoticeList(
			ModelAndView mv,
			@RequestParam(value="page", required=false) Integer page) {
		int currentPage = (page != null) ? page : 1; // 현재 페이지(페이지가 없으면 1, 아니면 해당 페이지 번호)
		int totalCount = nService.getTotalCount(); // 총 게시글 수
		int noticeLimit = 5; // 한 페이지에 보여줄 게시글 수
		int naviLimit = 5; // 한 화면에서 보여줄 페이지 수
		int maxPage; // 마지막 페이지 번호
		int startNavi; // 페이징 시작 번호 ex. (6) 7 8 9 10
		int endNavi; // 페이징 끝 번호 ex. 6 7 8 9 (10)
		
		maxPage = (int)((double)totalCount/noticeLimit+0.95); // int로 형변환시 내림 위해 0.9 더하기
		startNavi = ((int)((double)currentPage/naviLimit+0.9)-1)*naviLimit+1;
		endNavi = startNavi + naviLimit - 1;
		if(maxPage < endNavi) {
			endNavi = maxPage;
		}
		
		List<Notice> nList = nService.printAllNotice(currentPage, noticeLimit);
		if(!nList.isEmpty()) {
			mv.addObject("urlVal", "list");
			mv.addObject("maxPage", maxPage);
			mv.addObject("currentPage", currentPage);
			mv.addObject("startNavi", startNavi);
			mv.addObject("endNavi", endNavi);
			mv.addObject("nList", nList);
		}
		
		mv.setViewName("notice/noticeList");
		return mv;
	}
	
	/**
	 * 공지 상세 + 댓글 조회
	 * @param mv
	 * @param noticeNo
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/notice/detail.tripkase", method=RequestMethod.GET)
	public ModelAndView showNoticeDetail(
			ModelAndView mv,
			@RequestParam("noticeNo") Integer noticeNo,
			HttpSession session) {
		try {
			Notice notice = nService.printOneByNo(noticeNo);
			List<NoticeImg> nImgList = nService.printImgByNo(noticeNo);
			List<NoticeReply> nReplyList = nService.printAllnReply(noticeNo);
			session.setAttribute("noticeNo", notice.getNoticeNo());
			mv.addObject("notice", notice);
			mv.addObject("nImgList", nImgList);
			mv.addObject("nReplyList", nReplyList);
			mv.setViewName("notice/noticeDetail");
		} catch (Exception e) {
			mv.addObject("msg", e.toString());
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	/**
	 * 공지 댓글 등록
	 * @param mv
	 * @param nReply
	 * @param page
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/notice/replyRegister.tripkase", method=RequestMethod.POST)
	public ModelAndView registerNoticeReply(
			ModelAndView mv,
			@ModelAttribute NoticeReply nReply,
			HttpSession session) {
		Member member = (Member)session.getAttribute("loginMember");
		String nReplyWriter = member.getMemberNick();
		nReply.setnReplyWriter(nReplyWriter);
		int noticeNo = nReply.getRefNoticeNo();
		int result = nService.registerNReply(nReply);
		if(result > 0) {
			mv.setViewName("redirect:/notice/detail.tripkase?noticeNo="+noticeNo);
		}
		return mv;
	}
	
	/**
	 * 공지 댓글 수정
	 * @param nReply
	 * @return
	 */
	@RequestMapping(value="/notice/replyModify.tripkase", method=RequestMethod.POST)
	public String modifyNoticeReply(
			@ModelAttribute NoticeReply nReply) {
		int result = nService.modifyNReply(nReply);
		return "redirect:/notice/list.tripkase";
	}
}
