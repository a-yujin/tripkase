<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세 : 여행소통 게시글 작성</title>

<link href="../resources/css/trip.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body>
	<div>
		<p class="first-text">게시글 작성</p>
		<p class="second-text">♥ 사용자님의 1번째 게시글 작성을 해주세요. ♥</p>
	</div>
	
	<form action="/trip/tripDetail.tripkase" method="post" enctype="multipart/form-data">
		<!-- 게시글 제목, 내용 작성 영역 -->
		<div id="text-area">
			<input type="text" id="textTitle" name="tripTitle" placeholder=" 제목을 입력해주세요."> <br>
			<textarea id="textContent" name="tripContents" placeholder=" 내용을 입력해주세요."></textarea> <br>
		</div>
		
		<!-- 파일 업로드 영역 -->
		<div class="mb-3">
			<input type="file" id="formFileSm" class="form-control form-control-sm" name="uploadFile">
		</div>
		<br><br>
		
		<hr style="width : 80%; margin : 0 auto;">
		
		<!-- 추쳔여행 추기하기 영역 -->
		<div>
			<p class="first-text">추천여행 추가하기</p>	
			<p class="second-text">추천하고 싶은 여행지는 최대 4개까지 추가 가능합니다.</p>
		</div>
		<br><br>
		<div id="add-wrapper">
			<div id="add-outside">
				<div id="add-inside">
					<div class="trip-add">
					</div>
					<div class="trip-add">
					</div>
					<div class="trip-add">
					</div>
					<div class="trip-add">
					</div>
				</div>
			</div>
		</div>
		
		<!-- 버튼 영역 -->
		<br>
		<div id="trip-button1">
			<input type="button" id="tbutton1" value="목록으로">
			<input type="submit" id="tbutton2" value="등록하기">
		</div>
		<br><br>
	</form>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
</body>
</html>