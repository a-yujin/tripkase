<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세 : 마이 페이지</title>
	<style>
		input{
			text-align:center
		}
		#memberDiv{
			text-align: left;
			width: 720px;
			height: 220px;
		}
		#subTitle{
			text-align: center;
		}
		#mystorage{
			background-color : #e1f5fe;
			border-radius: 10px;
			width: 720px;
			height: 220px;
			text-align:center;
		}
		#mystorage:hover{
			width: 720px;
			height: 220px;
			box-shadow : 5px 5px 5px;
		}
		#mySchedule{
			background-color : #e1f5fe;
			border-radius: 10px;
			width: 720px;
			height: 300px;
			text-align:center;
		}
		#mySchedule:hover{
			width: 720px;
			height: 300px;
			box-shadow : 5px 5px 5px;
		}
		#myinfo{
			background-color : #e1f5fe;
			border-radius: 10px;
			width: 720px;
			height: 300px;
			text-align:center;
		}
		#myinfo:hover{
			width: 720px;
			height: 300px;
			box-shadow : 5px 5px 5px;
		}
		#myQNA{
			background-color : #e1f5fe;
			border-radius: 10px;
			width: 720px;
			height: 300px;
			text-align:center;
		}
		#myQNA:hover{
			width: 720px;
			height: 300px;
			box-shadow : 5px 5px 5px;
		}
		#imgStobox{
			position: relative;
		}
		#imgSchbox{
			position: relative;
		}
		.storageImg{
			margin: 3%;
			display: inline-block;
			text-align:center;
		}
		.scheImg{
			margin: 3%;
			display: inline-block;
			height: 180px;
			text-align:center;
		}
		.myQNAImg{
			height: 200px;
			width: 400px;
			display: inline-block;
			text-align:center;
		}
		#memberinfo1{
			width: 300px;
		}
		#memberinfo2{
			width: 300px;
		}
	</style>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
<body>
	<jsp:include page="../common/header.jsp"/>
	<h1 align="center">마이페이지</h1>
	<br><br>
	<div align="center">
		<div id="memberDiv">
		닉네임
		<input id= "memberinfo1" class="form-control" type="text" placeholder="${mOne.memberNick }" aria-label="Disabled input example" disabled>
		<br><br>
		회원 등급 
		<input id= "memberinfo2" class="form-control" type="text" placeholder="${mOne.memberGrade }" aria-label="Disabled input example" disabled>
		</div><br><br>
		
		<div id="mystorage" onclick="location.href='/storage/storageView.tripkase';">
			<b class="subTitle"><br>보관함</b><br>
			내가 보관한 관광지, 맛집, 숙소를 조회하세요!<br>
			<div id="imgStobox">
				<img class="storageImg" src="/resources/images/mypage/resimg.jpg" width="100" height="100">
				<img class="storageImg" src="/resources/images/mypage/roomimg.png" width="100" height="100">
				<img class="storageImg" src="/resources/images/mypage/attrimg.png" width="100" height="100">
			</div>
		</div><br><br>
		
		<div id="mySchedule" onclick="location.href='/schedule/scheduleView.tripkase';">
			<b class="subTitle"><br>여행 일정 관리</b><br>
			일정을 등록하고 여행일정을 채워보세요!
			<div id="imgSchbox">
				<img class="scheImg" src="/resources/images/mypage/scheduleimg.jpg">
			</div>
		</div><br><br>
		
		<div id="myinfo" onclick="location.href='/member/myinfo.tripkase';">
			<b class="subTitle"><br>내 정보 관리</b><br>
			내 정보를 조회하고 필요하다면 수정하세요!
			<div id="imginfobox">
				<img class="scheImg" src="/resources/images/mypage/myinfo.jpg">
			</div>
		</div><br><br>

		
		<div id="myQNA" onclick="location.href='/qna/qnaMainView.tripkase'">
			<b class="subTitle"><br>Q&A</b><br>
			질문을 작성하고 답변을 받으세요!
			<div id="imgQnAbox">
				<img class="myQNAImg" src="/resources/images/mypage/QNA.jpg">
			</div>
		</div>
	</div>
</body>
	<br><br><br><br><br><br><br><br><br><br><br><br><br>
<jsp:include page="../common/footer.jsp"/>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
</html>