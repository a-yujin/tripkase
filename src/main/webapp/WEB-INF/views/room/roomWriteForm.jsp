<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행소통 : 숙소 추가 (관리자)</title>
<link href="../resources/css/room.css" rel="stylesheet">
<script src="/resources/js/jquery-3.6.1.min.js"></script>
<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<jsp:include page="../admin/menuBar.jsp"></jsp:include>
	<br><br>
	<div id="room-text">
		<p class="first-text">숙소 입력</p>
	</div>
	<br>
	<form action="/room/roomDataPush.tripkase" method="post" enctype="multipart/form-data">
		<div id="plus-wrapper">
			<div id="plus-category">
				<p id="category-text">카테고리</p>
				<select id="category-choice" name="roomType" onchange="selectBox(this.value);">
					<option value="모텔">모텔</option>
					<option value="호텔">호텔</option>
					<option value="펜션">펜션</option>
					<option value="리조트">리조트</option>
				</select>
			</div>
			<br>
			<div id="plus-name">
				<p id="name-text">숙소이름</p>
				<input type="text" id="name-input" name="roomName">
			</div>
			<br>
			<div id="plus-price">
				<p id="price-text">가격</p>
				<input type="text" id="room-price" name="roomPrice">
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
				<p id="address-text">주소</p>
				<button type="button" id="address-search">검색</button> <br>
				<input type="text" id="rAddress1" class="postcodify_address" name="roomAddress1" placeholder="검색 버튼을 눌러주세요.">
				<input type="text" id="rAddress2" class="postcodify_details" name="roomAddress2" placeholder="상세주소를 입력해주세요.">
			</div>
			<br>
			<div>
				<p id="tel-text">전화번호</p>
				<input type="text" id="roomTel" name="roomTel">
			</div>
			<br>
			<div>
				<p id="person-text">입실 가능 인원</p>
				<input type="number" id="roomPerson" name="roomPerson">
			</div>
			<br>
			<div>
				<p id="pet-text">반려견 동반 가능 여부</p>
				<input type="radio" id="roomPet" name="roomPet" value="N" checked>
				<label for="N">NO</label>
				<input type="radio" id="roomPet" name="roomPet" value="Y">
				<label for="Y">YES</label>
			</div>
			<br>
			<div>
				<p>주차 정보</p>
				<textarea id="roomCar" name="roomCar"></textarea>
			</div>
			<div>
				<p>대중교통 정보</p>
				<textarea id="roomLocation" name="roomLocation"></textarea>
			</div>
			<div>
				<p>숙소정보</p>
				<textarea id="roomGuide" name="roomGuide"></textarea>
			</div>
			<table>
				<tr class="fileTr">
					<td>첨부파일</td>
					<td>
						<button class="btn btn-default" type="button" onclick="addFile();">추가</button>
						<button class="btn btn-default" type="button" onclick="removeFile();">삭제</button>
						<input multiple="multiple" type="file" name="uploadFile">
					</td>
				</tr>		
			</table>
		</div>
		<br><br>
		<div id="room-button">
			<input type="submit" id="rbutton" value="등록하기">
		</div>
		<br><br><br>
	</form>
	<script>
		var selectBox = function(value) {
			$("#changeInput").val(Value);
		}
		function addFile(){
			var number = 2;
			var trTag = $(".fileTr");
			$(trTag).children('td').eq(1).append("<br><input multiple='multiple' type='file' name='uploadFile' />");
			number = number + 1;
		}
		function removeFile(){
			var trTag = $(".fileTr");
		 	if($(trTag).children('td').eq(1).children('input').length > 1) {
			 	$(trTag).children('td').eq(1).children('input:last').remove();
			 	$(trTag).children('td').eq(1).children('br:last').remove();
			} 
		}
		$(function() {
			$("#address-search").postcodifyPopUp();
		});
	</script>
</body>
</html>