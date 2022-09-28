<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행 카세 : 코스 상세 조회</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="/resources/js/jquery-3.6.1.min.js"></script>
<style>
	.courseTable{
		padding-left:100px;
		width:700px;
		margin : 0 auto;
	}
	
	#td1{
		width:15%;
	}
	
	#table{
		width:700px;
		height:700px;
	}
</style>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<div class="courseTable">
	<br><br>
		<h2 align="center">코스 상세 조회</h2><br>
		<table id="table" align="center" width="500" border="1">
			<tr >
				<td id="td1">코스이름</td>
				<td>${course.courseName }</td>
			</tr>
			<tr>
				<td>코스테마</td>
				<td>${course.courseThema }</td>
			</tr>
			<tr>
				<td>코스거리</td>
				<td>${course.courseDistance }</td>
			</tr>
			<tr>
				<td>지역명</td>
				<td>${course.locationName }</td>
			</tr>
			<tr height="300">
				<td>코스정보</td>
				<td>${course.courseInfo }</td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td>
					<c:if test="${cImg ne null }">
						<c:forEach items="${cImg }" var="img" varStatus="i">
							<img alt="공지이미지" src="/resources/cosUploadFiles/${img.cFileRename}" width="400" height="200">
						</c:forEach>
					</c:if>
					<c:if test="${cImg eq null }">
						첨부파일 없음
					</c:if>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button class="btn btn-default" type="button" onclick="location.href='/course/modifyCourseView.tripkase?courseNo=${course.courseNo }'">코스 수정 </button>
					<button class="btn btn-default" type="button" onclick="location.href='/course/removeCourse.tripkase?courseNo=${course.courseNo }'">코스 삭제 </button>
				</td>
			</tr>
		</table>
	</div>
	<br><br><br><br><br>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<jsp:include page="../common/footer.jsp"/>
</body>
</html>