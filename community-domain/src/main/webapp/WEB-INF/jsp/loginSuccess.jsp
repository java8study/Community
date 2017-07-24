<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%> 

<body>
<div class="container-wrapper">
	<div class="container">

		<!-- Main component for a primary marketing message or call to action -->
		<div class="jumbotron">
			<h3>${userName}님 환영합니다</h3>
			<p>ID: ${userId}</p>
			<p>E-mail: ${email}</p>
			<p>
				<input class="btn btn-lg btn-primary" type="button" value="로그아웃"
					onclick="location.href='logout.do'">
					
				 <input
					class="btn btn-lg btn-primary" type="button" value="회원수정페이지"
					onclick="location.href='memberUpdate.do'">
			</p>
		</div>
	</div>
	</div>
	<!-- /container -->
</head>
</body>
