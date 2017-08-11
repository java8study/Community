<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 페이지 </title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
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

<form id="loginForm" name="loginForm">
	아이디 <input type="text" id ="userName" name="userName" /> <br/><br/>
	패스워드 <input type="password" id="userPassword" name="userPassword" />	<br/><br/>

	<button type="submit" id="loginBtn">로그인 </button>
	<button type="submit" id="registMemberBtn">회원가입 </button>
</form>

</body>
</html>