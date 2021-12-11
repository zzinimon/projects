<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Sign Up Page</title>
</head>
<style>
	body{
		text-align: center;
		background-color: lightpink;
	}
	.member{
		font-weight:bold; font-size:15px;
		margin: 10px;
		padding: 50px;
	}
	fieldset{
		margin:auto;
	}
</style>
<body>
<h1>"김한김장" 계정 만들기</h1><hr>
<button class="member" id="businessMember">기업회원</button>	
<button class="member" id="individualMember">개인회원</button>
<div id="signUpForm">

</div>

<script>
window.onload = function(){
	
 

	businessMember.onclick=function(){
	    $.ajax({
	            url:"BZ",
	            success:function(data){signUpForm.innerHTML=data;}
	    });
	}
	individualMember.onclick=function(){
	    $.ajax({
	            url:"Indi",
	            success:function(data){signUpForm.innerHTML=data;}
	    });
	}



	
}

</script>

<script>
var ok=false;
var validChk = false;
function call(){
	if(!(validChk && ok)){
		alert("유효성 검사를 진행해주세요");
	}
	return validChk && ok;
}
function chk2(){
	validChk =true;
	var number = signup.comNum.value;
	var numberMap = number.replace(/-/gi, '').split('').map(function (d){
		return parseInt(d, 10);
	});
	
	if(numberMap.length == 10){
		var keyArr = [1, 3, 7, 1, 3, 7, 1, 3, 5];
		var chk = 0;
		
		keyArr.forEach(function(d, i){
			chk += d * numberMap[i];
		});
		
		chk += parseInt((keyArr[8] * numberMap[8])/ 10, 10);
		ok=Math.floor(numberMap[9]) === ( (10 - (chk % 10) ) % 10);
		if(ok){
			alert("유효한 사업자번호 형식입니다.");
			return ok;
		}
	}
	
	ok = false;
	alert("유효하지 않은 사업자번호 형식입니다.");
	return false;
}
</script>

</body>

</html>