<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>개별 회원 조회</h2>
		<form action="/admin/memberOne.tripkase">
			아이디 <input type="text" name="memberId" placeholder="아이디를 입력해주세요"/>
			이름    <input type="text" name="memberName" placeholder="이름을 입력해주세요"/><br><br>
				 <input type="submit" value="검색">
		</form>
</body>
</html>