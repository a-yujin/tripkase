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
			width:50%;
		}
		#mypage{
			border:1px solid;
			width:50%;
			text-align:left	
		}
	</style>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
<body>
	<jsp:include page="../common/header.jsp"/>
	<h1 align="center">마이페이지</h1>
	<div align="center" class="">
		<div id="memberDiv">
		닉네임
		<input id= "memberinfo1" class="form-control" type="text" placeholder="${mOne.memberNick }" aria-label="Disabled input example" disabled>
		<br>
		회원 등급 
		<input id= "memberinfo2" class="form-control" type="text" placeholder="${mOne.memberGrade }" aria-label="Disabled input example" disabled>
		</div><br><br>
		
		<div id="mypage" onclick="location.href='/storage/storageView.tripkase';">
			<b>보관함</b><br>
			내가 보관한 관광지, 맛집, 숙소를 조회하세요!
		</div><br><br>
		
		<div id="mypage" onclick="location.href='/schedule/scheduleView.tripkase';">
			<b>여행일정관리</b><br>
			일정을 등록하고 여행일정을 채워보세요!
		</div><br><br>
		
		<div id="mypage" onclick="location.href='/member/myinfo.tripkase';">
			<b>내정보관리</b><br>
			내 정보를 조회하고 필요하다면 수정하세요!
		</div><br><br>

		
		<div id="mypage" onclick="location.href='/qna/qnaMainView.tripkase'">
			<b>Q&A</b><br>
			질문을 작성하고 답변을 받으세요!
		</div>
	</div>
</body>
	<br><br><br><br><br><br><br><br><br><br><br><br><br>
<jsp:include page="../common/footer.jsp"/>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
</html>