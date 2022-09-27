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
<body>
	<form action="/storage/insertStorage.tripkase" method="post">
		<input type="hidden" name="contentsCode" value="restaurant"> <!-- 보관함으로 넘기기 위한 컨텐츠 분류 코드 -->
		<input type="hidden" name="contentsId"   value="${restaurant.resNo }"> <!-- 보관함으로 넘기기 위한 컨텐츠 넘버값 -->
		<table align="center" border="1">
			<tr>
				<th>이미지</th>
				<th>맛집이름</th>
				<th>주소</th>
				<th>상세내용</th>
				<th>연락처</th>
				<th>휴일</th>
				<th>대표메뉴</th>
			</tr>
			<tr>
				<td>
					<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
					       <ol class="carousel-indicators">
					           <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
					           <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
					           <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
					       </ol>
					       <div class="carousel-inner">
						       <div class="carousel-item active">
						           <img src="/resources/resUploadFiles/${img.resFileRename }" class="d-block w-100">
						              <div class="carousel-caption d-block">
						                   <h1>First Image</h1>
						               </div>
						        </div>
						        <c:forEach items="${resImgList }" var="img">
							        <div class="carousel-item">
							            <img src="/resources/resUploadFiles/${img.resFileRename }" class="d-block w-100">
							               <div class="carousel-caption d-block">
							                  <h1>Image</h1>
							               </div>
							        </div>
						        </c:forEach>
					        </div>
					        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
					            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
					            <span class="visually-hidden">Previous</span>
					        </a>
					        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
					            <span class="carousel-control-next-icon" aria-hidden="true"></span>
					            <span class="visually-hidden">Next</span>
					        </a>
					  </div>
				</td>
				<td>${restaurant.resName }</td>
				<td>${restaurant.resAddress }</td>
				<td>${restaurant.resDetail }</td>
				<td>${restaurant.resTel }</td>
				<td>${restaurant.resDayoff }</td>
				<td>${restaurant.resMainmenu }</td>
			</tr>		
			<input type="submit" value="보관">
	</form>
	</table>
</body>
</html>