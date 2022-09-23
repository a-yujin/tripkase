<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세: 관광지 검색</title>
<link href="/resources/css/attraction.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	<br><br><br><br><br>
	<div id="attrSearchWrap">
		<!-- <form action="/attr/search.tripkase" method="post"> -->
		<form>
			<div>
				<div id="searchTextDiv">
					<input id="searchText" type="text" placeholder="가고 싶은 관광지를 입력하세요">
				</div>
				<div>
					<input type="radio" name="attrLocation" class="attrLocation" id="radioAll"><label for="radioAll">전체</label>
					<input type="radio" name="attrLocation" class="attrLocation" id="seoul"><label for="seoul">서울</label>
					<input type="radio" name="attrLocation" class="attrLocation" id="ggd"><label for="ggd">경기</label>
					<input type="radio" name="attrLocation" class="attrLocation" id="incheon"><label for="incheon">인천</label>
					<input type="radio" name="attrLocation" class="attrLocation" id="gwd"><label for="gwd">강원</label>
					<input type="radio" name="attrLocation" class="attrLocation" id="chNorth"><label for="chNorth">충북</label>
					<input type="radio" name="attrLocation" class="attrLocation" id="chSouth"><label for="chSouth">충남</label>
					<input type="radio" name="attrLocation" class="attrLocation" id="gsNorth"><label for="gsNorth">경북</label>
					<input type="radio" name="attrLocation" class="attrLocation" id="gsSouth"><label for="gsSouth">경남</label>
					<input type="radio" name="attrLocation" class="attrLocation" id="jrNorth"><label for="jrNorth">전북</label>
					<input type="radio" name="attrLocation" class="attrLocation" id="jrSouth"><label for="jrSouth">전남</label>
					<input type="radio" name="attrLocation" class="attrLocation" id="jejudo"><label for="jejudo">제주</label>
				</div>
					<select name="tripType">
						<option selected value="tripType">여행 유형</option>
						<option value="couple">커플 여행</option>
						<option value="friends">우정 여행</option>
						<option value="solo">홀로 여행</option>
						<option value="family">가족 여행</option>
						<option value="parents">효도 여행</option>
					</select>
				</div>
				<div>
					<h6>반려동물 동반 여부</h6>
					<label><input type="radio" name="animal" value="Y">네</label><br>
					<label><input type="radio" name="animal" value="N" checked>아니오</label>
				</div>
				<div>
					<input type="submit" value="조회하기">
				</div>
			</div>
		</form>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>