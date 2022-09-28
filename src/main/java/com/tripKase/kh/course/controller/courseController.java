package com.tripKase.kh.course.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.tripKase.kh.admin.domain.NoticeImg;
import com.tripKase.kh.course.domain.Course;
import com.tripKase.kh.course.domain.CourseImg;
import com.tripKase.kh.course.domain.CourseMainPage;
import com.tripKase.kh.course.domain.CourseReply;
import com.tripKase.kh.course.service.CourseService;
import com.tripKase.kh.member.domain.Member;
import com.tripKase.kh.notice.domain.Notice;
import com.tripKase.kh.room.domain.RoomImg;
@Controller
public class courseController {

	@Autowired
	private CourseService cService;

	@RequestMapping(value = "/course/insertCourseView.tripkase", method = RequestMethod.GET) // value = 사용할 url
	public String insertCourseView() {
		return "course/insertCourse"; // 스프링의 리턴타입은 String으로 정해져있음
	}

	@RequestMapping(value = "/course/courseMainPage.tripkase", method = RequestMethod.GET) // value = 사용할 url
	public String courseMainPage() {
		return "course/courseMainPage"; // 스프링의 리턴타입은 String으로 정해져있음
	}

	@RequestMapping(value = "/course/serchCourseByNameView.tripkase", method = RequestMethod.GET) // value = 사용할 url
	public String removeCourseView() {
		return "course/serchCourseByName"; // 스프링의 리턴타입은 String으로 정해져있음
	}
	
	@RequestMapping(value = "/course/modifyCourseView.tripkase", method = RequestMethod.GET) // value = 사용할 url
	public ModelAndView modifyCourseView(@RequestParam("courseNo")Integer courseNo, ModelAndView mv) {
		try {
			Course course = cService.courseByNo(courseNo);
			List<CourseImg> courseImg = cService.courseImgByNo(courseNo);
			System.out.println(course);
			System.out.println(courseImg);
			if (course != null && !courseImg.isEmpty()) {
				mv.addObject("cOne", course);
				mv.addObject("cImg", courseImg);
				mv.setViewName("/course/modifyCourse");
			}

		} catch (Exception e) {
			mv.addObject("msg", e.getMessage());
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	// 코스 등록, 다중 이미지 파일 등록
	@RequestMapping(value="/course/insertCourse.tripkase", method = RequestMethod.POST)
	public ModelAndView insertCourse(
			ModelAndView mv,
			@ModelAttribute Course course,
	//		@RequestParam(value="uploadFile", required = false) MultipartFile uploadFile,
			@RequestParam(value="uploadFile", required = false) List<MultipartFile> uploadFile,
			HttpServletRequest request,
			MultipartHttpServletRequest mRequest,
			@RequestParam("locationName") String locationName) {
		try {
			int imgNo = 1;
			CourseImg courseImg = null;

			int result = cService.registerCourse(course);

			for (MultipartFile mf : uploadFile) {
				String courseFileName = mf.getOriginalFilename();
				if (!courseFileName.equals("")) {
					String root = request.getSession().getServletContext().getRealPath("resources");
					String savePath = root + "\\cosUploadFiles";
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
					String courseFileRename = sdf.format(new Date(System.currentTimeMillis())) + imgNo + "."
							+ courseFileName.substring(courseFileName.lastIndexOf(".") + 1);
					File file = new File(savePath);
					if (!file.exists()) {
						file.mkdir();
					}
					mf.transferTo(new File(savePath + "\\" + courseFileRename));
					String courseFilePath = savePath + "\\" + courseFileRename;
					courseImg = new CourseImg();
					courseImg.setcFileName(courseFileName);
					courseImg.setcFileRename(courseFileRename); // 중복 파일 업로드를위해 파일 이름을 업로드 시간으로 설정
					courseImg.setcFilePath(courseFilePath);
					courseImg.setLocationName(locationName);
					imgNo = imgNo + 1;
				}
				int result2 = cService.registerCourseImg(courseImg);
				mv.setViewName("course/courseMainPage");
			}
		} catch (Exception e) {
			mv.addObject("msg", e.getMessage());
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	// 코스 메인페이지 및 지역별 코스 조회 o
		@RequestMapping(value="/course/selectCourse.tripkase", method = RequestMethod.GET)
		public ModelAndView selectCourse(
				@RequestParam("locationName") String locationName,
				@RequestParam("locationValue") String locationValue,
				ModelAndView mv) {
			
//			List<Course> cList = cService.selectCourseAll(locationName);
//			List<CourseImg> cListImg = cService.selectCourseImg(locationName);
			List<CourseMainPage> cmList = cService.selectCourseMain(locationName);
			mv.addObject("cmList", cmList);
			mv.addObject("locationValue", locationValue);
//			mv.addObject("cList", cList);
//			mv.addObject("cListImg", cListImg);
			mv.setViewName("course/courseMainPage");
			return mv;
		}
	
	// 코스 상세보기
	@RequestMapping(value="course/courseDetail.tripkase", method = RequestMethod.GET)
	public ModelAndView courseDetail(ModelAndView mv, @RequestParam("courseNo") int courseNo) {
		try {
			Course course = cService.courseByNo(courseNo);
			List<CourseImg> courseImg = cService.courseImgByNo(courseNo);
			System.out.println(course);
			System.out.println(courseImg);
			if (course != null && !courseImg.isEmpty()) {
				mv.addObject("cOne", course);
				mv.addObject("cImg", courseImg);
				mv.setViewName("/course/courseDetail");
			}

		} catch (Exception e) {
			mv.addObject("msg", e.getMessage());
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	// 이름으로 코스 검색
	@RequestMapping(value = "course/serchCourseByName.tripkase", method = RequestMethod.POST)
	public ModelAndView removeCourse(ModelAndView mv, @ModelAttribute Course course,
			@RequestParam("courseName") String courseName) {
		try {

			List<Course> cList = cService.serchCourseByName(courseName);
			if (!cList.isEmpty()) {
				mv.addObject("cList", cList);
				mv.setViewName("course/courseList");
			}
		} catch (Exception e) {
			mv.addObject("msg", e.getMessage());
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	//전체 코스 조회
	@RequestMapping(value="/course/courseAll.tripkase", method=RequestMethod.GET)
	public ModelAndView selectAllCourse(ModelAndView mv, @RequestParam(value="page", required=false) Integer page) {
		////////////////////////////////////////////////////
		int currentPage = (page != null) ? page : 1;
		int totalCount = cService.getCourseTotalCount();
		int boardLimit = 10;
		int naviLimit = 5;
		int maxPage;
		int startNavi;
		int endNavi;
		maxPage = (int) ((double) totalCount / boardLimit + 0.9);
		startNavi = ((int) ((double) currentPage / naviLimit + 0.9) - 1) * naviLimit + 1;
		System.out.println(currentPage + "," + totalCount);
		endNavi = startNavi + naviLimit - 1;
		if (maxPage < endNavi) {
			endNavi = maxPage;
		}
		////////////////////////////////////////////////////
		List<Course> cList = cService.selectAllCourse(currentPage, boardLimit);
		try {
			if (!cList.isEmpty()) {
				mv.addObject("currentPage", currentPage);
				mv.addObject("maxPage", maxPage);
				mv.addObject("startNavi", startNavi);
				mv.addObject("endNavi", endNavi);
				mv.addObject("cList", cList);
				mv.setViewName("course/courseList");
			}
		} catch (Exception e) {
			mv.addObject("msg", e.toString());
			mv.setViewName("/common/errorPage");
		}
		return mv;
	}
	
	// 코스 수정 삭제 페이지
		@RequestMapping(value="/course/courseAdmin.tripkase")
		public ModelAndView courseAdmin(ModelAndView mv, @RequestParam("courseNo") Integer courseNo ) {
			Course course = cService.courseAdmin(courseNo);
			List<CourseImg> cImg = cService.courseImgByNo(courseNo);
			mv.addObject("cImg",cImg);
			mv.addObject("course", course);
			mv.setViewName("course/courseAdmin");
			return mv;
		}
	
	// 코스삭제
	@RequestMapping(value="/course/removeCourse.tripkase", method = RequestMethod.GET)
	public ModelAndView removeCourse(ModelAndView mv, @RequestParam("courseNo") Integer courseNo) {
		try {
			int result = cService.removeCourse(courseNo);
			if (result > 0) {
				mv.setViewName("redirect:/course/courseAll.tripkase");
			}
		} catch (Exception e) {
			mv.addObject("msg", e.getMessage());
			mv.setViewName("/common/errorPage");
		}
		return mv;
	}
	

	 //코스수정
	@RequestMapping(value="/course/modifyCourse.tripkase", method = RequestMethod.POST)
	public ModelAndView modifyCourse (
			ModelAndView mv,
			@ModelAttribute Course course,
			@RequestParam(value="reloadFile") List<MultipartFile> reloadFile,
			@RequestParam("imgNo") int[] courseNoArr,
			@RequestParam("cFileRename") String[] cFileRenameArr,
			HttpServletRequest request){
		int num = 0;
		CourseImg courseImg = null;
		int result = cService.modifyCourse(course);
		try {
			for(MultipartFile mf : reloadFile ) {
				String courseFileName = mf.getOriginalFilename();
				if(!courseFileName.equals("")) {
					String root = request.getSession().getServletContext().getRealPath("resources");
					String savePath = root + "\\cosUploadFiles";
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
					//기존 파일 삭제
					String cFileRename = cFileRenameArr[num];
					File file = new File(savePath + "\\" + cFileRename);
					if(file.exists()) {
						file.delete();
					}
					//새로운 파일 등록
					String courseFileRename = sdf.format(new Date(System.currentTimeMillis()))+num+"."+courseFileName.substring(courseFileName.lastIndexOf(".")+1);
					file = new File(savePath);
					mf.transferTo(new File(savePath+"\\"+courseFileRename));
					String courseFilePath = savePath+"\\"+courseFileRename;
					courseImg = new CourseImg();
					courseImg.setcFileName(courseFileName);
					courseImg.setcFileRename(courseFileRename);
					courseImg.setcFilePath(courseFilePath);
					int imgNo = courseNoArr[num];
					courseImg.setImgNo(imgNo);
					num = num +1;
					}
					int result2 = cService.updateCourseImg(courseImg);
					mv.setViewName("redirect:/course/courseAll.tripkase");
					}
				}catch (Exception e) {
						mv.setViewName("/common/errorPage");
					}
					return mv;
						}
					}

























