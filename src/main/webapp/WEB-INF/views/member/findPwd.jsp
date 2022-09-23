<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.find {
  margin-top: 20px;
  width: 80%;
}

.find input {
  width: 30%;
  height: 50px;
  border-radius: 30px;
  margin-top: 10px;
  padding: 0px 20px;
  border: 1px solid lightgray;
  outline: none;
}
</style>
</head>
<body>
		<h2 align="center">비밀번호 찾기</h2>
		<form action="/member/findPwd.tripkase" method="POST">
		<div align="center">
			<div class="find">
				<b>아이디</b>
				<input type="text" name="memberId" placeholder="아이디를 입력해주세요."> <br>
				
				<b>이메일 주소</b>
				<input type="text" name="memberEmail" placeholder="이메일을 입력해주세요."><br>
				<input type="submit" value="비밀번호 찾기">
			</div>	
		</div>	
		</form>
</body>
</html>