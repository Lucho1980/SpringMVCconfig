<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>New Blog Post</title>

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
		<h1>new Blog Post Page</h1>
		
		<c:if test="${not empty message}">
			  ${message}<br/>
		</c:if>
		
		
		<form action="${pageContext.request.contextPath}/saveBlogPost" method="post">
		<table style="width: 650px" class="table-striped">
		<tr><td>Title</td><td><input type="text" name="title" required autofocus/></td></tr>
		<tr><td>Content</td><td>
		<textarea style="width: 400px" name="content" rows="10" maxlength="4000" required></textarea>
		</td></tr>
		<tr><td>Draft</td><td><input type="checkbox" name="draft"/></td></tr>
		<tr><td colspan="2"><input type="submit" value="save"></td></tr>
		</table>
		</form>
		
           <a href="${pageContext.request.contextPath}">Back</a>			
	</div>

	<footer class="footer">
		<div class="container">
			<p class="text-muted">
				<b>Tuna Tore 2016 Please feel free to ask questions by sending
					email to tunatore@gmail.com</b>
			</p>
			<a href="<%=request.getContextPath()%>?language=en">EN</a> <a
				href="<%=request.getContextPath()%>?language=de">DE</a>
		</div>
	</footer>
</body>
</html>