<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지등록</title>
</head>
<body>
	<h2>공지 등록</h2>
	<form action="/admin/registerNotice.tripkase" method="post">
		제목 <input type="text" name="noticeTitle"/><br>
		내용 <textarea name="noticeContents"></textarea><br>
		첨부파일 <input type="file" name="uploadFile"/><br>
		<button>등록</button>
	</form>
	
</body>
</html>