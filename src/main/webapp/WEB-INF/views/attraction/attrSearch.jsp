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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
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
					</div>
					<br><br><br>
<!-- 					<div>
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
					</div> -->
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
	<br><br><br><br><br><br>
	<jsp:include page="../common/footer.jsp"/>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
</body>
</html>