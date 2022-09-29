<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세: 관광지 상세</title>
<link href="/resources/css/attraction.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	<br><br><br>
	<form action="/storage/insertStorage.tripkase" method="post">
		<input type="hidden" name="contentsCode" value="attraction"> <!-- 보관함으로 넘기기 위한 컨텐츠 분류 코드 -->
		<input type="hidden" name="contentsId"   value="${attr.attrNo}"> <!-- 보관함으로 넘기기 위한 컨텐츠 넘버값 -->
		<table class="attrDetailTbl" align="center" width="1000px">
			<tbody>
				<tr>
					<td class="attrName2" colspan="3">${attr.attrName}</td>
				</tr>
				<tr>
					<td class="attrAddr2" colspan="3">${attr.attrAddress}</td>
				</tr>
				<tr>
					<td colspan="3"><hr class="invisiblehr"></td>
				</tr>
				<tr>
					<td class="leftImg" rowspan="2"><img alt="" src="../resources/attrUploadFiles/${attrImg[0].attrFileRename}" width="500px" height="500px;"></td>
					<td class="topLeft"><img alt="" src="../resources/attrUploadFiles/${attrImg[1].attrFileRename}" width="240px" height="240px;"></td>
					<td class="topRight"><img alt="" src="../resources/attrUploadFiles/${attrImg[2].attrFileRename}" width="240px" height="240px;"></td>
				</tr>
				<tr>
					<td><img class="bottomLeft" alt="" src="../resources/attrUploadFiles/${attrImg[3].attrFileRename}" width="240px" height="240px;"></td>
					<td><img class="bottomRight" alt="" src="../resources/attrUploadFiles/${attrImg[4].attrFileRename}" width="240px" height="240px;"></td>
				</tr>
				<tr>
					<td colspan="3"><hr class="invisiblehr"></td>
				</tr>
				<tr>
					<td class="storeBtn" colspan="3"><input type="submit" value="보관하기"></td>
				</tr>
				<tr>
					<td colspan="3"><hr></td>
				</tr>
				<tr>
					<td class="attrInfo2" colspan="3">${attr.attrInfo}</td>
				</tr>
				<tr>
					<td colspan="3"><hr class="invisiblehr"></td>
				</tr>
				<tr>
					<td class="info-items front-item">문의 및 안내</td>
					<td class="info-items" colspan="2">${attr.attrTel}</td>
				</tr>
				<tr>
					<td class="info-items front-item">홈페이지</td>
					<td class="info-items" colspan="2">${attr.attrWebsite}</td>
				</tr>
				<tr>
					<td class="info-items front-item">주소</td>
					<td class="info-items" colspan="2">${attr.attrAddress}</td>
				</tr>
				<tr>
					<td class="info-items front-item">이용 시간</td>
					<td class="info-items" colspan="2">${attr.attrHours}</td>
				</tr>
				<tr>
					<td class="info-items front-item">입장료</td>
					<td class="info-items" colspan="2">${attr.attrFee}</td>
				</tr>
				<tr>
					<td class="info-items front-item">주차</td>
					<td class="info-items" colspan="2">${attr.attrCar}</td>
				</tr>
				<tr>
					<td class="info-items front-item">반려동물 동반</td>
					<td class="info-items" colspan="2">${attr.attrPet}</td>
				</tr>
				<tr>
					<td colspan="3"><hr></td>
				</tr>
				<tr>
					<td colspan="3"><img alt="관광지 이미지" src="../resources/attrUploadFiles/${attrImg[0].attrFileRename}" width="990px" class="attr-images"></td>
				</tr>
				<tr>
					<td colspan="3"><hr class="invisiblehr"></td>
				</tr>
				<tr>
					<td colspan="3"><img alt="관광지 이미지" src="../resources/attrUploadFiles/${attrImg[1].attrFileRename}" width="990px" class="attr-images"></td>
				</tr>
				<tr>
					<td colspan="3"><hr class="invisiblehr"></td>
				</tr>
				<tr>
					<td colspan="3"><img alt="관광지 이미지" src="../resources/attrUploadFiles/${attrImg[2].attrFileRename}" width="990px" class="attr-images"></td>
				</tr>
				<tr>
					<td colspan="3"><hr class="invisiblehr"></td>
				</tr>
				<tr>
					<td colspan="3"><img alt="관광지 이미지" src="../resources/attrUploadFiles/${attrImg[3].attrFileRename}" width="990px" class="attr-images"></td>
				</tr>
				<tr>
					<td colspan="3"><hr class="invisiblehr"></td>
				</tr>
				<tr>
					<td colspan="3"><img alt="관광지 이미지" src="../resources/attrUploadFiles/${attrImg[4].attrFileRename}" width="990px" class="attr-images"></td>
				</tr>
			</tbody>
		</table>
	</form>
	<br><br><br>
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>