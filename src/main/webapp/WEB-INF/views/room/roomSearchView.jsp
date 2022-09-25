<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세 : 숙소 검색</title>
<link href="../resources/css/room.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
<script src="../resources/js/jquery-3.6.1.min.js"></script>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
		<div id="search-wrapper">
		<!-- 검색 영역 -->
			<div id="search-area" class="input-group">
			<input type="search" id="search-input" class="form-control rounded" placeholder="게시글 제목 또는 작성자 이름으로 검색 가능합니다." aria-label="Search" aria-describedby="search-addon" />
			<button type="button" id="searchBt" class="btn btn-outline-primary">검색하기</button>
				<!-- 지역 선택 영역 -->
				<div id="choice-area">
					<button class="areaBt-first">전체보기</button>
					<button class="areaBt">서울</button>
					<button class="areaBt">경기도</button>
					<button class="areaBt">인천</button>
					<button class="areaBt">강원도</button>
					<button class="areaBt">충청북도</button>
					<button class="areaBt">충청남도</button>
					<button class="areaBt">경상북도</button>
					<button class="areaBt">경상남도</button>
					<button class="areaBt">전라북도</button>
					<button class="areaBt">전라남도</button>
					<button class="areaBt">제주도</button>
				</div>
				<div id="choice-checkIn">
					<input type="date" id="check-in" class="room-check">
					<input type="date" id="check-out" class="room-check">
				</div>
				<div id="choice-place">
					<div id="choice-type">
						<span>숙소 종류</span>
						<input type="radio" id="type-all"> 전체
						<input type="radio"> 모텔
						<input type="radio"> 호텔
						<input type="radio"> 펜션
						<input type="radio"> 리조트
					</div>
					<div id="choice-person">
						<span id="person-text">입실 인원</span>
						<input type="number">
					</div>
					<div id="choice-pet">
						<span id="pet-text">반려견 동반 여부</span>
						<div id="pet-yes" class="form-check form-switch">
		  					<input class="form-check-input" type="checkbox" role="switch" id="flexSwitchCheckDefault">
						</div>
					</div>
				</div>
			</div>
			<br><br>
			<div id="search-button">
				<button type="submit" id="sbutton">조회하기</button>
			</div>
		</div>		
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
</body>
</html>