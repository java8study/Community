<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
		
		$("#logoutBtn").click(function() { 
			document.location.href = "<c:url value="/logout"/>"; 
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
		<c:forEach items="${articleListDTO.articleList}" var="article">
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
		<td colspan="6" align="center">
		<form id="searchForm">
			<div style="text-align: center;">
			${articleListDTO.paging.getPagingList("pageNo", "[@]", "이전", "다음", "searchForm") }
			</div>
			<div>
				<select id ="searchType" name ="searchType">
				<c:if test="${searchDTO.searchType eq '' }">
				<option value="selectTitleDesc" selected="selected">제목</option>
				<option value="selectMbrId">아이디</option>
				</c:if>
				<c:if test="${searchDTO.searchType eq 'selectTitleDesc' }">
				<option value="selectTitleDesc" selected="selected">제목</option>
				<option value="selectMbrId">아이디</option>
				</c:if>
				<c:if test="${searchDTO.searchType eq 'selectMbrId' }">
				<option value="selectTitleDesc">제목</option>
				<option value="selectMbrId" selected="selected">아이디</option>
				</c:if>
				</select>
				<input type="text" id="searchKeyword" name="searchKeyword" value="${searchDTO.searchKeyword}" />
				<input type="button" id="searchBtn" value="검색" />
				<input type="button" id="initSearchBtn" value="검색초기화" />
			</div>
		</form>
		</td>
	</table>
	<button type="submit" id="writeBtn">글쓰기 </button>
	<button type="submit" id="logoutBtn">로그아웃 </button>

</body>
</html>