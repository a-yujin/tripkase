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
	<h2 align="center">전체 공지 조회</h2><br>
	<table align="center" border="1">
					<tr>
						<td>No</td>
						<td>제목</td>
						<td>등록일</td>
						<td>상세조회</td>
					</tr>
					<c:forEach items="${nList }" var="notice" varStatus="i">
					<tr>
						<td>${ i.count}</td>
						<td>${ notice.noticeTitle}</td>
						<td>${ notice.nUpdateDate}</td>
						<td><button type="button" onclick="location.href='/admin/noticeDetail.tripkase?noticeNo=${notice.noticeNo}'">상세조회</button></td>		
					</tr>
					</c:forEach> 
					<tr>
						<td colspan="3" align="center">
							<c:if test="${currentPage ne 1 }">
								<a href="/admin/reportList.tripkase?page=${currentPage - 1}">이전</a>
							</c:if>
							<c:forEach var="page" begin="${startNavi }" end="${endNavi }">
							<a href="/admin/reportList.tripkase?page=${page }">${page }</a>
							</c:forEach>
							<c:if test="${currentPage ne maxPage}">
							<a href="/admin/reportList.tripkase?page=${currentPage + 1 }">다음</a>
							</c:if>
						</td>
						<td>
							<button type="button" onclick="location.href='/admin/noticeWriteForm.tripkase'">공지등록</button>
						</td>
					</tr>
			</table>
</body>
</html>