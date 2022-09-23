<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행소통 : 숙소 추가 (관리자)</title>
<link href="../resources/css/room.css" rel="stylesheet">
</head>
<body>
	<div id="room-text">
		<p>숙소 입력</p>
	</div>
	<br><br>
	<form action="/room/registerRoom.tripkase" method="post" enctype="multipart/form-data">
		<div id="plus-wrapper">
			<div id="plus-category">
				<p id="category-text">카테고리</p>
				<select id="category-choice">
					<option>모텔</option>
					<option>호텔</option>
					<option>펜션</option>
					<option>리조트</option>
				</select>
			</div>
			<br>
			<div id="plus-name">
				<p id="name-text">숙소이름</p>
				<input type="text" id="name-input">
			</div>
			<div id="plus-price">
				<p id="price-text">가격</p>
				<input type="text" id="room-price">
			</div>
			<div id="plus-map">
				<p id="map-text">지도</p>	
				<input type="button" id="searchBtn" onclick="searchPlaces()" value="검색">
			</div>
			<div id="">
				<p>주소</p>
				<input type="text">
			</div>
			<div>
				<p>전화번호</p>
				<input type="text">
			</div>
			<div>
				<p>입실 가능 인원</p>
				<input type="number">
			</div>
			<div>
				<p>반려견 동반 가능 여부</p>
				<input type="radio">
			</div>
			<div>
				<p>주차 정보</p>
				<textarea></textarea>
			</div>
			<div>
				<p>대중교통 정보</p>
				<textarea></textarea>
			</div>
			<div>
				<p>숙소정보</p>
				<textarea></textarea>
			</div>
			<div>
				<p>숙소사진</p>
				<input type="file">
			</div>
		</div>
	</form>
</body>
</html>