<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세 : 로그인</title>
</head>
<body>
	<form action="/member/login.tripkase" method="POST">
		<div align="center">
			<h1 align="center">로그인</h1>
			<b>아이디</b>
			<input type="text" name="memberId" placeholder="아이디를 입력해주세요."> <br>
			
			<b>비밀번호</b>
			<input type="password" name="memberPwd" placeholder="비밀번호를 입력해주세요."><br>
			<button type="submit">로그인</button>
			<button type="button" onclick="location.href='/member/registerView.tripkase'">회원가입</button >
			<button type="button" onclick="location.href='/member/registerView.tripkase'">아이디 찾기</button >
			<button type="button" onclick="location.href='/member/registerView.tripkase'">비밀번호 찾기</button >
		</div>	
	</form>
</body>
</html>














