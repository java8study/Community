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
	$(document).ready( function() {
		
		$("#cancelBtn").click(function() {
			
			document.location.href = "<c:url value="/mainPage" />";	
		});
		
	});

</script>
<body>
<form:form commandName="articleDTO" method="post" action="/community-domain/doUpdate">
	<div align="center" style="position: relative;left: 350px;top: 100px;">
	<div class="col-md-5">
	<table class="table">
		<tr>
			<td>제목 </td>
			<td> 
				<c:if test="${articleDTO.title eq ''}">
					<input type="text" id="title" name="title" size="50"/>
				</c:if>
				<c:if test="${articleDTO.title ne ''}">
					<input type="text" id="title" name="title" size="50" value="${articleDTO.title}"/>
				</c:if>
			</td>
		</tr>
		<tr>
			<td>내용 </td>
			<td>
				<c:if test="${articleDTO.contents eq ''}">
					<textarea id="contents" name="contents" cols="50" rows="10"></textarea>
				</c:if>
				<c:if test="${articleDTO.contents ne ''}">
				<textarea id="contents" name="contents" cols="50" rows="10">${articleDTO.contents}</textarea>
				</c:if>
			</td>
		</tr>
	</table>
	<button type="submit" id="writeBtn" class="btn btn-sm btn-primary"  >수정하기 </button> &nbsp;&nbsp;
	<button type="button" id="cancelBtn" class="btn btn-sm btn-primary" >취소 </button>
	<input type="hidden" id="articleId" name="articleId" value="${articleDTO.articleId}">
	</div>
	</div>
</form:form>
	
	
	
	
</body>
</html>