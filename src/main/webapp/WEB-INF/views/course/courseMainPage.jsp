<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세 : 코스 메인페이지 </title>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">

<style>
 input[type=radio]{
            background-color: #FFFF;
            -webkit-appearance: none;
            -moz-appearance: none;
            margin-left: 16px;
            border: 1px solid rgb(216, 216, 216);
            width: 14px;
            height: 14px;
            border-radius: 100%;
        }
        
    input[type=radio]:checked{
            background-color: rgb(25, 118, 248);
            -webkit-appearance: none;
            -moz-appearance: none;
            margin-left: 16px;
            border: none;
            width: 14px;
            height: 14px;
            border-radius: 100%;
        }
    #contents {
    	width : 1000px;
    	margin : 0 auto;
    }
    .image-box {
		   float : left;
	       text-align : center;
	       width : 30%;
	       height : 100%;
	       overflow:hidden;
		}		

	.imagee {
            width : 100%;
            height : 100%;
            display : table-cell;
            object-fit:cover;
            
        }
        
   .textarea{
   			  float : center;
   			  text-align : left;
		      width : 70%;
		      height : 100%;
		      margin-left : 300px;
 		 }     
 	.courseList{
 			height : 150px;
 			list-style : none;
 			padding-bottom : 30px; 
 			padding-top : 0px;
 			border-bottom : 1px solid;
 	}
 	
 	.hrs{
 		color : black;
 	}
  
</style>


</head>
<link href="../resources/css/.css" rel="stylesheet">
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<br>
	<h2 align="center"><b>#지역</b></h2>
		<div align="center">
			<div id="select-area" class="btn-group" role="group" aria-label="Basic radio toggle button group">
				<input type="radio"   class="btn-check" id="cosArea1" 	onclick="selectCourse(this, 'all');" checked value=""> 		<label class="btn btn-outline-primary" for="cosArea1">전체보기</label>
				<input type="radio"   class="btn-check" id="cosArea2" 	onclick="selectCourse(this, 'seoul');"> 	<label class="btn btn-outline-primary" for="cosArea2">서울</label>
				<input type="radio"   class="btn-check" id="cosArea3" 	onclick="selectCourse(this, 'gyeonggi');">	<label class="btn btn-outline-primary" for="cosArea3">경기</label>
				<input type="radio"   class="btn-check" id="cosArea4" 	onclick="selectCourse(this, 'incheon');"> 	<label class="btn btn-outline-primary" for="cosArea4">인천</label>
				<input type="radio"   class="btn-check" id="cosArea5" 	onclick="selectCourse(this, 'kangwon');">	<label class="btn btn-outline-primary" for="cosArea5">강원</label>
				<input type="radio"   class="btn-check" id="cosArea6" 	onclick="selectCourse(this, 'chungbuk');"> 	<label class="btn btn-outline-primary" for="cosArea6">충청북도</label>
				<input type="radio"   class="btn-check" id="cosArea7" 	onclick="selectCourse(this, 'chungnam');"> 	<label class="btn btn-outline-primary" for="cosArea7">충청남도</label>
				<input type="radio"   class="btn-check" id="cosArea8" 	onclick="selectCourse(this, 'gyeongbuk');"> <label class="btn btn-outline-primary" for="cosArea8">경상북도</label>
				<input type="radio"   class="btn-check" id="cosArea9" 	onclick="selectCourse(this, 'gyeongnam');"> <label class="btn btn-outline-primary" for="cosArea9">경상남도</label>
				<input type="radio"   class="btn-check" id="cosArea10" 	onclick="selectCourse(this, 'jeonbuk');"> 	<label class="btn btn-outline-primary" for="cosArea10">전라북도</label>
				<input type="radio"   class="btn-check" id="cosArea11" 	onclick="selectCourse(this, 'jeonnam');"> 	<label class="btn btn-outline-primary" for="cosArea11">전라남도</label>
				<input type="radio"   class="btn-check" id="cosArea12" 	onclick="selectCourse(this, 'jeju');"> 		<label class="btn btn-outline-primary" for="cosArea12">제주</label>
			</div>
		</div>
	<br><br><br>
	<h3 align="center"><b>#${locationValue }</b></h3>
	<br>
	<div id=contents align="center">
		<ul>
			<c:forEach items="${cmList }" var="courseMain">
				<hr class="hrs">
				<li class="courseList" >
						<div class="image-box" >
							<a href="/course/courseDetail.tripkase?courseNo=${courseMain.courseNo }"> 
							<img class="imagee" src="/resources/cosUploadFiles/${courseMain.cFileRename }">
							</a>
						</div>
						<div class="textarea">
							<br>
							<span>여행 이름 : ${courseMain.courseName }</span>
							<br><br><br>
							<span>여행 테마 : ${courseMain.courseThema }</span>
					</div>	
				
				</li>
			</c:forEach>
		</ul>
				
	</div>
	<script>
		function selectCourse(obj, area) {
			var value = obj.nextElementSibling.innerHTML;
			//document.getElementById("localName").innerHTML=value;
			location.href='/course/selectCourse.tripkase?locationName='+area+"&locationValue="+value;
		}
	</script>
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>