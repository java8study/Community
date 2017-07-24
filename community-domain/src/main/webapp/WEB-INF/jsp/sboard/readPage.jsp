<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="include/header.jsp"%>

<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">글 읽기</h3>
				</div>
				<!-- /.box-header -->

				<form role="form" action="modifyPage" method="post">
					<input type='hidden' name='bno' value="${board.bno}"> 
									
				</form>

				<div class="box-body">
					<div class="form-group">
						<label for="exampleInputEmail1">제목</label> <input type="text"
							name='title' class="form-control" value="${board.title}"
							readonly="readonly">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">내용</label>
						<textarea class="form-control" name="content" rows="3"
							readonly="readonly">${board.content}</textarea>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">작성자</label> <input type="text"
							name="writer" class="form-control" value="${board.writer}"
							readonly="readonly">
					</div>
				</div>
				<!-- /.box-body -->

			  <div class="box-footer">
			    <button type="submit" class="btn btn-primary btn-sm" id="modifyBtn">수정</button>
			    <button type="submit" class="btn btn-primary btn-sm" id="removeBtn">삭제</button>
			    <button type="submit" class="btn btn-primary btn-sm" id="goListBtn">리스트</button>
			  </div>



			</div>
			<!-- /.box -->
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->



	<div class="row">
		<div class="col-md-12">

			<div class="box box-success">
				<div class="box-header">
					<h3 class="box-title">댓글 목록</h3>
				</div>
				<div class="box-body">
					<label for="exampleInputEmail1">작성자</label> <input
						class="form-control" type="text" placeholder="USER ID"
						id="newReplyWriter"> <label for="exampleInputEmail1">
						갯글
						</label> <input class="form-control" type="text"
						placeholder="REPLY TEXT" id="newReplyText">

				</div>
				<!-- /.box-body -->
				<div class="box-footer">
					<button type="button" class="btn btn-primary btn-sm" id="replyAddBtn">댓글 추가</button>
				</div>
			</div>


			<!-- The time line -->
			<ul class="timeline">
				<!-- timeline time label -->
				<li class="time-label" id="repliesDiv"><span class="bg-green">
						Replies List </span></li>
			</ul>

			<div class='text-center'>
				<ul id="pagination" class="pagination pagination-sm no-margin ">

				</ul>
			</div>

		</div>
		<!-- /.col -->
	</div>
	<!-- /.row -->


          
<!-- Modal -->
<div id="modifyModal" class="modal modal-primary fade" role="dialog">
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title"></h4>
      </div>
      <div class="modal-body" data-rno>
        <p><input type="text" id="replytext" class="form-control"></p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-info" id="replyModBtn">수정</button>
        <button type="button" class="btn btn-danger" id="replyDelBtn">삭제</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
      </div>
    </div>
  </div>
</div>      
	
	
</section>
<!-- /.content -->

<script>


	$("#repliesDiv").on("click", function() {

		if ($(".timeline li").size() > 1) {
			return;
		}
		getPage("/replies/" + bno + "/1");

	});
	

	$(".pagination").on("click", "li a", function(event){
		
		event.preventDefault();
		
		replyPage = $(this).attr("href");
		
		getPage("/replies/"+bno+"/"+replyPage);
		
	});
	

	$("#replyAddBtn").on("click",function(){

		 alert("버튼 눌림");
		 var replyerObj = $("#newReplyWriter");
		 var replytextObj = $("#newReplyText");
		 var replyer = replyerObj.val();
		 var replytext = replytextObj.val();
		
		  
		  $.ajax({
				type:'post', 
				url:'/community-domain/replies',
				headers: { 
				      "Content-Type": "application/json",
				      "X-HTTP-Method-Override": "POST" },
				dataType:'text',
				data: JSON.stringify({bno:bno, replyer:replyer, replytext:replytext}),
				success:function(result){
					console.log("result: " + result);
					if(result == 'SUCCESS'){
						alert("등록 되었습니다.");
						replyPage = 1;
						getPage("/replies/"+bno+"/"+replyPage );
						replyerObj.val("");
						replytextObj.val("");
					}else{
						alert("그냥 에러난거임");
					
					}
			}});
	});


	$(".timeline").on("click", ".replyLi", function(event){
		
		var reply = $(this);
		
		$("#replytext").val(reply.find('.timeline-body').text());
		$(".modal-title").html(reply.attr("data-rno"));
		
	});
	
	

	$("#replyModBtn").on("click",function(){
		  
		  var rno = $(".modal-title").html();
		  var replytext = $("#replytext").val();
		  
		  $.ajax({
				type:'put',
				url:'/replies/'+rno,
				headers: { 
				      "Content-Type": "application/json",
				      "X-HTTP-Method-Override": "PUT" },
				data:JSON.stringify({replytext:replytext}), 
				dataType:'text', 
				success:function(result){
					console.log("result: " + result);
					if(result == 'SUCCESS'){
						alert("수정 되었습니다.");
						getPage("/replies/"+bno+"/"+replyPage );
					}
			}});
	});

	$("#replyDelBtn").on("click",function(){
		  
		  var rno = $(".modal-title").html();
		  var replytext = $("#replytext").val();
		  
		  $.ajax({
				type:'delete',
				url:'/replies/'+rno,
				headers: { 
				      "Content-Type": "application/json",
				      "X-HTTP-Method-Override": "DELETE" },
				dataType:'text', 
				success:function(result){
					console.log("result: " + result);
					if(result == 'SUCCESS'){
						alert("삭제 되었습니다.");
						getPage("/replies/"+bno+"/"+replyPage );
					}
			}});
	});
	
</script>


<script>
$(document).ready(function(){
	
	var formObj = $("form[role='form']");
	
	console.log(formObj);
	
	$("#modifyBtn").on("click", function(){
		alert("버튼 눌림");
		formObj.attr("action", "/community-domain/sboard/modifyPage");
		formObj.attr("method", "get");		
		formObj.submit();
	});
	
	$("#removeBtn").on("click", function(){
		formObj.attr("action", "'${pageContext.request.contextPath}/sboard/removePage");
		formObj.submit();
	});
	
	$("#goListBtn ").on("click", function(){
		formObj.attr("method", "get");
		formObj.attr("action", "/community-domain/sboard/list");
		formObj.submit();
	});
	
});
<<<<<<< HEAD
</script>
=======
</script>
>>>>>>> branch 'master' of https://github.com/java8study/Community.git
