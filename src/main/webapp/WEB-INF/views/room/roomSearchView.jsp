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
		<form action="/room/roomNameSearch.tripkase" method="get" enctype="multipart/form-data">
			<div id="search-area" class="input-group">				
				<input type="search" id="search-input" class="form-control rounded" name="searchValue" placeholder="숙소 이름으로 검색 가능합니다. 전체 조회를 원하시면 공백으로 조회하기 버튼을 눌러주세요." aria-label="Search" aria-describedby="search-addon" value="${searchValue }" />
				<button type="submit" id="searchBt" class="btn btn-outline-primary">조회하기</button>
			</div>	<!-- 지역 선택 영역 -->
		</form>
		<form action="/room/roomTypeSearch.tripkase" method="get" enctype="multipart/form-data">
			<div>
				<div id="choice-area" class="btn-group" role="group" aria-label="Basic radio toggle button group">
					<input type="radio" class="btn-check" id="btnradio1" name="areaValue" autocomplete="off" checked value="">
					<label class="btn btn-outline-primary" for="btnradio1">전체보기</label>
					
					<input type="radio" class="btn-check" id="btnradio2" name="areaValue" autocomplete="off" value="서울">
					<label class="btn btn-outline-primary" for="btnradio2">　서울　</label>
					
					<input type="radio" class="btn-check" id="btnradio3" name="areaValue" autocomplete="off" value="경기도">
					<label class="btn btn-outline-primary" for="btnradio3">　경기도　</label>
					
					<input type="radio" class="btn-check" id="btnradio4" name="areaValue" autocomplete="off" value="인천">
					<label class="btn btn-outline-primary" for="btnradio4">　인천　</label>
					
					<input type="radio" class="btn-check" id="btnradio5" name="areaValue" autocomplete="off" value="강원">
					<label class="btn btn-outline-primary" for="btnradio5">　강원도　</label>
					
					<input type="radio" class="btn-check" id="btnradio6" name="areaValue" autocomplete="off" value="충청북도">
					<label class="btn btn-outline-primary" for="btnradio6">　충청북도　</label>
					
					<input type="radio" class="btn-check" id="btnradio7" name="areaValue" autocomplete="off" value="충청남도">
					<label class="btn btn-outline-primary" for="btnradio7">　충청남도　</label>
					
					<input type="radio" class="btn-check" id="btnradio8" name="areaValue" autocomplete="off" value="경상북도">
					<label class="btn btn-outline-primary" for="btnradio8">　경상북도　</label>
					
					<input type="radio" class="btn-check" id="btnradio9" name="areaValue" autocomplete="off" value="경상남도">
					<label class="btn btn-outline-primary" for="btnradio9">　경상남도　</label>
					
					<input type="radio" class="btn-check" id="btnradio10" name="areaValue" autocomplete="off" value="전라북도">
					<label class="btn btn-outline-primary" for="btnradio10">　전라북도　</label>
						
					<input type="radio" class="btn-check" id="btnradio11" name="areaValue" autocomplete="off" value="전라남도">
					<label class="btn btn-outline-primary" for="btnradio11">　전라남도　</label>
						
					<input type="radio" class="btn-check" id="btnradio12" name="areaValue" autocomplete="off" value="제주도">
					<label class="btn btn-outline-primary" for="btnradio12">　제주도　</label>
				</div>
				<div id="choice-checkIn">
					<input type="date" id="check-in" class="room-check">
					<input type="date" id="check-out" class="room-check">
				</div>
				<div id="choice-place" >
					<div id="choice-type" class="btn-group" role="group" aria-label="Basic checkbox toggle button group">
						<span>숙소 종류</span>
						<input type="radio" name="typeValue" value="모텔"> 모텔
						<input type="radio" name="typeValue" value="호텔"> 호텔
						<input type="radio" name="typeValue" value="펜션"> 펜션
						<input type="radio" name="typeValue" value="리조트"> 리조트
					</div>
					<div id="choice-person">
						<span id="person-text">입실 인원</span>
						<input type="number" name="personValue">
					</div>
					<div id="choice-pet">
						<span id="pet-text">반려견 동반 여부</span>
						<div id="pet-yes" class="form-check form-switch">
							<input type="radio" name="petValue" value="N"> No
							<input type="radio" name="petValue" value="Y"> Yes
						</div>
					</div>
				</div>
			</div>
		<br><br>
		<div id="search-button">
			<button type="submit" id="sbutton">조회하기</button>
		</div>
		</form>
	</div>		
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
</body>
</html>