<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->


		<div class="col-md-12">
			<!-- general form elements -->
			<div class='box'>
				<div class="box-header with-border">
					<h3 class="box-title"></h3>
				</div>


				<div class='box-body'>
					<form action="/sboard/list" method="GET">
					<select name="searchType">
						<option value="n"
							<c:out value="${cri.searchType == null?'selected':''}"/>>
							---</option>
						<option value="t"
							<c:out value="${cri.searchType eq 't'?'selected':''}"/>>
							제목</option>    <!-- <option value="t" selected /> -->
						<option value="c"
							<c:out value="${cri.searchType eq 'c'?'selected':''}"/>>
							내용</option>
						<option value="w"
							<c:out value="${cri.searchType eq 'w'?'selected':''}"/>>
							작성자</option>
						<option value="tc"
							<c:out value="${cri.searchType eq 'tc'?'selected':''}"/>>
							제목 및 내용</option>
						<option value="cw" 	 
							<c:out value="${cri.searchType eq 'cw'?'selected':''}"/>>
							작성자 및 내용</option>
						<option value="tcw"
							<c:out value="${cri.searchType eq 'tcw'?'selected':''}"/>>
							제목 작성자 내용</option>
					</select> <input type="text" name='keyword' id="keywordInput"
						value='${cri.keyword}'>
					<input type="submit" id='searchBtn' value="검색">
					
					</form>

				</div>
			</div>


			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">LIST PAGING</h3>
				</div>
				<div class="box-body">
					<table class="table table-bordered">
						<tr>
							<th style="width: 80px">번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>등록일</th>
							<th style="width: 80px">조회수</th>
						</tr>

						<c:forEach items="${list}" var="board">

							<tr>
								<td>${board.bno}</td>
								<td><a
									href='readPage/${board.bno}'>
										${board.title} </a></td>
								<td>${board.writer}</td>
								<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
										value="${board.regdate}" /></td>
								<td><span class="badge bg-red">${board.viewcnt }</span></td>
							</tr>

						</c:forEach>

					</table>
				</div>
				<!-- /.box-body -->

					

			</div>
			
			 <div class="wrapper" style = "float: right; margin: 10px; " >
				<button id='newBtn' class="pull-right form-control"  align="right">글쓰기</button>	
			</div>
			
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
</section>
<!-- /.content -->


<script>
	var result = '${msg}';

	if (result == 'SUCCESS') {
		alert("처리가 완료되었습니다.");
	}
</script>

<script>
	$(document).ready(
			function() {


				$('#newBtn').on("click", function(evt) {

					self.location = "register";

				});

			});
</script>
