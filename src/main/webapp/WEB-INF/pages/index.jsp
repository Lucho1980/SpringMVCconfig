<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Welcome</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/starter-template.css">
<script	src="${pageContext.request.contextPath}/resources/js/jquery-2.1.4.min.js" type="text/javascript"></script>
<script	src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="https://www.udemy.com/u/tunatore/"><b>Udemy</b></a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Home</a></li>
				<li><a href="#">Promo</a></li>
			</ul>
		</div>
	</nav>
	<div class="container">
		<h1>Java Spring MVC(JavaConfig)</h1>
		<p>Welcome to Java Spring Configuration</p>
		<p>The sample application provided by Spring MVC javaConfig udemy course</p>
		
		springmvc-java-config-webxml
	</div>
	
	

	<footer class="footer">
		<div class="container">
			<p class="text-muted">
				<b>Tuna Tore 2016 Please feel free to ask questions by sending email to tunatore@gmail.com</b>
			</p>
			<a href="<%=request.getContextPath()%>?language=en">EN</a> 
			<a href="<%=request.getContextPath()%>?language=de">DE</a>
			
			
		</div>
	</footer>
</body>
</html>