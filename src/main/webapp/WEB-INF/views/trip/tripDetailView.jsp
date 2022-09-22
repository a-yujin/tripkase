<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세 : 여행소통 게시글 보기</title>
<link href="../resources/css/trip.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
<script src="/resources/js/jquery-3.6.1.min.js"></script>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	<div id="member-inf">
		<p>${trip.tripWriter }</p>
	</div>
	<!-- 게시글 상세 -->
	<br><br><br><br>
	<div id="first">
		<div id="first-left">
			<img src="/resources/tuploadFiles/${trip.tripFileRename }" width="400" height="400" alt="본문 이미지">
		</div>
		<div id="first-right">
			<div id="choice-drop" class="btn-group dropstart">
				<button type="button" id="choiceBt" data-bs-toggle="dropdown" aria-expanded="false">
					<img src="/resources/images/trip/dot.png" id="dot-select">
				</button>
					<ul id="choice-menu" class="dropdown-menu">
						<li><a id="choice-menu1" class="dropdown-item" onclick="location.href='/trip/tripModifyView.tripkase?tripNo=${trip.tripNo }';">수정하기</a></li>
						<li><a id="choice-menu2" class="dropdown-item" onclick="tripOneRemove()">삭제하기</a></li>
					</ul>
			</div>
			<br><br>
			<p>제목 : ${trip.tripTitle }</p>
			<p>작성자 : ${trip.tripWriter }</p>
			<p>작성일자 : ${trip.tripCreate }</p>
			<br>
			<p>${trip.tripContents }</p>
			<img src="/resources/images/trip/beforeLike.png" id="beforeLike" class="likeimgs" width="35px" height="30px" onclick="contentLike()">
            <img src="/resources/images/trip/afterLike.png" id="afterLike" class="likeimgs" width="35px" height="30px" onclick="contentLike()">
		</div>
	</div>
	<br>
	<div id="button-move">
		<button class="but-move">이전 페이지</button>
		<button class="but-move" onclick="location.href='/trip/tripList.tripkase';">목록으로</button>
		<button class="but-move">다음 페이지</button>
	</div>
	<br><br><br>	
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
	<br>
	<br><br><br><br>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
	<script>
		function tripOneRemove() {
			event.preventDefault();
			if(confirm("정말로 게시글을 삭제하시겠습니까?")) {
				location.href="/trip/tripRemove.tripkase";
			}
		}
		// 좋아요 클릭시 이미지 변경
		$(document).ready(function() {
			$("#beforeLike").show();
			$("#afterLike").hide();
			
			$("#beforeLike").click(function() {
				$("#beforeLike").hide();
				$("#afterLike").show();
			})
			$("#afterLike").click(function() {
				$("#beforeLike").show();
				$("#afterLike").hide();
			})
		})
	</script>
</body>
</html>