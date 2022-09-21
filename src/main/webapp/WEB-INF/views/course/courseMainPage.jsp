<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세 : 코스 메인페이지 </title>
</head>
<body>
	 
		<input type="radio"   id="cosArea1" 	onclick="location.href='/course/selectCourse.tripkase?locationName=all';"> 전체보기
		<input type="radio"   id="cosArea2" 	onclick="location.href='/course/selectCourse.tripkase?locationName=seoul';"> 서울
		<input type="radio"   id="cosArea3" 	onclick="location.href='/course/selectCourse.tripkase?locationName=gyeonggi';"> 경기
		<input type="radio"   id="cosArea4" 	onclick="location.href='/course/selectCourse.tripkase?locationName=incheon';"> 인천
		<input type="radio"   id="cosArea5" 	onclick="location.href='/course/selectCourse.tripkase?locationName=kangwon';"> 강원
		<input type="radio"   id="cosArea6" 	onclick="location.href='/course/selectCourse.tripkase?locationName=chungbuk';"> 충청북도
		<input type="radio"   id="cosArea7" 	onclick="location.href='/course/selectCourse.tripkase?locationName=chungnam';"> 충청남도
		<input type="radio"   id="cosArea8" 	onclick="location.href='/course/selectCourse.tripkase?locationName=gyeongbuk';"> 경상북도
		<input type="radio"   id="cosArea9" 	onclick="location.href='/course/selectCourse.tripkase?locationName=gyeongnam';"> 경상남도
		<input type="radio"   id="cosArea10" 	onclick="location.href='/course/selectCourse.tripkase?locationName=jeonbuk';"> 전라북도
		<input type="radio"   id="cosArea11" 	onclick="location.href='/course/selectCourse.tripkase?locationName=jeonnam';"> 전라남도
		<input type="radio"   id="cosArea12" 	onclick="location.href='/course/selectCourse.tripkase?locationName=jeju';"> 제주
	
	
	<h3>전체보기</h3>
	<div id=contents>
		<ul>
			<c:forEach items="${cList }" var="cList" >
				<li class="courseList">
					<div class="photo">
						<img src="/resources/cosUploadFiles/${cList.courseFileRename }">
					</div>
					<div class="textarea">
						<p>${cList.courseName }</p>
						<p>${cList.courseThema }</p>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>
	${cList}
	
</body>
</html>