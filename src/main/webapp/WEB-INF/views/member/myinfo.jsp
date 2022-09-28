<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<meta charset="UTF-8">
<title>마이페이지</title>
<style>
	#fw1 { 
		font-weight: bold;
		width : 150px;
	}
table {
	border-collapse: separate;
	border-spacing: 0 20px;
}
	input type{
		width : 150px;
		align : center;
	}
</style>


</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<br><br>
	<h1 align="center">마이페이지</h1>
	<br><br>
	<div align="center" class="">
		<form  action="/member/modify.tripkase" method="POST">
		<table>
			<tr>
				<td id="fw1"> * 아이디</td>
				<td>
					<input type="text" id="memberId" name="memberId" value="${mOne.memberId }" readonly>
				</td>
			</tr> 
			<tr>
				<td id="fw1"> * 현재 비밀번호</td>
				<td>
					<input type="password" name="memberPwd" value="${mOne.memberPwd }" readonly>
				</td>
			 </tr>
			<tr>
				<td id="fw1"> * 닉네임</td> 
				<td>
					<input type="text" name="memberNick" value="${mOne.memberNick }" readonly>
				</td>
			</tr>
			<tr>
				<td id="fw1"> * 이름</td>
				<td>
					<input type="text" name="memberName" value="${mOne.memberName }" readonly>
				</td>
			</tr>
			<tr>
				<td id="fw1"> * 생년월일</td>
				<td>
					<input type="text" name="memberBd" value="${mOne.memberBd }" readonly>
				</td>
			</tr>
			<tr>
				<td id="fw1"> * 성별</td>
				<td>
					<input type="text" name="memberGender" value="${mOne.memberGender }" readonly>
				</td>
			</tr>
			<tr>
				<td id="fw1"> * 핸드폰번호</td>
				<td>
					<input type="text" name="memberPhone" value="${mOne.memberPhone }" readonly>
				</td>
			</tr>
			<tr>
				<td id="fw1"> * 이메일</td>
				<td>
					<input type="text" name="memberEmail" value="${mOne.memberEmail }" readonly>
				</td>
			</tr>
			<tr>
				<td id="fw1"> * 현재 나의 등급</td>
				<td>
					<input type="text" name="memberGrade" value="${mOne.memberGrade }" readonly>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<br><br>
					<button type="button" class="btn btn-outline-primary" onclick="checkPassword();">수정페이지로 이동</button>
					<button type="button" class="btn btn-outline-primary" onclick="removeMember();">탈퇴하기</button>
				</td>
			</tr>
		</table>
	</form>
	</div>
	<script>
		function removeMember() {
			if(confirm("탈퇴하시겠습니까?")){
			location.href="/member/removeMember.tripkase";
			}
		}
		$("#postcodify_search_button").postcodifyPopUp();
		
		function checkPassword(){
			var goodUrl = "/member/modifyView.tripkase";
			var badUrl = "member/myPage";
			alert("패스워드를 입력해주세요.");
			var password = prompt("password입력");	
			var memberPwd = "${sessionScope.loginMember.memberPwd}";
		
			if(password == memberPwd){
				location.href = goodUrl;
			}else{
				alert("패스워드가 일치하지 않습니다.");
				location.href = badUrl;
			}
		}
	</script>
	<br><br><br><br><br>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="js/bootstrap.min.js"></script>	
<jsp:include page="../common/footer.jsp"/>
</body>
</html>









