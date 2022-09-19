<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
	<title>여행카세 홈페이지</title>
</head>
<body>
<h1>
	여행카세 홈페이지!  
</h1>
			<c:if test="${sessionScope.loginMember eq null }">
		<form action="/member/login.tripkase" method="post">
			<table align="right">
				<tr>
					<td>아이디 : </td>
					<td><input type="text" name="memberId"></td>
					<td rowspan="2">
					<input type="submit" value="로그인">
					</td>
				</tr>
				<tr>
					<td>비밀번호 : </td>
					<td><input type="password" name="memberPwd"></td>
					<td></td>
				</tr>
				<tr>
					<td ><a href="/member/registerView.tripkase">회원가입</a></td>
					<td ><a href="/member/findIdView.tripkase">아이디 찾기</a></td>
					<td ><a href="/member/findPwdView.tripkase">비밀번호 찾기</a></td>
				</tr>
			</table>
		</form>
		</c:if>
		<c:if test="${sessionScope.loginMember ne null }"> <!-- ne : not equal -->
			<table align="right">
			<tr>
				<td colspan="2">${sessionScope.loginMember.memberName }님 환영합니다!</td>
				<td></td>
			</tr>
			<tr>
				<td><a href="/member/mypage.tripkase">마이페이지</a></td>
				<td><a href="/member/logout.tripkase">로그아웃</a></td>
			</tr>
			</table>
		</c:if>
</body>
</html>
