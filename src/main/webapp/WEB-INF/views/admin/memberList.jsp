<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/resources/js/jquery-3.6.1.min.js"></script>
</head>
<body>
	<h2 align="center">회원 조회</h2>	
	<c:if test="${mList ne null }">
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
					<tr>
						<td>${ member.memberId}</td>
						<td>${ member.memberNick}</td>
						<td>${ member.memberName}</td>
						<td>${ member.memberPhone}</td>
						<td>${ member.memberEmail}</td>
						<td><button onclick="location.href='/admin/memberDetail.tripkase?memberId=${member.memberId}&memberName=${member.memberName}'">상세조회</button></td>		
					</tr>
					</c:forEach> 
					<tr>
						<td colspan="6" align="center">
							<c:if test="${currentPage ne 1 }">
								<a href="/admin/memberAll.tripkase?page=${currentPage - 1}">이전</a>
							</c:if>
							<c:forEach var="page" begin="${startNavi }" end="${endNavi }">
							<a href="/admin/memberAll.tripkase?page=${page }">${page }</a>
							</c:forEach>
							<c:if test="${currentPage ne maxPage}">
							<a href="/admin/memberAll.tripkase?page=${currentPage + 1 }">다음</a>
							</c:if>
						</td>
					</tr>
			</table>
	</c:if>
	
	<c:if test="${member ne null }">
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
					<td><button onclick="location.href='/admin/memberDetail.tripkase?memberId=${member.memberId}&memberName=${member.memberName}'">상세조회</button></td>			
				</tr>
			</table>
	</c:if>
</body>
</html>