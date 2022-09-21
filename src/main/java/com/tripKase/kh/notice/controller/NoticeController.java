package com.tripKase.kh.notice.controller;

import java.text.SimpleDateFormat;
import java.util.List;
import java.io.File;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.tripKase.kh.notice.domain.Notice;
import com.tripKase.kh.notice.service.NoticeService;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService nService;
	
	/**
	 * 공지 작성(테스트용)
	 * @return
	 */
	@RequestMapping(value="/notice/write.tripkase", method=RequestMethod.GET)
	public String showNoticeWrite() {
		return "notice/noticeWrite";
	}
	
	/**
	 * 공지 등록(테스트용)
	 * @param mv
	 * @param notice
	 * @param uploadFile
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/notice/register.tripkase", method=RequestMethod.POST)
	public ModelAndView registerNotice(
			ModelAndView mv,
			@ModelAttribute Notice notice,
			@RequestParam(value="uploadFile", required=false) MultipartFile uploadFile, // value -> jsp name
			HttpServletRequest request) {
		try {
			String noticeFileName = uploadFile.getOriginalFilename();
			if(!noticeFileName.equals("")) {
				String root = request.getSession().getServletContext().getRealPath("resources");
				String savePath = root + "\\nUploadFiles";
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				String noticeFileRename = sdf.format(new Date(System.currentTimeMillis()))+"."+noticeFileName.substring(noticeFileName.lastIndexOf(".")+1);
				File file = new File(savePath);
				if(!file.exists()) {
					file.mkdir();
				}
				uploadFile.transferTo(new File(savePath+"\\"+noticeFileRename));
				String noticeFilePath = savePath+"\\"+noticeFileRename;
				notice.setnFileName(noticeFileName);
				notice.setnFileRename(noticeFileRename);
				notice.setnFilePath(noticeFilePath);
			}
			int result = nService.registerNotice(notice);
			// 성공 시 테스트용 페이지로 이동
			mv.addObject("testMsg", "테스트 성공");
			mv.setViewName("common/testPage");
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("msg", e.getMessage());
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
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
		
		maxPage = (int)((double)totalCount/noticeLimit+0.9); // int로 형변환시 내림 위해 0.9 더하기
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
	 * 공지 상세 조회
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
			session.setAttribute("noticeNo", notice.getNoticeNo());
			mv.addObject("notice", notice);
			mv.setViewName("notice/noticeDetail");
		} catch (Exception e) {
			mv.addObject("msg", e.toString());
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
}
