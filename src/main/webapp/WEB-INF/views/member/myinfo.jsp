<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<style>
	#fw1 { font-weight: bold;}
	#btn1 {
  color: white;
  line-height: 35px;
  text-align: center;
  background: #1287ed;
  border: solid 2px #1287ed;
  border-top-left-radius: 5px;
  border-top-right-radius: 5px;
  border-bottom-left-radius: 5px;
  border-bottom-right-radius: 5px;
}

	#btn2 {
  color: white;
  line-height: 35px;
  text-align: center;
  background: #fa4f4f;
  border: solid 2px #fa4f4f;
  border-top-left-radius: 5px;
  border-top-right-radius: 5px;
  border-bottom-left-radius: 5px;
  border-bottom-right-radius: 5px;
}
	
table {
	border-collapse: separate;
	border-spacing: 0 20px;
}
</style>


</head>
<body>
	<h1 align="center">마이페이지</h1>
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
					<button type="button" onclick="checkPassword();" id="btn1" >수정페이지로 이동</button>
					<button type="button" onclick="removeMember();" id="btn2">탈퇴하기</button>
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
</body>
</html>









