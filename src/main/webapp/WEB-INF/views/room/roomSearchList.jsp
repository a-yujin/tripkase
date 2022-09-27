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
			<div id="roomlist-outside">
				<p>${roomJoin.roomName }</p>
				<p>${roomJoin.roomAddress } ${roomJoin.roomName }</p>
				<p>1일 숙박 ${roomJoin.roomPrice }</p>
				<hr>
			</div>
		</c:forEach>
	</div>
</body>
</html>