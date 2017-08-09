<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>


<%@include file="include/header.jsp"%>

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
<<<<<<< HEAD
<<<<<<< HEAD
					<form action="/sboard/list" method="GET">
=======

>>>>>>> branch 'master' of https://github.com/java8study/Community.git
=======
					<form action="/community-domain/sboard/list" method="GET">
>>>>>>> jewel1609_2
					<select name="searchType">
						<option value="t"
<<<<<<< HEAD
						<c:if test="${cri.searchType ==null or cri.searchType =='t' }">
								<c:out value='selected'/>							
						</c:if>>	
						  제목</option>
=======
							<c:out value="${cri.searchType eq 't'?'selected':''}"/>>
							제목</option>    <!-- <option value="t" selected /> -->
>>>>>>> jewel1609_2
						<option value="c"
							<c:out value="${cri.searchType eq 'c'?'selected':''}"/>>
							내용</option>
						<option value="w"
							<c:out value="${cri.searchType eq 'w'?'selected':''}"/>>
							작성자</option>
						<option value="tc"
							<c:out value="${cri.searchType eq 'tc'?'selected':''}"/>>
<<<<<<< HEAD
							제목 또는 내용</option>
						<option value="cw"
=======
							제목 및 내용</option>
						<option value="cw" 	 
>>>>>>> jewel1609_2
							<c:out value="${cri.searchType eq 'cw'?'selected':''}"/>>
							내용 또는 작성자</option>
						<option value="tcw"
							<c:out value="${cri.searchType eq 'tcw'?'selected':''}"/>>
							제목 또는 내용 또는 작성자</option>
					</select> <input type="text" name='keyword' id="keywordInput"
<<<<<<< HEAD
						value='${cri.keyword }'>
					<button id='searchBtn'>검색</button>
=======
						value='${cri.keyword}'>
					<input type="submit" id='searchBtn' value="검색">
					
					</form>
>>>>>>> jewel1609_2

				</div>
			</div>


			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">LIST PAGING</h3>
				</div>
				<div class="box-body">
					<table class="table table-bordered">
						<tr>
<<<<<<< HEAD
							<th style="width: 60px">글 번호</th>
=======
							<th style="width: 80px">번호</th>
>>>>>>> jewel1609_2
							<th>제목</th>
							<th>작성자</th>
							<th>등록일</th>
							<th style="width: 80px">조회수</th>
						</tr>

						<c:forEach items="${list}" var="board">

							<tr>
								<td>${board.bno}</td>
								<td><a
<<<<<<< HEAD
									href='${pageContext.request.contextPath}/sboard/readPage${pageMaker.makeSearch(pageMaker.cri.page)}&bno=${board.bno}'>
										${board.title} <strong>[ ${board.replycnt} ]</strong>
								</a></td>
=======
									href='readPage/${board.bno}'>
										${board.title} </a></td>
>>>>>>> jewel1609_2
								<td>${board.writer}</td>
								<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
										value="${board.regdate}" /></td>
								<td><span class="badge bg-red">${board.viewcnt }</span></td>
							</tr>

						</c:forEach>

					</table>
				</div>
				<!-- /.box-body -->

					

<<<<<<< HEAD
				<div class="box-footer">

					<div class="text-center">
						<ul class="pagination">

							<c:if test="${pageMaker.prev}">
								<li><a
									href="list${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
							</c:if>

							<c:forEach begin="${pageMaker.startPage }"
								end="${pageMaker.endPage }" var="idx">
								<li
									<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
									<a href="list${pageMaker.makeSearch(idx)}">${idx}</a>
								</li>
							</c:forEach>

							<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
								<li><a
									href="list${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
							</c:if>

						</ul>
					</div>

				</div>
				<!-- /.box-footer-->
			<div class="wrapper" style = "float: right; margin: 10px; " >
				<button id='newBtn' class="pull-right form-control"  align="right">글쓰기</button>	
			</div>		
			</div>
		
=======
			</div>
			
			 <div class="wrapper" style = "float: right; margin: 10px; " >
				<button id='newBtn' class="pull-right form-control"  align="right">글쓰기</button>	
			</div>
			
>>>>>>> jewel1609_2
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
