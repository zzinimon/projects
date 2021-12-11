<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Sign Up Page</title>
<style>
input {
	margin: 10px;
}

fieldset {
	width: 400px;
	font-size: 12px;
}

legend {
	font-weight: bold;
	font-size: 20px;
}

textarea {
	overflow: scroll;
}
</style>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

</head>
<body>

	<h1>기업회원가입</h1>
	<form id="signup" action="BZSignUp" method="post" enctype="multipart/form-data" onsubmit="return call();">
		<input name="comName" id="comName" type="text" placeholder="기업 명" required="required"><br> 
		
		<input name="comNum" id="comNum" type="text" required="required" placeholder="사업자 등록번호">
		<input type="button" id="btn1" name="btn1" onclick="chk2();" value="유효성"><br>
		
		<input name="comId" id="comId" type="text" placeholder="로그인 ID" required="required"><br> 
		<input name="comPassword" id="comPassword" type="password" required="required"	placeholder="비밀번호"><br> 
		<input type="password" required="required" placeholder="비밀번호 확인"><br>
		<select name="station">
			<option value="" disabled selected>위치한 역 정보</option>
		<c:forEach var="s" items="${stList}">
			<option value="${s.id}">${s.laneName} ${s.stationName}</option>
		</c:forEach>
		</select>
		<fieldset>
			<legend>추가정보</legend>
			기업 로고<br>
			<input type="file" name="comLogo" id="comLogo" accept="image/*"><br> 
		</fieldset>
		<input type="submit"> <input type="reset" value="다시 입력">
	</form>
	
</body>
</html>

