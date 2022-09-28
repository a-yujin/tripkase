package com.tripKase.kh.course.service.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripKase.kh.course.domain.Course;
import com.tripKase.kh.course.domain.CourseImg;
import com.tripKase.kh.course.domain.CourseMainPage;
import com.tripKase.kh.course.domain.CourseReply;
import com.tripKase.kh.course.service.CourseService;
import com.tripKase.kh.course.store.CourseStore;
import com.tripKase.kh.member.domain.Member;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private SqlSession session;
	@Autowired
	private CourseStore cStore;
	
	
	@Override
	public List<Course> selectCourseAll(String locationName) {
		List<Course> cList = cStore.selectCourseAll(session, locationName);
		return cList;
	}

	
	@Override
	public Course courseByNo(int courseNo) {
		Course cOne = cStore.courseByNo(session, courseNo);
		return cOne;
	}

	@Override
	public List<Course> serchCourseByName(String courseName) {
		List<Course> cList = cStore.serchCourseByName(session, courseName);
		return cList;
	}

	@Override
	public int getCourseTotalCount() {
		int result = cStore.getCourseTotalCount(session);
		return result;
	}

	@Override
	public List<Course> selectAllCourse(int currentPage, int boardLimit) {
		List<Course> cList = cStore.selectAllCourse(session,currentPage,boardLimit);
		return cList;
	}

	@Override
	public int registerCourse(Course course) {
		int result = cStore.registerCourse(session,course);
		return result;
	}

	@Override
	public int registerCourseImg(CourseImg courseImg) {
		int result = cStore.registerCourseImg(session,courseImg);
		return result;
	}

	@Override
	public List<CourseImg> selectCourseImg(String locationName) {
		List<CourseImg> cListImg = cStore.selectCourseImg(session,locationName);
		return cListImg;
	}

	@Override
	public int removeCourse(int courseNo) {
		int result = cStore.removeCourse(session, courseNo);
		return result;
	}


	@Override
	public Course courseAdmin(int courseNo) {
		Course course = cStore.courseAdmin(session, courseNo);
		return course;
	}


	@Override
	public List<CourseMainPage> selectCourseMain(String locationName) {
		List<CourseMainPage> cmList = cStore.courseMainPage(session, locationName);
		return cmList;
	}


	@Override
	public List<CourseImg> courseImgByNo(int courseNo) {
		List<CourseImg> courseImg = cStore.coursImgByNo(session, courseNo);
		return courseImg;
	}


	@Override
	public int registerReply(CourseReply courseReply) {
		int result = cStore.registerCourseReply(session, courseReply);
		return result;
	}


	@Override
	public int modifyCourse(Course course) {
		int result = cStore.modifyCourse(session, course);
		return result;
	}


	@Override
	public int updateCourseImg(CourseImg courseImg) {
		int result = cStore.updateCourseImg(session, courseImg);
		return result;
	}

	
}



