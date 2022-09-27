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
		textarea{
			border:0;:0;
		}
		.qnaTable{
			text-align: center;
		}
		
	</style>
</head>
<body>
<jsp:include page="../common/header.jsp"></jsp:include>

	<div class="noticeTable">
		<h2 align="center">문의 상세 조회</h2><br>
		<form action="/admin/qnaAnswer.tripkase">
			<input type="hidden" name="questionNo" value="${qna.questionNo }">
			<input type="hidden" name="answerWriter" value="admin">
			<%-- <input type="hidden" name="answerWriter" value="${loginMember.memberName }"> --%>
			<table align="center" border="1" width="500" class="qnaTable">
				<tr>
					<td width="80">제목</td>
					<td>${qna.questionTitle }</td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea cols="55" rows="10" name="questionTitle">${qna.qContents }</textarea></td>
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
			<table align="center" border="1" width="500" class="qnaTable">
				<tr>
					<td width="80">답변</td>
					<td>
						<c:if test="${qna.aContents eq null }">
							아직 등록된 답변이 없습니다. 기다려주셔서 감사합니다.
						</c:if>
						<c:if test="${qna.aContents ne null }">
							<textarea cols="55" rows="10" name="aContents" >${qna.aContents }</textarea>
						</c:if>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<br>
<jsp:include page="../common/footer.jsp"/>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</body>
</html>