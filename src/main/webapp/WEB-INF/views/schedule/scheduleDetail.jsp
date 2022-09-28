<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세 : 여행일정 관리</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100&display=swap" rel="stylesheet">

	<style>
		body{
			font-family: 'Noto Sans KR', sans-serif;
		}
		div{
			padding:20px;
		}
		#contentsIMg{
			border:1px solid;
		}
		#days{
			padding:20px;
		}
		#schedule{
			margin:30px;
			float:left;
			width:200px;
			height:200px;
			text-align:center;
		}
		#icon{
			margin-top:70px;
			float:left;
			width:3px;
			height:3px;
			text-align:center;
		}
		#addContents{
			margin-top:70px;
			margin-left:50px;
			
			border:1px solid;
			float:left;
			width:150px;
			height:150px;
			text-align:center;
		}
	</style>

</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	
	<div id="h1">
		<h1><b>여행일정 관리</b></h1>
	</div>
	<div id="h2">
		<h2>#${sList[0].scheduleName}</h2>
		<h2>${sList[0].scheduleStart} ~ ${sList[0].scheduleEnd}</h2>
	</div>
	<div id="days">
	<ul class="nav nav-tabs">
		<c:forEach items="${sList }" var="schedule">
			<li role="presentation" class="active"><a href="/schedule/scheduleDetail.tripkase?scheduleSeq=${schedule.scheduleSeq }&scheduleDays=${schedule.scheduleDays } ">${schedule.scheduleDays }</a></li>
		</c:forEach>
	</ul>
	</div>
	<c:forEach items="${smList }" var="scheduleManage">
		<div id="schedule">
			<c:if test="${scheduleManage.contetnsType eq 'attraction'}">
				<span class="glyphicon glyphicon-map-marker"></span>
			</c:if>
			<c:if test="${scheduleManage.contetnsType eq 'restaurant'}">
				<span class="glyphicon glyphicon-cutlery"></span>
			</c:if>
			<c:if test="${scheduleManage.contetnsType eq 'room'}">
				<span class="glyphicon glyphicon-bed"></span>
			</c:if>
			<img id="contentsIMg" onclick="" width="150" height="150" src="/resources/resUploadFiles/20220921134942.jpg" alt="컨텐츠 이미지"/><br>
			컨텐츠 이름
		</div>		
		<div id="icon">
				<br><br><br><span class="glyphicon glyphicon-menu-right"></span>
		</div>
	</c:forEach>
	<div id="addContents">
		<br><br><a href="/storage/storageView.tripkase">보관함으로</a>
	</div>
</body>
</html>