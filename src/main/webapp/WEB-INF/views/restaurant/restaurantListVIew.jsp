<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세 : 맛집 목록 페이지</title>
<!-- 테스트용 jsp  -->
</head>
<body>
	<h1 align="center">맛집 목록</h1>
<br><br>
<table align="center" border="1">
	<tr>
		<th>이미지</th>
		<th>제목</th>
		<th>주소</th>
		<th>평점</th>
		<th>평가수</th>
		<th>상세내용</th>
	</tr>
	<c:if test="${!empty resList }">
		<c:forEach items="${resList }" var="restaurant" varStatus="i">
			<tr>
				<td>
					<img alt="맛집이미지" src="#" width="300" height="300">
				</td>
				<td><a href="/restaurant/retaurantDetail.tripkase?resNo=${restaurant.resNo }&page=${currentPage}">${restaurant.resName }</a></td>
				<td>${restaurant.resAddress }</td>
				<td>${restaurant.resGrade }</td>
				<td>${restaurant.resComentCount }</td>
				<td>${restaurant.resDetail }</td>
			</tr>
		</c:forEach>
	</c:if>
	<c:if test="${empty resList }">
		<tr>
			<td colspan="6" align="center">데이터가 존재하지 않습니다</td>
		</tr>
	</c:if>
	<tr align="center" height="20">
		<td colspan="6">
			<c:if test ="${currentPage != 1}">
				<a href="/restaurant/${urlVal }.tripkase?page=${currentPage - 1 }&searchCondition=${searchCondition}&searchValue=${searchValue}">[이전]</a>
			</c:if>
			<c:forEach var="p" begin="${startNavi }" end="${endNavi }">
				<c:if test="${currentPage eq p }">
					${p }
				</c:if>
				<c:if test="${currentPage ne p }">
					<a href="/restaurant/${urlVal }.tripkase?page=${p }&searchCondition=${searchCondition}&searchValue=${searchValue}">${p }</a>
				</c:if>
			</c:forEach>
			<c:if test ="${maxPage > currentPage}">
			<a href="/restaurant/${urlVal }.tripkase?page=${currentPage + 1 }&searchCondition=${searchCondition}&searchValue=${searchValue}">[다음]</a>
			</c:if>
		</td>
	</tr>
</table>
</body>
</html>