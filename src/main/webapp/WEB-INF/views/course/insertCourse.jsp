<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세 : 코스등록 </title>
<script src="/resources/js/jquery-3.6.1.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<style>
	.courseTable{
		padding-left:100px;
		width:1000px;
		margin : 0 auto;
	}
	
	#table{
		width : 800px;
	}
	
</style>

</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<jsp:include page="../admin/menuBar.jsp"></jsp:include>
	<div class="courseTable">
	<br><br>
	<h1 align="center">코스 등록  페이지</h1>
	<br>
	<form action="/course/insertCourse.tripkase" method="post" enctype="multipart/form-data">
	<div class="register">
		<table id="table" align="center" border="1">
			<tr>
				<td>이름</td>
				<td><input size="108" type="text" name="courseName"></td>
			</tr>
			<tr>
				<td>코스 테마</td>
				<td><input size="108" type="text" name="courseThema"></td>
			</tr>
			<tr>
				<td>코스 거리</td>
				<td><input size="108" type="text" name="courseDistance"></td>
			</tr>
			<tr class="fileTr">
				<td>코스 이미지</td>
				<td>
					<button type="button" onclick="addFile();">추가</button>
					<button type="button" onclick="removeFile();">삭제</button>
					<input multiple="multiple" type="file" name="uploadFile">
				</td>
			</tr>
			<tr>
				<td>코스 지역</td>
				<td><input type="text" size="108" name="locationName" placeholder = "영어로 입력해주세요"></td>
			</tr>
			<tr>
				<td>코스 설명</td>
				<td><textarea cols="112" rows="20" name=courseInfo> </textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="등록">
					<input type="reset"  value="취소">
				</td>
			</tr>
		</table>
	</div>
	</form>
	</div>
	<br><br><br><br><br>
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
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<jsp:include page="../common/footer.jsp"/>
</body>
</html>
