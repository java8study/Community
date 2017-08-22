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
<title>Article Detail Page</title>
</head>
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
	
	function replyDeleteOpen(replyId) {
		var msg = confirm("댓글을 삭제합니다.");
		if ( msg == true ) {
			replyDelete(replyId);
		}
	}
	
	function replyDelete(replyId) {
		
		var params = "replyId="+replyId;
		
		$.ajax({
			url:"/community-domain/articleDetail/deleteReplyByReplyId",
			dataType:"json",
			type:'POST',	
			contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
			data : params,
			success: function(data)	{
				if ( data.KEY == 'REPLY_DELETE') {
					location.reload();
					alert("댓글 삭제 완료 ");
				}
				else if ( data.KEY == 'FAIL' ) {
					alert("실패 !");
				}
				},
			error: function(request,status,error) {
				alert("code:"+request.status+"\n"+"error:"+error);
			}
			
		});
		
	}
</script>
<body>
	<div style="position: relative;left: 350px; top:100px;">
	<div class="page-header">
        <h1>Detail page입니다. </h1>
     </div>
	<br/><br/>
	<form:form commandName="articleDTO" method="post"
		action="/community-domain/doAdjustWritePage/${articleDTO.articleId}">
	<div class="row">
        <div class="col-md-6">
          <table class="table">		
		<tr>
			<th>${articleDTO.title }
			<div align="right"> 
			${articleDTO.writeDate }
			</div>
			</th>
		</tr>
		<tr>
			<td>${articleDTO.contents }</td>
		<tr/>
		<tr>
			<td>
			<div align="right"> 
			${articleDTO.userName }, 
			좋아요 : ${articleDTO.likesCount }
			</div>
			</td>
		</tr>
			</table>
		</div>
	</div>
	<input type="hidden" name="articleId" value="${articleDTO.articleId}" />
	
	<button type="submit" id="editBtn" class="btn btn-sm btn-primary">수정하기</button>
	<button type="button" id="goListBtn" class="btn btn-sm btn-primary">목록으로</button>
	<button type="button" id="doDeleteBtn" class="btn btn-sm btn-primary">삭제 </button>
	<button type="button" id="likeBtn" class="btn btn-sm btn-primary">좋아요!</button> <br/>
	</form:form>
	<form id ="detailForm">
	
	<c:forEach items="${replyList}" var="reply">
	<br/>
	작성자 : ${reply.userName}
	<br/>
	댓글 내용 : ${reply.replyContents}
	<br/>
	좋아요 : ${reply.replyLikesCount }
	싫어요 : ${reply.replyDisLikesCount }
	<c:if test="${sessionScope._MEMBER_.userName eq reply.userName}">
	<button type="button" name ="replyDeleteBtn" class="btn btn-sm btn-danger" onclick="replyDeleteOpen(${reply.replyId})">삭제 </button>
	</c:if>			
	
	<br/><br/>
	</c:forEach>
	내 닉네임 : ${ sessionScope._MEMBER_.userName} <br/>
	<textarea id="replyContents" name="replyContents" cols="40" rows="3"></textarea>
	<input type="hidden" name="articleId" value="${articleDTO.articleId}" />
	<button type="submit" id="replyWirteBtn" class="btn btn-sm btn-primary">댓글 작성 </button>
	
	</form>
	</div>
	


</body>
</html>