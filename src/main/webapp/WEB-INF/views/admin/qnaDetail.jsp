<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세 : 문의 상세 조회</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" />
<style>
	.noticeTable{
		float:left;
		padding-left:100px;
		width:700px;
	}
	textarea{
		border:0;
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
		<h2 align="center">문의 상세 조회</h2><br>
		<form action="/admin/qnaAnswer.tripkase">
			<input type="hidden" name="questionNo" value="${qna.questionNo }">
			<input type="hidden" name="answerWriter" value="admin">
			<%-- <input type="hidden" name="answerWriter" value="${loginMember.memberName }"> --%>
			<table class="table" align="center" border="1" width="400">
				<tr>
					<td>제목</td>
					<td>${qna.questionTitle }</td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea cols="50" rows="7" name="questionTitle">${qna.qContents }</textarea></td>
				</tr>
				<tr>
					<td>첨부파일</td>
					<c:if test="${qna.qFileRename ne null}">
						<td>
							 <img alt="문의이미지" src="/resources/qUploadFiles/${qna.qFileRename}" width="300" height="300"/>
						</td>
					</c:if>
					<c:if test="${qna.qFileRename eq null}">
						<td>
							첨부파일 없음
						</td>
					</c:if>
				</tr>
			</table>
			<br><br>
			<table class="table" align="center" border="1" width="400">
				<tr>
					<td>답변</td>
					<td>
						<c:if test="${qna.aContents eq null }">
							등록된 답변이 없습니다
						</c:if>
						<c:if test="${qna.aContents ne null }">
							<textarea cols="50" rows="7" name="aContents" >${qna.aContents }</textarea>
						</c:if>
					</td>
				</tr>
				<tr>
					<td>답변 등록 (수정)</td>
					<td>
					<textarea cols="50" rows="7" name="aContents" placeholder="답변을 작성해주세요."></textarea>
					</td>
				</tr>
				<tr align="center">
					<td colspan="2"><button class="btn btn-dark">답변 등록</button></td>
				</tr>
			</table>
		</form>
	</div>
</div>
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<jsp:include page="../common/footer.jsp"/>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</body>
</html>