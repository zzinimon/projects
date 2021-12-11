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
	<h1>${stId}번 ${station} REVIEW</h1>
	<table>
		<tr>
			<th></th>
			<th>CONTENT</th>
			<th>WRITER</th>
			<th>DATETIME</th>
			<th></th>
		</tr>
	<c:forEach var="r" items="${list}" varStatus="idx">
		<tr>
			<td>${idx.count}</td>
			<td>${r.rvContent}</td>
			<td>${r.rvWriter}</td>
			<td>${r.rvDate}</td>
			<th>
				<a href="/review/delete?rvId=${r.id}&stId=${stId}">삭제</a>
			</th>
		</tr>
	</c:forEach>
	</table>
	<hr>
	<jsp:include page="add.jsp"></jsp:include>
</body>
</html>