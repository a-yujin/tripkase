package com.tripKase.kh.course.store.logic;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.tripKase.kh.course.domain.Course;
import com.tripKase.kh.course.domain.CourseImg;
import com.tripKase.kh.course.domain.CourseMainPage;
import com.tripKase.kh.course.domain.CourseReply;
import com.tripKase.kh.course.store.CourseStore;
import com.tripKase.kh.member.domain.Member;

@Repository
public class CourseStoreLogic implements CourseStore {

	@Override
	public List<Course> selectCourseAll(SqlSession session, String locationName) {
		List<Course> cList = session.selectList("CourseMapper.selectCourseAll", locationName);
		return cList;
	}

	@Override
	public Course courseByNo(SqlSession session, int courseNo) {
		Course cOne = session.selectOne("CourseMapper.courseByNo", courseNo);
		return cOne;
	}

	@Override
	public List<Course> serchCourseByName(SqlSession session, String courseName) {
		List<Course> cList = session.selectList("CourseMapper.serchCourseByName", courseName );
		return cList;
	}

	@Override
	public int getCourseTotalCount(SqlSession session) {
		int result = session.selectOne("CourseMapper.getCourseTotalCount");
		return result;
	}

	@Override
	public List<Course> selectAllCourse(SqlSession session, int currentPage, int limit) {
		int offset = (currentPage-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Course> cList = session.selectList("CourseMapper.selectAllCourse", null, rowBounds);
		return cList;
	}

	@Override
	public int registerCourse(SqlSession session, Course course) {
		int result = session.insert("CourseMapper.registerCourse",course);
		return result;
	}

	@Override
	public int registerCourseImg(SqlSession session, CourseImg courseImg) {
		int result = session.insert("CourseMapper.registerCourseImg",courseImg);
		return result;
	}

	@Override
	public List<CourseImg> selectCourseImg(SqlSession session, String locationName) {
		List<CourseImg> cListImg = session.selectList("CourseMapper.selectCourseImg", locationName);
		return cListImg;
	}

	@Override
	public int removeCourse(SqlSession session, int courseNo) {
		int result = session.delete("CourseMapper.removeCourse", courseNo);
		return result;
	}

	@Override
	public Course courseAdmin(SqlSession session, int courseNo) {
		Course course = session.selectOne("CourseMapper.courseAdmin", courseNo);
		return course;
	}

	@Override
	public List<CourseMainPage> courseMainPage(SqlSession session, String locationName) {
		List<CourseMainPage> cmList = session.selectList("CourseMapper.courseMainPage", locationName);
		return cmList;
	}

	@Override
	public List<CourseImg> coursImgByNo(SqlSession session, int courseNo) {
		List<CourseImg> courseImg = session.selectList("CourseMapper.courseImgByNo", courseNo);
		return courseImg;
	}

	@Override
	public int registerCourseReply(SqlSession session, CourseReply courseReply) {
		int result = session.insert("CourseMapper.registerReply", courseReply);
		return result;
	}

	@Override
	public int modifyCourse(SqlSession session, Course course) {
		int result = session.update("CourseMapper.modifyCourse", course);
		return result;
	}

	@Override
	public int updateCourseImg(SqlSession session, CourseImg courseImg) {
		int result = session.update("CourseMapper.updateCourseImg",courseImg);
		return result;
	}
}
