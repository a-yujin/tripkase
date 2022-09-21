package com.tripKase.kh.admin.controller;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.tripKase.kh.admin.domain.NoticeImg;
import com.tripKase.kh.admin.domain.Report;
import com.tripKase.kh.admin.service.AdminService;
import com.tripKase.kh.grade.domain.Grade;
import com.tripKase.kh.member.domain.Member;
import com.tripKase.kh.notice.domain.Notice;
import com.tripKase.kh.notice.domain.NoticeReply;
import com.tripKase.kh.notice.service.NoticeService;
import com.tripKase.kh.qna.domain.QnA;
import com.tripKase.kh.trip.domain.Trip;
import com.tripKase.kh.trip.domain.TripReply;

@Controller
public class AdminController {

	@Autowired
	AdminService aService;
	@Autowired
	NoticeService nService;
	
	
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
			ModelAndView mv
			,@RequestParam(value="page", required=false) Integer page) {
		////////////////////////////////////////////////////
		int currentPage = (page!=null) ? page : 1;
		int totalCount = aService.getMemberTotalCount();
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
		List<Member> mList = aService.selectAllMember(currentPage, boardLimit);
		try {
			if(!mList.isEmpty()) {
				mv.addObject("currentPage", currentPage);
				mv.addObject("maxPage", maxPage);
				mv.addObject("startNavi", startNavi);
				mv.addObject("endNavi", endNavi);
				mv.addObject("mList",mList);
				mv.setViewName("admin/memberList");
			}
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
			ModelAndView mv
			,@RequestParam(value="page", required = false) Integer page) {
		////////////////////////////////////////////////////
		int currentPage = (page!=null) ? page : 1;
		int totalCount = aService.getReportTotalCount();
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
		List<Report> rList = aService.selectAllReport(currentPage, boardLimit);
		try {
			if(!rList.isEmpty()) {
				mv.addObject("currentPage", currentPage);
				mv.addObject("maxPage", maxPage);
				mv.addObject("startNavi", startNavi);
				mv.addObject("endNavi", endNavi);
				mv.addObject("rList", rList);
				mv.setViewName("/admin/reportList");
			}
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
	@RequestMapping("/admin/noticeList.tripkase")
	public ModelAndView noticeList(
			ModelAndView mv
			,@RequestParam(value="page", required=false) Integer page) {
			////////////////////////////////////////////////////
			int currentPage = (page!=null) ? page : 1;
			int totalCount = nService.getTotalCount();
			int noticeLimit = 10;
			int naviLimit = 5;
			int maxPage;
			int startNavi;
			int endNavi;
			maxPage = (int)((double)totalCount/noticeLimit + 0.9);
			startNavi = ((int)((double)currentPage/naviLimit+0.9)-1)*naviLimit+1;
			System.out.println(currentPage+","+totalCount);
			endNavi = startNavi + naviLimit - 1;
			if(maxPage < endNavi) {
			endNavi = maxPage;
			}
			////////////////////////////////////////////////////
			List<Notice> nList = nService.printAllNotice(currentPage, noticeLimit);
			try {
				if(!nList.isEmpty()) {
					mv.addObject("currentPage", currentPage);
					mv.addObject("maxPage", maxPage);
					mv.addObject("startNavi", startNavi);
					mv.addObject("endNavi", endNavi);
					mv.addObject("nList",nList);
					mv.setViewName("admin/noticeList");
				}
			} catch (Exception e) {
				mv.addObject("msg",e.toString());
				mv.setViewName("/common/errorPage");
			}
		return mv;
	}
	
	//공지 상세 조회
	@RequestMapping("/admin/noticeDetail.tripkase")
	public ModelAndView noticeDetail(
			ModelAndView mv
			,@RequestParam("noticeNo") int noticeNo
			) {
		Notice notice = aService.noticeDetail(noticeNo);
		List<NoticeImg> niList = aService.noticeImgDetail(noticeNo);
		mv.addObject("notice",notice);
		mv.addObject("niList",niList);
		mv.setViewName("admin/noticeDetail");
		return mv;
	}
	
	//공지 작성 폼으로 이동
	@RequestMapping("/admin/noticeWriteForm.tripkase")
	public String noticeWriteForm() {
		return "/admin/noticeWriteForm";
	}
	
//	//공지 등록, 단일 파일 등록
//	@RequestMapping(value="/admin/registerNotice.tripkase", method=RequestMethod.POST)
//	public ModelAndView registerNotice(
//			ModelAndView mv,
//			@ModelAttribute Notice notice,
//			@RequestParam(value="uploadFile", required=false) MultipartFile uploadFile,
//			HttpServletRequest request) {
//		try {
//			String noticeFileName = uploadFile.getOriginalFilename();
//			if(!noticeFileName.equals("")) {
//				String root = request.getSession().getServletContext().getRealPath("resources");
//				//resources/nUploadFiles
//				String savePath = root + "\\nUploadFiles";
//				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
//				//20220921104350.jpg
//				String noticeFileRename = sdf.format(new Date(System.currentTimeMillis()))+"."+noticeFileName.substring(noticeFileName.lastIndexOf(".")+1);
//				File file = new File(savePath);
//				if(!file.exists()) {
//					System.out.println(savePath);
//					file.mkdir();
//				}
//				//resources/nUploadFiles/202209211104350.jpg 
//				uploadFile.transferTo(new File(savePath+"\\"+noticeFileRename));
//				String noticeFilePath = savePath+"\\"+noticeFileRename;
//				notice.setnFileName(noticeFileName);
//				notice.setnFileRename(noticeFileRename);
//				notice.setnFilePath(noticeFilePath);
//			}
//			int result = aService.registerNotice(notice);
//			mv.setViewName("redirect:/admin/noticeList.tripkase");
//		} catch (Exception e) {
//			e.printStackTrace();
//			mv.addObject("msg", e.getMessage());
//			mv.setViewName("common/errorPage");
//		}
//		return mv;
//	}
	
	//공지 등록, 다중파일 등록 적용
	@RequestMapping(value="/admin/registerNotice.tripkase", method=RequestMethod.POST)
	public ModelAndView registerNotice(
			ModelAndView mv,
			@ModelAttribute Notice notice,
//			@RequestParam(value="uploadFile", required=false) MultipartFile uploadFile,
			@RequestParam(value="uploadFile", required=false) List<MultipartFile> uploadFile,
			HttpServletRequest request,
			MultipartHttpServletRequest mRequest) {
		try {
			int imgNo = 1;
			NoticeImg noticeImg = null;
			
			int result = aService.registerNotice(notice);
			
			for(MultipartFile mf : uploadFile ) {
				String noticeFileName = mf.getOriginalFilename();
				if(!noticeFileName.equals("")) {
					String root = request.getSession().getServletContext().getRealPath("resources");
					//resources/nUploadFiles
					String savePath = root + "\\nUploadFiles";
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
					//202209211043501.jpg
					String noticeFileRename = sdf.format(new Date(System.currentTimeMillis()))+imgNo+"."+noticeFileName.substring(noticeFileName.lastIndexOf(".")+1);
					File file = new File(savePath);
					if(!file.exists()) {
						System.out.println(savePath);
						file.mkdir();
					}
					//resources/nUploadFiles/202209211104350.jpg 
					mf.transferTo(new File(savePath+"\\"+noticeFileRename));
					String noticeFilePath = savePath+"\\"+noticeFileRename;
					noticeImg = new NoticeImg();
					noticeImg.setnFileName(noticeFileName);
					noticeImg.setnFileRename(noticeFileRename);
					noticeImg.setnFilePath(noticeFilePath);
					imgNo = imgNo +1;
				}
				int result2 = aService.registerNoticeImg(noticeImg);
				mv.setViewName("redirect:/admin/noticeList.tripkase");
				}
			} catch (Exception e) {
				e.printStackTrace();
				mv.addObject("msg", e.getMessage());
				mv.setViewName("common/errorPage");
			}
		return mv;
	}
	//공지 수정 페이지로 이동
	@RequestMapping(value="/admin/modifyNoticeView.tripkase")
	public ModelAndView modifyNoticeView(
			ModelAndView mv
			,@RequestParam("noticeNo") int noticeNo) {
		Notice notice = aService.noticeDetail(noticeNo);
		List<NoticeImg> niList = aService.noticeImgDetail(noticeNo);
		mv.addObject("notice", notice);
		mv.addObject("niList", niList);
		mv.setViewName("/admin/modifyNoticeForm");
		return mv;
	}
	
	//공지 수정
	@RequestMapping(value="/admin/updateNotice.tripkase", method=RequestMethod.POST)
	public ModelAndView updateNotice(
			ModelAndView mv
			,@ModelAttribute Notice notice
			,@RequestParam(value="reloadFile", required=false) List<MultipartFile> reloadFile
			,@RequestParam("imgNo") int[] arr
			,HttpServletRequest request) {
		int num = 0;
		NoticeImg noticeImg = null;
		int result = aService.updateNotice(notice);
		try {
			for(MultipartFile mf : reloadFile ) {
				String noticeFileName = mf.getOriginalFilename();
				if(!noticeFileName.equals("")) {
					String root = request.getSession().getServletContext().getRealPath("resources");
					//resources/nUploadFiles
					String savePath = root + "\\nUploadFiles";
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
					//202209211043501.jpg
					String noticeFileRename = sdf.format(new Date(System.currentTimeMillis()))+num+"."+noticeFileName.substring(noticeFileName.lastIndexOf(".")+1);
					File file = new File(savePath);
					//resources/nUploadFiles/202209211104350.jpg 
					mf.transferTo(new File(savePath+"\\"+noticeFileRename));
					String noticeFilePath = savePath+"\\"+noticeFileRename;
					noticeImg = new NoticeImg();
					noticeImg.setnFileName(noticeFileName);
					noticeImg.setnFileRename(noticeFileRename);
					noticeImg.setnFilePath(noticeFilePath);
					int imgNo = arr[num];
					noticeImg.setImgNo(imgNo);
					num = num +1;
					}
				int result2 = aService.updateNoticeImg(noticeImg);
				mv.setViewName("redirect:/admin/noticeList.tripkase");
				}
		} catch (Exception e) {
			mv.setViewName("/common/errorPage");
		}
	
		return mv;
		} 
	
	//공지 삭제
	@RequestMapping(value="admin/deleteNotice.tripkase")
	public ModelAndView deleteNotice(
			ModelAndView mv) {
		return mv;
	}
	
	//문의 조회
	public ModelAndView qnaList(
			ModelAndView mv) {
		return mv;
	}
	//문의 상세 조회
	public ModelAndView qnaDetail(
			ModelAndView mv) {
		return mv;
	}
	//문의 답변 등록
	public ModelAndView registerQnA(
			ModelAndView mv) {
		return mv;
	}
		
}
