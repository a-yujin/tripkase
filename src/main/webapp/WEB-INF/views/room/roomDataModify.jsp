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
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
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
				<p id="uptext"> 기존 주소 : ${room.roomAddress }</p>
				<input type="button" onclick="sample4_execDaumPostcode()" value="검색"><br>
				<input type="text" id="sample4_roadAddress" name="roomAddress1" placeholder="도로명주소">
				<input type="text" id="sample4_detailAddress" name="roomAddress2" placeholder="상세주소">
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
					<input type="file" name="reloadFile" value="${roomImg.roomFileRename }">
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
		
		function sample4_execDaumPostcode() {
	        new daum.Postcode({
	            oncomplete: function(data) {
	                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

	                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
	                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	                var roadAddr = data.roadAddress; // 도로명 주소 변수
	                var extraRoadAddr = ''; // 참고 항목 변수

	                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
	                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
	                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                    extraRoadAddr += data.bname;
	                }
	                // 건물명이 있고, 공동주택일 경우 추가한다.
	                if(data.buildingName !== '' && data.apartment === 'Y'){
	                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                }
	                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	                if(extraRoadAddr !== ''){
	                    extraRoadAddr = ' (' + extraRoadAddr + ')';
	                }

	                // 우편번호와 주소 정보를 해당 필드에 넣는다.
	                document.getElementById("sample4_roadAddress").value = roadAddr;
	            }
	        }).open();
	    }
	</script>
</body>
</html>