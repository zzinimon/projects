<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>ZZINI TEST</title>
<style>
body{
	background-color: rgb(78, 78, 78);
	color:white;
}
.lin{
	text-decoration: none;
	color:yellowgreen;
	font-size: 20px;
}
.station{
	width:100px;
	height:100px;
}
</style>
</head>
<body>
<h1>테스트 페이즿</h1>
<a class=lin href="test/sign">회원가입</a><br>
<a class=lin href="test/station">역 상세</a><br>
<a class=lin href="test/login">로그인</a><br>

<a href="/test/station?id=001"><img class=station alt="1인가영" src="https://w7.pngwing.com/pngs/218/24/png-transparent-white-and-green-number-1-number-number-1-blue-image-file-formats-text-thumbnail.png"></a>
<a href="/test/station?id=002"><img class=station alt="2인가영" src="https://w7.pngwing.com/pngs/990/675/png-transparent-number-information-skill-number-2-english-text-trademark-thumbnail.png"></a><br>
</body>
</html>