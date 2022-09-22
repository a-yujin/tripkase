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
        
    .photo {
		   float : left;
	       text-align : center;
	       width : 15%;
	       height : 100%;
		}		

	.image {
            width : 100%;
            height : 100%;
            display : inline-block;
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
	
	
	

	<div id=contents>
		<ul>
			<c:forEach items="${cList }" var="course">
				<hr>
				<li class="courseList">
						<div class="photo">
							<a href="/course/courseDetail.tripkase?courseNo=${course.courseNo }"> 
							<img class="image" src="/resources/cosUploadFiles/${course.courseFileRename }">
							</a>
						</div>
						<div class="textarea">
							<p>${course.courseName }</p>
							<p>${course.courseThema }</p>
						</div>
					<br><br>
				</li><hr>
				<li class="courseList">
						<div class="photo">
							<a href="/course/courseDetail.tripkase?courseNo=${course.courseNo }"> 
							<img class="image" src="/resources/cosUploadFiles/${course.courseFileRename }">
							</a>
						</div>
						<div class="textarea">
							<p>${course.courseName }</p>
							<p>${course.courseThema }</p>
						</div>
					<br><br>
				</li><hr>
						<li class="courseList">
						<div class="photo">
							<a href="/course/courseDetail.tripkase?courseNo=${course.courseNo }"> 
							<img class="image" src="/resources/cosUploadFiles/${course.courseFileRename }">
							</a>
						</div>
						<div class="textarea">
							<p>${course.courseName }</p>
							<p>${course.courseThema }</p>
						</div>
					<br><br>
				</li><hr>
						<li class="courseList">
						<div class="photo">
							<a href="/course/courseDetail.tripkase?courseNo=${course.courseNo }"> 
							<img class="image" src="/resources/cosUploadFiles/${course.courseFileRename }">
							</a>
						</div>
						<div class="textarea">
							<p>${course.courseName }</p>
							<p>${course.courseThema }</p>
						</div>
					<br><br>
				</li><hr>
						<li class="courseList">
						<div class="photo">
							<a href="/course/courseDetail.tripkase?courseNo=${course.courseNo }"> 
							<img class="image" src="/resources/cosUploadFiles/${course.courseFileRename }">
							</a>
						</div>
						<div class="textarea">
							<p>${course.courseName }</p>
							<p>${course.courseThema }</p>
						</div>
					<br><br>
				</li><hr>
			
				
			</c:forEach>
		</ul>
					
				
	</div>
	<script>
		function selectCourse(obj, area) {
			var dd = console.log(obj.nextElementSibling.innerHTML);
		//	document.getElementById("dd").innerHTML=localName;
			location.href='/course/selectCourse.tripkase?locationName='+area;
		}
	</script>

</body>
</html>