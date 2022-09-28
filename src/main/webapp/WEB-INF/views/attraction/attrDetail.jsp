<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세: 관광지 상세</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	<br><br><br>
	<form action="/storage/insertStorage.tripkase" method="post">
		<input type="hidden" name="contentsCode" value="attraction"> <!-- 보관함으로 넘기기 위한 컨텐츠 분류 코드 -->
		<input type="hidden" name="contentsId"   value="${attr.attrNo}"> <!-- 보관함으로 넘기기 위한 컨텐츠 넘버값 -->
		<div id="detailWrap">
			<div id="attrName">${attr.attrName}</div>
			<div id="attrAddr">${attr.attrAddress}</div>
			
			<!-- 관광지 사진 영역 -->
			<div id="detailImg">
				<div id="leftImg">
					<img alt="" src="../resources/attrUploadFiles/${attrImg[0].attrFileRename}" width="580px" height="435px;">
				</div>
				<div id="rightImgs">
					<div id="rightTop">
						<div id="topLeft">
							<img alt="" src="../resources/attrUploadFiles/${attrImg[1].attrFileRename}" width="300px">
						</div>
						<div id="topRight">
							<img alt="" src="../resources/attrUploadFiles/${attrImg[2].attrFileRename}" width="300px">
						</div>
					</div>
					<div id="rightBottom">
						<div id="bottomLeft">
							<img alt="" src="../resources/attrUploadFiles/${attrImg[3].attrFileRename}" width="300px">
						</div>
						<div id="bottomRight">
							<img alt="" src="../resources/attrUploadFiles/${attrImg[4].attrFileRename}" width="300px">
						</div>
					</div>
				</div>
			</div>
		
			<div id="storeBtn">
				<input type="submit" value="보관하기">		
			</div>
			
			<div id="attrInfo">
				<div class="attrInfo">${attr.attrInfo}</div>
				<div class="attrInfo">${attr.attrTel}</div>
				<div class="attrInfo">${attr.attrWebsite}</div>
				<div class="attrInfo">${attr.attrAddress}</div>
				<div class="attrInfo">${attr.attrHours}</div>
				<div class="attrInfo">${attr.attrFee}</div>
				<div class="attrInfo">${attr.attrCar}</div>
				<div class="attrInfo">${attr.attrPet}</div>
			</div>
		</div>
	</form>
	<br><br><br>
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>