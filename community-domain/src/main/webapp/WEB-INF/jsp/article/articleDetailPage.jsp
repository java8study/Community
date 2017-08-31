<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<%@ include file="/WEB-INF/jsp/member/header.jsp"%>
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
			
			if ( confirm ("정말 삭제하시겠습니까?") == true ) {
				document.location.href = "<c:url value="/doDeleteAction/${articleDTO.articleId}" />";
				alert("삭제했습니다!");
			}
			else {
				return;
			}
			
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
					$('#likesCount').html(data.KEY);
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
	
	function replyLikeUp(replyId) {
		
		var params = "replyId=" + replyId;
		
		var replyId = "replyLikesUp"+replyId;
		
		$.ajax({
			url:"/community-domain/articleDetail/replyLikeUpByReplyId",
			dataType:"json",
			type:'POST',
			contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
			data : params,
			success:function(data) { 
				$("#"+replyId).html(data.KEY);
			},
			error: function(request,status,error) {
				alert("code:"+request.status+"\n"+"error:"+error);
			}
		});
		
	}
	
	function replyDisLikeUp(replyId) {
		
		var params = "replyId=" + replyId;
		
		var replyId = "replyDisLikesUp"+replyId;
		
		$.ajax({
			url:"/community-domain/articleDetail/replyDisLikeUpByReplyId",
			dataType:"json",
			type:'POST',
			contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
			data : params,
			success:function(data) { 
				$("#"+replyId).html(data.KEY);
			},
			error: function(request,status,error) {
				alert("code:"+request.status+"\n"+"error:"+error);
			}
		});
		
	}
	
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
			<span id="likeBtn" class= "glyphicon glyphicon-thumbs-up" ></span> : 
			<div id="likesCount">${articleDTO.likesCount }</div>
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
	<br/>
	</form:form>
	<form id ="detailForm">
	
	<c:forEach items="${replyList}" var="reply">
	<br/>
	작성자 : ${reply.userName}
	<br/>
	댓글 내용 : ${reply.replyContents}
	<br/>
	<div style="float: left;">
	<span class= "glyphicon glyphicon-thumbs-up" onclick="replyLikeUp(${reply.replyId})" ></span> 
	&nbsp; : </div> 
	<div style="float: left;" id= "replyLikesUp${reply.replyId}">${reply.replyLikesCount }</div>
	&nbsp;&nbsp;
	
	<div style="float: left;">
	<span class= "glyphicon glyphicon-thumbs-down" onclick="replyDisLikeUp(${reply.replyId})"></span> 
	&nbsp; : </div>
	<div style = "float:left;" id = "replyDisLikesUp${reply.replyId}">${reply.replyDisLikesCount }</div>
	<c:if test="${sessionScope._MEMBER_.userName eq reply.userName}">
	<button type="button" name ="replyDeleteBtn" class="btn btn-xs btn-danger" onclick="replyDeleteOpen(${reply.replyId})">삭제 </button>
	</c:if>			
	
	<br/><br/>
	</c:forEach>
	내 닉네임 : ${ sessionScope._MEMBER_.userName} <br/>
	<textarea id="replyContents" name="replyContents" cols="40" rows="3"></textarea>
	<input type="hidden" name="articleId" value="${articleDTO.articleId}" />
	<button type="button" id="replyWirteBtn" class="btn btn-sm btn-primary">댓글 작성 </button>
	
	</form>
	</div>
	


</body>
</html>