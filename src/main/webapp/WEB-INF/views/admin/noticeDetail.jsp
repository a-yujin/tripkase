<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 상세 조회</title>
</head>
<body>
	<h2>공지 상세 조회</h2><br>
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
				<img alt="본문이미지" 
				src="/resources/nUploadFiles/${notice.nFileRename }" 
				width="300" height="300">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<a href="/admin/modifyNoticeView.tripkase?noticeNo=${notice.noticeNo }">수정 페이지로 이동</a>
				<%-- <a href="#" onclick="boardRemove(${page});" >삭제하기</a> --%>
				<a href="#" onclick="return confirm('게시물을 삭제하시겠습니까?');" >삭제하기</a>
			</td>
		</tr>
	</table>
	
</body>
</html>