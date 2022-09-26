<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세 : 숙소 정보 (관리자)</title>
<link href="../resources/css/room.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	<jsp:include page="../admin/menuBar.jsp"></jsp:include>
	<br><br>
	<div id="rdata-list">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>순번</th>
					<th>숙소 이름</th>
					<th>숙소 종류</th>
					<th>숙소 지역</th>
				</tr>
			</thead>
				<c:forEach items="${rList }" var="room" varStatus="i">
				<tbody onclick="location.href='/room/roomDataDetailView.tripkase?roomNo=${room.roomNo}&page=${page }'" id="roombody">
					<tr>
						<th>${i.count }</th>
						<td>${room.roomName }</td>
						<td>${room.roomType }</td>
						<td>${room.roomArea }</td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
	</div>
	<div id="rdata-page">
		<c:if test="${currentPage != 1 }">
			<a id="pageback" href="/room/${urlValue }.tripkase?page=${currentPage -1}">이전</a>
		</c:if>
		<c:forEach var="p" begin="${startNavi }" end="${endNavi }">
			<c:if test="${currentPage eq p }">
				<b id="pagecurrent">${p }</b>
			</c:if>
			<c:if test="${currentPage ne p }">
				<a id="pageother" href="/room/${urlValue }.tripkase?page=${p}">${p }</a>
			</c:if>
		</c:forEach>
		<c:if test="${maxPage > currentPage }">
			<a id="pagenext" href="/room/${urlValue }.tripkase?page=${currentPage +1}">다음</a>
		</c:if>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
</body>
</html>