<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세: 공지사항</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	<br><br><br><br><br>
	<!-- 공지 번호, 타입, 첨부파일 필요 -->
	<table align="center" border="1">
		<tr>
			<th>제목</th>
			<th>작성일</th>
			<th>작성자</th>
		</tr>
		<!-- 공지 목록에 데이터가 있을 때 -->
		<c:if test="${!empty nList}">
			<c:forEach items="${nList}" var="notice" varStatus="i">
				<tr height="20">
					<td><a href="#">${notice.noticeTitle}</a></td>
					<td>${notice.nCreateDate}</td>
					<td>${notice.noticeWriter}</td>
				</tr>
			</c:forEach>
			<!-- 페이징 처리 -->
			<tr align="center" height="20">
				<td colspan="3">
					<!-- 현재 페이지가 첫번째 페이지가 아니면 이전 페이지로 이동 버튼 생성 -->
					<c:if test="${currentPage != 1}">
						<a href="/notice/${urlVal}.kh?page=${currentPage - 1}">[이전]</a>
					</c:if>
					<c:forEach var="p" begin="${startNavi}" end="${endNavi}">
						<!-- 페이지 번호가 현재 페이지와 같으면 볼드체로 표시 -->
						<c:if test="${currentPage eq p}">
							<b>${p}</b>
						</c:if>
						<!-- 페이지 번호가 현재 페이지와 다르면 해당 페이지로 이동 링크 처리 -->
						<c:if test="${currentPage ne p}">
							<a href="/notice/${urlVal}.kh?page=${p}">${p}</a>
						</c:if>
					</c:forEach>
					<!-- 마지막 페이지 번호가 현재 페이지보다 크면 다음 페이지로 버튼 생성 -->
					<c:if test="${maxPage >= currentPage}">
						<a href="/notice/${urlVal}.kh?page=${currentPage + 1}">[다음]</a>
					</c:if>
				</td>
			</tr>
		</c:if>
		<!--  공지 목록에 데이터가 없을 때 -->
		<c:if test="${empty nList}">
			<tr>
				<td colspan="3" align="center"><b>데이터가 존재하지 않습니다.</b></td>
			</tr>
		</c:if>
	</table>
</body>
</html>