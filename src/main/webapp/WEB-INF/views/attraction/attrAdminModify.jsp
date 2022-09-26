<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세: 관광지 상세(수정/삭제)</title>
<script src="/resources/js/jquery-3.6.1.min.js"></script>
</head>
<body>
<!-- 	<form action="/attraction/modify.tripkase" method="post" enctype="multipart/form-data"> -->
	<form>
		<input type="hidden" name="attrNo" value="${attr.attrNo}">
		<table align="center" border="1">
			<tr>
				<td>관광지 이름</td>
				<td><input type="text" name="attrName" value ="${attr.attrName}"></td>
			</tr>
			<tr>
				<td>관광지 지역</td>
				<td>
					<input type="radio" name="attrLocation" id="seoul"><label for="seoul">서울</label>
					<input type="radio" name="attrLocation" id="gg"><label for="gg">경기</label>
					<input type="radio" name="attrLocation" id="incheon"><label for="incheon">인천</label>
					<input type="radio" name="attrLocation" id="gw"><label for="gw">강원</label>
					<input type="radio" name="attrLocation" id="cb"><label for="cb">충북</label>
					<input type="radio" name="attrLocation" id="cn"><label for="cn">충남</label>
					<input type="radio" name="attrLocation" id="gb"><label for="gb">경북</label>
					<input type="radio" name="attrLocation" id="gn"><label for="gn">경남</label>
					<input type="radio" name="attrLocation" id="jb"><label for="jb">전북</label>
					<input type="radio" name="attrLocation" id="jn"><label for="jn">전남</label>
					<input type="radio" name="attrLocation" id="jeju"><label for="jeju">제주</label>
				</td>
			</tr>
			<tr>
				<td>여행 유형</td>
				<td>
					<input type="checkbox" name="attrTripType" id="couple">
					<label for="couple">커플</label>
					<input type="checkbox" name="attrTripType" id="friend">
					<label for="friend">우정</label>
					<input type="checkbox" name="attrTripType" id="solo">
					<label for="solo">홀로</label>
					<input type="checkbox" name="attrTripType" id="family">
					<label for="family">가족</label>
					<input type="checkbox" name="attrTripType" id="parents">
					<label for="parents">효도</label>
				</td>
			</tr>
			<tr>
				<td>관광지 한줄 정보</td>
				<td><input type="text" name="attrShortInfo" value="${attr.attrShortInfo}"></td>
			</tr>
			<tr>
				<td>관광지 상세 정보</td>
				<td><textarea cols="50" rows="10" name="attrInfo">${attr.attrInfo}</textarea></td>
			</tr>
			<tr>
				<td>관광지 지도</td>
				<td><input type="text" name="attrMap" value="${attr.attrMap}"></td>
			</tr>
			<tr>
				<td>관광지 전화번호</td>
				<td><input type="text" name="attrTel" value="${attr.attrTel}"></td>
			</tr>
			<tr>
				<td>관광지 홈페이지</td>
				<td><input type="text" name="attrWebsite" value="${attr.attrWebsite}"></td>
			</tr>
			<tr>
				<td>관광지 주소</td>
				<td><input type="text" name="attrAddress" value="${attr.attrAddress}"></td>
			</tr>
			<tr>
				<td>관광지 이용시간</td>
				<td><input type="text" name="attrHours" value="${attr.attrHours}"></td>
			</tr>
			<tr>
				<td>관광지 입장료</td>
				<td><input type="text" name="attrFee" value="${attr.attrFee}"></td>
			</tr>
			<tr>
				<td>주차 가능 여부</td>
				<td>
					<input type="radio" name="attrCar" id="yesCar">
					<label for="yesCar">예</label>
					<input type="radio" name="attrCar" id="noCar">
					<label for="noCar">아니요</label>
				</td>
			</tr>
			<tr>
				<td>반려동물 동반 가능 여부</td>
				<td>
					<input type="radio" name="attrAnimal" id="yesAnimal">
					<label for="yesAnimal">예</label>
					<input type="radio" name="attrAnimal" id="noAnimal">
					<label for="noAnimal">아니요</label>
				</td>
			</tr>
			<tr class="fileTr">
				<td>관광지 사진</td>
				<td>
					<button type="button" onclick="addFile();">추가</button>
					<button type="button" onclick="removeFile();">삭제</button><br>
					<input multiple="multiple" type="file" name="attrFile">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정">
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>
	<script>
		function addFile(){
			var number = 2;
			var trTag = $(".fileTr");
			$(trTag).children('td').eq(1).append("<br><input multiple='multiple' type='file' name='attrFile' />");
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
</body>
</html>