package com.tripKase.kh.course.service.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripKase.kh.course.domain.Course;
import com.tripKase.kh.course.service.CourseService;
import com.tripKase.kh.course.store.CourseStore;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private SqlSession session;
	@Autowired
	private CourseStore cStore;
	
	@Override
	public int insertCourse(Course course) {
		int result = cStore.insertCourse(session, course);
		return result;
	}

	@Override
	public List<Course> selectCourseAll(String locationName) {
		List<Course> cList = cStore.selectCourseAll(session, locationName);
		return cList;
	}

	@Override
	public List<Course> selectCourseSeoul(String locationName) {
		List<Course> cList = cStore.selectCourseSeoul(session, locationName);
		return cList;
	}

	@Override
	public List<Course> selectCourseGyeonggi(String locationName) {
		List<Course> cList = cStore.selectCourseGyeonggi(session, locationName);
		return cList;
	}

	@Override
	public List<Course> selectCourseIncheon(String locationName) {
		List<Course> cList = cStore.selectCourseIncheon(session, locationName);
		return cList;
	}

	@Override
	public List<Course> selectCourseKangwon(String locationName) {
		List<Course> cList = cStore.selectCourseKangwon(session, locationName);
		return cList;
	}

	@Override
	public List<Course> selectCourseChungbuk(String locationName) {
		List<Course> cList = cStore.selectCourseChungbuk(session, locationName);
		return cList;
	}

	@Override
	public List<Course> selectCourseChungnam(String locationName) {
		List<Course> cList = cStore.selectCourseChungnam(session, locationName);
		return cList;
	}

	@Override
	public List<Course> selectCourseGyeongbuk(String locationName) {
		List<Course> cList = cStore.selectCourseGyeongbuk(session, locationName);
		return cList;
	}

	@Override
	public List<Course> selectCourseGyeongnam(String locationName) {
		List<Course> cList = cStore.selectCourseGyeongnam(session, locationName);
		return cList;
	}

	@Override
	public List<Course> selectCourseJeonbuk(String locationName) {
		List<Course> cList = cStore.selectCourseJeonbuk(session, locationName);
		return cList;
	}

	@Override
	public List<Course> selectCourseJeonnam(String locationName) {
		List<Course> cList = cStore.selectCourseJeonnam(session, locationName);
		return cList;
	}

	@Override
	public List<Course> selectCourseJeju(String locationName) {
		List<Course> cList = cStore.selectCourseJeju(session, locationName);
		return cList;
	}

	@Override
	public Course courseByNo(int courseNo) {
		Course cOne = cStore.courseByNo(session, courseNo);
		return cOne;
	}

	
}




























