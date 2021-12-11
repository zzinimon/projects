<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Sign Up Page</title>
<style>
body {
	background-color: lightpink;
}

input {
	margin: 10px;
}
</style>
</head>
<body>
	<h1>개인회원가입</h1>
	<form id="signup" action="indiSignUp" method="post">
		<input id="norId" name="norId" type="text" required="required"	placeholder="사용자 ID"><br> 
		<input id="nickname" name="nickname" type="text" maxlength="8" placeholder="닉네임"><br> 
		<input id="norEmail" name="norEmail" type="email" placeholder="이메일 주소"><br> 
		<input id="norPassword" name="norPassword" type="password" required="required" placeholder="비밀번호"><br> 
		<input type="password" required="required" placeholder="비밀번호 확인"><br> 
		
		<input type="submit"> 
		<input type="reset" value="다시 입력">
	</form>
	
</body>
</html>
