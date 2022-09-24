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
		#days{
			padding:20px;
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
		<div id="schdule">
			<span>
				<c:if test="${scheduleManage.contetnsType eq '관광지'}">
					관광지<br>
				</c:if>
				<c:if test="${scheduleManage.contetnsType eq '맛집'}">
					맛집<br>
				</c:if>
				<c:if test="${scheduleManage.contetnsType eq '숙소'}">
					숙소<br>
				</c:if>
				<img src=""/>
				${scheduleManage.restaurnat.resName}
				<%-- ${scheduleManage.restaurant.resName} --%>
				
			</span>	
		</div>
	</c:forEach>
</body>
</html>