<%@include file="include/header.jsp"%>

<body>

	<div class="container">

		<form class="form-signin" action="memberUpdate.do">
			<h2 class="form-signin-heading">Update</h2>

			<label for="userId" class="sr-only">ID</label>
			 <input type="text"
			 id="userId" name="userId" class="form-control"
			value="${userId }">

			<label for="userPwd" class="sr-only">Password</label>
			 <input type="password" id="userPwd" class="form-control"
				placeholder="Password" required> 
				
			<label for="userPwd2" class="sr-only">Confirm Password</label>
			 <input type="password" id="userPwd2" name="userPwd2" class="form-control"
				placeholder="Confirm Password" required> 
				
			<label for="userName" class="sr-only">Name</label>
			 <input type="text" id="userName" name="userName" class="form-control"
				value="${userName }"> 

			<label for="email" class="sr-only">Email Address</label>
          	<input type="email" id="email" class="form-control" name="email" value="${email }"> >


			<button class="btn btn-lg btn-primary btn-block" type="submit" value="update">Update</button>		

		</form>
	</div>

	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>


<%@include file="include/footer.jsp"%>