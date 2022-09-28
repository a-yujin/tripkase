<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>여행카세 : 보관함</title>
    <link href="../resources/css/storage.css" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100&display=swap" rel="stylesheet">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<script src="/resources/js/jquery-3.6.1.min.js"></script>
</head>
<body>
    <jsp:include page="../common/header.jsp"/>
    <div id="storagetitle">
        <h2>나의 보관함</h2>
    </div>
   	<div class="contents-type">　　#관광지</div><br>
   	<div class="contents-box">
		<c:if test="${!empty attrDataList }">
         <c:forEach items="${attrDataList }" var="attraction">
	            <div class="contents-contents">
	                <img src="/resources/attrUploadFiles/${attraction.attrFileRename }" class="contents-img" width="150px" height="150px">
                    	<div id="choice-drop" class="btn-group dropstart">
							<button type="button" class="FAB-btn" id="choiceBt" data-bs-toggle="dropdown" aria-expanded="false">
								<img class="fab-btn-img" src="/resources/images/storage/fab.png">
							</button>
							<ul id="choice-menu" class="dropdown-menu">
								<li>
									<a id="choice-menu1" class="dropdown-item" onclick="location.href='/storage/deleteStorage.tripkase?stoNo=${attraction.stoNo}';"><img src="/resources/images/storage/trash.png" width="20px" height="20px">   보관 삭제</a>
								</li>
								<li>
									<a id="choice-menu2" class="dropdown-item" onclick="choiceSchedule('${attraction.contentsCode}',${attraction.contentsNo});"><img src="/resources/images/storage/calendar.png" width="20px" height="20px">   일정 추가</a>
								</li>
							</ul>
						</div>
	                <p class="contents-name">${attraction.attrName}</p>
	            </div>
	       </c:forEach>
	      </c:if>
	 	<c:if test="${empty attrDataList }">
	 			<div class="contents-contents">
					추가된 관광지가 없습니다.
				</div>
	 	</c:if>
 	</div>
    <br>
    <br>
    
    <div class="contents-type">　　#맛집</div><br>
    <div class="contents-box">
     <c:if test="${!empty resDataList }">
        <c:forEach items="${resDataList }" var="restaurant">
	            <div class="contents-contents">
	                <img src="/resources/resUploadFiles/${restaurant.resFileRename }" class="contents-img" width="150px" height="150px">
                    	<div id="choice-drop" class="btn-group dropstart">
							<button type="button" class="FAB-btn" id="choiceBt" data-bs-toggle="dropdown" aria-expanded="false">
								<img class="fab-btn-img" src="/resources/images/storage/fab.png">
							</button>
							<ul id="choice-menu" class="dropdown-menu">
								<li>
									<a id="choice-menu1" class="dropdown-item" onclick="location.href='/storage/deleteStorage.tripkase?stoNo=${restaurant.stoNo}';"><img src="/resources/images/storage/trash.png" width="20px" height="20px">   보관 삭제</a>
								</li>
								<li>
									<a id="choice-menu2" class="dropdown-item" onclick="choiceSchedule('${restaurant.contentsCode}',${restaurant.contentsNo})"><img src="/resources/images/storage/calendar.png" width="21px" height="21px">   일정 추가</a>
								</li>
							</ul>
						</div>
	                <p class="contents-name">${restaurant.resName}</p>
	            </div>
	     </c:forEach>
	  </c:if>
 	<c:if test="${empty resDataList }">
			<div class="contents-contents">
				추가된 맛집이 없습니다.
			</div>
	</c:if>
	</div>
    <br>
    <br>
    
    <div class="contents-type">　　#숙소</div><br>
    <div class="contents-box">
     <c:if test="${!empty roomDataList }">
        <c:forEach items="${roomDataList }" var="room">
	            <div class="contents-contents">
	                <img src="/resources/ruploadFiles/${room.roomFileRename }" class="contents-img" width="150px" height="150px">
                        <div id="choice-drop" class="btn-group dropstart">
							<button type="button" class="FAB-btn" id="choiceBt" data-bs-toggle="dropdown" aria-expanded="false">
								<img class="fab-btn-img" src="/resources/images/storage/fab.png">
							</button>
							<ul id="choice-menu" class="dropdown-menu">
								<li>
									<a id="choice-menu1" class="dropdown-item" onclick="location.href='/storage/deleteStorage.tripkase?stoNo=${room.stoNo}';"><img src="/resources/images/storage/trash.png" width="20px" height="20px">   보관 삭제</a>
								</li>
								<li>
									<a id="choice-menu2" class="dropdown-item" onclick="choiceSchedule('${room.contentsCode}',${room.contentsNo})"><img src="/resources/images/storage/calendar.png" width="25px" height="25px">   일정 추가</a>
								</li>
							</ul>
						</div>
	                <p class="contents-name">${room.roomName}</p>
	            </div>
	     </c:forEach>
	  </c:if>
	<c:if test="${empty roomDataList }">
			<div class="contents-contents">
				추가된 숙소가 없습니다.
			</div>
	</c:if>
	</div>
	<jsp:include page="../common/footer.jsp"/>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous">
</script>
<script>
	function choiceSchedule(contentsCode, contentsNo) {
		console.log(contentsCode);
		console.log(contentsNo);
		window.open("/schedule/choiceSchedule.tripkase?contentsType="+contentsCode+"&contentsNo="+contentsNo,"_blank","width=900px,height=900px");
	}
</script>
</body>
</html>