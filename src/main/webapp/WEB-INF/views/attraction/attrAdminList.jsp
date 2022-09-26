<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세: 관광지 목록</title>
</head>
<body>
	<h1 align="center">관광지 목록</h1>
	<table align="center" border="1">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>지역</th>
			<th>상세</th>
		</tr>
		
		<c:if test="${!empty attrList}">
			<c:forEach items="${attrList}" var="attr" varStatus="i">
				<tr>
					<td>${attr.attrNo}</td>
					<td><a href="/attraction/modifyView.tripkase?attrNo=${attr.attrNo}&page=${currentPage}">${attr.attrName}</a></td>
					<td>${attr.attrLocation}</td>
					<td>
						<input type="button" value="수정">
						<input type="button" value="삭제">
					</td>
				</tr>
			</c:forEach>
			<tr align="center" height="20">
				<td colspan="4">
					<!-- 현재 페이지가 첫번째 페이지가 아니면 이전 페이지로 이동 버튼 생성 -->
					<c:if test="${currentPage != 1}">
						<a href="/attraction/${urlVal}.tripkase?page=${currentPage - 1}">이전</a>
					</c:if>
					<c:forEach var="p" begin="${startNavi}" end="${endNavi}">
						<!-- 페이지 번호가 현재 페이지와 같으면 볼드체로 표시 -->
						<c:if test="${currentPage eq p}">
							<b>${p}</b>
						</c:if>
						<!-- 페이지 번호가 현재 페이지와 다르면 해당 페이지로 이동 링크 처리 -->
						<c:if test="${currentPage ne p}">
							<a href="/attraction/${urlVal}.tripkase?page=${p}">${p}</a>
						</c:if>
					</c:forEach>
					<!-- 마지막 페이지 번호가 현재 페이지보다 크면 다음 페이지로 버튼 생성 -->
					<c:if test="${maxPage > currentPage}">
						<a href="/attraction/${urlVal}.tripkase?page=${currentPage + 1}">다음</a>
					</c:if>
				</td>
			</tr>
		</c:if>
		
		<c:if test="${empty attrList}">
			<tr>
				<td colspan="4" align="center"><b>데이터가 존재하지 않습니다.</b></td>
			</tr>
		</c:if>
	</table>
</body>
</html>