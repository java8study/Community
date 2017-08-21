<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 페이지 </title>
</head>
<script type="text/javascript">

	$(document).ready(function() {
		
		$("#loginBtn").click(function() {
			var params = $("#loginForm").serialize();
			
			$.ajax({
				url:"/community-domain/checkLoginMember",
				dataType:"json",
				type:'POST',
				contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
				data : params,
				success: function(data){
					if ( data.KEY == 'SUCCESS') {
						document.location.href = "<c:url value="/mainPage" />";
						alert("로그인 성공 ");
					}
					else if ( data.KEY == 'FAIL' ) {
						alert("아이디와 비밀번호를 다시 확인해주시기 바랍니다.");
					}
 				},
				error: function(request,status,error) {
					alert("code:"+request.status+"\n"+"error:"+error);
				}
				
			});
			
		});
		
		$("#registMemberBtn").click(function() {
			document.location.href = "<c:url value="/registMemberPage" />";
		});

	});
</script>
<body>
<div style="position:relative;top:150px;"  align="center">
<form id="loginForm" name="loginForm">
	<h1>
	<input type="text" id ="userName" name="userName" placeholder="아이디"/> <br/><br/>
	<input type="password" id="userPassword" name="userPassword"  placeholder="비밀번호"/>	<br/><br/>
	</h1>

	<button type="button" id="loginBtn" class="btn btn-lg btn-primary">로그인 </button> &nbsp;&nbsp;
	<button type="button" id="registMemberBtn" class="btn btn-lg btn-primary">회원가입 </button>
</form>
</div>

</body>
</html>