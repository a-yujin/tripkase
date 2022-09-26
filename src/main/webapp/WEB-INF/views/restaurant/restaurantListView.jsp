<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세 : 맛집 목록 페이지</title>
<!-- 테스트용 jsp  -->
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="../resources/css/restaurant.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<style>
    body {
        font-family : 'Noto Sans KR',sans-serif;
    }
</style>
<body>
<jsp:include page="../common/header.jsp"></jsp:include>
	<h1 align="center">맛집 목록</h1>
<br><br>
	<div id="res-data-list">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>사진</th>
					<th>가게 이름</th>
					<th>가게 주소</th>
					<th>상세내용</th>
				</tr>
			</thead>
			<c:if test="${!empty resList }">
				<c:forEach items="${resList }" var="resList" varStatus="i">
					<tbody onclick="/restaurant/restaurantDetailView.tripkase?resNo=${resList.resNo }&page=${currentPage}" id="resbody">
						<tr>
							<td><img src="/resources/resUploadFiles/${resList.resFileRename }" width="150" height="150"></td>
							<td>${resList.resName }</td>
							<td>${resList.resAddress }</td>
							<td>${resList.resDetail }</td>
						</tr>
					</tbody>
				</c:forEach>
			</c:if>
			<c:if test="${empty resList }">
				<tr>
					<td>검색 결과가 없습니다.</td>
				</tr>
			</c:if>
			</tbody>
		</table>
	</div>
	<div id="rdata-page">
			<c:if test ="${currentPage != 1}">
				<a id="pageback" href="/restaurant/${urlVal }.tripkase?page=${currentPage - 1 }&areaValue=${areaValue}&searchValue=${searchValue}
																<c:forEach items="${typeValue}" var="list">
																		&typeValue=${list}
																</c:forEach>">이전</a>
			<!-- forEach통해 리스트로 받아지는 쿼리스트링을 벗겨내서 포이치문 한번 더 쓰는걸로 쿼리스트링 완성 -->
			</c:if>
			
			<c:forEach var="p" begin="${startNavi }" end="${endNavi }">
				<c:if test="${currentPage eq p }">
					<b id="pagecurrent">${p }</b>
				</c:if>
				<c:if test="${currentPage ne p }">
					<a id="pageother" href="/restaurant/${urlVal }.tripkase?page=${p }&areaValue=${areaValue}&searchValue=${searchValue}
													<c:forEach items="${typeValue}" var="list">
															&typeValue=${list}
													</c:forEach>">${p }</a>
				</c:if>
			</c:forEach>
			
			<c:if test ="${maxPage > currentPage}">
			<a id="pagenext" href="/restaurant/${urlVal }.tripkase?page=${currentPage + 1 }&areaValue=${areaValue}&searchValue=${searchValue}
						&typeValue=<c:forEach items="${typeValue}" var="list">
											&typeValue=${list}
									</c:forEach>">다음</a>
			</c:if>
	</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
</body>
</html>