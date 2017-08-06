<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Update Template for Bootstrap</title>

<!-- Bootstrap core CSS -->
<link href="../../dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="signin.css" rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="../../assets/js/ie-emulation-modes-warning.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

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
</html>
