package com.tripKase.kh.attraction.controller;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.tripKase.kh.attraction.domain.Attraction;
import com.tripKase.kh.attraction.domain.AttractionImg;
import com.tripKase.kh.attraction.service.AttractionService;

@Controller
public class AttractionController {
	@Autowired
	private AttractionService attrService;
	
	/**
	 * 관광지 검색 화면
	 * @return
	 */
	@RequestMapping(value="/attraction/searchView.tripkase", method=RequestMethod.GET)
	public String showAttrSearch(){
		return "attraction/attrSearch";
	}
	
	/**
	 * 관광지 등록 화면
	 * @return
	 */
	@RequestMapping(value="/attraction/write.tripkase", method=RequestMethod.GET)
	public String showAttrWrite() {
		return "attraction/attrAdminWrite";
	}
	
	/**
	 * 관광지 등록
	 * @param mv
	 * @param attr
	 * @param attrFile
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/attraction/register.tripkase", method=RequestMethod.POST)
	public ModelAndView registerAttr(
			ModelAndView mv,
			@ModelAttribute Attraction attr,
			@RequestParam(value="uploadFile", required=false) List<MultipartFile> uploadFile, // value -> jsp name
			HttpServletRequest request) {
		try {
			int attrImgNo = 1;
			AttractionImg attrImg = null;
			
			int result = attrService.registerAttr(attr);
			
			for(MultipartFile mf: uploadFile) {
				String attrFileName = mf.getOriginalFilename();
				if(!attrFileName.equals("")) {
					String root = request.getSession().getServletContext().getRealPath("resources");
					String savePath = root + "\\attrUploadFiles";
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
					String attrFileRename = sdf.format(new Date(System.currentTimeMillis()))+attrImgNo+"."+attrFileName.substring(attrFileName.lastIndexOf(".")+1);
					File file = new File(savePath);
					if(!file.exists()) {
						System.out.println(savePath);
						file.mkdir();
					}
					mf.transferTo(new File(savePath+"\\"+attrFileRename));
					String attrFilePath = savePath+"\\"+attrFileRename;
					attrImg = new AttractionImg();
					attrImg.setAttrFileName(attrFileName);
					attrImg.setAttrFileRename(attrFileRename);
					attrImg.setAttrFilePath(attrFilePath);
					attrImgNo = attrImgNo+1;
				}
				
				int result2 = attrService.registerAttrImg(attrImg);
				mv.setViewName("redirect:/attraction/list.tripkase");
			} 
			}catch (Exception e) {
				e.printStackTrace();
				mv.addObject("msg", e.getMessage());
				mv.setViewName("common/errorPage");
			}
		return mv;
	}
	
	/**
	 * 관광지 목록(관리자) 조회
	 * @param mv
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/attraction/list.tripkase", method=RequestMethod.GET)
	public ModelAndView showAttrList(
			ModelAndView mv,
			@RequestParam(value="page", required=false) Integer page) {
		int currentPage = (page != null) ? page : 1; // 현재 페이지(페이지가 없으면 1, 아니면 해당 페이지 번호)
		int totalCount = attrService.getTotalCount(); // 총 게시글 수
		int attrLimit = 5; // 한 페이지에 보여줄 게시글 수
		int naviLimit = 5; // 한 화면에서 보여줄 페이지 수
		int maxPage; // 마지막 페이지 번호
		int startNavi; // 페이징 시작 번호 ex. (6) 7 8 9 10
		int endNavi; // 페이징 끝 번호 ex. 6 7 8 9 (10)
		
		maxPage = (int)((double)totalCount/attrLimit+0.95); // int로 형변환시 내림 위해 0.9 더하기
		startNavi = ((int)((double)currentPage/naviLimit+0.9)-1)*naviLimit+1;
		endNavi = startNavi + naviLimit - 1;
		if(maxPage < endNavi) {
			endNavi = maxPage;
		}
		
		List<Attraction> attrList = attrService.printAllAttr(currentPage, attrLimit);
		if(!attrList.isEmpty()) {
			mv.addObject("urlVal", "list");
			mv.addObject("maxPage", maxPage);
			mv.addObject("currentPage", currentPage);
			mv.addObject("startNavi", startNavi);
			mv.addObject("endNavi", endNavi);
			mv.addObject("attrList", attrList);
		}
		
		mv.setViewName("attraction/attrAdminList");
		
		return mv;
	}
	
	/**
	 * 관광지 수정 화면
	 * @param mv
	 * @param attrNo
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/attraction/modifyView.tripkase", method=RequestMethod.GET)
	public ModelAndView showAttrModify(
			ModelAndView mv,
			@RequestParam("attrNo") Integer attrNo,
			@RequestParam("page") int page) {
		try {
			Attraction attr = attrService.printOneByNo(attrNo);
			List<AttractionImg> attrImgList = attrService.printImgByNo(attrNo);
			mv.addObject("attr", attr);
			mv.addObject("attrImgList", attrImgList);
			mv.addObject("page", page);
			mv.setViewName("attraction/attrAdminModify");
		} catch (Exception e) {
			mv.addObject("msg", e.toString());
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	/**
	 * 관광지 수정
	 * @param attr
	 * @param mv
	 * @param reloadFile
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/attraction/modify.tripkase", method=RequestMethod.POST)
	public ModelAndView modifyAttr(
			@ModelAttribute Attraction attr,
			ModelAndView mv,
			@RequestParam(value="reloadFile", required=false) List<MultipartFile> reloadFile,
			@RequestParam("attrImgNo") int[] aImgNoArr,
			@RequestParam("attrFileRename") String[] aFileRenameArr,
			@RequestParam("page") Integer page,
			HttpServletRequest request) {
		int num = 0;
		AttractionImg attrImg = null;
		int result = attrService.modifyAttr(attr);
		try {
			for(MultipartFile mf: reloadFile) {
				String aFileName = mf.getOriginalFilename();
				if(!aFileName.equals("")) {
					String root = request.getSession().getServletContext().getRealPath("resources");
					String savedPath = root + "\\attrUploadFiles";
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
					
					String attrFileRename = aFileRenameArr[num];
					File file = new File(savedPath + "\\" + attrFileRename);
					if(file.exists()) {
						file.delete();
					}
					
					String aFileRename = sdf.format(new Date(System.currentTimeMillis()))+num+ "." + aFileName.substring(aFileName.lastIndexOf(".")+1);
					file = new File(savedPath);
					
					mf.transferTo(new File(savedPath + "\\" + aFileRename));
					String aFilePath = savedPath + "\\" + aFileRename;
					attrImg = new AttractionImg();
					attrImg.setAttrFileName(aFileName);
					attrImg.setAttrFileRename(aFileRename);
					attrImg.setAttrFilePath(aFilePath);
					int attrImgNo = aImgNoArr[num];
					attrImg.setAttrImgNo(attrImgNo);
					num = num + 1;
				}
				int result2 = attrService.modifyAttrImg(attrImg);
				mv.setViewName("redirect:/attraction/list.tripkase?page="+page);
			}
		} catch (Exception e) {
			mv.addObject("msg", e.toString()).setViewName("common/errorPage");
		}
		return mv;
	}
	
	/**
	 * 관광지 삭제
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/attraction/remove.tripkase", method=RequestMethod.GET)
	public String removeAttr(
			HttpSession session,
			Model model,
			@RequestParam("page") Integer page) {
		try {
			int attrNo = (int)session.getAttribute("attrNo");
			int result = attrService.removeOneByNo(attrNo);
			if(result > 0) {
				session.removeAttribute("attrNo");
			}
			return "redirect:/attraction/list.tripkase?page="+page;
		} catch (Exception e) {
			model.addAttribute("msg", e.toString());
			return "common/errorPage";
		}
	}
	
	/**
	 * 관광지 검색(목록 결과)
	 * @param mv
	 * @param searchValue
	 * @param areaValue
	 * @param typeValue
	 * @param petValue
	 * @param currentPage
	 * @return
	 */
	@RequestMapping(value="/attraction/searchList.tripkase", method=RequestMethod.GET)
	public ModelAndView showAttrList(
			ModelAndView mv,
			@RequestParam(value="searchValue", required = false) String searchValue,
			@RequestParam("areaValue") String areaValue,
			@RequestParam("typeValue") String [] typeValue,
			@RequestParam(value="page", required=false, defaultValue="1") int currentPage) {
		try {
			int searchCount = attrService.getSearchCount(searchValue, areaValue, typeValue);
			int attrLimit = 5; // 한 페이지에 보여줄 게시글 수
			int naviLimit = 5; // 한 화면에서 보여줄 페이지 수
			int maxPage; // 마지막 페이지 번호
			int startNavi; // 페이징 시작 번호 ex. (6) 7 8 9 10
			int endNavi; // 페이징 끝 번호 ex. 6 7 8 9 (10)
			
			maxPage = (int)((double)searchCount/attrLimit+0.95);
			startNavi = ((int)((double)currentPage/naviLimit+0.9)-1)*naviLimit+1;
			endNavi = startNavi + naviLimit - 1;
			if(maxPage < endNavi) {
				endNavi = maxPage;
			}
			
			List<Attraction> attrList = attrService.printSearchAttr(searchValue, areaValue, typeValue, currentPage, attrLimit);
			if(!attrList.isEmpty()) {
				mv.addObject("attrList", attrList);
			} else {
				mv.addObject("attrList", null);
			}
			mv.addObject("urlVal", "searchList");
			mv.addObject("searchValue", searchValue);
			mv.addObject("areaValue", areaValue);
			mv.addObject("typeValue", typeValue);
			mv.addObject("maxPage", maxPage);
			mv.addObject("currentPage", currentPage);
			mv.addObject("startNavi", startNavi);
			mv.addObject("endNavi", endNavi);
			
			mv.setViewName("attraction/attrSearchList");
		} catch (Exception e) {
			mv.addObject("msg", e.toString()).setViewName("common/errorPage");
		}
		return mv;
	}
	
	@RequestMapping(value="/attraction/detail.tripkase", method=RequestMethod.GET)
	public ModelAndView showAttrDetail(
			ModelAndView mv,
			HttpSession session,
			@RequestParam("attrNo") Integer attrNo,
			@RequestParam("page") Integer page) {
		try {
			Attraction attr = attrService.printOneByNo(attrNo);
			mv.addObject("attr", attr);
			mv.addObject("page", page);
			mv.setViewName("attraction/attrDetail");
		} catch (Exception e) {
			mv.addObject("msg", e.toString()).setViewName("common/errorPage");
		}
		return mv;
	}
}
