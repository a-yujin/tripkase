<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세 : 맛집 검색 페이지</title>
<!-- 테스트용 jsp  -->
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="../resources/css/restaurant.css" rel="stylesheet">
<script src="../resources/js/jquery-3.6.1.min.js"></script>
</head>
<style>
	#res-admin-search{
		text-align: center;
	}
	body{
			font-family: 'Noto Sans KR', sans-serif;
		}
</style>
<body>
<jsp:include page="../common/header.jsp"/>
<jsp:include page="../admin/menuBar.jsp"/>
		<div id="res-admin-search">
			<form action="/restaurant/restaurantAdminSearchView.tripkase" method="get">
			<br><br><br><br><br><br><br><br>
				<input type="text" name="searchValue" placeholder="맛집 이름을 입력해주세요.">
				<br><br>
				<div>
					<div>
						<input type="radio" name="areaValue" checked value="">
						<label">전체보기</label>
						
						<input type="radio" name="areaValue" value="seoul">
						<label>　서울　</label>
						
						<input type="radio" name="areaValue" value="gyeonggi">
						<label>　경기　</label>
						
						<input type="radio" name="areaValue" value="incheon">
						<label>　인천　</label>
						
						<input type="radio" name="areaValue" value="kangwon">
						<label>　강원　</label>
						
						<input type="radio" name="areaValue" value="chungbuk">
						<label>　충북　</label>
						
						<input type="radio" name="areaValue" value="chungnam">
						<label>　충남　</label>
						
						<input type="radio" name="areaValue" value="gyeongbuk">
						<label>　경북　</label>
						
						<input type="radio" name="areaValue" value="gyeongnam">
						<label>　경남　</label>
						
						<input type="radio" name="areaValue" value="jeonbuk">
						<label>　전북　</label>
						
						<input type="radio" name="areaValue" value="jeonnam">
						<label>　전남　</label>
						
						<input type="radio" name="areaValue" value="jeju">
						<label>　제주　</label>
					</div>
					<br><br><br>
					<div>
					<label><input type="checkbox" name="typeValue" value="korean" checked>　한식　</label>
						<label><input type="checkbox" name="typeValue" value="chinese" checked>　중식　</label>
						<label><input type="checkbox" name="typeValue" value="japanese" checked>　일식　</label>
						<label><input type="checkbox" name="typeValue" value="american" checked>　양식　</label>
						<label><input type="checkbox" name="typeValue" value="etc" checked>　기타</label>
						<br><br>
					</div>
				</div>
				<br><br>
				<div>
					<input type="submit" value="조회하기">
				</div>
			</form>
		</div>
<br><br><br><br><br><br><br><br><br>
<jsp:include page="../common/footer.jsp"/>
</body>
</html>