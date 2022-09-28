<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세 : 맛집 검색 페이지</title>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
<link href="../resources/css/restaurant.css" rel="stylesheet">
<script src="../resources/js/jquery-3.6.1.min.js"></script>
</head>
<body>
<jsp:include page="../common/header.jsp"/>
	<div id="search-wrapper">
		<div id="search-area" class="input-group">
			<form action="/restaurant/restaurantSearch.tripkase" method="get">
				<input type="text" class="form-control rounded"  id="restaurantName" name="searchValue" placeholder="맛집 이름을 입력해주세요." aria-label="Search" aria-describedby="search-addon">
				<br><br><br><br>
				<div id="choice-area">
					<div id="select-area" class="btn-group" role="group" aria-label="Basic radio toggle button group">
						<input type="radio" class="btn-check" id="btnradio1" name="areaValue" autocomplete="off" checked value="">
						<label class="btn btn-outline-primary" for="btnradio1">전체보기</label>
						
						<input type="radio" class="btn-check" id="btnradio2" name="areaValue" autocomplete="off" value="seoul">
						<label class="btn btn-outline-primary" for="btnradio2">　서울　</label>
						
						<input type="radio" class="btn-check" id="btnradio3" name="areaValue" autocomplete="off" value="gyeonggi">
						<label class="btn btn-outline-primary" for="btnradio3">　경기　</label>
						
						<input type="radio" class="btn-check" id="btnradio4" name="areaValue" autocomplete="off" value="incheon">
						<label class="btn btn-outline-primary" for="btnradio4">　인천　</label>
						
						<input type="radio" class="btn-check" id="btnradio5" name="areaValue" autocomplete="off" value="kangwon">
						<label class="btn btn-outline-primary" for="btnradio5">　강원　</label>
						
						<input type="radio" class="btn-check" id="btnradio6" name="areaValue" autocomplete="off" value="chungbuk">
						<label class="btn btn-outline-primary" for="btnradio6">　충북　</label>
						
						<input type="radio" class="btn-check" id="btnradio7" name="areaValue" autocomplete="off" value="chungnam">
						<label class="btn btn-outline-primary" for="btnradio7">　충남　</label>
						
						<input type="radio" class="btn-check" id="btnradio8" name="areaValue" autocomplete="off" value="gyeongbuk">
						<label class="btn btn-outline-primary" for="btnradio8">　경북　</label>
						
						<input type="radio" class="btn-check" id="btnradio9" name="areaValue" autocomplete="off" value="gyeongnam">
						<label class="btn btn-outline-primary" for="btnradio9">　경남　</label>
						
						<input type="radio" class="btn-check" id="btnradio10" name="areaValue" autocomplete="off" value="jeonbuk">
						<label class="btn btn-outline-primary" for="btnradio10">　전북　</label>
						
						<input type="radio" class="btn-check" id="btnradio11" name="areaValue" autocomplete="off" value="jeonnam">
						<label class="btn btn-outline-primary" for="btnradio11">　전남　</label>
						
						<input type="radio" class="btn-check" id="btnradio12" name="areaValue" autocomplete="off" value="jeju">
						<label class="btn btn-outline-primary" for="btnradio12">　제주　</label>
					</div>
					<br><br><br><br><br>
					<div id="check-Type" class="btn-group" role="group" aria-label="Basic checkbox toggle button group">
					<label><input type="checkbox" name="typeValue" value="korean" checked>　한식　　</label>
						<label><input type="checkbox" name="typeValue" value="chinese" checked>　중식　　</label>
						<label><input type="checkbox" name="typeValue" value="japanese" checked>　일식　　</label>
						<label><input type="checkbox" name="typeValue" value="american" checked>　양식　　</label>
						<label><input type="checkbox" name="typeValue" value="etc" checked>　기타</label>
						<br><br>
					</div>
				</div>
				<br><br>
				<div id="search-button">
					<input type="submit" value="조회하기" id="sbutton">
				</div>
			</form>
		</div>
	</div>
<jsp:include page="../common/footer.jsp"/>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
</body>
</html>