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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready( function() {
		
		$("#cancelBtn").click(function() {
			
			document.location.href = "<c:url value="/mainPage" />";	
		});
		
	});

</script>
<body>
<form:form commandName="articleDTO" method="post" action="/community-domain/doUpdate">
	<table border="1">
		<tr>
			<td>제목 </td>
			<td> 
				<c:if test="${articleDTO.title eq ''}">
					<input type="text" id="title" name="title" size="42"/>
				</c:if>
				<c:if test="${articleDTO.title ne ''}">
					<input type="text" id="title" name="title" value="${articleDTO.title}"/>
				</c:if>
			</td>
		</tr>
		<tr>
			<td>내용 </td>
			<td>
				<c:if test="${articleDTO.contents eq ''}">
					<textarea id="contents" name="contents" cols="40" rows="10"></textarea>
				</c:if>
				<c:if test="${articleDTO.contents ne ''}">
				<textarea id="contents" name="contents" cols="40" rows="10">${articleDTO.contents}</textarea>
				</c:if>
			</td>
		</tr>
	</table>
	<button type="submit" id="writeBtn"  >수정하기 </button>
	<input type="hidden" id="articleId" name="articleId" value="${articleDTO.articleId}">
</form:form>
	<button type="submit" id="cancelBtn" >취소 </button>
	
	
	
	
</body>
</html>