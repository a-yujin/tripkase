<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세 : 숙소 수정 (관리자)</title>
<link href="../resources/css/room.css" rel="stylesheet">
<script src="/resources/js/jquery-3.6.1.min.js"></script>
<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<jsp:include page="../admin/menuBar.jsp"></jsp:include>
	<br><br>
	<div id="updateRoom">
		<strong id="first-text">숙소 정보 수정</strong>
		<p id="second-text">${room.roomName } (${room.roomType })</p>
	</div>
	<br>
	<form action="/room/updateRoomData.tripkase" method="post" enctype="multipart/form-data">
		<input type="hidden" name="roomNo" value="${room.roomNo }">
		<input type="hidden" name="page" value="${page }">
		<input type="hidden" value="${roomImg.roomImgNo }" name="roomImgNo">
		<input type="hidden" value="${roomImg.roomFileName }" name="roomFileName">
		<input type="hidden" value="${roomImg.roomFileRename }" name="roomFileRename">
		<div id="plus-wrapper">
			<div id="plus-price">
				<p class="update-text">가격</p>
				<input type="text" id="update-price" name="roomPrice" value="${room.roomPrice }">
			</div>
			<br>
			<div id="plus-area">
				<p id="area-text">지역</p>
				<select id="area-choice" name="roomArea" onchange="selectBox(this.value);">
					<option value="서울">서울</option>
					<option value="경기도">경기도</option>
					<option value="인천">인천</option>
					<option value="강원도">강원도</option>
					<option value="충청북도">충청북도</option>
					<option value="충청남도">충청남도</option>
					<option value="경상북도">경상북도</option>
					<option value="경상남도">경상남도</option>
					<option value="전라북도">전라북도</option>
					<option value="전라남도">전라남도</option>
					<option value="제주도">제주도</option>
				</select>
			</div>
			<br>
			<div id="plus-address">
				<p class="update-text">주소</p>
				<button type="button" id="address-search">검색</button> <br>
				<p id="uptext"> 기존 주소 : ${room.roomAddress }</p>
				<input type="text" id="uAddress1" class="postcodify_address" name="roomAddress1" placeholder="검색 버튼을 눌러주세요.">
				<input type="text" id="uAddress2" class="postcodify_details" name="roomAddress2" placeholder="상세주소를 입력해주세요.">
			</div>
			<br>
			<div>
				<p id="tel-text">전화번호</p>
				<input type="text" id="roomTel" name="roomTel" value="${room.roomTel }">
			</div>
			<br>
			<div>
				<p id="person-text">입실 가능 인원</p>
				<input type="number" id="roomPerson" name="roomPerson" value="${room.roomPerson }">
			</div>
			<br>
			<div>
				<p id="pet-text">반려견 동반 가능 여부</p>
				<input type="radio" id="roomPet" name="roomPet" value="N">
				<label for="N">NO</label>
				<input type="radio" id="roomPet" name="roomPet" value="Y">
				<label for="Y">YES</label>
			</div>
			<br>
			<div>
				<p>주차 정보</p>
				<textarea id="roomCar" name="roomCar" spellcheck="false">${room.roomCar }</textarea>
			</div>
			<div>
				<p>대중교통 정보</p>
				<textarea id="roomLocation" name="roomLocation" spellcheck="false">${room.roomLocation }</textarea>
			</div>
			<div>
				<p>숙소정보</p>
				<textarea id="roomGuide" name="roomGuide" spellcheck="false">${room.roomGuide }</textarea>
			</div>
			<div>
				<p>숙소사진</p>
				<c:forEach items="${riList }" var="img">
					<img src="../resources/ruploadFiles/${roomImg.roomFileRename }" id="roomimg-area" width="300px" height="150px">
					<input type="file" name="reloadFile" value="${roomImg.roomFileName }">
				</c:forEach>
			</div>
			
		</div>
		<br><br>
		<div id="room-button">
			<input type="submit" id="rbutton" value="수정하기">
		</div>
		<br><br><br>
	</form>
	<script>
		var selectBox = function(value) {
			$("#changeInput").val(Value);
		}
		$(function() {
			$("#address-search").postcodifyPopUp();
		});
	</script>
</body>
</html>