<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세 : 맛집 상세조회</title>
</head>
<body>
	<table align="center" border="1">
		<tr>
			<th>이미지</th>
			<th>제목</th>
			<th>주소</th>
			<th>평점</th>
			<th>평가수</th>
			<th></th>
			<th>상세내용</th>
		</tr>
		<tr>
			<td>${restaurant.resAddress }</td>
			<td>${restaurant.resGrade }</td>
			<td>${restaurant.resComentCount }</td>
			<td>${restaurant.resDetail }</td>
		</tr>
	</table>
</body>
</html>