package com.tripKase.kh.course.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.tripKase.kh.course.domain.Course;
import com.tripKase.kh.course.service.CourseService;
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
	
	
	// 코스 등록
	@RequestMapping(value="/course/insertCourse.tripkase", method = RequestMethod.POST)
	public ModelAndView insertCourse(
			ModelAndView mv,
			@ModelAttribute Course course,
			@RequestParam(value="uploadFile", required = false) MultipartFile uploadFile,
			HttpServletRequest request) {
		try {
		String courseFileName = uploadFile.getOriginalFilename();
		if(!courseFileName.equals("")) {
			String root = request.getSession().getServletContext().getRealPath("resources");
			String savePath = root + "\\cosUploadFiles";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String courseFileRename = sdf.format(new Date(System.currentTimeMillis()))+"." + courseFileName.substring(courseFileName.lastIndexOf(".")+1);
			File file = new File(savePath);
			if(!file.exists()) {
				file.mkdir();
			}
			uploadFile.transferTo(new File(savePath+"\\"+courseFileRename));
			String courseFilePath = savePath + "\\"+ courseFileRename;
			course.setCourseFileName(courseFileName);
			course.setCourseFileRename(courseFileRename); // 중복 파일 업로드를위해 파일 이름을 업로드 시간으로 설정
			course.setCourseFilePath(courseFilePath);
			} 
			int result = cService.insertCourse(course);
			mv.setViewName("course/courseMainPage");
			}catch (Exception e) {
				mv.addObject("msg", e.getMessage());
				mv.setViewName("common/errorPage"); 
			}
			return mv;
		}
	
	// 코스 메인페이지 및 지역별 코스 조회 o 
		@RequestMapping(value="/course/selectCourse.tripkase", method = RequestMethod.GET)
		public ModelAndView selectCourse(
				@RequestParam("locationName") String locationName,
				ModelAndView mv) {
			
			List<Course> cList = cService.selectCourseAll(locationName);
			mv.addObject("cList",cList);
			mv.setViewName("course/courseMainPage");
			return mv;
			
	}
	
	// 코스 상세보기
		
	// 코스 삭제
	
	
}
