<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세 : 게시글 수정</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="/resources/js/jquery-3.6.1.min.js"></script>
<style>
	.noticeTable{
		float:left;
		padding-left:100px;
		width:700px;
	}
	input, textarea{
		border : 0;
	}
</style>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<jsp:include page="../admin/menuBar.jsp"></jsp:include>
	
	<div class="noticeTable">
		<h1 align="center">${notice.noticeNo }번 게시글 수정하기</h1>
		<form action="/admin/updateNotice.tripkase" method="post" enctype="multipart/form-data">
			<input type="hidden" name="noticeNo" value="${notice.noticeNo }">
			<table class="table table-hover" align="center" border="1">
				<tr>
					<td>제목</td>
					<td><input size="75" type="text" name="noticeTitle" value="${notice.noticeTitle }">
					</td>
				</tr>
				<tr>
					<td>작성자</td>
					<td><input size="75" type="text" name="noticeWriter" value="${notice.noticeWriter }" readonly></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea cols="80" rows="7" name="nContents">${notice.nContents }</textarea></td>
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
						<button class="btn btn-default" type="submit">수정</button>
						<button class="btn btn-default" onclick="location.href='/admin/noticeList.tripkase'">목록</button>
						<!--js history 객체 사용  -->
						<button class="btn btn-default" onclick="location.href='javascript:history.go(-1);''">이전 페이지</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<jsp:include page="../common/footer.jsp"/>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</body>
</html>