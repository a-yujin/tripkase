<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세: 공지 상세</title>
<link href="/resources/css/notice.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	<br><br><br><br><br>
	<table id="nDetailTable" align="center">
		<tr>
			<td id="nDetailContents1" colspan="2">${notice.noticeTitle}</td>
		</tr>
		<tr id="nDetailContents2">
			<td id="nDetailWriter">${notice.noticeWriter}</td>
			<td>${notice.nCreateDate}</td>
		</tr>
		<tr>
			<td id="bottomLine2" colspan="2"></td>
		</tr>
		<tr height="100">
			<td colspan="2">${notice.nContents}</td>
		</tr>
		<tr>
			<td colspan="2">
				<img id="nDetailPic" src="/resources/nUploadFiles/${notice.nFileRename}" onerror="this.style.display='none'" alt="첨부파일">
			</td>
		</tr>
	</table>
	<br><br><br><br><br>
</body>
</html>