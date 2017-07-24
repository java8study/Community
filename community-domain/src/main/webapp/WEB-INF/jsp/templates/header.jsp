<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>my eStore</title>

<!-- Bootstrap core CSS -->


<link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="<c:url value="/resources/bootstrap/css/carousel.css"/>"
	rel="stylesheet">

<link href="<c:url value="/resources/bootstrap/css/main.css"/>"
	rel="stylesheet">

	
</head>
<!-- NAVBAR
================================================== -->
<body>
 <!-- Navigation -->
    <nav id="mainNav" class="navbar navbar-default navbar-fixed-top navbar-custom">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span> Menu <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand" href="/">Project</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                    <li class="page-scroll">
                        <a href="#community">COMMUNITY</a>
                    </li>
                    
                    <li class="page-scroll">
                    <a href="#" class="dropdown-toggle"
									data-toggle="dropdown" role="button" aria-expanded="false">DROPDOWN
										<span class="caret"></span>
								</a>
									<ul class="dropdown-menu" role="menu">
										<li><a href="#">Action</a></li>
										<li><a href="#">Another action</a></li>
										<li><a href="#">Something else here</a></li>
										<li class="divider"></li>
										<li class="dropdown-header">Nav header</li>
										<li><a href="#">Separated link</a></li>
										<li><a href="#">One more separated link</a></li>
									</ul></li>
                    
                    <li class="page-scroll">
                        <a href="${pageContext.request.contextPath}/loginForm.do">Login</a>
                    </li>
                    <li class="page-scroll">
                        <a href="${pageContext.request.contextPath}/registerForm.do">Register</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>
	