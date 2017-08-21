<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<title>Write Page</title>
</head>
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
	<div align="center" style="position: relative;left: 350px;top: 100px;">
	<form id="writeForm" >
		<div class="col-md-5">
		<table class="table">
			<tr>
				<th>제목</th>
				<td><input type="text" id="title" name="title" size="50" placeholder="제목을 입력하세요. " /></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea id="contents" name="contents" cols="50" rows="10" placeholder="내용을 입력하세요. "></textarea>
				</td>
			</tr>
			
		</table>
		<button type="button" id="writeBtn" class="btn btn-sm btn-primary">글쓰기</button> &nbsp;&nbsp;
		<button type="button" id="cancelBtn" class="btn btn-sm btn-primary">취소</button>
		</div>
		
	</form>
		
	</div>




</body>
</html>