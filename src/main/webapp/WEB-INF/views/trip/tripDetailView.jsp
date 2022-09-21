<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세 : 여행소통 게시글 보기</title>
<link href="../resources/css/trip.css" rel="stylesheet">
<script src="/resources/js/jquery-3.6.1.min.js"></script>
</head>
<body>
	<!-- 게시글 상세 -->
	<br><br><br><br>
	<div id="first">
		<div id="first-left">
			<img src="/resources/tuploadFiles/${trip.tripFileRename }" width="400" height="400" alt="본문 이미지">
		</div>
		<div id="first-right">
			<a><img src="/resources/images/trip/dot.png"></a>
			<br>
			<p>제목 : ${trip.tripTitle }</p>
			<p>작성자 : ${trip.tripWriter }</p>
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
	<br><br><hr width="60%"><br><br>
	
	<!-- 댓글 등록 -->
	<form action="/trip/addReply.tripkase" method="post">
		<input type="hidden" name="repTripNo" value="${trip.tripNo }">
		<div id="tReply-wrapper">
			<div id="tReply-background">
				<textarea id="tReply-write" name="tReplyContents"></textarea>
				<input type="submit" id="tReply-writebt" value="등록하기">		
			</div>
		</div>
	</form>
	<br><br><br><br>
</body>
</html>