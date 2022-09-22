<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의 상세 조회</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<jsp:include page="../admin/menuBar.jsp"></jsp:include>
	
	<h2>문의 상세 조회</h2><br>
	<form action="/admin/qnaAnswer.tripkase">
		<input type="hidden" name="questionNo" value="${qna.questionNo }">
		<input type="hidden" name="answerWriter" value="admin">
		<%-- <input type="hidden" name="answerWriter" value="${loginMember.memberName }"> --%>
		<table align="center" border="1" width="400">
			<tr>
				<td>제목</td>
				<td>${qna.questionTitle }</td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea cols="50" rows="10" name="questionTitle">${qna.qContents }</textarea></td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td>
					 <img alt="문의이미지" src="/resources/qUploadFiles/${qna.qFileRename}" width="300" height="300"/>
				</td>
			</tr>
		</table>
		<br><br>
		<table align="center" border="1" width="400">
			<tr>
				<td>답변</td>
				<td>
					<c:if test="${qna.aContents eq null }">
						등록된 답변이 없습니다
					</c:if>
					<c:if test="${qna.aContents ne null }">
						<textarea cols="50" rows="10" name="aContents" >${qna.aContents }</textarea>
					</c:if>
				</td>
			</tr>
			<tr>
				<td>답변 등록 (수정)</td>
				<td>
				<textarea cols="50" rows="10" name="aContents" placeholder="답변을 작성해주세요."></textarea>
				</td>
			</tr>
			<tr>
				<td align="right" colspan="2"><button>답변 등록</button></td>
			</tr>
		</table>
	</form>
</body>
</html>