<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1 align="center">비밀번호 찾기</h1>
		<form action="/member/findPwd.tripkase" method="POST">
			<div align="center">
				<b>아이디</b>
				<input type="text" name="memberId" placeholder="아이디를 입력해주세요."> <br>
				
				<b>이메일 주소</b>
				<input type="text" name="memberEmail" placeholder="이메일을 입력해주세요."><br>
				<button type="submit">비밀번호 찾기</button>
			</div>	
		</form>
	</div>	
</body>
</html>