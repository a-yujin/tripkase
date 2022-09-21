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
	<!-- 여행소통 상단, 게시글 작성 페이지 이동 -->
	<div id="back-img" align="center">
		<div id="intext">
			<p style="font-size:20px;">여 행 소 통</p>
			<p style="font-size:15px;">♥ 여러분들의 여행을 작성해주세요. ♥</p>
			<button id="writeBt" onclick="location.href='/trip/writeView.tripkase';">여행 작성하기</button>
		</div>
	</div>
	
	<!-- 검색 -->
	<div id="input-group" class="input-group">
		<input type="search" id="search-input" class="form-control rounded" placeholder="게시글 제목 또는 작성자 이름으로 검색 가능합니다." aria-label="Search" aria-describedby="search-addon" />
		<button type="button" id="searchBt" class="btn btn-outline-primary">검색하기</button>
	</div>
	
	<!-- 게시글 리스트 -->
	<div class="top-text">Travel</div>
	<br><br><br>
	<div id="card-wrapper">
		<div id="card-outside">
			<c:forEach items="${tList }" var="trip" varStatus="i">
				<div class="card" id="card-inside" style="width: 280px;">
					<a href="/trip/detailView.tripkase?tripNo=${trip.tripNo }">
						<img src="/resources/tuploadFiles/${trip.tripFileRename }" class="card-img-top" alt="리스트 이미지" width="200px" height="280px">
					</a>
					<div class="card-body">
						<b id="list-title" class="card-title">${trip.tripTitle }</b>
						<p id="list-text" class="card-text">${trip.tripContents }</p>
						<input type="hidden" id="like-check" value="${trip.tripLike }">
						<img src="/resources/images/trip/beforeLike.png" id="likeimg" class="likeimgs" width="35px" height="30px">
						<span id="like-counter">${trip.tripLike }</span>
						<span id="card-maker">${trip.tripWriter } ${trip.tripCreate }</span>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
<script>
	// 
</script>
</body>
</html>