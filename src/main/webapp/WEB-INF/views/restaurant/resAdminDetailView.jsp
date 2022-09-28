<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세 : 맛집 상세조회</title>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<jsp:include page="../common/header.jsp"></jsp:include>
 <jsp:include page="../admin/menuBar.jsp"></jsp:include>
<body>
<script>
</script>
<style>
	.admintable {
		text-align : center;
		width : 80px;
		border : 1px solid black;
	}
	
	.contents {
		text-align : center;
		border : 1px solid black;
		width : 40px;
	}
</style>
 <div>
	<h2 align="center">맛집 상세 조회 (관리자)</h2>
		<table align="center" border="1" width="800">
		<tbody>
			<tr class="admintable">
				<td class="contents">가게 이름</td>
				<td class="contents">${restaurant.resName }</td>
			</tr>
			<tr class="admintable">
				<td  class="contents">주소</td>
				<td>${restaurant.resAddress }</td>
			</tr>
			<tr class="admintable">
				<td class="contents">문의처</td>
				<td class="contents">${restaurant.resTel }</td>
			</tr>
			<tr class="admintable">
				<td class="contents">휴일</td>
				<td class="contents">${restaurant.resDayoff }</td>
			</tr>
			<tr class="admintable">
				<td class="contents">대표메뉴</td>
				<td class="contents">${restaurant.resMainmenu }</td>
			</tr>
			<tr>
				<td class="contents">상세내용</td>
				<td class="contents">${restaurant.resDetail }</td>
			</tr>
			<tr class="admintable">
				<td class="contents">이미지</td>
				<td class="contents">
					<c:forEach items="${resImgList}" var="resImg">
						<img src="/resources/resUploadFiles/${resImg.resFileRename}" width="200px" height="200px">				
					</c:forEach>
				</td>
			</tr>
			<tr>
				<td  class="contents" colspan="2" align="center">
					<button class="btn btn-default" type="button" onclick="location.href='/restaurant/modifyRestaurantView.tripkase?resNo=${restaurant.resNo }'">수정</button>
					<button class="btn btn-default" type="button" onclick="location.href='/restaurant/deleteRestaurant.tripkase?resNo=${restaurant.resNo }'">삭제</button>
				</td>
			</tr>
			</tbody>
		</table>
	</div>
<jsp:include page="../common/footer.jsp"/>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</body>
</html>