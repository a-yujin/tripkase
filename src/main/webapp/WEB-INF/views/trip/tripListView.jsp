<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세 : 여행소통 게시판</title>
<link href="../resources/css/trip.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
<script src="/resources/js/jquery-3.6.1.min.js"></script>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	<!-- 여행소통 상단, 게시글 작성 페이지 이동 -->
	<div id="back-img" align="center">
		<div id="intext">
			<p style="font-size:20px;">여 행 소 통</p>
			<p style="font-size:15px;">♥ 여러분들의 여행을 작성해주세요. ♥</p>
			<button id="writeBt" onclick="location.href='/trip/writeView.tripkase';">여행 작성하기</button>
		</div>
	</div>
	
	<!-- 검색 -->
	<form action="/trip/searchTrip.tripkase">
		<div id="input-group" class="input-group">
			<input type="search" id="search-input" class="form-control rounded" placeholder="게시글 제목 또는 작성자 이름으로 검색 가능합니다." aria-label="Search" aria-describedby="search-addon" name="searchValue" value="${searchValue }" />
			<button type="submit" id="searchBt" class="btn btn-outline-primary">검색하기</button>
		</div>
	</form>
	
	<!-- 게시글 리스트 -->
	<div class="top-text">Travel</div>
	<br><br><br>
	<div id="card-wrapper">
		<div id="card-outside">
			<c:forEach items="${tList }" var="trip" varStatus="i">
				<div class="card" id="card-inside" style="width: 280px;">
					<c:if test="${not empty loginMember}">
						<a href="/trip/detailView.tripkase?tripNo=${trip.tripNo }">
						<img src="/resources/tuploadFiles/${trip.tripFileRename }" class="card-img-top" alt="리스트 이미지" width="200px" height="280px">
						</a>
					</c:if>
					<c:if test="${sessionScope.loginMember eq null}">
						<img src="/resources/tuploadFiles/${trip.tripFileRename }" class="card-img-top" alt="리스트 이미지" width="200px" height="280px">
					</c:if>
					<div class="card-body">
						<!-- 게시글 제목 -->
						<b id="list-title" class="card-title">${trip.tripTitle }</b>
						<!-- 게시글 본문 -->
						<p id="list-text" class="card-text">${trip.tripContents }</p>
						<!-- 게시글 좋아요 -->
						<input type="hidden" id="like-check" value="${trip.tripLike }">
						<img src="/resources/images/trip/beforeLike.png" id="beforeLike" width="35px" height="30px">
						<span id="like-counter">${trip.tripLike }</span>
						<span id="card-maker">${trip.tripWriter } ${trip.tripCreate }</span>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<br><br>
	<table id="trip-page">
	<!-- 페이징 처리 -->
		<tr align="center" height="20">
			<td id="trip-list" colspan="2">
				<!-- 현재 페이지가 첫번째 페이지가 아니면 이전 페이지로 이동 버튼 생성 -->
				<c:if test="${currentPage != 1}">
					<a id="page-back" href="/trip/${urlVal}.tripkase?page=${currentPage - 1}&searchValue=${searchValue}">이전</a>
				</c:if>
				<c:forEach var="p" begin="${startNavi}" end="${endNavi}">
					<!-- 페이지 번호가 현재 페이지와 같으면 볼드체로 표시 -->
					<c:if test="${currentPage eq p}">
						<b id="page-current">${p}</b>
					</c:if>
					<!-- 페이지 번호가 현재 페이지와 다르면 해당 페이지로 이동 링크 처리 -->
					<c:if test="${currentPage ne p}">
						<a id="page-other" href="/trip/${urlVal}.tripkase?page=${p}&searchValue=${searchValue}">${p}</a>
					</c:if>
				</c:forEach>
				<!-- 마지막 페이지 번호가 현재 페이지보다 크면 다음 페이지로 버튼 생성 -->
				<c:if test="${maxPage > currentPage}">
					<a id="page-next" href="/trip/${urlVal}.tripkase?page=${currentPage + 1}&searchValue=${searchValue}">다음</a>
				</c:if>
			</td>
		</tr>
	</table>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
</body>
</html>