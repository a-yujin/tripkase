package com.tripKase.kh.course.store;

import org.apache.ibatis.session.SqlSession;

import com.tripKase.kh.course.domain.Course;

public interface CourseStore {

	public int insertCourse(SqlSession session, Course course);
}
