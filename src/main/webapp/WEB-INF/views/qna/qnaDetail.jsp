<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세 : 문의 상세조회</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<style>
		.qnaDetail{
			margin:auto;
			width: 1000px;
			height: 500px;
		}
		.title{
			font-size: 40px;
		}
		.contents{
			width: 1000px;
			height: 200px;
		}
		.answer{
			width: 1000px;
			height:200px;
			
		}
		.delete{
			color: red;
		}
		
	</style>
</head>
<body>
<jsp:include page="../common/header.jsp"></jsp:include>
	<br><br><br>
	<div class="qnaDetail">
		<div class="title">
			<b>${qna. questionTitle}</b><br>
		</div>
		${qna.questionWriter } | ${qna.qCreateDate } | <c:if test="${qna.aContents eq null }">답변대기</c:if> <c:if test="${qna.aContents ne null }">답변완료</c:if> | 
		<a class="delete" href="/qna/deleteQna.tripkase?qnaNo=${qna.questionNo }" onclick="return confirm('문의글을 삭제하시겠습니까?')">문의삭제</a> 
		<hr>
		 <div class="contents">
		 	${qna.qContents }
		 </div>
		 <hr>
		 <div class="answer">
		 <c:if test="${qna.aContents eq null }">아직 등록된 답변이 없습니다. 기다려주셔서 감사합니다.</c:if>
		 <c:if test="${qna.aContents ne null }">
		 	${qna.answerWriter } | ${qna.aCreateDate }<br>
		 	${qna.aContents }
		 </c:if>
		 </div>
	</div>

<jsp:include page="../common/footer.jsp"/>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</body>
</html>