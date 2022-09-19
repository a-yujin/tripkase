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

	<!-- 게시글 TOP3 -->
	<div class="top-text">Month Best Travel</div>
	<br><br>
	<div class="container text-center">
		<div class="row">
			<div class="col">
				<c:forEach items="${tList }" var="trip" varStatus="i">
					<div class="card" style="width: 18rem;">
						<img src="/resources/tuploadFiles/${trip.tripFileRename }" class="card-img-top" alt="리스트 이미지">
						<div class="card-body">
							<h5 class="card-title">${trip.tripTitle }</h5>
							<p class="card-text">${trip.tripContents }</p>
							<a href="#" class="btn btn-primary">Go somewhere</a>
						</div>
					</div>
				</c:forEach>
			</div>
			<div class="col">
				<c:forEach items="${tList }" var="trip" varStatus="i">
					<div class="card" style="width: 18rem;">
						<img src="/resources/tuploadFiles/${trip.tripFileRename }" class="card-img-top" alt="리스트 이미지">
						<div class="card-body">
							<h5 class="card-title">${trip.tripTitle }</h5>
							<p class="card-text">${trip.tripContents }</p>
							<a href="#" class="btn btn-primary">Go somewhere</a>
						</div>
					</div>
				</c:forEach>
			</div>
			<div class="col">
				<c:forEach items="${tList }" var="trip" varStatus="i">
					<div class="card" style="width: 18rem;">
						<img src="/resources/tuploadFiles/${trip.tripFileRename }" class="card-img-top" alt="리스트 이미지">
						<div class="card-body">
							<h5 class="card-title">${trip.tripTitle }</h5>
							<p class="card-text">${trip.tripContents }</p>
							<a href="#" class="btn btn-primary">Go somewhere</a>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	
	<!-- 게시글 리스트 -->
	<br><br><br><br>
	<div class="top-text">Travel</div>
	<br><br>
	<div class="container text-center">
		<div class="row">
			<c:forEach items="${tList }" var="trip" varStatus="i">
				<div class="col">
					<div class="card" style="width: 18rem;">
						<img src="/resources/tuploadFiles/${trip.tripFileRename }" class="card-img-top" alt="리스트 이미지">
						<div class="card-body">
							<h5 class="card-title">${trip.tripTitle }</h5>
							<p class="card-text">${trip.tripContents }</p>
							<a href="#" class="btn btn-primary">Go somewhere</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
</body>
</html>