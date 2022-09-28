<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세 : 숙소 검색 리스트</title>
<link href="../resources/css/room.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	<div id="roomlist">
		<c:forEach items="${rjList }" var="roomJoin">
			<div id="roomlist-outside" onclick="location.href='/room/roomDetailView.tripkase?roomNo=${roomJoin.roomNo}';">
				<div id="roomlist-left">
					<img src="/resources/ruploadFiles/${roomJoin.roomFileRename }" id="roomlist-img">			
				</div>
				<div id="roomlist-right">
					<p>${roomJoin.roomName }</p>
					<p>${roomJoin.roomAddress }</p>
				</div>
				<div id="roomlist-price">
					<p>1일 숙박 ${roomJoin.roomPrice }</p>				
				</div>
			</div>
			<hr id="roomlist-hr">
		</c:forEach>
	</div>
	<div id="rlist-page">
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
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>