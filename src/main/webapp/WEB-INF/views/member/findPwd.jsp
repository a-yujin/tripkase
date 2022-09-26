<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
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

span{
	display : inline-block;
	 width: 100px;
}
</style>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<br><br>
	<h2 align="center">비밀번호 찾기</h2>
	<form action="/member/findPwd.tripkase" method="POST">
	<div align="center">
		<div class="find">
			<label for="id"><span><b>아이디</b></span></label>
			<input type="text" id="id" name="memberId" placeholder="아이디를 입력해주세요."> <br>
			
			<label for="email"><span><b>이메일 주소</b></span></label>
			<input type="text" id="email" name="memberEmail" placeholder="이메일을 입력해주세요."><br><br>
			<button type="submit" class="btn btn-outline-primary">비밀번호 찾기</button>
		</div>	
	</div>	
	</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="js/bootstrap.min.js"></script>	
</body>
</html>