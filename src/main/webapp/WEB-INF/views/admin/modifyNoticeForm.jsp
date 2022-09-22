<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">${notice.noticeNo }번 게시글 수정하기</h1>
	<br>
	<form action="/admin/updateNotice.tripkase" method="post" enctype="multipart/form-data">
		<%-- <input type="hidden" name="page" value="${page }">
		<input type="hidden" name="boardNo" value="${board.boardNo }">
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
				<td><input type="file" name="reloadFile">
					<a href="#">${notice.nFileName }</a>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="수정">
					<a href="/admin/noticelist.tripkase">목록으로</a>
					<!--js history 객체 사용  -->
					<a href="javascript:history.go(-1);">이전 페이지로</a>
				</td>
			</tr>
		</table>
		</form>
</body>
</html>