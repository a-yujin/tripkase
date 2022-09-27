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
 <div>
	<h2 align="center">맛집 상세 조회 (관리자)</h2>
		<table align="center" border="1" width="800">
		<tbody>
			<tr>
				<td>가게 이름</td>
				<td>${restaurant.resName }</td>
			</tr>
			<tr>
				<td>주소</td>
				<td>${restaurant.resAddress }</td>
			</tr>
			<tr>
				<td>문의처</td>
				<td>${restaurant.resTel }</td>
			</tr>
			<tr>
				<td>문의처</td>
				<td>${restaurant.resTel }</td>
			</tr>
			<tr>
				<td>휴일</td>
				<td>${restaurant.resDayoff }</td>
			</tr>
			<tr>
				<td>대표메뉴</td>
				<td>${restaurant.resMainmenu }</td>
			</tr>
			<tr>
				<td>상세내용</td>
				<td>${restaurant.resDetail }</td>
			</tr>
			<tr>
				<td>이미지</td>
				<td>
					<c:forEach items="${resImgList}" var="resImg">
						<img src="/resources/resUploadFiles/${resImg.resFileRename}" width="200px" height="200px">				
					</c:forEach>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button class="btn btn-default" type="button" onclick="location.href='/restaurant/modifyRestaurantView.tripkase?resNo=${restaurant.resNo }'">수정</button>
					<button class="btn btn-default" type="button" onclick="location.href='/restaurant/deleteRestaurant.tripkase?resNo=${restaurant.resNo }'">삭제</button>
				</td>
			</tr>
			</tbody>
		</table>
	</div>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</body>
</html>