<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세: 공지 상세</title>
<link href="/resources/css/notice.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	<br><br><br><br><br>
	<table id="nDetailTable" align="center">
		<!-- 공지 제목, 작성자, 작성일 보이는 상단 -->
		<tr>
			<td id="nDetailContents1" colspan="2">${notice.noticeTitle}</td>
		</tr>
		<tr id="nDetailContents2">
			<td id="nDetailWriter">${notice.noticeWriter}</td>
			<td>${notice.nCreateDate}</td>
		</tr>
		<tr>
			<td id="bottomLine2" colspan="2"></td>
		</tr>
		<!-- 공지 내용, 사진 보이는 하단 -->
		<tr height="100">
			<td colspan="2">${notice.nContents}</td>
		</tr>
		<tr>
			<td colspan="2" id="nDetailImg">
				<c:forEach items="${nImgList}" var="nImg" varStatus="i">
					<img id="nDetailPic" src="/resources/nUploadFiles/${nImg.nFileRename}" onerror="this.style.display='none'" alt="첨부파일">
				</c:forEach>
			</td>
		</tr>
	</table>
	<!-- 공지 댓글 등록 -->
	<form action="/notice/replyRegister.tripkase" method="post">
		<input type="hidden" name="refNoticeNo" value="${notice.noticeNo}">
		<table id="nReplyRegister" align="center">
			<tr>
				<td id="nReplyRegiTd1">
					<textarea id="nReplyRegiText" type="text" name="nReplyContents"></textarea>
				</td>
			</tr>
			<tr>
				<td id="nReplyRegiTd2">
					<input id="nReplyRegiBtn" type="submit" value="등록">
				</td>
			</tr>
		</table>
	</form>
	<!-- 공지 댓글 목록 -->
	<table id="nReplyList" align="center">
		<c:forEach items="${nReplyList}" var="nReply">
			<tr id="nReplyTop">
				<td id="nReplyWriter">${nReply.nReplyWriter}</td>
				<td>${nReply.nreUpdateDate}</td>
			</tr>
			<tr>
				<td id="nReplyContents" colspan="2">${nReply.nReplyContents}</td>
			</tr>
			<tr>
				<td>
					<a href="#" onclick="">수정</a>
					<a href="#" onclick="">삭제</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<script>
		function modifyView(obj, nReplyContents, nReplyNo){
			event.preventDefault();
			var $tr = $("<tr>");
			$tr.append("<td colspan='2'><input type='text' size='50' value='"+nReplyContents+"'></td>");
			$tr.append("<td><button onclick='modifyReply(this, "+nReplyNo+");'>수정</button></td>");
			$(obj).parent().parent().after($tr);
		}
		
		function modifyReply(obj, nReplyNo) {
			var inputTag = $(obj).parent().prev().children();
			console.log(inputTag.val());
			var nReplyContents = inputTag.val();
			var $form = $("<form>");
			$form.attr("action", "/notice/replyModify.tripkase");
			$form.attr("method", "post");
			$form.append("<input type='hidden' value='"+nReplyContents+"' name='nReplyContents'>");
			$form.append("<input type='hidden' value='"+nReplyNo+"' name='nReplyNo'>");
			console.log($form[0]);
			$form.appendTo("body");
			$form.submit();
		}
	</script>
	<br><br><br><br><br>
</body>
</html>