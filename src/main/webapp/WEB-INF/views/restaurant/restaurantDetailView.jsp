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
			<th>맛집ID값</th>
			<th>이미지</th>
			<th>맛집이름</th>
			<th>주소</th>
			<th>평점</th>
			<th>평가수</th>
			<th>상세내용</th>
			<th>연락처</th>
			<th>휴일</th>
			<th>대표메뉴</th>
		</tr>
		<tr>
			<td>${restaurant.resNo }</td>
			<td><img src="/resources/resUploadFiles/${restaurant.resFileRename }" width="300" height="300"></td>
			<td>${restaurant.resName }</td>
			<td>${restaurant.resAddress }</td>
			<td></td>
			<td></td>
<%-- 			<td>${restaurant.resGrade }</td> --%>
<%-- 			<td>${restaurant.resComentCount }</td> --%>
			<td>${restaurant.resDetail }</td>
			<td>${restaurant.resTel }</td>
			<td>${restaurant.resDayoff }</td>
			<td>${restaurant.resMainmenu }</td>
		</tr>
		
		<a href="/restaurant/deleteRestaurant.tripkase">삭제</a>
		
	</table>
</body>
</html>