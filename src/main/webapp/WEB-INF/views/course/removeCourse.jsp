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
	<h1 align="center">코스 삭제  페이지</h1>
	<form action="/course/removeCourse.tripkase" method="post">
	<div class="register">
		<table align="center" border="1">
			<tr>
				<td>삭제할 코스 이름</td>
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
</body>
</html>
