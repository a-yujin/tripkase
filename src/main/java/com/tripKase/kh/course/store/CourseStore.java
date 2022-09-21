package com.tripKase.kh.course.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.tripKase.kh.course.domain.Course;

public interface CourseStore {

	public int insertCourse(SqlSession session, Course course);

	public List<Course> selectCourseAll(SqlSession session, String locationName);

	public List<Course> selectCourseSeoul(SqlSession session, String locationName);

	public List<Course> selectCourseGyeonggi(SqlSession session, String locationName);

	public List<Course> selectCourseIncheon(SqlSession session, String locationName);

	public List<Course> selectCourseKangwon(SqlSession session, String locationName);

	public List<Course> selectCourseChungbuk(SqlSession session, String locationName);

	public List<Course> selectCourseChungnam(SqlSession session, String locationName);

	public List<Course> selectCourseGyeongbuk(SqlSession session, String locationName);

	public List<Course> selectCourseGyeongnam(SqlSession session, String locationName);

	public List<Course> selectCourseJeonbuk(SqlSession session, String locationName);

	public List<Course> selectCourseJeonnam(SqlSession session, String locationName);

	public List<Course> selectCourseJeju(SqlSession session, String locationName);
}
