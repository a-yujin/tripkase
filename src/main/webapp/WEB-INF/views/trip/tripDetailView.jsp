<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세 : 여행소통 게시글 보기</title>
</head>
<body>
	<h1 align="center">${trip.tripNo }번째 게시글 </h1>
	<table align="center" width="500" border="1">	
		<tr>
			<td>제목</td>
			<td>${trip.tripTitle }</td>
		</tr>
		<tr>
			<td>작성날짜</td>
			<td>${trip.tripCreate }</td>
		</tr>
		<tr height="300">
			<td>내용</td>
			<td>${trip.tripContents }</td>
		</tr>
		<tr>
			<td>첨부파일</td>
			<td>
				<img alt="본문이미지"
				src="/resources/tuploadFiles/${trip.tripFileRename }"
				width="300" height="300">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<a href="#">수정 페이지로 이동</a>
				<a href="#">삭제하기</a>
			</td>
		</tr>		
	</table>
</body>
</html>