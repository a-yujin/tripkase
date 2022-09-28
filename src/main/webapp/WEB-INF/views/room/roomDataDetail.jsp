<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세 : 숙소 상세 (관리자)</title>
<link href="../resources/css/room.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<jsp:include page="../admin/menuBar.jsp"></jsp:include>
	<br><br>
	<div id="room-text">
		<p class="first-text">숙소 상세보기</p>
	</div>
	<br>
	<div id="plus-wrapper">
		<div id="show-category">
			<p id="show-ctext">카테고리 : ${room.roomType }</p>
		</div>
		<br>
		<div id="show-name">
			<p id="show-ntext">숙소이름 : ${room.roomName }</p>
		</div>
		<br>
		<div id="show-price">
			<p id="show-ptext">가격 : ${room.roomPrice }</p>
		</div>
		<br>
		<div id="show-area">
			<p id="show-atext">지역 : ${room.roomArea }</p>
		</div>
		<br>
		<div id="show-address">
			<p id="show-atext">주소 : ${room.roomAddress }</p>
		</div>
		<br>
		<div id="show-tel">
			<p id="show-ttext">전화번호 : ${room.roomTel }</p>
		</div>
		<br>
		<div id="show-person">
			<p id="show-ptext">입실 가능 인원 : ${room.roomPerson }명</p>
		</div>
		<br>
		<div id="show-pet">
			<p id="show-ptext">반려견 동반 가능 여부 : ${room.roomPet }</p>
		</div>
		<br>
		<div id="show-car">
		<p>주차 정보</p>
			<textarea id="roomCar" name="roomCar">${room.roomCar }</textarea>
		</div>
		<div>
			<p>대중교통 정보</p>
			<textarea id="roomLocation" name="roomLocation">${room.roomLocation }</textarea>
		</div>
		<div>
			<p>숙소정보</p>
		<textarea id="roomGuide" name="roomGuide">${room.roomGuide }</textarea>
		</div>
		<div>
			<p>숙소사진</p>
			<c:if test="${riList ne null }">
				<c:forEach items="${riList }" var="roomImg" varStatus="i">
					<img src="../resources/ruploadFiles/${roomImg.roomFileRename }" id="roomimg-area" width="300px" height="150px">
				</c:forEach>
			</c:if>
			<c:if test="${riList eq null }">
				<p>첨부파일이 없습니다.</p>
			</c:if>
		</div>
	</div>
	<br><br>
	<div id="room-button">
		<button class="detail-button" onclick="location.href='/room/roomDataModifyView.tripkase?roomNo=${room.roomNo}&page=${page }'">수정하기</button>
		<button class="detail-button" onclick="location.href='/room/roomDataList.tripkase'">목록으로</button>
		<button class="detail-button" onclick="roomDataRemove()">삭제하기</button>
	</div>
	<br><br><br>
	<script>
		// 데이터 삭제
		function roomDataRemove() {
			event.preventDefault();
			if(confirm("정말로 게시글을 삭제하시겠습니까?")) {
				location.href="/room/roomDataRemove.tripkase";
			}
		}
	</script>
</body>
</html>