<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">

<meta charset="UTF-8">
<title>여행카세 : 코스 상세페이지</title>
<style>
.course_detail {
	position: relative;
	width: 100%;
	height: 200px;
	margin-top: 24px;
}

#contents {
	width: 1000px;
	margin: 0 auto;
	padding: 0 20px 27px 20px;
}

div {
	box-sizing: border-box;
}

#course {
	folat: left;
}

.map {
	width: 100%;
	height: 100px;
}

#title {
	clear: both;
}

#courseSchedule-wapper {
	height: 50px;
}

#courseSchedule-inside {
	float: left;
}

#courseSchedule-wapper {
	width: 100%;
	height: 150px;
	margin: 0 auto;
}

#courseSchedule-inside {
	width: 20%;
	height: 150px;
	margin: 0 auto;
	float : left;
}

.imagee {
	width: 90%;
	height: 150px;
	margin: 0 auto;
}

#courseDetail-wapper {
	width: 100%;
	height: 500px;
	margin: 0 auto;
}

#courseDetail-inside{
	width: 50%;
	height: 30%;
	margin: 0 auto;
	float : left;
}


#Detailimage {
	width: 50%;
	height: 50%;
	margin: 0 auto;
}

#courseDetail-wapper{
	width: 100%;
	height: 1000px;
	margin: 0 auto;
}

#courseDetail-inside{
	width: 50%;
	height: 33%;
}

.detailImage{
	width: 90%;
	height: 90%;
}

#cosReply-wrapper {
	width : 1000px;
	margin : 0 auto;
	padding-top : 1000px;
}
#footer{
	margin-top : 100%;
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
				<br>
				<div id="course_info">
					<span>지역 : ${cOne.locationName }</span> <span>코스 총거리 : ${cOne.courseDistance }</span>
				</div>
				<br>
			</div>
			<hr>
			<br>
			<div class="course_detail">
				<div>
					<p align="center">${cOne.courseInfo }</p>
				</div>
				
				<div class="map"></div>
				
				<div id="courseSchedule-wapper">
					<c:forEach items="${cImg}" var="cImg">
						<div id="courseSchedule-inside">
							<img class="imagee" src="/resources/cosUploadFiles/${cImg.cFileRename}">
						</div>
					</c:forEach>
				</div>
				<br><br><br><br><br><br>
				<div id="courseDetail-wapper">
					<c:forEach items="${cImg}" var="cImg">
						<div id="courseDetail-inside">
							<img class="detailImage" src="/resources/cosUploadFiles/${cImg.cFileRename}">
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</form>
<jsp:include page="../common/footer.jsp"/>	
</body>
</html>















