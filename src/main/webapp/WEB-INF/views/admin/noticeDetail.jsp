<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행 카세 : 공지 상세 조회</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="/resources/js/jquery-3.6.1.min.js"></script>
<style>
	.noticeTable{
		float:left;
		padding-left:100px;
		width:700px;
	}
</style>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<jsp:include page="../admin/menuBar.jsp"></jsp:include>
	<div class="noticeTable">
		<h2 align="center">공지 상세 조회</h2><br>
		<table align="center" width="500" border="1">
			<tr>
				<td>제목</td>
				<td>${notice.noticeTitle }</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${notice.noticeWriter }</td>
			</tr>
			<tr>
				<td>작성날짜</td>
				<td>${notice.nCreateDate }</td>
			</tr>
			<tr>
				<td>조회수</td>
				<td>${notice.noticeCount }</td>
			</tr>
			<tr height="300">
				<td>내용</td>
				<td>${notice.nContents }
				<%-- <img alt="본문이미지" src="/resources/buploadFiles/${board.boardFileRename }"> --%>
				</td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td>
					<c:if test="${niList ne null }">
						<c:forEach items="${niList }" var="img" varStatus="i">
							<img alt="공지이미지" src="/resources/nUploadFiles/${img.nFileRename}" width="400" height="200">
						</c:forEach>
					</c:if>
					<c:if test="${niList eq null }">
						첨부파일 없음
					</c:if>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button class="btn btn-default" type="button" onclick="location.href='/admin/modifyNoticeView.tripkase?noticeNo=${notice.noticeNo }'">수정 </button>
					<%-- <a href="#" onclick="boardRemove(${page});" >삭제하기</a> --%>
					<button class="btn btn-default" type="button" onclick="location.href='/admin/deleteNotice.tripkase?noticeNo=${notice.noticeNo }'" >삭제</button>
				</td>
			</tr>
		</table>
	</div>
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<jsp:include page="../common/footer.jsp"/>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</body>
</html>