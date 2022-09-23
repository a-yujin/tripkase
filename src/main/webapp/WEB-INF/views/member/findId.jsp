<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세 : 아이디 찾기</title>
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
	<h2 align="center">아이디 찾기</h2>
	<form action="/member/findId.tripkase" method="POST">
	<div align="center">	
		<div class="find">
			<b>이름</b>
			<input type="text" name="memberName" placeholder="이름을 입력해주세요."> <br>
			
			<b>이메일 주소</b>
			<input type="text" name="memberEmail" placeholder="이메일을 입력해주세요."><br>
			<input type="submit" value="아이디 찾기">
		</div>	
	</div>
	</form>
</body>
</html>














