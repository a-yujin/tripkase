<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 상세 조회</title>
</head>
<body>
	<h2>공지 상세 조회</h2><br>
	제목 <input type="text" name="noticeTitle" value="${notice.noticeTitle }"/><br>
	내용 <textarea name="noticeTitle">${notice.noticeTitle }</textarea><br>
	등록(수정)일 <input type="text" name="nUpdateDate" value="${notice.nUpdateDate }"/><br>
	
</body>
</html>