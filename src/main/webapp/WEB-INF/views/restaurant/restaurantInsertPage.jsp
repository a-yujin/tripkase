<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세 : 맛집 등록 페이지</title>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
</head>
<style>
    body {
        font-family : 'Noto Sans KR',sans-serif;
    }
</style>
<!-- 테스트용 jsp -->
<body>
	<form action="/restaurant/insertRestaurant.tripkase" method="post" enctype="multipart/form-data">
		
		<br><br>종류 선택
		<input type="radio" id="resType" name="resType" value="korean"> 한식
		<input type="radio" id="resType" name="resType" value="chinese"> 중식
		<input type="radio" id="resType" name="resType" value="japanese"> 일식
		<input type="radio" id="resType" name="resType" value="american"> 양식
		<input type="radio" id="resType" name="resType" value="etc"> 기타
		
		<br><br> 지역
		<input type="radio" id="resArea1" name="resArea" value="seoul"> 서울
		<input type="radio" id="resArea2" name="resArea" value="gyeonggi"> 경기
		<input type="radio" id="resArea3" name="resArea" value="incheon"> 인천
		<input type="radio" id="resArea4" name="resArea" value="kangwon"> 강원
		<input type="radio" id="resArea5" name="resArea" value="chungbuk"> 충청북도
		<input type="radio" id="resArea6" name="resArea" value="chungnam"> 충청남도
		<input type="radio" id="resArea7" name="resArea" value="gyeongbuk"> 경상북도
		<input type="radio" id="resArea8" name="resArea" value="gyeongnam"> 경상남도
		<input type="radio" id="resArea9" name="resArea" value="jeonbuk"> 전라북도
		<input type="radio" id="resArea10" name="resArea" value="jeonnam"> 전라남도
		<input type="radio" id="resArea11" name="resArea" value="jeju"> 제주
		<br><br>
		
		<br><br>이름
		<input type="text" name="resName">
		
		<br><br>이미지 파일
		<input type="file" name="resUploadFile">
		
		<br><br>상세정보
		<textarea name="resDetail">
		</textarea>
		
		<br><br>지도
		<input type="text" name="resMap">
		
		<br><br>문의
		<input type="text" name="resTel">
		
		<br><br>주소
		<input type="text" name="resAddress">
		
		<br><br>휴일
		<input type="text" name="resDayoff">
		
		<br><br>대표메뉴
		<input type="text" name="resMainmenu">
		
		<br><br>
		<input type="submit" value="등록">
	</form>
</body>
</html>