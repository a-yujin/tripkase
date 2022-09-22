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
		</div>
	</form>
</body>
</html>