<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세 : 회원 조회</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="/resources/js/jquery-3.6.1.min.js"></script>
<style>
	.memberTable{
		float:left;
		padding-left:100px;
		width:700px;
	}
	td{
		text-align:center;
	}
</style>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<jsp:include page="../admin/menuBar.jsp"></jsp:include>
	<div class="memberTable">
		<h2 align="center">회원 조회</h2>	
		<c:if test="${mList ne null }">
					<table class="table table-hover" align="center" border="1">
						<tr>
							<th>아이디</th>
							<th>닉네임</th>
							<th>이름</th>
							<th>번호</th>
							<th>이메일주소</th>
							<th>상세조회</th>
						</tr>
						<c:forEach items="${mList }" var="member">
						<tr>
							<td>${ member.memberId}</td>
							<td>${ member.memberNick}</td>
							<td>${ member.memberName}</td>
							<td>${ member.memberPhone}</td>
							<td>${ member.memberEmail}</td>
							<td><button class="btn btn-default" onclick="location.href='/admin/memberDetail.tripkase?memberId=${member.memberId}&memberName=${member.memberName}'">상세조회</button></td>		
						</tr>
						</c:forEach> 
						<tr>
							<td height="30" colspan="6" align="center">
								<ul class="pagination">
									<li>
										<c:if test="${currentPage ne 1 }">
											<a href="/admin/memberAll.tripkase?page=${currentPage - 1}">이전</a>
										</c:if>
									</li>
									<li>
										<c:forEach var="page" begin="${startNavi }" end="${endNavi }">
											<a href="/admin/memberAll.tripkase?page=${page }">${page }</a>
										</c:forEach>
									</li>
									<li>
										<c:if test="${currentPage ne maxPage}">
											<a href="/admin/memberAll.tripkase?page=${currentPage + 1 }">다음</a>
										</c:if>
									</li>
							    </ul>
							</td>
						</tr>
				</table>
		</c:if>
		
		<c:if test="${member ne null }">
				<table class="table table-hover" align="center" border="1">
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
						<td><button class="btn btn-default" onclick="location.href='/admin/memberDetail.tripkase?memberId=${member.memberId}&memberName=${member.memberName}'">상세조회</button></td>			
					</tr>
				</table>
		</c:if>
	</div>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</body>
</html>