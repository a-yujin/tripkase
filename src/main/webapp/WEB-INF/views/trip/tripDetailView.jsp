<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세 : 여행소통 게시글 보기</title>
<link href="../resources/css/trip.css" rel="stylesheet">
</head>
<body>
	<br><br><br><br>
	<div id="first">
		<div id="first-left">
			<img src="/resources/tuploadFiles/${trip.tripFileRename }" width="400" height="400" alt="본문 이미지">
		</div>
		<div id="first-right">
			<img src="/resources/images/trip/dot.png" id="dot-select">
			<br>
			<p>제목 : ${trip.tripTitle }</p>
			<p>작성자 : </p>
			<p>작성일자 : ${trip.tripCreate }</p>
			<br>
			<p>${trip.tripContents }</p>
		</div>
	</div>
	<br>
	<div id="button-move">
		<button class="but-move">이전 페이지</button>
		<button class="but-move" onclick="location.href='/trip/tripList.tripkase';">목록으로</button>
		<button class="but-move">다음 페이지</button>
	</div>
	<br><br><hr width="80%"><br>
</body>
</html>