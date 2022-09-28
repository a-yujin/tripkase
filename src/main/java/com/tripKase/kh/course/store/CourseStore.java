package com.tripKase.kh.course.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.tripKase.kh.course.domain.Course;
import com.tripKase.kh.course.domain.CourseImg;
import com.tripKase.kh.course.domain.CourseMainPage;
import com.tripKase.kh.course.domain.CourseReply;

public interface CourseStore {

	public List<Course> selectCourseAll(SqlSession session, String locationName);

	public Course courseByNo(SqlSession session, int courseNo);
	
	public List<Course> serchCourseByName(SqlSession session, String courseName);
	
	public int getCourseTotalCount(SqlSession session);
	
	public List<Course> selectAllCourse(SqlSession session, int currentPage, int limit);
	
	public int registerCourse(SqlSession session, Course course);
	
	public int registerCourseImg(SqlSession session,CourseImg courseImg);
	
	public List<CourseImg> selectCourseImg(SqlSession session, String locationName);
	
	public int removeCourse(SqlSession session, int courseNo);

	public Course courseAdmin(SqlSession session, int courseNo);
	
	public List<CourseMainPage> courseMainPage(SqlSession session, String locationName);
	
	public List<CourseImg> coursImgByNo(SqlSession session, int courseNo);
	
	public int registerCourseReply(SqlSession session, CourseReply courseReply);
	
	public int modifyCourse(SqlSession session, Course course);

	public int updateCourseImg(SqlSession session, CourseImg courseImg);

}
