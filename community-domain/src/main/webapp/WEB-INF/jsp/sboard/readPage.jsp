<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="include/header.jsp"%>
<<<<<<< HEAD
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
=======

>>>>>>> jewel1609_2
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>


<section class="content">
	<div class="row">
		<div class="col-md-12">
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">글 읽기</h3>
				</div>

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
<<<<<<< HEAD
						<label for="exampleInputEmail1">작가</label> <input type="text"
=======
						<label for="exampleInputEmail1">작성자</label> <input type="text"
>>>>>>> jewel1609_2
							name="writer" class="form-control" value="${board.writer}"
							readonly="readonly">
					</div>
				</div>
				<!-- /.box-body -->

			  <div class="box-footer">
			    <button type="submit" class="btn btn-primary btn-sm" id="modifyBtn">수정</button>
			    <button type="submit" class="btn btn-primary btn-sm" id="removeBtn">삭제</button>
<<<<<<< HEAD
			    <button type="submit" class="btn btn-primary btn-sm" id="goListBtn">목록으로</button>
=======
			    <button type="submit" class="btn btn-primary btn-sm" id="goListBtn">리스트</button>
>>>>>>> jewel1609_2
			  </div>



			</div>
		</div>

	</div>

	<div class="row">
		<div class="col-md-12">

			<div class="box box-success">
				<div class="box-header">
					<h3 class="box-title">댓글 목록</h3>
				</div>
				<form>
				<div class="box-body">
					<label for="exampleInputEmail1">작성자</label> <input
						class="form-control" type="text" placeholder="USER ID"
						id="newReplyWriter" required>
						 <label for="exampleInputEmail1"> 글쓰기 내용 </label> <input class="form-control" type="text"
						placeholder="REPLY TEXT" required id="newReplyText">

				</div>
				</form>
				<!-- /.box-body -->
				<div class="box-footer">
<<<<<<< HEAD
					<button type="button" class="btn btn-primary" id="replyAddBtn"> 추가</button>
=======
					<button type="button" class="btn btn-primary btn-sm" id="replyAddBtn">댓글 추가</button>
>>>>>>> jewel1609_2
				</div>
			</div>

		
		<!-- The time line -->
		<ul class="timeline">
		  <!-- timeline time label -->
		<li class="time-label" id="repliesDiv">
		  <span class="bg-green">
		     댓글목록 <small id='replycntSmall'> [ ${board.replycnt} ] </small>
		    </span>
		  </li>
		</ul>
		
		<ul id="replies">
			
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
<<<<<<< HEAD
<script>

var bno = ${board.bno};
var replyPage = 1;

$("#repliesDiv").on("click", function() {

	if ($(".timeline li").size() > 1) {
		return;
	}
	getPageList(1);

});
=======
<!-- /.content -->

<script>


	$("#repliesDiv").on("click", function() {
>>>>>>> jewel1609_2

var timeFormat = function(timeValue) {
	var dateObj = new Date(timeValue);
	var year = dateObj.getFullYear();
	var month = dateObj.getMonth() + 1;
	var date = dateObj.getDate();
	return year + "/" + month + "/" + date;
};

$("#replyAddBtn").on("click", function() {

	var replyer = $("#newReplyWriter").val();
	var replytext = $("#newReplyText").val();

	$.ajax({
		type : 'post',
		url : "${pageContext.request.contextPath}/replies",
		headers : {
			"Content-Type" : "application/json"
		},
		dataType : 'text',
		data : JSON.stringify({
			bno : bno,
			replyer : replyer,
			replytext : replytext
		}),
		success : function(result) {

			if (result == 'SUCCESS') {

				alert("등록 되었습니다.");
				$("#newReplyWriter").val("");
				$("#newReplyText").val("");
				getPageList(1);

			}
		}
	});
});
 $(".timeline").on("click", ".replyLi", function(event){
		
		var reply = $(this);
		
		$("#replytext").val(reply.find('.timeline-body').text());
		$(".modal-title").html(reply.attr("data-rno"));
		
	}); 

$("#replyDelBtn").on("click", function() {

	var rno = $(".modal-title").html();
	var replytext = $("#replytext").val();

	$.ajax({
		type : 'delete',
		url : '${pageContext.request.contextPath}/replies/' + rno,
		headers : {
			"Content-Type" : "application/json"
		},
		dataType : 'text',
		success : function(result) {
			console.log("result: " + result);
			if (result == 'SUCCESS') {
				alert("삭제 되었습니다.");
				getPageList(1);
			}
		}
	});
});

<<<<<<< HEAD
$("#replyModBtn").on("click",function(){
	  
	  var rno = $(".modal-title").html();
	  var replytext = $("#replytext").val();
	  
	  $.ajax({
			type:'put',
			url:'${pageContext.request.contextPath}/replies/'+rno,
			headers: { 
			      "Content-Type": "application/json"},
			data:JSON.stringify({replytext:replytext}), 
			dataType:'text', 
			success:function(result){
				console.log("result: " + result);
				if(result == 'SUCCESS'){
					alert("수정 되었습니다.");
					//getAllList();
					 getPageList(replyPage);
				}
		}});
});		


function getPageList(page){
	$(".replyLi").remove();
	$("#modifyModal").modal('hide');
  $.getJSON("${pageContext.request.contextPath}/replies/"+bno+"/"+page , function(data){
	  
	  console.log(data.list.length);
	  console.log(data.pageMaker);
	  var str ="";
	 
		
	  $(data.list).each(function(){
			str = "<li data-rno='"+this.rno+"'class='replyLi'> "
			+ "<i class='fa fa-comments bg-blue'> </i> "
			+ "<div class='timeline-item'> "
			+ "<span class='time'> "
			+ "<i class='fa fa-clock-o'></i> " + timeFormat(this.regdate) 
			+ "</span> "
			+ "<h3 class='timeline-header'><strong>"+this.rno+"</strong> -"+this.replyer+"</h3> "
			+ "<div class='timeline-body'>"+this.replytext + "</div> "
			+ "<div class='timeline-footer'> "
			+  "<a class='btn btn-primary btn-xs' id='modButton' data-toggle='modal' data-target='#modifyModal'>수정</a> "
			+ "</div>" + "</div>"+"</li>";
		$("#repliesDiv").after(str);
				
=======
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
>>>>>>> jewel1609_2
	});



	  $("#replycntSmall").html("[ " + data.pageMaker.totalCount +" ]");  
	  printPaging(data.pageMaker);
	  
  });
}		
/* 
$("#modifyModal").modal('hide');
<a class='btn btn-primary btn-xs' data-toggle='modal' data-target=''#modifyModal'>수정</a>
*/  
function printPaging(pageMaker){
	
	var str = "";
	
	if(pageMaker.prev){
		str += "<li><a href='"+(pageMaker.startPage-1)+"'> << </a></li>";
	}
	
	for(var i=pageMaker.startPage, len = pageMaker.endPage; i <= len; i++){				
			var strClass= pageMaker.cri.page == i?'class=active':'';
		  str += "<li "+strClass+"><a href='"+i+"'>"+i+"</a></li>";
	}
	
	if(pageMaker.next){
		str += "<li><a href='"+(pageMaker.endPage + 1)+"'> >> </a></li>";
	}
	$('.pagination').html(str);				
}


$(".pagination").on("click", "li a", function(event){

	event.preventDefault();
	
	replyPage = $(this).attr("href");
	
	getPageList(replyPage);
	
});

$(document).ready(function(){
	
	var formObj = $("form[role='form']");
	
	console.log(formObj);
	
	$("#modifyBtn").on("click", function(){
<<<<<<< HEAD
		formObj.attr("action", "${pageContext.request.contextPath}/sboard/modifyPage");
=======
		alert("버튼 눌림");
		formObj.attr("action", "/community-domain/sboard/modifyPage");
>>>>>>> jewel1609_2
		formObj.attr("method", "get");		
		formObj.submit();
	});
	
	$("#removeBtn").on("click", function(){
<<<<<<< HEAD
		formObj.attr("action", "${pageContext.request.contextPath}/sboard/removePage");
=======
		formObj.attr("action", "'${pageContext.request.contextPath}/sboard/removePage");
>>>>>>> jewel1609_2
		formObj.submit();
	});
	
	$("#goListBtn ").on("click", function(){
		formObj.attr("method", "get");
<<<<<<< HEAD
		formObj.attr("action", "${pageContext.request.contextPath}/sboard/list");
=======
		formObj.attr("action", "/community-domain/sboard/list");
>>>>>>> jewel1609_2
		formObj.submit();
	});
	
<<<<<<< HEAD
});
</script>
=======
});

</script>
<<<<<<< HEAD
>>>>>>> branch 'master' of https://github.com/java8study/Community.git
=======
>>>>>>> jewel1609_2
