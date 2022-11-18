<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" />
<title>여행카세 : Q&A</title>
	<style>
	#myQnA{
		width: 1000px;
		margin: auto;
	}
	#qnaTalbe{
		width: 100%;
		text-align: center;
	}
	.h1{
		padding-left: 100px;
	}
	
	</style>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	
	<br>
	<div id="myQnA">
		<h2 align="center">나의 문의 조회</h2><br>
		
		<table id="qnaTalbe" class="table table-hover" align="center" border="1">
						<tr>
							<td>No</td>
							<td width="80px">유형</td>
							<td width="500px">제목</td>
							<td width="110px">등록일</td>
							<td>상세조회</td>
							<td width="80px">답변여부</td>
						</tr>
						<c:forEach items="${qList }" var="qna" varStatus="i">
						<tr>
							<td>${ i.count}</td>
							<td>${ qna.questionType}</td>
							<td>${ qna.questionTitle}</td>
							<td>${ qna.qCreateDate}</td>
							<td><button class="btn btn-dark" type="button" onclick="location.href='/qna/qnaDetail.tripkase?qnaNo=${qna.questionNo}'">상세조회</button></td>		
							<c:if test="${qna.aContents eq null}">
								<td>대기</td>
							</c:if>
							<c:if test="${qna.aContents ne null}">
								<td>완료</td>
							</c:if>
						</tr>
						</c:forEach> 
						<tr>
							<td colspan="5" align="center">
								<ul class="pagination">
									<li>
										<c:if test="${currentPage ne 1 }">
											<button class="btn btn-dark" onclick="location.href='/qna/qnaMainView.tripkase?page=${currentPage - 1}'">이전</button>
										</c:if>
									</li>
									<li>
										<c:forEach var="page" begin="${startNavi }" end="${endNavi }">
											<button class="btn btn-dark" onclick="location.href='/qna/qnaMainView.tripkase?page=${page}'">${page }</button>
										</c:forEach>
									</li>
									<li>
										<c:if test="${currentPage ne maxPage}">
											<button class="btn btn-dark" onclick="location.href='/qna/qnaMainView.tripkase?page=${currentPage + 1}'">다음</button>
										</c:if>
									</li>
								</ul>
							</td>
							<td>
								<br>
								<button class="btn btn-dark" onclick="location.href='/qna/qnaWriterForm.tripkase'">질문 등록</button>
							</td>
						</tr>
				</table>
	</div>
	<br>
<jsp:include page="../common/footer.jsp"/>
</body>
</html>