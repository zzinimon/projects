<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<h1>REVIEW LIST</h1>
<a href="studentInsert">신규등록</a>
<hr>
<table border="1">
  <tr>
    <td>no.</td>
    <td>역명</td>
    <td>제목</td>
    <td>내용</td>
    <td>작성시간</td>
    <td>작성자</td>
  </tr>
  <c:forEach items="${reviewList}" var="rv">
	  <tr>
	    <td>${rv.id}</td>
	    <td>${rv.st_id}</td>
	    <td><a href="reviewDetail?rvid=${rv.id}">${rv.rv_content}</a></td>
	    <td>>${rv.rv_date}</td>
	    <td>${rv.rv_writer}</td>
	    <td><button onclick="location.href='studentDelete?sid=${rv.student_id}';">삭제</button></td>
	  </tr>
  </c:forEach>
</table>
<hr>
<jsp:include page="add.jsp"></jsp:include>
    
    