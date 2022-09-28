<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세 : 맛집 상세조회</title>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="../resources/css/restaurant.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body>
<jsp:include page="../common/header.jsp"></jsp:include>
	<form action="/storage/insertStorage.tripkase" method="post">
		<input type="hidden" name="contentsCode" value="restaurant"> <!-- 보관함으로 넘기기 위한 컨텐츠 분류 코드 -->
		<input type="hidden" name="contentsId"   value="${restaurant.resNo }"> <!-- 보관함으로 넘기기 위한 컨텐츠 넘버값 -->
			<div id="top-wrapper">
			<!-- 정보 영역 -->
				<div id="top-text">
					<p id="top-name">${restaurant.resName }</p>
					<p id="top-address">${restaurant.resAddress }</p>
				</div>	
				<!-- 사진 영역 -->
				<div id="top-picture">
					<div id="pic-left">
						<img id="first-img"src="../resources/resUploadFiles/${resImgList[0].resFileRename }">
					</div>
					<div id="pic-right">
						<div id="right-top">
							<div class="right-pic">
								<div class="detail-pic">
									<img class="double-pic" src="../resources/resUploadFiles/${resImgList[1].resFileRename }">
								</div>
								<div class="detail-pic">
									<img class="double-pic" src="../resources/resUploadFiles/${resImgList[2].resFileRename }">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- 버튼 영역 -->
			<br><br>
			<div id="top-button">
				<button type="submit" class="detail-button">보관하기</button>
				<button type="button" class="detail-button" onclick="javascript:history.go(-1);">목록으로</button>
			</div>
			</form>
			<hr class="detail-hr">
	<br><br>
<jsp:include page="../common/footer.jsp"/>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
</body>
</html>