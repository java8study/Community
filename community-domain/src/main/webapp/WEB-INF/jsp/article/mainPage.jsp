<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<title>Main Page</title>
</head>
<script type="text/javascript">

	$(document).ready( function() {
		
		$("#writeBtn").click(function() {
			document.location.href = "<c:url value="/doWritePage" />";
		});
		
		$("#logoutBtn").click(function() { 
			document.location.href = "<c:url value="/logout"/>"; 
		});
		
		$("#searchBtn").click(function(){
			if( $("#searchKeyword").val() == "" ) {
				alert("검색어를 입력하세요!");
				return;
			}
			
			/* $("#searchForm").attr("action", "<c:url value="/mainPage"/>");
			$("#searchForm").attr("method", "POST");
			$("#searchForm").submit(); */
			
			movePage('0');
		});
		
		$("#initSearchBtn").click(function(){
			location.href="<c:url value="/mainPage" />"
		});
	});

</script>
<body>
	<div class="row" style="position: relative;left: 350px;top: 100px;" align="center">
	<div class="col-md-6">
	<table class="table">
		<thead>
		<tr>
			<th>글번호 </th>
			<th>제 목 </th>
			<th>좋아요 </th>
			<th>작성자 </th>
			<th>조회수 </th>
			<th>작성일 </th>
		</tr>
		</thead>
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
			<td>${article.likesCount}</td>
			<td>${article.userName}</td>
			<td>${article.readsCount}</td>
			<td>${article.writeDate}</td>
		</tr>
		</c:forEach>
		</table>
		<form id="searchForm">
			<div>
			${articleListDTO.paging.getPagingList("pageNo", "[@]", "이전", "다음", "searchForm") }
			</div>
			<div>
				<c:set var="selectedSearchType" value="${ sessionScope._SEARCH_ART_.searchType }" />
						<select id="searchType" name="searchType" >
							<option value="userName" ${ selectedSearchType eq "userName" ? "selected" : "" }>아이디 </option>
							<option value="title" ${ selectedSearchType eq "title" ? "selected" : "" }>제목  </option>
							<option value="contents" ${ selectedSearchType eq "contents" ? "selected" : "" }>내용 </option>
						</select>
				<input type="text" id="searchKeyword" name="searchKeyword" value="${searchDTO.searchKeyword}" />
				<input type="button" id="searchBtn" class="btn btn-sm btn-primary" value="검색" />
				<input type="button" id="initSearchBtn" class="btn btn-sm btn-primary" value="검색초기화" />
			</div>
		</form>
	<br/>
	<button type="button" id="writeBtn" class="btn btn-sm btn-primary">글쓰기 </button>
	<button type="button" id="logoutBtn" class="btn btn-sm btn-primary">로그아웃 </button>
	</div>
	</div>

</body>
</html>