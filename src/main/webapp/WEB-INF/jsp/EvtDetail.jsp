<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Event Detail</title>

<style>
*{text-align: center; margin:auto;}
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

<script>
	list.onclick=function(){
		location.href="/test/ad?com=${evt.comName}";
	}
	
	modify.onclick=function(){
		location.href="/test/ad/modify";
	}
	
	del.onclick=function(){
		var con=confirm("본 이벤트를 삭제하시겠습니까?");
		if(con==true){
			location.href="/test/ad/delete?post=${evt.id}&com=${evt.comName}";
		}
	}
	
	
</script>
</body>
</html>