<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세 : 맛집 등록 페이지</title>
<!-- 테스트용 jsp -->
</head>
<body>
	<form action="/restaurant/insertRestaurant.tripkase" method="post" enctype="multipart/form-data">
		
		<br><br>종류 선택
		<input type="radio" id="resType" name="resType" value="korea"> 한식
		<input type="radio" id="resType" name="resType" value="chinese"> 중식
		<input type="radio" id="resType" name="resType" value="japan"> 일식
		<input type="radio" id="resType" name="resType" value="amearica"> 양식
		<input type="radio" id="resType" name="resType" value="guitar"> 기타
		
		<br><br> 지역
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