package com.tripKase.kh.qna.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tripKase.kh.member.domain.Member;
import com.tripKase.kh.qna.domain.QnA;
import com.tripKase.kh.qna.service.QnAService;

@Controller
public class QnAController {

	@Autowired
	QnAService qService;
	
	//질문 메인페이지(전체조회+질문등록)로
	@RequestMapping("/qna/qnaMainView.tripkase")
	public ModelAndView qnaMainView(
			ModelAndView mv
			,@RequestParam(value="page", required = false) Integer page
			,HttpSession session) {
			String memberId = ((Member)session.getAttribute("loginMember")).getMemberId();
			////////////////////////////////////////////////////
			int currentPage = (page!=null) ? page : 1;
			int totalCount = qService.getQnATotalCount(memberId);
			int boardLimit = 10;
			int naviLimit = 5;
			int maxPage;
			int startNavi;
			int endNavi;
			maxPage = (int)((double)totalCount/boardLimit + 0.9);
			startNavi = ((int)((double)currentPage/naviLimit+0.9)-1)*naviLimit+1;
			System.out.println(currentPage+","+totalCount);
			endNavi = startNavi + naviLimit - 1;
			if(maxPage < endNavi) {
			endNavi = maxPage;
			}
			////////////////////////////////////////////////////
		List<QnA> qList = qService.selectAllQna(memberId);
		mv.addObject("qList",qList);
		mv.setViewName("/qna/qnaMainView");
		return mv;
	}
	
	//질문 등록 폼으로 이동
	@RequestMapping("/qna/qnaWriterForm.tripkase")
	public String qnaWriteForm() {
		return "/qna/qnaWriteForm";
	}
	
	//질문 등록
	@RequestMapping("/qna/RegisterQna.tripkase")
	public ModelAndView RegisterQna(
			ModelAndView mv
			,@ModelAttribute QnA qna
			,HttpSession session) {
		String memberId = ((Member)session.getAttribute("loginMember")).getMemberId();
		qna.setQuestionWriter(memberId);
		System.out.println(qna.toString());
		int result = qService.insertQna(qna);
		mv.setViewName("redirect:/qna/qnaMainView.tripkase");
		return mv;
	}
	
	
}
