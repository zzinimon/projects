<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>ADD REVIEW</h1>
	<form action="/review/add" method="post">
	<table>
		<tr><th>CONTENT</th><th>WRITER</th><th></th></tr>
		<tr><th><input name="rvContent" type="text"></th>
		<th><input name="rvWriter" type="text"></th>
		<th><input type="submit" value="ADD"></th></tr>
	</table>
		<input type="hidden" name="stId" value="${stId}">
	</form>
</body>
</html>