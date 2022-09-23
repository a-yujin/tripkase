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
		<!-- 공지 제목, 작성자, 작성일 보이는 상단 -->
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
		<!-- 공지 내용, 사진 보이는 하단 -->
		<tr height="100">
			<td colspan="2">${notice.nContents}</td>
		</tr>
		<tr>
			<td colspan="2" id="nDetailImg">
				<c:forEach items="${nImgList}" var="nImg" varStatus="i">
					<img id="nDetailPic" src="/resources/nUploadFiles/${nImg.nFileRename}" onerror="this.style.display='none'" alt="첨부파일">
				</c:forEach>
			</td>
		</tr>
	</table>
	<!-- 공지 댓글 등록 -->
	<form action="" method="">
		<input type="hidden" name="page" value="${page}">
		<input type="hidden" name="refBoardNo" value="${notice.noticeNo}">
		<table id="nReplyRegister" align="center">
			<tr>
				<td id="nReplyRegiTd1">
					<input id="nReplyRegiText" type="text" name="nReplyContents">
				</td>
			</tr>
			<tr>
				<td id="nReplyRegiTd2">
					<input id="nReplyRegiBtn" type="submit" value="등록">
				</td>
			</tr>
		</table>
	</form>
	<br><br><br><br><br>
</body>
</html>