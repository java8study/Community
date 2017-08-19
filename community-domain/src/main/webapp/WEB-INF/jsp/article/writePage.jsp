<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Write Page</title>
</head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

		$("#writeBtn").click(function() {
			if ( $("#title").val() == '' ) {
				alert("제목을 입력하시오.");
				$("#title").focus();
			}
			else if ( $("#contents").val() == '' ) {
				alert("내용 입력하시오.");
				$("#contents").focus();
			}
			else {
				$("#writeForm").attr("action", "<c:url value="/doWriteAction"/>");
				$("#writeForm").attr("method", "POST");
				$("#writeForm").submit();
			}
			
		});
		
		$("#cancelBtn").click(function() {

			document.location.href = "<c:url value="/mainPage" />";
		});

	});
</script>
<body>
	<form id="writeForm" >
		<table border="1">
			<tr>
				<td>제목</td>
				<td><input type="text" id="title" name="title" size="42" /></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea id="contents" name="contents" cols="40" rows="10"></textarea>
				</td>
			</tr>
		</table>
		<button type="button" id="writeBtn">글쓰기</button>
	</form>
	<button type="button" id="cancelBtn">취소</button>




</body>
</html>