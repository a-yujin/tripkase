<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세 : 코스삭제 </title>
<script src="/resources/js/jquery-3.6.1.min.js"></script>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<h1 align="center">이름으로 코스 검색</h1>
	<form action="/course/serchCourseByName.tripkase" method="post">
	<div class="register">
		<table align="center" border="1">
			<tr>
				<td>검색할 코스 이름</td>
				<td><input type="text" name="courseName"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="등록">
					<input type="reset"  value="취소">
				</td>
			</tr>
		</table>
	</div>
	</form>
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>
