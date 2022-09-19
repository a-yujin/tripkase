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
		<input type="text" id=restaurantName>
		<br>
		<input type="radio" id="resArea" name="resArea" value="all"> 전체보기
		<input type="radio" id="resArea" name="resArea" value="seoul"> 서울
		<input type="radio" id="resArea" name="resArea" value="gyenggi"> 경기
		<input type="radio" id="resArea" name="resArea" value="incheon"> 인천
		<input type="radio" id="resArea" name="resArea" value="kangwon"> 강원
		<input type="radio" id="resArea" name="resArea" value="chungbuk"> 충청북도
		<input type="radio" id="resArea" name="resArea" value="chungnam"> 충청남도
		<input type="radio" id="resArea" name="resArea" value="gyengbuk"> 경상북도
		<input type="radio" id="resArea" name="resArea" value="gyengnam"> 경상남도
		<input type="radio" id="resArea" name="resArea" value="jeonbuk"> 전라북도
		<input type="radio" id="resArea" name="resArea" value="jeonnam"> 전라남도
		<input type="radio" id="resArea" name="resArea" value="jeju"> 제주
		<br><br>
		<label><input type="checkbox" name="resType" value="korea"> 한식 </label>
		<label><input type="checkbox" name="resType" value="chinese"> 중식 </label>
		<label><input type="checkbox" name="resType" value="japan"> 일식 </label>
		<label><input type="checkbox" name="resType" value="amearica"> 양식 </label>
		<label><input type="checkbox" name="resType" value="guitar"> 기타 </label>
		<br><br>
		<input type="submit" value="조회하기">
	</form>
</body>
</html>