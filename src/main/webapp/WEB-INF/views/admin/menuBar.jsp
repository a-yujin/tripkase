<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세 : 관리자 페이지</title>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100&display=swap" rel="stylesheet">
	<style>
		body{
			font-family: 'Noto Sans KR', sans-serif;
		}
		ul{
			padding:0;
			list-style : none;
		}
		a{
			text-decoration : none;
			font-size: 16px;
		}
		#side{
			float : left;
			width : 150px;
			border-right : 1px solid lightgray;
			padding-left : 20px;
			font-size: 20px;
		}
		#mainPage{
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
			text-align:left;
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
				<a class="function" href="#" onclick="location.href='/course/courseAll.tripkase'">코스 조회</a>
			</li>
			<li>
				<a class="function" href="#" onclick="location.href='/attraction/write.tripkase'">관광지 등록</a>
			</li>
			<li>
				<a class="function" href="#" onclick="location.href='/attraction/list.tripkase'">관광지 조회</a>
			</li>
			<li>
				<a class="function" href="#" onclick="location.href='/restaurant/restaurantInsertPage.tripkase'">맛집 등록</a>
			</li>
			<li>
				<a class="function" href="#" onclick="location.href='/restaurant/resAdminSearchPage.tripkase'">맛집 조회</a>
			</li>
			<li>
				<a class="function" href="#" onclick="location.href='/room/registerRoom.tripkase'">숙소 등록</a>
			</li>
			<li>
				<a class="function" href="#" onclick="location.href='/room/roomDataList.tripkase'">숙소 조회</a>
			</li>
		</ul>
		<br><br><br><br><br>
	</div>
</body>
</html>