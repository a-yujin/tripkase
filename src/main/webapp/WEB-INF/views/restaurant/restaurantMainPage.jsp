<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세 : 맛집 검색 페이지</title>
<!-- 테스트용 jsp  -->
</head>
<body>
	<br><br>
	<form action="/restaurant/restaurantSearch.tripkase" method="get">
		<input type="text" id="restaurantName" name="searchValue">
		<br>
		<input type="radio" id="resArea1" name="areaValue" value=""> 전체보기
		<input type="radio" id="resArea2" name="areaValue" value="seoul"> 서울
		<input type="radio" id="resArea3" name="areaValue" value="gyeonggi"> 경기
		<input type="radio" id="resArea4" name="areaValue" value="incheon"> 인천
		<input type="radio" id="resArea5" name="areaValue" value="kangwon"> 강원
		<input type="radio" id="resArea6" name="areaValue" value="chungbuk"> 충청북도
		<input type="radio" id="resArea7" name="areaValue" value="chungnam"> 충청남도
		<input type="radio" id="resArea8" name="areaValue" value="gyeongbuk"> 경상북도
		<input type="radio" id="resArea9" name="areaValue" value="gyeongnam"> 경상남도
		<input type="radio" id="resArea10" name="areaValue" value="jeonbuk"> 전라북도
		<input type="radio" id="resArea11" name="areaValue" value="jeonnam"> 전라남도
		<input type="radio" id="resArea12" name="areaValue" value="jeju"> 제주
		<br><br>
		<label><input type="checkbox" name="typeValue" value="korean"> 한식 </label>
		<label><input type="checkbox" name="typeValue" value="chinese"> 중식 </label>
		<label><input type="checkbox" name="typeValue" value="japanese"> 일식 </label>
		<label><input type="checkbox" name="typeValue" value="american"> 양식 </label>
		<label><input type="checkbox" name="typeValue" value="etc"> 기타 </label>
		<br><br>
		<input type="submit" value="조회하기">
	</form>
</body>
</html>