<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<script src="/resources/js/jquery-3.6.1.min.js"></script>
<meta charset="UTF-8">
<title>여행카세 : 회원 상세 조회</title>
	<style>
		.memberDiv{
			float:left;
			padding-left:100px;
			width:600px;
		}
		#memberTable{
			text-align: center;
		}
	</style>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<jsp:include page="../admin/menuBar.jsp"></jsp:include>
	<div class="memberDiv">
		<h2 align="center">회원 상세 조회</h2>
				<table id="memberTable" class="table table-hover" border="1">
					<tr>
						<th width="100px" >아이디</th>
						<td>${member.memberId }</td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td>${member.memberPwd }</td></tr>
					<tr>
						<th>이메일</th>
						<td>${member.memberEmail }</td></tr>
					<tr>
						<th>이름</th>
						<td>${member.memberName }</td></tr>
					<tr>
						<th>닉네임</th>
						<td>${member.memberNick }</td></tr>
					<tr>
						<th>생년월일</th>
						<td>${member.memberBd }</td></tr>
					<tr>
						<th>회원등급</th>
						<td>${member.memberGrade }</td></tr>
					<tr>
						<th>성별</th>
						<td>${member.memberGender }</td></tr>
					<tr>
						<th>번호</th>
						<td>${member.memberPhone }</td></tr>
					<tr>
						<th>회원가입일</th>
						<td>${member.mRegisterDate }</td></tr>
					<tr align="center">
						<td colspan="2">
						<button class="btn btn-default" type="button" onclick="location.href='/admin/modifyMemberView.tripkase?memberId=${member.memberId}&memberName=${member.memberName }'">수정</button>
						<button class="btn btn-default" type="button" onclick="location.href='/admin/deleteMember.tripkase?memberId=${member.memberId}'">삭제</button>
					</td>
				</table>
	</div>
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<jsp:include page="../common/footer.jsp"/>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</body>
</html>