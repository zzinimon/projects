<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>LOGIN</title>
<style>
* {
	text-align: center;
	margin: auto;
}

body {
	background-color: rgb(78, 78, 78);
	color: white
}

td {
	width: 100px;
}

form, input[type="submit"] {
	margin-top: 15px;
}
</style>
</head>
<body>
	<h1>로그인 페이지 입니다!</h1>
	<form action="login" method="post">
		일반회원 <input type="radio" name="logType" value="nuser" checked="checked">
		기업회원 <input type="radio" name="logType" value="buser">
		<table>
			<tr>
				<td>ID</td>
				<td><input type="text" name="userId" size="15" required="required"></td>
			</tr>
			<tr>
				<td>PW</td>
				<td><input type="password" name="userPw" size="15" required="required"></td>
			</tr>
		</table>
		<br>
		<input type="submit" value="login">
	</form>
</body>
</html>