<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세 : 여행일정</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100&display=swap" rel="stylesheet">
<script src="/resources/js/jquery-3.6.1.min.js"></script>
	<style>	
	body{
		font-family: 'Noto Sans KR', sans-serif;
	}
    #scheduleReg{
        width:600px;
        margin:auto;
        border:1px solid;
        margin-top:100px;
        padding-top:30px;
    }
    #btnSubmit{
        width:100px;
        margin:auto;
        display:block;
    }
    #schedule{
    	border:1px solid;
    	margin:30px;
    }
    #calendar{
    	display:none;
    	padding-left:15px;
    	border:1px solid;
    	margin:30px auto;
    	padding:30px;
    	width:300px;
    	
	}
	#CalendarBtn{
		width:100px;
		height:50px;
        margin:auto;
	}	
	</style>
	
</head>
<body>
		<div id="scheduleReg">
			<button id="btnSubmit" type="button" class="btn btn-default" onclick="showCalendar();">일정 등록</button>
			<br>
			<div id="calendar">
				<form action="/schedule/RegisteSchedule.tripkase">
					<div></div>
					제목<br>
					<input size="28" type="text" name="scheduleName" placeholder="일정 제목을 입력해주세요."/><br><br>
					일정<br>
					<input type="date" name="scheduleStart"/><input type="date" name="scheduleEnd"/><br><br>
					<div id="CalendarBtn">
					<button type="submit" onclick="return confirm('일정을 등록하시겠습니까?');">확인</button>
					<button type="button" onclick="hideCalendar();">닫기</button>
					</div>
				</form>
			</div>
				<c:forEach items="${sList }" var="schedule" varStatus="i">
					<form action="/schedule/insertSchedule.tripkase">
						<div id="schedule" style="cursor : pointer">
							${schedule.scheduleName } ${schedule.scheduleDays }<br>
							${schedule.scheduleStart }~${schedule.scheduleEnd }<br>
							<button onclick="">일정에 넣기</button>
						</div>
						<input type="hidden" name="contentsType" value="${contentsType}">
						<input type="hidden" name="contentsNo" value="${contentsNo}">
						<input type="hidden" name="scheduleSeq" value="${schedule.scheduleSeq}">
						<input type="hidden" name="scheduleDays" value="${schedule.scheduleDays}">
					</form>
				</c:forEach>
		</div>
	

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script>
	function showCalendar(){
		$("#calendar").show();
	}
	function hideCalendar(){
		$("#calendar").hide();
	}
	function cls(){
		alert("일정에 추가 되었습니다.");
		window.close();
	}
</script>
</body>
</html>