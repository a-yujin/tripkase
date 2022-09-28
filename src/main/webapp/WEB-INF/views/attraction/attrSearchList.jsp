<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세: 관광지 검색 결과</title>
<link href="/resources/css/attraction.css" rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100&display=swap" rel="stylesheet">
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	<br><br><br>
	<table align="center" width="700px" height="200px" border="1">
		<c:if test="${!empty attrList}">
			<c:forEach items="${attrList}" var="attrList" varStatus="i">
				<tr>
					<td rowspan="4"><img src="/resources/attrUploadFiles/${attrList.attrFileRename}" width="150" height="150"></td>
				</tr>
				<tr>
					<td>${attrList.attrName}</td>
				</tr>
				<tr>
					<td>${attrList.attrAddress}</td>
				</tr>
				<tr>
					<td>${attrList.attrShortInfo}</td>
				</tr>
				<tr>
					<td colspan="2"></td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${empty attrList}">
			<tr>
				<td>검색 결과가 없습니다.</td>
			</tr>
		</c:if>
		<!-- 페이징 처리 전 -->
	</table>
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>