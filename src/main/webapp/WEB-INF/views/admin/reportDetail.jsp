<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세 : 신고 상세 조회</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<style>
	.reportTable{
		float:left;
		padding-left:100px;
	}
	textarea{
		border:0;
	}
</style>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<jsp:include page="../admin/menuBar.jsp"></jsp:include>
	
	<div class="reportTable">
		<h2 align="center">신고 상세 조회</h2><br>
		<table class="table table-hover" border="1">
			<tr>
				<th>분류</th>
				<td>${report.reportType }</td>
			</tr>
			<tr>
				<th>신고 제목</th>
				<td>${report.reportTitle }</td>
			</tr>
			<tr>
				<th>신고 내용</th>
				<td><textarea>${report.reportContents }</textarea></td>
			</tr>
			<tr>
				<th>신고자</th>
				<td>${report.memberId }</td>
			</tr>
			<c:if test="${trip ne null }">
				<tr>
					<th>게시글 내용</th>
					<td><textarea name="contetns" >${trip.tripContents }</textarea></td>
				</tr>
				<tr align="center">
					<td colspan="2"><button class="btn btn-default" type="button" onclick="location.href='/admin/deleteContents.tripkase?reportNo=${report.reportNo }&tripNo=${trip.tripNo}'">게시글 삭제</button></td>
				</tr>
			</c:if>
			<c:if test="${tripReply ne null }">
				<tr>
					<th>여행 게시글 댓글 내용 </th>
					<td><input type="text" name="contetns" value="${tripReply.tripReplyContents }" readonly/></td>
				</tr>
				<tr align="center">
					<td colspan="2"><button class="btn btn-default" type="button" onclick="location.href='/admin/deleteContents.tripkase?reportNo=${report.reportNo }&tReplyNo=${tripReply.replyNo}'">댓글 삭제</button></td>
				</tr>
			</c:if>
			<c:if test="${noticeReply ne null }">
				<tr>
					<th>문의 게시글 댓글 내용</th>
					<td><input type="text" name="contetns" value="${noticeReply.noticeReplyContents }" readonly/></td>
				</tr>
				<tr align="center">
					<td colspan="2"><button class="btn btn-default" type="button" onclick="location.href='/admin/deleteContents.tripkase?reportNo=${report.reportNo }&nReplyNo=${noticeReply.repyNo}'">댓글 삭제</button></td>
				</tr>
			</c:if>
			<c:if test="${grade ne null }">
				<tr>
					<th>평점 내용</th>
					<td><input type="text" name="contetns" value="${grade.gradeComment }" readonly/></td>
				</tr>
				<tr align="center">
					<td colspan="2"><button class="btn btn-default" type="button" onclick="location.href='/admin/deleteContents.tripkase?reportNo=${report.reportNo }&gradeNo=${grade.gradeNo}'">평점 삭제</button></td>
				</tr>
			</c:if>
		</table>
	</div>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</body>
</html>