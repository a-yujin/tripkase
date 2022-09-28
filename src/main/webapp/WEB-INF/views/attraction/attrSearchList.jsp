<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행카세: 관광지 검색 결과</title>
<link href="/resources/css/attraction.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	<br><br><br>
	<table align="center" width="700px" height="200px">
		<c:if test="${!empty attrList}">
			<c:forEach items="${attrList}" var="attrList" varStatus="i">
				<c:if test="${sessionScope.loginMember ne null}">
					<tbody onclick="location.href='/attraction/detail.tripkase?attrNo=${attrList.attrNo}&page=${currentPage}'" class="attrBody">
						<tr>
							<td class="oneImg" rowspan="4"><img src="/resources/attrUploadFiles/${attrList.attrFileRename}"></td>
						</tr>
						<tr>
							<td class="attrName">${attrList.attrName}</td>
						</tr>
						<tr>
							<td class="attrAddr">${attrList.attrAddress}</td>
						</tr>
						<tr>
							<td class="attrSInfo">${attrList.attrShortInfo}</td>
						</tr>
						<tr>
							<td class="bottomLine" colspan="2"></td>
						</tr>
					</tbody>
				</c:if>
				<c:if test="${sessionScope.loginMember eq null}">
					<tbody onclick="alertLogin();" class="attrBody">
						<tr>
							<td class="oneImg" rowspan="4"><img src="/resources/attrUploadFiles/${attrList.attrFileRename}" width="150" height="150"></td>
						</tr>
						<tr>
							<td class="attrName">${attrList.attrName}</td>
						</tr>
						<tr>
							<td class="attrAddr">${attrList.attrAddress}</td>
						</tr>
						<tr>
							<td class="attrSInfo">${attrList.attrShortInfo}</td>
						</tr>
						<tr>
							<td class="bottomLine" colspan="2"></td>
						</tr>
					</tbody>
				</c:if>
			</c:forEach>
		</c:if>
		<c:if test="${empty attrList}">
			<tr>
				<td>검색 결과가 없습니다.</td>
			</tr>
		</c:if>
		<tr align="center" height="20">
			<td class="attrPage" colspan="2">
				<!-- 현재 페이지가 첫번째 페이지가 아니면 이전 페이지로 이동 버튼 생성 -->
				<c:if test="${currentPage != 1}">
					<a class="prevBtn" href="/attraction/${urlVal}.tripkase?page=${currentPage - 1}&searchValue=${searchValue}&areaValue=${areaValue}
						<c:forEach items="${typeValue}" var="list">&typeValue=${list}</c:forEach>">이전</a>
				</c:if>
				<c:forEach var="p" begin="${startNavi}" end="${endNavi}">
					<!-- 페이지 번호가 현재 페이지와 같으면 볼드체로 표시 -->
					<c:if test="${currentPage eq p}">
						<b class="attrCurrent">${p}</b>
					</c:if>
					<!-- 페이지 번호가 현재 페이지와 다르면 해당 페이지로 이동 링크 처리 -->
					<c:if test="${currentPage ne p}">
						<a class="otherPage" href="/attraction/${urlVal}.tripkase?page=${p}&searchValue=${searchValue}&areaValue=${areaValue}
							<c:forEach items="${typeValue}" var="list">&typeValue=${list}</c:forEach>">${p}</a>
					</c:if>
				</c:forEach>
				<!-- 마지막 페이지 번호가 현재 페이지보다 크면 다음 페이지로 버튼 생성 -->
				<c:if test="${maxPage > currentPage}">
					<a class="nextBtn" href="/attraction/${urlVal}.tripkase?page=${currentPage + 1}&searchValue=${searchValue}&areaValue=${areaValue}
						&typeValue=<c:forEach items="${typeValue}" var="list">&typeValue=${list}</c:forEach>">다음</a>
				</c:if>
			</td>
		</tr>
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