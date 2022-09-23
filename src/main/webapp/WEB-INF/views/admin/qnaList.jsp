<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세 : 전체 문의 조회</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<style>
	.qnaTable{
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
	<div class="qnaTable">
	<h2 align="center">전체 문의 조회</h2><br>
		<table class="table table-hover" align="center" border="1">
						<tr>
							<td>No</td>
							<td>유형</td>
							<td>제목</td>
							<td>등록일</td>
							<td>상세조회</td>
						</tr>
						<c:forEach items="${qList }" var="qna" varStatus="i">
						<tr>
							<td>${ i.count}</td>
							<td>${ qna.questionType}</td>
							<td>${ qna.questionTitle}</td>
							<td>${ qna.qCreateDate}</td>
							<td><button class="btn btn-default" type="button" onclick="location.href='/admin/qnaDetail.tripkase?qnaNo=${qna.questionNo}'">상세조회</button></td>		
						</tr>
						</c:forEach> 
						<tr>
							<td colspan="5" align="center">
								<ul class="pagination">
									<li>
										<c:if test="${currentPage ne 1 }">
											<a href="/admin/qnaList.tripkase?page=${currentPage - 1}">이전</a>
										</c:if>
									</li>
									<li>
										<c:forEach var="page" begin="${startNavi }" end="${endNavi }">
											<a href="/admin/qnaList.tripkase?page=${page }">${page }</a>
										</c:forEach>
									</li>
									<li>
										<c:if test="${currentPage ne maxPage}">
											<a href="/admin/qnaList.tripkase?page=${currentPage + 1 }">다음</a>
										</c:if>
									</li>
								</ul>
							</td>
						</tr>
				</table>
	</div>
			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</body>
</html>