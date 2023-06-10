<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login home</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" />
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<script type="text/javascript">
	function loginCheck() {
		if($("#userId").val() == '' || $("#userId").val() == null){
			alert("아이디를 입력해주세요.");
			return;
		}
		if($("#userPassword").val() == '' || $("#userPassword").val() == null){
			alert("비밀번호를 입력해주세요.");
			return;
		}
		$.ajax({
		    url: "/loginCheck",
		    data: { id:$("#userId").val(),password:$("#userPassword").val()},  
		    type: "post",
		    success: function(result) {
		    	console.log(result);
		    	if(result == 0){
		    		alert("아이디가 존재하지 않습니다.");
		    		return;
		    	}else if(result == 1){
		    		alert("로그인 성공");
		    		var frm = document.getElementById("frm");
					frm.action = "/join"; 
					frm.submit();
		    	}else{
		    		alert("비밀번호가 틀렸습니다.");
		    		return;
		    	}
		    	
	        },fail: function (request,status,error){
	            alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	     	},
	    }); 
		
	}
</script>
</head>
<body>
	<form name="frm" id="frm" method="post"  enctype="multipart/form-data">
		<div>
			<span>아이디 : </span>
			<input type="text" id="userId">
		</div>
		<div>
			<span>비밀번호 : </span>
			<input type="password" id="userPassword">
		</div>
		<button onclick="loginCheck();return false;">로그인</button>
	</form>
</body>
</html>