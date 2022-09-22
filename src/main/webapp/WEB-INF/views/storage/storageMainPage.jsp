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
    <div class="contents-type">　　#관광지</div>
        <div class="contents-area">
            <div class="contents-contents">
                <img src="/resources/resUploadFiles/20220921134942.jpg" class="contents-img" width="150px" height="150px">
                <p class="contents-name">{$trip.tripName}</p>
                <a href="#" class="contents-btn">추가</a>
                <a href="#" class="contents-btn">삭제</a>
            </div>
        </div>
    </div>
    <br>
    <div class="contents-type">　　#맛집</div>
        <div class="contents-area">
            <div class="contents-contents">
            	<img src="/resources/resUploadFiles/20220921134942.jpg" class="contents-img" width="150px" height="150px">
            	<p>{$restaurant.resName}</p>
                <a href="#" class="contents-btn">추가</a>
                <a href="#" class="contents-btn">삭제</a>
            </div>
        </div>
    </div>
    <br>
    <div class="contents-type">　　#숙소</div>
        <div class="contents-area">
            <div class="contents-contents">
            	<img src="/resources/resUploadFiles/20220921134942.jpg" class="contents-img" width="150px" height="150px">
            	<p>{$room.roomName}</p>
            	<a href="#" class="contents-btn">추가</a>
                <a href="#" class="contents-btn">삭제</a>
            </div>
        </div>
    </div>   
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>