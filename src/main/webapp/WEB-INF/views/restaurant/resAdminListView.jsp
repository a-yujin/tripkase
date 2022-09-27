<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세 : 맛집 목록 페이지</title>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
</head>
<style>
    body {
        font-family : 'Noto Sans KR',sans-serif;
        text-align : center;
    }
    
    .restitle {
    	text-align : center;
    }
</style>
<body>
<jsp:include page="../common/header.jsp"/>
<jsp:include page="../admin/menuBar.jsp"/>
	<h1 align="center">맛집 목록</h1>
<br><br>
<table align="center" border="1" width="1100px">
	<tr>
		<th class="restitle">이미지</th>
		<th class="restitle" width="80px">제목</th>
		<th class="restitle">주소</th>
		<th class="restitle">상세내용</th>
		<th class="restitle" width="50px">수정</th>
		<th class="restitle" width="50px">삭제</th>
	</tr>
	<c:if test="${!empty resList }">
		<c:forEach items="${resList }" var="restaurant" varStatus="i">
			<tr>
				<td>
					<img src="/resources/resUploadFiles/${restaurant.resFileRename }" width="150" height="150">
				</td>
				<td><a href="/restaurant/resAdminDetailView.tripkase?resNo=${restaurant.resNo }">${restaurant.resName }</a></td>
				<td>${restaurant.resAddress }</td>
				<td class="resDetail">${restaurant.resDetail }</td>
				<td><a href="/restaurant/modifyRestaurantView.tripkase?resNo=${restaurant.resNo }">수정</a></td>
				<td><a href="/restaurant/deleteRestaurant.tripkase?resNo=${restaurant.resNo }">삭제</a></td>
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
				<a href="/restaurant/${urlVal }.tripkase?page=${currentPage - 1 }&areaValue=${areaValue}&searchValue=${searchValue}
																<c:forEach items="${typeValue}" var="list">
																		&typeValue=${list}
																</c:forEach>">[이전]</a>
			<!-- forEach통해 리스트로 받아지는 쿼리스트링을 벗겨내서 포이치문 한번 더 쓰는걸로 쿼리스트링 완성 -->
			</c:if>
			
			<c:forEach var="p" begin="${startNavi }" end="${endNavi }">
				<c:if test="${currentPage eq p }">
					${p }
				</c:if>
				<c:if test="${currentPage ne p }">
					<a href="/restaurant/${urlVal }.tripkase?page=${p }&areaValue=${areaValue}&searchValue=${searchValue}
													<c:forEach items="${typeValue}" var="list">
															&typeValue=${list}
													</c:forEach>">${p }</a>
				</c:if>
			</c:forEach>
			
			<c:if test ="${maxPage > currentPage}">
			<a href="/restaurant/${urlVal }.tripkase?page=${currentPage + 1 }&areaValue=${areaValue}&searchValue=${searchValue}
						&typeValue=<c:forEach items="${typeValue}" var="list">
											&typeValue=${list}
									</c:forEach>">[다음]</a>
			</c:if>
		</td>
	</tr>
</table>
</body>
</html>