<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form action="/admin/updateMember.tripkase" method="post">
			아이디 <input type="text" name="memberId" value="${member.memberId }"/><br>
			비밀번호 <input type="password" name="memberPwd" value="${member.memberPwd }" /><br>
			이메일 <input type="text" name="memberEmail" value="${member.memberEmail }" /><br>
			이름 <input type="text" name="memberName" value="${member.memberName }" /><br>
			닉네임 <input type="text" name="memberNick" value="${member.memberNick }" /><br>
			생년월일 <input type="text" name="memberBd" value="${member.memberBd }" /><br>
			회원등급 <input type="text" name="memberGrade" value="${member.memberGrade }" /><br>
			성별 <input type="text" name="memberGender" value="${member.memberGender }" /><br>
			번호 <input type="text" name="memberPhone" value="${member.memberPhone }" /><br>
			회원가입일 <input type="text" name="mRegisterDate" value="${member.mRegisterDate }" /><br>
			<input type="hidden" name="mPfpName" value="${member.mPfpName }" /><br>
			<input type="hidden" name="mPfpReName" value="${member.mPfpReName }" /><br>
			<input type="hidden" name="mPfpPath" value="${member.mPfpPath }" /><br>
			<button>수정</button>
		</form>
		<form action="/admin/deleteMember.tripkase'">
			<input type="hidden" name="memberId" value="${member.memberId }"/><br>
			<button>삭제</button>
		</form>
</body>
</html>