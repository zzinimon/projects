<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Event Add Page</title>

<style>
*{margin:auto; text-align: center;}
body{
	background-color : rgb(78,78,78);
	color : white;
}
</style>

</head>
<body>


<h1>이벤트 등록</h1>
<form action="/test/ad/insert" method="post">
 <input type="hidden" name="id" >
 <input type="text" name="comName" value="${evt.comName}">
제목:<input type="text" name="title"><br>
내용<br>
<textarea rows="25" cols="50" name="content" placeholder="이벤트 내용을 입력해주세요."></textarea><br>
<input type="submit" value="입력하기">
</form>


</body>
</html>