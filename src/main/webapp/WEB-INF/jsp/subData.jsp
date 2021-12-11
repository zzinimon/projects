<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	function call(str) {
		//alert(info); //encodeURIComponent
		$.ajax({
			url : "/data/update",
			method : "POST",
			data : {
				"str" : str
			},
			success : function() {
				window.location.reload();
			}
		});
	}

	function searchSub() {
		var stId = document.getElementById('stationId').value;
		//for (var i = stId; i <= 300; i++) {
			var xhr = new XMLHttpRequest();
			var url = "https://api.odsay.com/v1/api/subwayStationInfo?&apiKey=VCgXq0yAz%2Bk4rjjNowaVjrszrhkqoqjlHyJ3GIvb0Bs"
					+ "&stationID=" + stId;
			xhr.open("GET", url, true);
			xhr.send();
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4 && xhr.status == 200) {
					if (xhr.responseText != null) {
						//alert(xhr.responseText);
						call(xhr.responseText);
					}
				}
			}
		//}
	}
</script>
</head>
<body>
	<div>
		<input type="text" id="stationId">
		<button onclick="searchSub();">click</button>
	</div>
	<div id="resultDiv" style="border: solid red 1px;">
	
	<table style="width: 100%;">
		<tr>
			<th></th>
			<th>정류장 ID</th>
			<th>정류장 이름</th>
			<th>호선</th>
			<th>구주소</th>
			<th>신주소</th>
			<th>전화번호</th>
		</tr>
	<c:forEach var="s" items="${sList}" varStatus="idx">
		<tr>
			<td>${idx.count}</td>
			<td>${s.id}</td>
			<td><a href="detail?stId=${s.id}">${s.stationName}</a></td>
			<td>${s.laneName}</td>
			<td>${s.address}</td>
			<td>${s.newAddress}</td>
			<td>${s.tel}</td>
		</tr>
	</c:forEach>
	</table>
	
	</div>
</body>
</html>