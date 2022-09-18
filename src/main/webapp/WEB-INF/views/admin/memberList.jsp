<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2 align="center">회원 조회</h2>
	<c:if test="${mList ne null }">
		<form action="/admin/memberDetail.tripkase">
				<table align="center" border="1">
					<tr>
						<td>아이디</td>
						<td>닉네임</td>
						<td>이름</td>
						<td>번호</td>
						<td>이메일주소</td>
						<td>상세조회</td>
					</tr>
					<c:forEach items="${mList }" var="member">
					<input type="hidden" name="memberId" value="${ member.memberId}" />
					<input type="hidden" name="memberName" value="${ member.memberName}" />
					<tr>
						<td>${ member.memberId}</td>
						<td>${ member.memberNick}</td>
						<td>${ member.memberName}</td>
						<td>${ member.memberPhone}</td>
						<td>${ member.memberEmail}</td>
						<td><button>수정/삭제</button></td>
					</tr>
					</c:forEach> 
			</table>
		</form>
	</c:if>

	<c:if test="${member ne null }">
		<form action="/admin/memberDetail.tripkase">
			<input type="hidden" name="memberId" value="${memberId }"/>
			<input type="hidden" name="memberName" value="${memberName }"/>
			<table align="center" border="1">
				<tr>
					<td>아이디</td>
					<td>닉네임</td>
					<td>이름</td>
					<td>번호</td>
					<td>이메일주소</td>
					<td>상세조회</td>
				</tr>
				<tr>
					<td>${member.memberId}</td>
					<td>${member.memberNick}</td>
					<td>${member.memberName}</td>
					<td>${member.memberPhone}</td>
					<td>${member.memberEmail}</td>
					<td><button>수정/삭제</button></td>
				</tr>
			</table>
		</form>
	</c:if>
</body>
</html>