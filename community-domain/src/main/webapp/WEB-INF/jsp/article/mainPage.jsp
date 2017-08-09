<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main Page</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready( function() {
		
		$("#writeBtn").click(function() {
			document.location.href = "<c:url value="/doWritePage" />";
		});
		
	});

</script>
<body>

	<table border="1">
		<tr>
			<td>글번호 </td>
			<td>제 목 </td>
			<td>작성일 </td>
			<td>조회수 </td>
			<td>좋아요 </td>
			<td>작성자 </td>
		</tr>
		<c:forEach items="${articleList}" var="article">
		<tr>
			<td>
				${article.articleId}
			</td>
			<td>
			<a href="<c:url value='/articleDetail/${article.articleId}'/>">
			${article.title}
			</a>
			</td>
			<td>${article.writeDate}</td>
			<td>${article.readsCount}</td>
			<td>${article.likesCount}</td>
			<td>${article.userName}</td>
		</tr>
		</c:forEach>
		
		
		
	</table>
	<button type="submit" id="writeBtn">글쓰기 </button>

</body>
</html>