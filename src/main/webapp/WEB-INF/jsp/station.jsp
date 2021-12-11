<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Station Detail***TEST***</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style>
*{
	text-align: center;
	margin:auto;
	color:white;
}

body{
	background-color: rgb(78, 78, 78);
	color:white
	overflow: scroll;
}

.btn-group{
	margin-top:10px;
}
#x{
	float:right;
	margin-right: 0px;
}


</style>
</head>
<body>
<div id="x">
	<button type="button"><img alt="x" src="">닫기</button>
</div>
<div class="container">
  <div class="btn-group">
    <button type="button" class="btn btn-primary" id="sdetail">역 상세정보</button>
    <button type="button" class="btn btn-primary" id="rvlist">서비스 리뷰</button>
    <button type="button" class="btn btn-primary" id="shoplist">근처 상점</button>
  </div>
</div>

<div id="here">
${id}
</div>




<script>
	sdetail.onclick=function(){
	    $.ajax({
	            url:"sdetail?id=${id}",
	            success:function(data){here.innerHTML=data;}
	    });
	}
	rvlist.onclick=function(){
	    $.ajax({
	            url:"rvlist",
	            success:function(data){here.innerHTML=data;}
	    });
	}
	shoplist.onclick=function(){
	    $.ajax({
	            url:"shoplist",
	            success:function(data){here.innerHTML=data;}
	    });
	}
</script>
</body>
</html>
