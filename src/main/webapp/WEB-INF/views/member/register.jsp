<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h1 align="center">회원가입</h1>
	<div align="center">
		<form action="/member/register.tripdkase" method="post">
		<table>
			<tr>
				<td> * 아이디</td>
				<td>
					<input type="text" id="memberId" name="memberId">
				</td>
			</tr>
			<tr>
				<td> * 비밀번호</td>
				<td>
					<input type="password" name="memberPwd">
				</td>
			</tr>
			<tr>
				<td> * 닉네임</td>
				<td>
					<input type="text" name="memberNick">
				</td>
			</tr>
			<tr>
				<td> * 이름</td>
				<td>
					<input type="text" name="memberName">
				</td>
			</tr>	
			<tr>
				<td> * 생년월일 </td>
				<td>
					<input type="text" name="memberBd">
				</td>
			</tr>	
			<tr>
				<td> * 성별 </td>
				<td>
					<input type="text" name="memberGender">
				</td>
			</tr>	
			<tr>
				<td> * 핸드폰번호 </td>
				<td>
					<input type="text" name="memberPhone">
				</td>
			</tr>	
			<tr>
				<td> * 이메일 </td>
				<td>
					<input type="text" name="memberEmail">
				</td>
			</tr>	
			</tr>
					<td align="center" colspan="30">
					<input type="submit" value="join !">
					</td>
				</tr>
				
			</table>
		</form>
	</div>
</body>
</html>