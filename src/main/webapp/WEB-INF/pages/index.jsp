<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>


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
		<div class="container">

			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Menu</span> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<div class="navbar-header">
				<a class="navbar-brand" href="#"><b>Basic</b></a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-left">
					<li class=""><a href="#">Home</a></li>
					<li><a href="#">Contacto</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Learn <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li class="dropdown-header">ejemplo</li>
							<li><a href="#">test</a></li>
						</ul>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="active"><a href="${pageContext.request.contextPath}/registro">Registrate</a></li>
					<li class=""><a	href="${pageContext.request.contextPath}/ingresar">Ingresar</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container">
		<h1>Pagina de prueba Basica</h1>
		<p>Welcome to Java Spring Configuration</p>
		<p>The sample application provided by Spring MVC javaConfig udemy course</p>

		<a href="${pageContext.request.contextPath}/displayUsers">Display users with Embedded Database</a> <br /> <a
			href="${pageContext.request.contextPath}/displayUsersMySQL">Display users with MySQL Database</a> <br /> <a
			href="${pageContext.request.contextPath}/admin.html">Admin</a> 
			<br />
			<br />

		<!-- con esto puedo decidir si puede o no ver el contenido algun usuario o rol
	   <security:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_USER')">
	   <b>You are logged in as: </b><security:authentication property="principal.username"/>
	   with the role of: <security:authentication property="principal.authorities"/>
	   <br/>
	   <a href="<c:url value="/logout"/>">Logout</a>
	   </security:authorize>
	        
	        -->
	</div>
	<footer class="footer">
		<div class="container">
			<p class="text-muted">
				<b>Texto para footer</b>
			</p>
			<a href="<%=request.getContextPath()%>?language=en">EN</a> <a
				href="<%=request.getContextPath()%>?language=de">DE</a>

			<spring:message code="language" />

			<font color="green"><b><spring:message code="welcome.text" /></b></font>
		</div>
	</footer>
</body>
</html>