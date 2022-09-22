<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세 : 맛집 상세조회</title>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
</head>
<style>
    body {
        font-family : 'Noto Sans KR',sans-serif;
    }
</style>
<body>
	<form action="/storage/insertStorage.tripkase" method="post">
		<input type="hidden" name="contentsCode" value="restaurant"> <!-- 보관함으로 넘기기 위한 컨텐츠 분류 코드 -->
		<input type="hidden" name="contentsId" value="${restaurant.resNo }"> <!-- 보관함으로 넘기기 위한 컨텐츠 넘버값 -->
		<table align="center" border="1">
			<tr>
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
			<input type="submit" value="보관">
	</form>
		<a href="/restaurant/deleteRestaurant.tripkase">삭제</a>
	</table>
</body>
</html>