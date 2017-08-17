<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
		
		
		$("#doDeleteBtn").click(function() {
			document.location.href = "<c:url value="/doDeleteAction/${articleDTO.articleId}" />";
		}); 

		$("#goListBtn").click(function() {
			document.location.href = "<c:url value="/mainPage" />";
		});
		
		$("#likeBtn").click(function() {
			var params = $("#detailForm").serialize();
			
			$.ajax({
				url:"/community-domain/articleDetail/upLikesCount",
				dataType:"json",
				type:'POST',
				contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
				data : params,
				success: function(data){
					if ( data.KEY == 'UP') {
						location.reload();
						alert("좋아요!!! ");
					}
					else if ( data.KEY == 'FAIL' ) {
						alert("좋아요 실패!");
					}
 				},
				error: function(request,status,error) {
					alert("code:"+request.status+"\n"+"error:"+error);
				}
				
			});
			
		});
		
		$("#replyWirteBtn").click(function() {
			
			if ( $("#replyContents").val() == '' ) {
				alert("댓글 내용을 입력하세요.");
			}
			else {
				var params = $("#detailForm").serialize();
				
				$.ajax({
					url:"/community-domain/articleDetail/writeReplyByUserNameAndArticleId",
					dataType:"json",
					type:'POST',
					contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
					data : params,
					success: function(data){
						if ( data.KEY == 'REPLY_WRITE') {
							location.reload();
							alert("댓글 작성 완료! ");
						}
						else if ( data.KEY == 'FAIL' ) {
							alert("댓글 실패!");
						}
	 				},
					error: function(request,status,error) {
						alert("code:"+request.status+"\n"+"error:"+error);
					}
					
				});
			}
			
		});

	});
</script>
<body>
	Detail page입니다.
	<form:form commandName="articleDTO" method="post"
		action="/community-domain/doAdjustWritePage/${articleDTO.articleId}">
	<table border="1">
		<tr>
			<td>${articleDTO.articleId}</td>
			<td>${articleDTO.title }</td>
			<td>${articleDTO.contents }</td>
			<td>${articleDTO.writeDate }</td>
			<td>${articleDTO.userName }</td>
			<td>${articleDTO.likesCount }</td>
		</tr>
	</table>
	<input type="hidden" name="articleId" value="${articleDTO.articleId}" />
	
	<button type="submit" id="editBtn">수정하기</button>
	</form:form>
	<form id ="detailForm">
	<button type="button" id="goListBtn">목록으로</button>
	<button type="button" id="doDeleteBtn">삭제 </button>
	<button type="button" id="likeBtn">좋아요!</button> <br/>
	
	<c:forEach items="${replyList}" var="reply">
	작성자 : ${reply.userName}
	<br/>
	댓글 내용 : ${reply.replyContents}
	<br/>
	좋아요 : ${reply.replyLikesCount }
	싫어요 : ${reply.replyDisLikesCount }
	<br/><br/>
	</c:forEach>
			
	내 닉네임 : ${ sessionScope._MEMBER_.userName} <br/>
	<textarea id="replyContents" name="replyContents" cols="40" rows="3"></textarea>
	<input type="hidden" name="articleId" value="${articleDTO.articleId}" />
	<button type="submit" id="replyWirteBtn">댓글 작성 </button>
	
	</form>
	
	


</body>
</html>