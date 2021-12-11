<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Event Modify</title>

<style>
*{margin:auto; text-align: center;}
body{
	background-color : rgb(78,78,78);
	color : white;
}

</style>
</head>
<body>


<h1>${evt.id}</h1>
<h1>${evt.title}</h1>
<hr>
<h6>${evt.date}	<button id="list">목록으로</button></h6>
<h1>${evt.content}</h1>
<br>
<button id="modify">수정</button>
<button id="del">삭제</button>



<form action="/test/ad/insert" method="post" item="evt">
 <input type="hidden" name="id" value="${evt.id}">
 <input type="text" disabled="disabled" name="comName" value="${evt.comName}">
제목:<input type="text" name="title" value="${evt.title}"><br>
내용<br>
<input type="text" size="">
<textarea rows="25" cols="50" name="content"></textarea><br>
<input type="submit" value="입력하기">
</form>

</body>
</html>