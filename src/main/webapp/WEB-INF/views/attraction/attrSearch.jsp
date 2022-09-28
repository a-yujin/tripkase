<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세: 관광지 검색</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100&display=swap" rel="stylesheet">
<link href="/resources/css/attraction.css" rel="stylesheet">
<script src="../resources/js/jquery-3.6.1.min.js"></script>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	<div id="attrSearchWrap">
		<br><br><br><br><br>
		<div id="attrSearchArea">
			<form action="/attraction/searchList.tripkase" method="get">
				<div>
					<div id="searchTextDiv">
						<input id="searchText" type="text" placeholder="원하는 관광지를 입력하세요 !" name="searchValue">
					</div>
					<div>
						<input type="radio" name="areaValue" class="attrLocation" id="radioAll" value="" checked><label for="radioAll">전체</label>
						<input type="radio" name="areaValue" class="attrLocation" id="seoul" value="seoul"><label for="seoul">서울</label>
						<input type="radio" name="areaValue" class="attrLocation" id="gg" value="gyeonggi"><label for="gg">경기</label>
						<input type="radio" name="areaValue" class="attrLocation" id="incheon" value="incheon"><label for="incheon">인천</label>
						<input type="radio" name="areaValue" class="attrLocation" id="kw" value="kangwon"><label for="kw">강원</label>
						<input type="radio" name="areaValue" class="attrLocation" id="cb" value="chungbuk"><label for="cb">충북</label>
						<input type="radio" name="areaValue" class="attrLocation" id="cn" value="chungnam"><label for="cn">충남</label>
						<input type="radio" name="areaValue" class="attrLocation" id="gb" value="gyeongbuk"><label for="gb">경북</label>
						<input type="radio" name="areaValue" class="attrLocation" id="gn" value="gyeongnam"><label for="gn">경남</label>
						<input type="radio" name="areaValue" class="attrLocation" id="jb" value="jeonbuk"><label for="jb">전북</label>
						<input type="radio" name="areaValue" class="attrLocation" id="jn" value="jeonnam"><label for="jn">전남</label>
						<input type="radio" name="areaValue" class="attrLocation" id="jeju" value="jeju"><label for="jeju">제주</label>
					</div>
					<div class="searchChkDiv">
						<label>누구와 함께 하나요?
						  	<!-- 모두 선택 추가 -->
						  	<label>모두<input type="checkbox" value="all" name="typeValue" onclick="selectAll(this)" checked></label>
							<label>연인과<input type="checkbox" value="couple" name="typeValue" checked></label>
							<label>친구와<input type="checkbox" value="friend" name="typeValue" checked></label>
							<label>혼자<input type="checkbox" value="alone" name="typeValue" checked></label>
							<label>가족과<input type="checkbox" value="family" name="typeValue" checked></label>
							<label>반려동물과<input type="checkbox" value="pet" name="typeValue" checked></label>
						</label>
					</div>
					<div class="searchBtnDiv">
						<input type="submit" value="조회하기">
					</div>
				</div>
			</form>
		</div>
	</div>
	<script>
		function selectAll(selectAll)  {
			  const checkboxes = document.getElementsByName('typeValue');
			  checkboxes.forEach((checkbox) => {
			    checkbox.checked = selectAll.checked;
			  })
			}
	</script>
</body>
</html>