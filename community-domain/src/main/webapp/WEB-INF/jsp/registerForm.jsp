<%@include file="include/header.jsp"%>
<div class="container-wrapper">
<div class="container">

		<form class="form-signin" action="register.do">
			<h2 class="form-signin-heading">Register</h2>

			<label for="userId" class="sr-only">ID</label> <input type="text"
				id="userId" name="userId" class="form-control" placeholder="ID"
				required autofocus> <label for="userPwd" class="sr-only">Password</label>
			<input type="password" id="userPwd" name="userPwd"
				class="form-control" placeholder="Password" required> <label
				for="userPwd2" class="sr-only">Confirm Password</label> <input
				type="password" id="userPwd2" name="userPwd2" class="form-control"
				placeholder="Confirm Password" required> <label
				for="userName" class="sr-only">Name</label> <input type="text"
				id="userName" name="userName" class="form-control"
				placeholder="Name" required> <label for="email"
				class="sr-only">Email Address</label> <input type="email" id="email"
				class="form-control" name="email" placeholder="Email Address"
				required>


			<button class="btn btn-lg btn-primary btn-block" type="submit"
				value="register">Sign up</button>

			<button class="btn btn-lg btn-primary btn-block" type="reset"
				value="reset">Reset</button>
		</form>
	</div>
</div>

<%@include file="include/footer.jsp"%>