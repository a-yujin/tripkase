<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세 : 전체 공지 조회</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" />
<style>
	.noticeTable{
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
<div class="contents" style="width: 1200px; margin: auto;">
	<jsp:include page="../admin/menuBar.jsp"></jsp:include>
	<div class="noticeTable">
	<h2 align="center">전체 공지 조회</h2><br>
	<table class="table table-hover" align="center" border="1">
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
						<td><button class="btn btn-dark" type="button" onclick="location.href='/admin/noticeDetail.tripkase?noticeNo=${notice.noticeNo}'">상세조회</button></td>		
					</tr>
					</c:forEach> 
					<tr>
						<td colspan="3" align="center">
							<ul class="pagination">
								<li>
									<c:if test="${currentPage ne 1 }">
										<button class="btn btn-dark" onclick="location.href='/admin/noticeList.tripkase?page=${currentPage - 1}'">이전</button>
									</c:if>
								</li>
								<li>
									<c:forEach var="page" begin="${startNavi }" end="${endNavi }">
										<button class="btn btn-dark" onclick="location.href='/admin/noticeList.tripkase?page=${page}'">${page }</button>
									</c:forEach>
								</li>
								<li>
									<c:if test="${currentPage ne maxPage}">
										<button class="btn btn-dark" onclick="location.href='/admin/noticeList.tripkase?page=${currentPage + 1}'">다음</button>
									</c:if>
								</li>
							</ul>	
						</td>
						<td>
							<br>
							<button class="btn btn-dark" type="button" onclick="location.href='/admin/noticeWriteForm.tripkase'">공지등록</button>
						</td>
					</tr>
			</table>
	</div>
</div>
		<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<jsp:include page="../common/footer.jsp"/>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</body>
</html>