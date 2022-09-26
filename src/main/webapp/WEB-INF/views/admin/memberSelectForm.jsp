<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세 : 회원 검색</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<style>
		.memberSearch{
			float:left;
			padding-left:100px;
		}
		label{
			display:inline-block;
			width:50px;
		}
		.button{
			text-align:center;
		}
	</style>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<jsp:include page="../admin/menuBar.jsp"></jsp:include>
	<div class="memberSearch">
		<form action="/admin/memberOne.tripkase">
			<fieldset>
				<legend>개별 회원 조회</legend>
					<div class="form-group">
						<label for="memberId">아이디</label>
						<input type="text" name="memberId" id="memberId" placeholder="아이디를 입력해주세요"/>
					</div>
					<div class="form-group">
						<label for="memberName">이름</label>
						<input type="text" name="memberName" id="memberName" placeholder="이름을 입력해주세요"/><br><br>
					</div>
					<div class="button">
					<button type="submit" class="btn btn-default">검색</button>
					</div>
			</fieldset>
		</form>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	</div>
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<jsp:include page="../common/footer.jsp"/>
</body>
</html>