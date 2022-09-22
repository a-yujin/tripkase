<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>여행카세 : 보관함</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100&display=swap" rel="stylesheet">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
</head>
<style>
	body {
        font-family : 'Noto Sans KR',sans-serif;
    }

    #storagetitle {
        height: 80px;
    }
    
    .contents-area {
        height: 250px;
    }

    .contents-type {
        height: 50px;
    }

    .contents-contents {
        float : left;
        height: 250px;
        width: 200px;
    }

    .contents-img {
        display: block;
        margin: auto;
        border-radius: 20px;
    }

    p.contents-name {
        margin-bottom: 0 auto;
        text-align: left;
    }
    
    a.contents-btn {
    	float : left;
    }

</style>
<body>

    <div id="storagetitle">
        <h2>나의 보관함</h2>
    </div>
    <c:if test="${!empty resList }">
   		<div class="contents-type">　　#관광지</div>
   			<c:forEach items="${stoList }" var="attraction" varStatus="i">
	        <div class="contents-area">
	            <div class="contents-contents">
	                <img src="#" class="contents-img" width="150px" height="150px">
	                <p class="contents-name">${stoList.attrName}</p>
	                <a href="#" class="contents-btn">추가</a>
	                <a href="#" class="contents-btn">삭제</a>
	            </div>
	        </div>
	        </c:forEach>
	    </div>
	</c:if>
    <br>
    <div class="contents-type">　　#맛집</div>
        <c:forEach items="${stoList }" var="attraction" varStatus="i">
	        <div class="contents-area">
	            <div class="contents-contents">
	                <img src="#" class="contents-img" width="150px" height="150px">
	                <p class="contents-name">${stoList.resName }</p>
	                <a href="#" class="contents-btn">추가</a>
	                <a href="#" class="contents-btn">삭제</a>
	            </div>
	        </div>
	     </c:forEach>
    </div>
    <br>
    <div class="contents-type">　　#숙소</div>
        <c:forEach items="${stoList }" var="attraction" varStatus="i">
	        <div class="contents-area">
	            <div class="contents-contents">
	                <img src="#" class="contents-img" width="150px" height="150px">
	                <p class="contents-name">${stoList.roomName}</p>
	                <a href="#" class="contents-btn">추가</a>
	                <a href="#" class="contents-btn">삭제</a>
	            </div>
	        </div>
	     </c:forEach>
    </div>   
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>