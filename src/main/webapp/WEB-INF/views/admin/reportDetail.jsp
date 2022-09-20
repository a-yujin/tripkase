<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신고 상세 조회</title>
</head>
<body>
	<h2>신고 상세 조회</h2><br>
	분류 : <input type="text" name="reportType" value="${report.reportType }" readonly/><br>
	신고 제목 : <input type="text" name="reportTitle" value="${report.reportTitle }" readonly/><br>
	신고 내용 : <textarea name="reportContents">${report.reportContents }"</textarea><br>
	신고자 : <input type="text" name="memberId" value="${report.memberId }" readonly/><br><br>
	
	<c:if test="${trip ne null }">
	게시글 내용  : <textarea name="contetns" >${trip.tripContents }</textarea><br>
	<button type="button" onclick="location.href='/admin/deleteContents.tripkase?reportNo=${report.reportNo }&tripNo=${trip.tripNo}'">게시글 삭제</button>
	</c:if>
	<c:if test="${tripReply ne null }">
	여행 게시글 댓글 내용  : <input type="text" name="contetns" value="${tripReply.tripReplyContents }" readonly/><br>
	<button type="button" onclick="location.href='/admin/deleteContents.tripkase?reportNo=${report.reportNo }&tReplyNo=${tripReply.replyNo}'">댓글 삭제</button>
	</c:if>
	<c:if test="${noticeReply ne null }">
	문의 게시글 댓글 내용  : <input type="text" name="contetns" value="${noticeReply.noticeReplyContents }" readonly/><br>
	<button type="button" onclick="location.href='/admin/deleteContents.tripkase?reportNo=${report.reportNo }&nReplyNo=${noticeReply.repyNo}'">댓글 삭제</button>
	</c:if>
	<c:if test="${grade ne null }">
	평점 내용  : <input type="text" name="contetns" value="${grade.gradeContents }" readonly/><br>
	<button type="button" onclick="location.href='/admin/deleteContents.tripkase?reportNo=${report.reportNo }&gradeNo=${grade.gradeNo}'">평점 삭제</button>
	</c:if>
	
	
	
</body>
</html>