<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<h1>STATION DETAIL</h1>
<table>
  <tr><td>id</td><td>${bs.id}</td></tr>
  <tr><td>역명</td><td>${bs.laneName}</td></tr>
  <tr><td>호선</td><td>${bs.line}</td></tr>
  <tr><td>열리는 문</td><td>slc.door</td></tr>
  <tr><td>화장실</td><td>slc.toilet</td></tr>
  <tr><td>반대편 이동</td><td>slc.reverse</td></tr>
  <tr><td>빠른하차</td><td>slc.exit</td></tr>
</table> 
<br>
<h6>추가 제공 서비스</h6>

달러{자전거 보관소}<br>
달러{민원 발급기}<br>
달러{수유실}<br>
달러{만남의 광장<br>
달러{장애인 편의 시설}<br>

<style>
td{
	text-align:left;
	width:100px;
}

</style>
    