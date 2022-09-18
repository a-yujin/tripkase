<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세 : 아이디 찾기</title>
</head>
<body>
		<div align="center">
			<h1 align="center">아이디 찾기</h1>
			<form action="/member/findId.tripkase" method="post">
			<b>이름</b>
			<input type="text" name="memberName" placeholder="이름을 입력해주세요."> <br>
			
			<b>이메일 주소</b>
			<input type="text" name="memberEmail" placeholder="이메일을 입력해주세요."><br>
			<input type="submit" value="확인">
			</form>
		</div>	

</body>
</html>