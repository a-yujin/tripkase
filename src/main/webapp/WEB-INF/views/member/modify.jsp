<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<body>
	<h1 align="center">회원가입</h1>
	<div class="">
		<form  action="/member/modify.tripkase" method="GET">
		<table>
			<tr>
				<td> * 아이디</td>
				<td>
					<input type="text" id="memberId" name="memberId" value="${mOne.memberId }" readonly>
				</td>
			</tr>
			<c:if test="${sessionScope.loginMember.memberPwd eq loginMember.memberPwd }">
			<tr>
				<td> * 현재 비밀번호</td>
				<td>
					<input type="text" name="memberPwd" value="${mOne.memberPwd }" >
				</td>
			 </tr>
			<tr>
				<td> * 변경할 비밀번호</td>
				<td>
					<input type="text" name="memberPwd" value="${mOne.memberPwd }" >
				</td>
			</tr> 
			<tr>
				<td> * 닉네임</td> 
				<td>
					<input type="text" name="memberNick" value="${mOne.memberNick }" >
				</td>
			</tr>
			<tr>
				<td> * 이름</td>
				<td>
					<input type="text" name="memberName" value="${mOne.memberName }" >
				</td>
			</tr>
			<tr>
				<td> * 생년월일</td>
				<td>
					<input type="text" name="memberBd" value="${mOne.memberBd }" >
				</td>
			</tr>
			<tr>
				<td> * 성별</td>
				<td>
					<input type="text" name="memberGender" value="${mOne.memberGender }" >
				</td>
			</tr>
			<tr>
				<td> * 핸드폰번호</td>
				<td>
					<input type="text" name="memberPhone" value="${mOne.memberPhone }" >
				</td>
			</tr>
			<tr>
				<td> * 이메일</td>
				<td>
					<input type="text" name="memberEmail" value="${mOne.memberEmail }" >
				</td>
			</tr>
			<tr>
				<td> * 현재 나의 등급</td>
				<td>
					<input type="text" name="memberGrade" value="${mOne.memberGrade }" readonly>
				</td>
			</tr>
			</c:if>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="수정하기">
					<button type="button" onclick="removeMember();">탈퇴하기</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>









