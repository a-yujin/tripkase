package com.tripKase.kh.course.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.tripKase.kh.course.domain.Course;
import com.tripKase.kh.course.store.CourseStore;

@Repository
public class CourseStoreLogic implements CourseStore {

	@Override
	public int insertCourse(SqlSession session, Course course) {
		int result = session.insert("CourseMapper.insertCourse", course);
		return result;
	}

	@Override
	public List<Course> selectCourseAll(SqlSession session, String locationName) {
		List<Course> cList = session.selectList("CourseMapper.selectCourseAll", locationName);
		return cList;
	}

	@Override
	public List<Course> selectCourseSeoul(SqlSession session, String locationName) {
		List<Course> cList = session.selectList("CourseMapper.selectCourseSeoul", locationName);
		return cList;
	}

	@Override
	public List<Course> selectCourseGyeonggi(SqlSession session, String locationName) {
		List<Course> cList = session.selectList("CourseMapper.selectCourseGyeonggi", locationName);
		return cList;
	}

	@Override
	public List<Course> selectCourseIncheon(SqlSession session, String locationName) {
		List<Course> cList = session.selectList("CourseMapper.selectCourseIncheon", locationName);
		return cList;
	}

	@Override
	public List<Course> selectCourseKangwon(SqlSession session, String locationName) {
		List<Course> cList = session.selectList("CourseMapper.selectCourseKangwon", locationName);
		return cList;
	}

	@Override
	public List<Course> selectCourseChungbuk(SqlSession session, String locationName) {
		List<Course> cList = session.selectList("CourseMapper.selectCourseChungbuk", locationName);
		return cList;
	}

	@Override
	public List<Course> selectCourseChungnam(SqlSession session, String locationName) {
		List<Course> cList = session.selectList("CourseMapper.selectCourseChungnam", locationName);
		return cList;
	}

	@Override
	public List<Course> selectCourseGyeongbuk(SqlSession session, String locationName) {
		List<Course> cList = session.selectList("CourseMapper.selectCourseGyeongbuk", locationName);
		return cList;
	}

	@Override
	public List<Course> selectCourseGyeongnam(SqlSession session, String locationName) {
		List<Course> cList = session.selectList("CourseMapper.selectCourseGyeongnam", locationName);
		return cList;
	}

	@Override
	public List<Course> selectCourseJeonbuk(SqlSession session, String locationName) {
		List<Course> cList = session.selectList("CourseMapper.selectCourseJeonbuk", locationName);
		return cList;
	}

	@Override
	public List<Course> selectCourseJeonnam(SqlSession session, String locationName) {
		List<Course> cList = session.selectList("CourseMapper.selectCourseJeonnam", locationName);
		return cList;
	}

	@Override
	public List<Course> selectCourseJeju(SqlSession session, String locationName) {
		List<Course> cList = session.selectList("CourseMapper.selectCourseJeju", locationName);
		return cList;
	}

	@Override
	public Course courseByNo(SqlSession session, int courseNo) {
		Course cOne = session.selectOne("CourseMapper.courseByNo", courseNo);
		return cOne;
	}

	@Override
	public int removeCourse(SqlSession session, String courseNo) {
		int result = session.update("CourseMapper.removeCourse", courseNo);
		return result;
	}

}
