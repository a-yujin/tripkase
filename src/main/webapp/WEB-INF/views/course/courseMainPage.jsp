<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세 : 코스 메인페이지 </title>

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
        
    .image-box {
		   float : left;
	       text-align : center;
	       width : 15%;
	       height : 100%;
	       overflow:hidden;
    		margin:0 auto;
    		
    		
		}		

	.image {
            width : 100%;
            height : 100%;
            display : table-cell;
            object-fit:cover;
            
        }
        
   .textarea{
   			  float : center;
		      width : 85%;
		      height : 100%;
 		 }     
 	.courseList{
 			height : 150px;
 	}
  
</style>


</head>
<link href="../resources/css/.css" rel="stylesheet">
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<h2><b>#지역</b></h2>
	 	<label class="box-radio-input">
		<input type="radio"   id="cosArea1" 	onclick="selectCourse(this, 'all');"> <span>전체보기</span>
		<input type="radio"   id="cosArea2" 	onclick="selectCourse(this, 'seoul');"> <span>서울</span>
		<input type="radio"   id="cosArea3" 	onclick="selectCourse(this, 'gyeonggi');"> <span>경기</span>
		<input type="radio"   id="cosArea4" 	onclick="selectCourse(this, 'incheon');"> <span>인천</span>
		<input type="radio"   id="cosArea5" 	onclick="selectCourse(this, 'kangwon');"> <span>강원</span>
		<input type="radio"   id="cosArea6" 	onclick="selectCourse(this, 'chungbuk');"> <span>충청북도</span>
		<input type="radio"   id="cosArea7" 	onclick="selectCourse(this, 'chungnam');"> <span>충청남도</span>
		<input type="radio"   id="cosArea8" 	onclick="selectCourse(this, 'gyeongbuk');"> <span>경상북도</span>
		<input type="radio"   id="cosArea9" 	onclick="selectCourse(this, 'gyeongnam');"> <span>경상남도</span>
		<input type="radio"   id="cosArea10" 	onclick="selectCourse(this, 'jeonbuk');"> <span>전라북도</span>
		<input type="radio"   id="cosArea11" 	onclick="selectCourse(this, 'jeonnam');"> <span>전라남도</span>
		<input type="radio"   id="cosArea12" 	onclick="selectCourse(this, 'jeju');"> <span>제주</span>
		</label>
	
	
	<h3><b>#${locationValue }</b></h3>

	<div id=contents>
		<ul>
			<c:forEach items="${cmList }" var="courseMain">
				<hr>
				<li class="courseList">
						<div class="image-box">
							<a href="/course/courseDetail.tripkase?courseNo=${courseMain.courseNo }"> 
							<img class="image" src="/resources/cosUploadFiles/'20220921145739.PNG">
							</a>
						</div>
						<div class="textarea">
							<br>
							<span>여행 이름 : ${courseMain.courseName }</span>
							<br><br><br>
							<span>여행 테마 : ${courseMain.courseThema }</span>
					</div>	
					<br><br>
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

</body>
</html>