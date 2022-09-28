<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세 : 코스수정 </title>
<script src="/resources/js/jquery-3.6.1.min.js"></script>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<h2 align="center">코스 수정  페이지</h2>
	<form action="/course/modifyCourse.tripkase" method="get" enctype="multipart/form-data">
	<div class="register">
		<table align="center" border="1">
			<tr>
				<td>코스 이름</td>
				<td><input type="text" name="courseName"></td>
			</tr>
			<tr>
				<td>코스 테마</td>
				<td><input type="text" name="courseThema"></td>
			</tr>
			<tr>
				<td>코스 거리</td>
				<td><input type="text" name="courseDistance"></td>
			</tr>
			<tr class="fileTr">
				<td>코스 이미지</td>
				<td>
					<input multiple="multiple" type="file" name="uploadFile">
					<button type="button" onclick="addFile();">추가</button>
					<button type="button" onclick="removeFile();">삭제</button>
				</td>
			</tr>
			<tr>
				<td>코스 지역</td>
				<td><input type="text" name="locationName" placeholder = "영어로 입력해주세요"></td>
			</tr>
			<tr>
				<td>코스 설명</td>
				<td><textarea cols="50" rows="50" name=courseInfo> </textarea></td>
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
