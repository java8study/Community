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
			document.location.href = "<c:url value="/mainPage" />";
		});
		
		$("#registMemberBtn").click(function() {
			document.location.href = "<c:url value="/registMemberPage" />";
		});

	});
</script>
<body>

	아이디 <input type="text" id ="userName" name="userName" /> <br/><br/>
	패스워드 <input type="password" id="userPwd" name="userPwd" />	<br/><br/>

	<button type="submit" id="loginBtn">로그인 </button>
	<button type="submit" id="registMemberBtn">회원가입 </button>


</body>
</html>