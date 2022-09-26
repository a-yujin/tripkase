<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세 : 질문 등록</title>
	<style>
		body{
			padding:20px;
		}
	</style>
	
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	
	<h1>질문등록</h1>
	<hr>
	<h3>질문유형</h3>
	<form action="/qna/RegisterQna.tripkase" method="post">
		<input type="radio" name="questionType" value="course"/>코스 &nbsp;
		<input type="radio" name="questionType" value="attr"/>관광지 &nbsp;
		<input type="radio" name="questionType" value="res"/>맛집 &nbsp;
		<input type="radio" name="questionType" value="room"/>숙소 &nbsp;
		<input type="radio" name="questionType" value="other"/>기타
		<br><br>
		제목<br>
		<input size="50" type="text" name="questionTitle" placeholder="제목을 입력해주세요" required="required"/><br><br>
		내용<br>
		<textarea cols="52" rows="10" name="qContents" placeholder="내용을 입력해주세요" required="required"></textarea><br>
		<input type="file" name="uploadFile"/><br>
		<input type="submit" value="등록">
	</form>
	
</body>
</html>