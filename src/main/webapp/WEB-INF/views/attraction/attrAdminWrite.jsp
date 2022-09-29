<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세: 관광지 등록</title>
<script src="/resources/js/jquery-3.6.1.min.js"></script>
	<style>
	input, textarea{
		border:0;
	}
	</style>
	
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<jsp:include page="../admin/menuBar.jsp"></jsp:include>
	<h1 align="center">관광지 등록</h1>
	<form action="/attraction/register.tripkase" method="post" enctype="multipart/form-data">
		<table align="center" border="1">
			<tr>
				<td>관광지 이름</td>
				<td><input type="text" name="attrName"></td>
			</tr>
			<tr>
				<td>관광지 지역</td>
				<td>
					<input type="radio" name="attrLocation" id="seoul" value="서울"><label for="seoul">서울</label>
					<input type="radio" name="attrLocation" id="gg" value="경기"><label for="gg">경기</label>
					<input type="radio" name="attrLocation" id="incheon" value="인천"><label for="incheon">인천</label>
					<input type="radio" name="attrLocation" id="gw" value="강원"><label for="gw">강원</label>
					<input type="radio" name="attrLocation" id="cb" value="충북"><label for="cb">충북</label>
					<input type="radio" name="attrLocation" id="cn" value="충남"><label for="cn">충남</label>
					<input type="radio" name="attrLocation" id="gb" value="경북"><label for="gb">경북</label>
					<input type="radio" name="attrLocation" id="gn" value="경남"><label for="gn">경남</label>
					<input type="radio" name="attrLocation" id="jb" value="전북"><label for="jb">전북</label>
					<input type="radio" name="attrLocation" id="jn" value="전남"><label for="jn">전남</label>
					<input type="radio" name="attrLocation" id="jeju" value="제주"><label for="jeju">제주</label>
				</td>
			</tr>
			<tr>
				<td>여행 유형</td>
				<td>
					<input type="radio" name="attrTripType" id="couple" value="couple">
					<label for="couple">커플</label>
					<input type="radio" name="attrTripType" id="friend" value="friend">
					<label for="friend">우정</label>
					<input type="radio" name="attrTripType" id="solo" value="alone">
					<label for="solo">홀로</label>
					<input type="radio" name="attrTripType" id="family" value="family">
					<label for="family">가족</label>
					<input type="radio" name="attrTripType" id="animal" value="pet">
					<label for="animal">동물</label>
				</td>
			</tr>
			<tr>
				<td>관광지 한줄 정보</td>
				<td><input type="text" name="attrShortInfo"></td>
			</tr>
			<tr>
				<td>관광지 상세 정보</td>
				<td><textarea cols="50" rows="10" name="attrInfo"></textarea></td>
			</tr>
			<tr>
				<td>관광지 전화번호</td>
				<td><input type="text" name="attrTel"></td>
			</tr>
			<tr>
				<td>관광지 홈페이지</td>
				<td><input type="text" name="attrWebsite"></td>
			</tr>
			<tr>
				<td>관광지 주소</td>
				<td><input type="text" name="attrAddress"></td>
			</tr>
			<tr>
				<td>관광지 이용시간</td>
				<td><input type="text" name="attrHours"></td>
			</tr>
			<tr>
				<td>관광지 입장료</td>
				<td><input type="text" name="attrFee"></td>
			</tr>
			<tr>
				<td>주차 가능 여부</td>
				<td>
					<input type="radio" name="attrCar" id="yesCar" value="가능">
					<label for="yesCar">예</label>
					<input type="radio" name="attrCar" id="noCar" value="">
					<label for="noCar">아니요</label>
				</td>
			</tr>
			<tr>
				<td>반려동물 동반 가능 여부</td>
				<td>
					<input type="radio" name="attrPet" id="yesPet" value="가능">
					<label for="yesPet">예</label>
					<input type="radio" name="attrPet" id="noPet" value="">
					<label for="noPet">아니요</label>
				</td>
			</tr>
			<tr class="fileTr">
				<td>관광지 사진</td>
				<td>
					<button type="button" onclick="addFile();">추가</button>
					<button type="button" onclick="removeFile();">삭제</button><br>
					<input multiple="multiple" type="file" name="uploadFile">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="등록">
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>
	<script>
		function addFile(){
			var number = 2;
			var trTag = $(".fileTr");
			$(trTag).children('td').eq(1).append("<br><input multiple='multiple' type='file' name='uploadFile'/>");
			number = number + 1;
		}
		
		function removeFile(){
			var trTag = $(".fileTr");
		 	if($(trTag).children('td').eq(1).children('input').length > 1) {
			 	$(trTag).children('td').eq(1).children('input:last').remove();
			 	$(trTag).children('td').eq(1).children('br:last').remove();
			} 
			
		}
	</script>
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>