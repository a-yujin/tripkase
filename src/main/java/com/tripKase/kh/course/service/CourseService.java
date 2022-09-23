package com.tripKase.kh.course.service;

import java.util.List;

import com.tripKase.kh.course.domain.Course;

public interface CourseService {

	public int insertCourse(Course course);

	public List<Course> selectCourseAll(String locationName);

	public List<Course> selectCourseSeoul(String locationName);

	public List<Course> selectCourseGyeonggi(String locationName);

	public List<Course> selectCourseIncheon(String locationName);

	public List<Course> selectCourseKangwon(String locationName);

	public List<Course> selectCourseChungbuk(String locationName);

	public List<Course> selectCourseChungnam(String locationName);

	public List<Course> selectCourseGyeongbuk(String locationName);

	public List<Course> selectCourseGyeongnam(String locationName);

	public List<Course> selectCourseJeonbuk(String locationName);

	public List<Course> selectCourseJeonnam(String locationName);

	public List<Course> selectCourseJeju(String locationName);
	
	public Course courseByNo(int courseNo);
	
	public int removeCourse(String courseNo);
	
}
