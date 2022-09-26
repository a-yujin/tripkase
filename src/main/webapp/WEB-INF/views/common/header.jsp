<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세: Header</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link href="/resources/css/header.css" rel="stylesheet">
<script src="/resources/js/jquery-3.6.1.min.js"></script>
</head>
<body>
	<div id="tk_wrap">
		<ul id="tk_header">
			<li class="tk_h_item" id="tk_logo"><a href="/home.tripkase"><img id="tk_logo_img" alt="여행카세 로고" src="/resources/images/logo_tripkase.png"></a></li>
			<li class="tk_h_item" id="tk_menu1"><a href="#" onclick="tripMenu();">여행</a></li>
			<li class="tk_h_item" id="tk_menu2"><a href="/trip/tripList.tripkase">소통</a></li>
			<li class="tk_h_item" id="tk_menu3"><a href="/notice/list.tripkase">공지</a></li>
			<c:if test="${sessionScope.loginMember eq null }">
		        <div id="login">
		        	<table align="right">
			           <tr>
			              <td class="tk_h_item" id="tk_menu4"><a href="/member/loginView.tripkase"><b>로그인</b></a></td>
			           </tr>
		        	</table>
		        </div>
	        </c:if>
	      	<c:if test="${sessionScope.loginMember ne null }"> <!-- ne : not equal -->
	      		<table align="right">
		        	<tr>
			            <td colspan="2"><b>${sessionScope.loginMember.memberName }</b>님 환영합니다!</td>
			            <td></td>
		        	</tr>
		         	<tr>
		            	<c:if test="${loginMember.adminYN == 'Y' }">
		               		<td><a href="/admin/adminMainPage.tripkase">관리자페이지</a> &nbsp;</td> 
		            	</c:if>
		            	<td><a href="/member/myPage.tripkase">마이페이지</a> &nbsp;</td>
		            	<td><a href="/member/logout.tripkase">로그아웃</a> &nbsp;</td> 
		         	</tr>
	        	</table>
	    	</c:if>
		</ul>
	</div>
	<div id="tripMenu">
		<ul id="trip_menu">
			<li class="menu_item"><a href="#">코스</a></li>		
			<li class="menu_item"><a href="#">관광지</a></li>		
			<li class="menu_item"><a href="/restaurant/restaurantMainPage.tripkase">맛집</a></li>		
			<li class="menu_item"><a href="/room/searchView.tripkase">숙소</a></li>		
		</ul>
	</div>

	<script>
		function tripMenu(){
			if($("#tripMenu").css("display") == "none"){
				$("#tripMenu").show();
			} else{
				$("#tripMenu").hide();
			}
		}
	</script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</body>
</html>