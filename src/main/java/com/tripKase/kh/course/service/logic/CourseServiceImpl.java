package com.tripKase.kh.course.service.logic;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.tripKase.kh.course.domain.Course;
import com.tripKase.kh.course.service.CourseService;
import com.tripKase.kh.course.store.CourseStore;

@Service
public class CourseServiceImpl implements CourseService {

	private SqlSession session;
	private CourseStore cStore;
	
	@Override
	public int insertCourse(Course course) {
		int result = cStore.insertCourse(session, course);
		return result;
	}

}
