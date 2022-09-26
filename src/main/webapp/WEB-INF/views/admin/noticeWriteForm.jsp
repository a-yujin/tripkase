<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행 카세 : 공지등록</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="/resources/js/jquery-3.6.1.min.js"></script>
<style>
	.noticeTable{
		float:left;
		padding-left:100px;
	}
	input, textarea{
		border:0;
	}
</style>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<jsp:include page="../admin/menuBar.jsp"></jsp:include>
	
	<div class="noticeTable">
		<h2 align="center">공지 등록</h2>
		<form action="/admin/registerNotice.tripkase" method="post" enctype="multipart/form-data">
			<table align="center" border="1">
				<tr>
					<td>제목</td>
					<td><input size="50" type="text" name="noticeTitle" placeholder="제목을 입력해주세요"></td>
				</tr>
				<tr>
					<td>작성자</td>
					<%-- <td>${loginMember.memberName }</td> --%>
					<td>admin</td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea cols="52" rows="20" name="nContents" placeholder="내용을 입력해주세요"></textarea></td>
				</tr>
				<tr class="fileTr">
					<td>첨부파일</td>
					<td>
						<button class="btn btn-default" type="button" onclick="addFile();">추가</button>
						<button class="btn btn-default" type="button" onclick="removeFile();">삭제</button>
						<input multiple="multiple" type="file" name="uploadFile">
					</td>
				</tr>
				<tr>
					<td align="center" colspan="2">
						<button class="btn btn-default" type="submit">등록</button>
						<button class="btn btn-default" type="reset">취소</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
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
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<jsp:include page="../common/footer.jsp"/>	
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</body>
</html>