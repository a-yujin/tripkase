<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세 : 숙소 상세페이지</title>
<link href="../resources/css/room.css" rel="stylesheet">
<script src="/resources/js/jquery-3.6.1.min.js"></script>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	<form action="/storage/insertStorage.tripkase" method="post">
		<input type="hidden" name="contentsCode" value="room"> <!-- 보관함으로 넘기기 위한 컨텐츠 분류 코드 -->
		<input type="hidden" name="contentsId"   value="${room.roomNo }"> <!-- 보관함으로 넘기기 위한 컨텐츠 넘버값 -->
		<div id="top-wrapper">
			<!-- 정보 영역 -->
			<div id="top-text">
				<p id="top-name">${room.roomName }</p>
				<p id="top-price">${room.roomPrice }</p>
			</div>	
			<!-- 사진 영역 -->
			<div id="top-picture">
				<div id="pic-left">
					<img src="../resources/ruploadFiles/${riList[0].roomFileRename }" width="580px" height="435px;">
				</div>
				<div id="pic-right">
					<div id="right-top">
						<div class="right-pic">
							<img src="../resources/ruploadFiles/${riList[1].roomFileRename }" width="300px">
						</div>
						<div class="right-pic">
							<img src="../resources/ruploadFiles/${riList[2].roomFileRename }" width="300px">
						</div>
					</div>
					<div id="right-bottom">
						<div class="right-pic">
							<img src="../resources/ruploadFiles/${riList[3].roomFileRename }" width="300px">
						</div>
						<div class="right-pic">
							<img src="../resources/ruploadFiles/${riList[4].roomFileRename }" width="300px">
						</div>
					</div>
				</div>
			</div>
			<!-- 버튼 영역 -->
			<br><br>
			<div id="top-button">
				<button type="submit" class="detail-button">보관하기</button>
				<button type="button" class="detail-button" onclick="javascript:history.go(-1);">목록으로</button>
			</div>
			<hr class="detail-hr">
			<div id="context-wrapper">
				<p class="detail-text">숙 소 정 보</p>
				<div id="detail-room">
					<p>주차장 정보</p>
					<pre>${room.roomCar }</pre> <br>
					<p>대중교통 정보</p>
					<pre>${room.roomLocation }</pre> <br>
					<p>숙소 정보</p>
					<pre>${room.roomGuide }</pre> <br>
				</div>
			</div>
			<hr class="detail-hr">
			<div id="room-imglist">
				<p class="detail-text">숙 소 사 진</p>
				<img src="../resources/ruploadFiles/${riList[0].roomFileRename }" width="800px" class="room-images">
				<img src="../resources/ruploadFiles/${riList[1].roomFileRename }" width="800px" class="room-images">
				<img src="../resources/ruploadFiles/${riList[2].roomFileRename }" width="800px" class="room-images">
				<img src="../resources/ruploadFiles/${riList[3].roomFileRename }" width="800px" class="room-images">
				<img src="../resources/ruploadFiles/${riList[4].roomFileRename }" width="800px" class="room-images">
				<img src="../resources/ruploadFiles/${riList[5].roomFileRename }" width="800px" class="room-images">
				<img src="../resources/ruploadFiles/${riList[6].roomFileRename }" width="800px" class="room-images">
				<img src="../resources/ruploadFiles/${riList[7].roomFileRename }" width="800px" class="room-images">
			</div>
		</div>
	</form>
	<script>
	</script>
</body>
</html>