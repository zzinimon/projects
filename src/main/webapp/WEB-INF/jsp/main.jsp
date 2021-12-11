<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>MAIN PAGE</title>
<style>
body {
	background-color: lightpink;
	margin: auto;
}

#buttons {
	border: 1px solid black;
	float: left;
	padding: 15px;
	height: 400px;
	width: 170px;
	overflow: hidden;
}

button {
	width: 100px;
	margin: 10px;
}

#Mzone {
	height: 500px;
	overflow: hidden;
}

img {
	margin-left: 50px;
}

#header {
	height: 100px;
	background-color: black;
	margin-bottom: 35px;
	color: white;
}

#footer {
	height: 100px;
	background-color: black;
	color: white;
	text-align: center;
}

#footer p {
	margin: auto;
	padding: 40px;
}
</style>
</head>
<body>
	<div id="header">
	<c:if test="${empty sessionScope.nuser and empty sessionScope.buser}">
		<a href="/login">로그인하기</a>
		<a href="/SignUp">회원가입</a>
	</c:if>
	<c:if test="${not empty sessionScope.nuser}">
		일반회원 ${sessionScope.nuser.nickname}으로 접속중 <a href="/logout">로그아웃</a>
	</c:if>
	<c:if test="${not empty sessionScope.buser}">
		<img src="/logos/${sessionScope.buser.comLogo}" width="50px" height="50px" border="1px solid white">
		기업회원 ${sessionScope.buser.comName} 접속중 <a href="/logout">로그아웃</a>
	</c:if>
	</div>


	<!-- 서비스 버튼 zone -->
	<div id=buttons>
		<button>화장실</button>
		<br>
		<button>문열림</button>
		<br>
		<button>빠른하차</button>
		<br>
		<button>반대방향 이동</button>
		<br>
		<form>
			<input type="text" size="10px" placeholder="역명"> <input
				type="submit" value="검색"><br>

			<details>
				<summary>상세검색</summary>
				<input type="checkbox" name="service" value="service1">service1
				<input type="checkbox" name="service" value="service2">service2
				<br>
				<input type="checkbox" name="service" value="service3">service3
				<input type="checkbox" name="service" value="service4">service4
				<br>
				<input type="submit" value="검색">
			</details>
		</form>


	</div>


	<!-- 지하철 노선도 zone -->
	<div id=Mzone>
		<img alt="대충 지하철 노선도 얽힌 이미지"
			src="https://cphoto.asiae.co.kr/listimglink/6/2017072813523484896_2.png">
	</div>

	<div id=footer>
		<p>김한김장 프로젝트</p>
	</div>


</body>
</html>