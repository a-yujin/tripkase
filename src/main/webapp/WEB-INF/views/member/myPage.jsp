<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이 페이지</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
<body>
	<jsp:include page="../common/header.jsp"/>
	<h1 align="center">마이페이지</h1>
	<div align="center" class="">
		<div>
		닉네임 :
		<input id= "memberinfo1" class="form-control" type="text" placeholder="${mOne.memberNick }" aria-label="Disabled input example" disabled>
		<br>
		회원 등급 : 
		<input id= "memberinfo2" class="form-control" type="text" placeholder="${mOne.memberGrade }" aria-label="Disabled input example" disabled>
		</div><br><br>
		
		<div onclick="location.href='/member/storageMain.tripkase';">
			보관함
		</div><br><br>
		
		<div onclick="location.href='#';">
			여행일정관리
		</div><br><br>
		
		<div onclick="location.href='/member/myinfo.tripkase';">
			내정보관리
		</div><br><br>
		
		<div onclick="location.href='#';">
			Q&A
		</div>
	</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
</html>