<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세 : 게시글 수정</title>
<link href="../resources/css/trip.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	<br><br><br>
	<div>
		<p class="first-text">게시글 수정</p>
	</div>
	
	<form action="/trip/tripModify.tripkase" method="post" enctype="multipart/form-data">
		<input type="hidden" name="page" value="${page }">
		<input type="hidden" name="tripNo" value="${trip.tripNo }">
		<input type="hidden" name="tripFileRename" value="${trip.tripFileRename }">

		<!-- 게시글 제목, 내용 작성 영역 -->
		<div id="text-area">
			<input type="text" id="textTitle" name="tripTitle" value="${trip.tripTitle }"> <br>
			<textarea id="textContent" name="tripContents">${trip.tripContents }</textarea> <br>
		</div>

		<!-- 파일 업로드 영역 -->
		<div class="mb-3">
			<input type="file" id="formFileSm" class="form-control form-control-sm" name="reloadFile" value="${trip.tripFileName }">
		</div>
		<br><br>
		
		<!-- 버튼 영역 -->
		<br>
		<div id="trip-button1">
			<input type="button" id="tbutton1" value="돌아가기" onclick="javascript:history.go(-1);">
			<input type="submit" id="tbutton2" value="수정하기">
		</div>
		<br><br>
	</form>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>

</body>
</html>