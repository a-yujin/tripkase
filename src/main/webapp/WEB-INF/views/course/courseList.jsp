<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세 : 코스 조회</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="/resources/js/jquery-3.6.1.min.js"></script>
<style>
	.courseTable{
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
	<div class="courseTable">
		<h2 align="center">코스 조회</h2>	
		<c:if test="${cList ne null }">
					<table class="table table-hover" align="center" border="1">
						<tr>
							<th>코스번호</th>
							<th>코스이름</th>
							<th>코스테마</th>
							<th>코스거리</th>
							<th>코스지역</th>
							<th>코스상세보기</th>
						</tr>
						<c:forEach items="${cList }" var="course">
						<tr>
							<td>${ course.courseNo}</td>
							<td>${ course.courseName}</td>
							<td>${ course.courseThema}</td>
							<td>${ course.courseDistance}</td>
							<td>${ course.locationName}</td>
							<td><button onclick="location.href='/course/courseAdmin.tripkase?courseNo=${course.courseNo}';">상세조회</button></td>
						</tr>
						</c:forEach> 
						<tr>
							<td height="30" colspan="6" align="center">
								<ul class="pagination">
									<li>
										<c:if test="${currentPage ne 1 }">
											<a href="/course/courseAll.tripkase?page=${currentPage - 1}">이전</a>
										</c:if>
									</li>
									<li>
										<c:forEach var="page" begin="${startNavi }" end="${endNavi }">
											<a href="/course/courseAll.tripkase?page=${page }">${page }</a>
										</c:forEach>
									</li>
									<li>
										<c:if test="${currentPage ne maxPage}">
											<a href="/course/courseAll.tripkase?page=${currentPage + 1 }">다음</a>
										</c:if>
									</li>
							    </ul>
							</td>
						</tr>
				</table>
		</c:if>
	</div>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</body>
</html>