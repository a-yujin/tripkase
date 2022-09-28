<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세 : 숙소 상세페이지</title>
<link href="../resources/css/room.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	<div id="top-wrapper">
		<div id="top-text">
			<p id="top-name">${room.roomName }</p>
			<p id="top-price">${room.roomPrice }</p>
		</div>	
		<!-- 사진 -->
		<div id="top-picture">
			<div id="pic-left">
				<img src="../resources/ruploadFiles/${riList[0].roomFileRename }" width="580px">
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
		<!-- 지도 -->
	</div>
</body>
</html>