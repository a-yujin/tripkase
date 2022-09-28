<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세: 공지 목록</title>
<link href="/resources/css/notice.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	<br><br><br>
	<table id="nListTable" align="center">
		<!-- 공지 목록에 데이터가 있을 때 -->
		<c:if test="${!empty nList}">
			<c:forEach items="${nList}" var="notice" varStatus="i">
				<c:if test="${sessionScope.loginMember ne null}">
					<tr height="20">
						<td id="nListContents1" colspan="2"><a href="/notice/detail.tripkase?noticeNo=${notice.noticeNo}">${notice.noticeTitle}</a></td>
					</tr>
				</c:if>
				<c:if test="${sessionScope.loginMember eq null}">
					<tr height="20">
						<td id="nListContents1" colspan="2"><a onclick="alertLogin();">${notice.noticeTitle}</a></td>
					</tr>
				</c:if>
				<tr id="nListContents2" height="20">
					<td id="nListDate"><fmt:formatDate pattern="yyyy.MM.dd" value="${notice.nCreateDate}"/></td>
					<td>${notice.noticeWriter}</td>
				</tr>
				<tr>
					<td class="bottomLine" colspan="2"></td>
				</tr>
			</c:forEach>
			<!-- 페이징 처리 -->
			<tr align="center" height="20">
				<td id="nListPage" colspan="2">
					<!-- 현재 페이지가 첫번째 페이지가 아니면 이전 페이지로 이동 버튼 생성 -->
					<c:if test="${currentPage != 1}">
						<a id="nListPrev" href="/notice/${urlVal}.tripkase?page=${currentPage - 1}">이전</a>
					</c:if>
					<c:forEach var="p" begin="${startNavi}" end="${endNavi}">
						<!-- 페이지 번호가 현재 페이지와 같으면 볼드체로 표시 -->
						<c:if test="${currentPage eq p}">
							<b id="nListCurrent">${p}</b>
						</c:if>
						<!-- 페이지 번호가 현재 페이지와 다르면 해당 페이지로 이동 링크 처리 -->
						<c:if test="${currentPage ne p}">
							<a id="nListOther" href="/notice/${urlVal}.tripkase?page=${p}">${p}</a>
						</c:if>
					</c:forEach>
					<!-- 마지막 페이지 번호가 현재 페이지보다 크면 다음 페이지로 버튼 생성 -->
					<c:if test="${maxPage > currentPage}">
						<a id="nListNext" href="/notice/${urlVal}.tripkase?page=${currentPage + 1}">다음</a>
					</c:if>
				</td>
			</tr>
		</c:if>
		<!--  공지 목록에 데이터가 없을 때 -->
		<c:if test="${empty nList}">
			<tr>
				<td colspan="3" align="center"><b>데이터가 존재하지 않습니다.</b></td>
			</tr>
		</c:if>
	</table>
	<script>
		function alertLogin(){
			alert("회원만 볼 수 있는 게시물입니다.");
		}
	</script>
	<br><br><br>
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>