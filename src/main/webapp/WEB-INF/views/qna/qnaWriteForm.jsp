<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" />
<title>여행카세 : 질문 등록</title>
	<style>
		body{
			padding:20px;
		}
		h1{
			padding-left: 100px; 
		}
		#qnaForm{
			margin: auto;
			width: 800px;
			padding-left: 100px;
		}
	</style>
	
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<br>
	<div id="qnaForm">
		<h3>질문유형</h3>
		<form action="/qna/RegisterQna.tripkase" method="post">
					코스 <input type="radio" name="questionType" value="course"/> &nbsp;
					관광지 <input type="radio" name="questionType" value="attr"/> &nbsp;
					맛집 <input type="radio" name="questionType" value="res"/> &nbsp;
					숙소 <input type="radio" name="questionType" value="room"/> &nbsp;
					기타 <input type="radio" name="questionType" value="other"/>
					<br><br>
			<table class="table">
				<tr>
					<td>제목</td>
				</tr>
				<tr>
					<td><input size="80" type="text" name="questionTitle" placeholder="제목을 입력해주세요" required="required"/></td>
				</tr>
				<tr>
					<td>내용</td>
				</tr>
				<tr>
					<td><textarea cols="82" rows="15" name="qContents" placeholder="내용을 입력해주세요" required="required"></textarea></td>
				</tr>
				<tr>
					<td><input type="file" name="uploadFile"/></td>
				</tr>
				<tr align="center">
					<td >
						<button class="btn btn-dark" type="submit">등록</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<br>
<jsp:include page="../common/footer.jsp"/>
</body>
</html>