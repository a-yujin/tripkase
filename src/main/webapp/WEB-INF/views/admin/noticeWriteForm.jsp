<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지등록</title>
<script src="/resources/js/jquery-3.6.1.min.js"></script>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<jsp:include page="../admin/menuBar.jsp"></jsp:include>
	
	<h2 align="center">공지 등록</h2>
	<form action="/admin/registerNotice.tripkase" method="post" enctype="multipart/form-data">
		<table align="center" border="1">
			<tr>
				<td>제목</td>
				<td><input size="50" type="text" name="noticeTitle"></td>
			</tr>
			<tr>
				<td>작성자</td>
				<%-- <td><input size="50" type="text" name="noticeWriter" value="${loginMember.memberName }" readonly></td> --%>
				<td><input size="50" type="text" name="noticeWriter" value="admin" ></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea cols="52" rows="20" name="nContents"></textarea></td>
			</tr>
			<tr class="fileTr">
				<td>첨부파일</td>
				<td>
					<input  multiple="multiple" type="file" name="uploadFile">
					<button type="button" onclick="addFile();">추가</button>
					<button type="button" onclick="removeFile();">삭제</button>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="등록">
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>
	<script>
		function addFile(){
			var number = 2;
			var trTag = $(".fileTr");
			$(trTag).children('td').eq(1).append("<br><input multiple='multiple' type='file' name='uploadFile' />");
			number = number + 1;
		}
		function removeFile(){
			var trTag = $(".fileTr");
		 	if($(trTag).children('td').eq(1).children('input').length > 1) {
			 	$(trTag).children('td').eq(1).children('input:last').remove();
			 	$(trTag).children('td').eq(1).children('br:last').remove();
			} 
			
		}
	</script>	
	
</body>
</html>