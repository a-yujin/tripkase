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
	<jsp:include page="../common/header.jsp"></jsp:include>
	<jsp:include page="../admin/menuBar.jsp"></jsp:include>
	<h1 align="center">${notice.noticeNo }번 게시글 수정하기</h1>
	<br>
	<form action="/admin/updateNotice.tripkase" method="post" enctype="multipart/form-data">
		<input type="hidden" name="noticeNo" value="${notice.noticeNo }">
		<%-- <input type="hidden" name="page" value="${page }">
		<input type="hidden" name="boardFilename" value="${board.boardFilename }">
		<input type="hidden" name="boardFileRename" value="${board.boardFileRename }"> --%>
		<table align="center" border="1">
			<tr>
				<td>제목</td>
				<td><input type="text" name="noticeTitle" value="${notice.noticeTitle }">
				</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="noticeWriter" value="${notice.noticeWriter }" readonly></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea cols="30" rows="7" name="nContents">${notice.nContents }</textarea></td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td>
					<c:forEach items="${niList }" var="img">
						<input type="hidden" value="${img.imgNo }" name="imgNo">
						<input type="hidden" value="${img.nFileRename }" name="nFileRename">
						<input type="file" name="reloadFile">
						<a href="#">${img.nFileName }</a><br>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="수정">
					<a href="/admin/noticeList.tripkase">목록으로</a>
					<!--js history 객체 사용  -->
					<a href="javascript:history.go(-1);">이전 페이지로</a>
				</td>
			</tr>
		</table>
		</form>
</body>
</html>