<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
<meta charset="UTF-8">
<title>여행카세 : 코스 상세페이지</title>
<style>
.course_detail {
    position: relative;
    width : 100%;
    height : 200px; 
    margin-top: 24px;
}

#contents {
    width: 980px;
    margin: 0 auto;
    padding: 0 20px 27px 20px;
}

div {
    box-sizing: border-box;
}

#course{
	folat : left;
}

.map{
	 width : 100%;
    height : 200px; 
}

#title {
	clear:both;
}

#courseSchedule-wapper{
	height : 50px;
}

#courseSchedule-inside{
	float : left;
}

</style>

</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<form action="/course/courseDetail.tripkase" method="GET">
		<div id=contents>
			<div id="title" align="center">
				<div id="course_title">
					<br>
					<h3>${cOne.courseName }</h3>
				</div>
				<div id="course_info">
					<span>지역 : ${cOne.locationName }</span> <span>코스 총거리 :
						${cOne.courseDistance }</span>
				</div>
			</div>
			<hr>
			<div class="course_detail">
				<div>
					<p>${cOne.courseInfo }</p>
				</div>
				<div class="map">
				
				</div>
				
				<div id="courseSchedule-wapper">
					<div id="courseSchedule-inside">1</div>
					<div id="courseSchedule-inside">2</div>
					<div id="courseSchedule-inside">3</div>
					<div id="courseSchedule-inside">4</div>
				</div>

			<div id=""></div>


			</div>
		</div>
	</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
</body>
</html>















