<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2 align="ceter">전체 신고 조회</h2>
	<table align="center" border="1">
					<tr>
						<td>No</td>
						<td>컨텐츠</td>
						<td>분류</td>
						<td>제목</td>
						<td>신고일</td>
						<td>상세조회</td>
					</tr>
					<c:forEach items="${rList }" var="report" varStatus="i">
					<tr>
						<td>${ i.count}</td>
						<td>${ report.commonType}</td>
						<td>${ report.reportType}</td>
						<td>${ report.reportTitle}</td>
						<td>${ report.reportDate}</td>
						<td><button type="button" onclick="location.href='/admin/reportDetail.tripkase?reportNo=${report.reportNo}'">상세조회</button></td>		
					</tr>
					</c:forEach> 
			</table>
</body>
</html>