package com.tripKase.kh.course.store.logic;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.tripKase.kh.course.domain.Course;
import com.tripKase.kh.course.store.CourseStore;

@Repository
public class CourseStoreLogic implements CourseStore {

	@Override
	public int insertCourse(SqlSession session, Course course) {
		int result = session.insert("", course);
		return result;
	}

}
