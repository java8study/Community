<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Article Detail Page</title>
</head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

		$("#editBtn").click(function() {
			document.location.href = "<c:url value="/doWritePage" />";
		});

		$("#goListBtn").click(function() {
			document.location.href = "<c:url value="/mainPage" />";
		});

	});
</script>
<body>
	Detail page입니다.
	<table border="1">
		<tr>
			<td>${articleDTO.articleId}</td>
			<td>${articleDTO.title }</td>
			<td>${articleDTO.contents }</td>
			<td>${articleDTO.writeDate }</td>
			<td>${articleDTO.userName }</td>
		</tr>
		<tr>
	</table>

	<button type="submit" id="editBtn">수정하기</button>
	<button type="submit" id="goListBtn">목록으로</button>



</body>
</html>