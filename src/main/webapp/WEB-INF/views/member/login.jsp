<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
 <link href="css/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>여행카세 : 로그인</title>
<style>
.login_id {
  margin-top: 20px;
  width: 80%;
}

.login_id input {
  width: 30%;
  height: 50px;
  border-radius: 30px;
  margin-top: 10px;
  padding: 0px 20px;
  border: 1px solid lightgray;
  outline: none;
}

.login_pw {
  margin-top: 20px;
  width: 80%;
}

.login_pw input {
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
	<div>
	<form action="/member/login.tripkase" method="POST">
			<h2 align="center">로그인</h2>
	<div align="center">
		<div class="login_id"   style="position:relative; left:70;">
			<b>아이디</b>
			 <input type="text" id="login" class="fadeIn second" name="memberId" placeholder="login"><br>
		</div>
		<div class="login_pw" style="position:relative; left:10;">
			<b>비밀번호</b>
			<input type="password" id="password" class="fadeIn third" name="memberPwd" placeholder="password"><br><br>
			
			<button type="submit" class="btn btn-outline-primary">로그인</button>
			<button type="button" class="btn btn-outline-primary" onclick="location.href='/member/registerView.tripkase'">회원가입</button>
			<button type="button" class="btn btn-outline-primary" onclick="location.href='/member/findIdView.tripkase'">아이디 찾기</button>
			<button type="button" class="btn btn-outline-primary" onclick="location.href='/member/findPwdView.tripkase'">비밀번호 찾기</button>
		</div>
	</div>	
	</form>
	</div>
	
	
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>














