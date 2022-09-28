<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행 카세 : 코스 수정</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="/resources/js/jquery-3.6.1.min.js"></script>
<style>
	.courseTable{
		padding-left:100px;
		width:1000px;
		margin : 0 auto;
	}
	
	#table{
		width : 700px;
	}
</style>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<div class="courseTable">
	<br><br>
		<h2 align="center">코스 수정</h2><br>
		<form action="/course/modifyCourse.tripkase" method="POST" enctype="multipart/form-data">
		<input type="hidden" name="courseNo" value="${cOne.courseNo }">
		<table id = "table" align="center" width="500" border="1">
			<tr>
				<td>코스이름</td>
				<td><input type="text" name="courseName" size=85 value="${cOne.courseName }"></td>
			</tr>
			 
			<tr>
				<td>코스테마</td>
				<td><input type="text" name="courseThema" size=85 value="${cOne.courseThema }"></td>
			</tr>
			<tr>
				<td>코스거리</td>
				<td><input type="text" name="courseDistance" size=85 value="${cOne.courseDistance }"></td>
			</tr>
			<tr>
				<td>지역명</td>
				<td><input type="text" name="locationName" size=85 value="${cOne.locationName }"></td>
			</tr>
			<tr height="300">
				<td>코스정보</td>
				<td><textarea cols="50" rows="15" name=courseInfo>${cOne.courseInfo } </textarea></td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td>
					<c:forEach items="${cImg }" var="img">
						<input type="hidden" value="${img.imgNo }" name="imgNo">
						<input type="hidden" value="${img.cFileRename }" name="cFileRename">
						<input type="file" name="reloadFile">
					</c:forEach>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button class="btn btn-default" type="submit" >수정하기 </button>
				</td>
			</tr>
		</table>
		
		</form>
	</div>
	<br><br><br><br><br>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<jsp:include page="../common/footer.jsp"/>
</body>
</html>