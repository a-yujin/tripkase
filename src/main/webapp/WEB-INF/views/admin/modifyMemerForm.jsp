<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행 카세 : 회원 수정</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="/resources/js/jquery-3.6.1.min.js"></script>
<style>
	.memberTable{
		float:left;
		padding-left:100px;
	}
	table{
		width=1000;
	}
</style>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<jsp:include page="../admin/menuBar.jsp"></jsp:include>
	<div class="memberTable">
			<form action="/admin/updateMember.tripkase" method="post">
				<fieldset>
					<legend>회원수정</legend>
					<table class="table table-hover" border="1" align="cnter">
						<tr>
							<th>아이디</th>
							<td><input type="text" name="memberId" value="${member.memberId }"/></td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td><input type="password" name="memberPwd" value="${member.memberPwd }" /></td></tr>
						<tr>
							<th>이메일</th>
							<td><input type="text" name="memberEmail" value="${member.memberEmail }" /></td></tr>
						<tr>
							<th>이름</th>
							<td><input type="text" name="memberName" value="${member.memberName }" /></td></tr>
						<tr>
							<th>닉네임</th>
							<td><input type="text" name="memberNick" value="${member.memberNick }" /></td></tr>
						<tr>
							<th>생년월일</th>
							<td><input type="text" name="memberBd" value="${member.memberBd }" /></td></tr>
						<tr>
							<th>회원등급</th>
							<td><input type="text" name="memberGrade" value="${member.memberGrade }" /></td></tr>
						<tr>
							<th>성별</th>
							<td><input type="text" name="memberGender" value="${member.memberGender }" /></td></tr>
						<tr>
							<th>번호</th>
							<td><input type="text" name="memberPhone" value="${member.memberPhone }" /></td></tr>
						<tr>
							<th>회원가입일</th>
							<td><input type="text" name="mRegisterDate" value="${member.mRegisterDate }" readonly/></td></tr>
						<tr align="center">
							<td colspan="2">
							<button>수정</button>
							<button type="button" onclick="location.href='/admin/deleteMember.tripkase?memberId=${member.memberId}'">삭제</button>
						</td>
					</table>
					<input type="hidden" name="mPfpName" value="${member.mPfpName }" /><br>
					<input type="hidden" name="mPfpReName" value="${member.mPfpReName }" /><br>
					<input type="hidden" name="mPfpPath" value="${member.mPfpPath }" /><br>
				</fieldset>
			</form>
	</div>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</body>
</html>