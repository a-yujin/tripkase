<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세 : 관리자 페이지</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100&display=swap" rel="stylesheet">
	<style>
		body{
			font-family: 'Noto Sans KR', sans-serif;
		}
		ul{
			list-style : none;
		}
		a{
			text-decoration : none;
		}
		#side{
			float : left;
			width : 20%;
			border-right : 1px solid lightgray;
			padding-left : 20px;
		}
		#body{
			float : left;
			width : 75%;
			padding-left : 20px;
		}
		.function{
			text-align: center;
		}
		img {
			margin : auto;
			display : block;
		}
		li{
			text-align:center;
		}
	</style>
</head>
<body>
	<div id="side">
		<br>
		<ul>
			<li>
				<b>회원관리</b>
			</li>
			<li>
				<a class="function" href="#" onclick="location.href='/admin/memberAll.tripkase'">전체 회원 조회</a>
			</li>
			<li>
				<a class="function" href="#" onclick="location.href='/admin/memberSelectForm.tripkase'">개별 회원 조회</a><br><br>
			</li>
			<li>
				<b>게시판 관리</b>
			</li>
			<li>
				<a class="function" href="#" onclick="location.href='/admin/noticeList.tripkase'">공지 조회</a>
			</li>
			<li>
				<a class="function" href="#" onclick="location.href='/admin/qnaList.tripkase'">문의 조회</a><br><br>
			</li>
			<li>
				<b>신고 관리</b>
			</li>
			<li>
				<a class="function" href="#" onclick="location.href='/admin/reportList.tripkase'">신고 조회</a><br><br>
			</li>
			<li>
				<b>컨텐츠 관리</b><br>
			</li>
			<li>
				<a class="function" href="#" onclick="location.href='/course/insertCourseView.tripkase'">코스 등록</a>
			</li>
			<li>
				<a class="function" href="#" onclick="location.href='/admin/reportList.tripkase'">관광지 등록</a>
			</li>
			<li>
				<a class="function" href="#" onclick="location.href='/restaurant/restaurantInsertPage.tripkase'">맛집 등록</a>
			</li>
			<li>
				<a class="function" href="#" onclick="location.href='/room/registerRoom.tripkase'">숙소 등록</a>
			</li>
			<li>
				<a class="function" href="#" onclick="location.href='/admin/reportList.tripkase'">컨텐츠 수정/삭제</a><br><br>
			</li>
		</ul>
		<br><br><br><br><br><br><br><br><br><br><br><br>
	</div>
</body>
</html>