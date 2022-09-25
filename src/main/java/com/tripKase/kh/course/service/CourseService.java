package com.tripKase.kh.course.service;

import java.util.List;

import com.tripKase.kh.course.domain.Course;
import com.tripKase.kh.course.domain.CourseImg;

public interface CourseService {

	public List<Course> selectCourseAll(String locationName);
	
	public Course courseByNo(int courseNo);
	
	public List<Course> serchCourseByName(String courseName);
	
	public int getCourseTotalCount();
	
	public List<Course> selectAllCourse(int currentPage, int boardLimit);
	
	public int registerCourse(Course course);
	
	public int registerCourseImg(CourseImg courseImg);
	
	public List<CourseImg> selectCourseImg(String locationName);
	
	public int removeCourse(int courseNo);
	
}
