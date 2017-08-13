<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Ingresar</title>


<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/starter-template.css">

<script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<script	src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script	src="${pageContext.request.contextPath}/resources/js/validator.min.js"></script>
</head>
<body>

	<div class="container">
		<div class="row text-center pad-top">
			<div class="col-md-12">
				<h2>Registration Page</h2>
			</div>
		</div>
		<div class="row pad-top">

			<div class="col-md">
				<div class="panel panel-default">
					<div class="panel-heading">
						<strong>Fomulario de Registro</strong>
					</div>
					<div class="panel-body">

						<form action="${pageContext.request.contextPath}/saveUser" method="post" role="form" class="form-horizontal" data-toggle="validator">
							<fieldset>		

								<!-- Text input  has-success has-feedback -->
								<div class="form-group has-feedback">
									<label class="control-label col-md-2" for="fn">First name</label>
									<div class="inputGroupContainer col-md-8">
									<div class="input-group">
										<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> 
										<input id="fn" name="fn" type="text" placeholder="first name" class="form-control input-md" required>
										<div class="glyphicon form-control-feedback"></div>
										</div>
									</div>
								</div>

								<!-- Text input-->
								<div class="form-group has-feedback">
									<label class="control-label col-md-2" for="ln">Last name</label>
									<div class="inputGroupContainer col-md-8">
										<div class="input-group">
											<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
											<input id="ln" name="ln" type="text" placeholder="last name" class="form-control input-md" required>
											<div class="glyphicon form-control-feedback"></div>
										</div>
								  </div>
								</div>

								<!-- Text input-->
								<div class="form-group has-feedback">
									<label class="control-label col-md-2" for="un">User name</label>
									<div class="inputGroupContainer col-md-8">
										<div class="input-group">
											<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
											<input id="un" name="un" type="text" placeholder="user name" class="form-control input-md" required>
											<div class="glyphicon form-control-feedback"></div>
										</div>	
									</div>								
								</div>

								<!-- Text input-->
								<div class="form-group has-feedback">
									<label class="control-label col-md-2" for="email">Email</label>
									<div class="inputGroupContainer col-md-8">
										<div class="input-group">
											<span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
											<input id="email" name="email" type="email" placeholder="email" class="form-control input-md" data-error="Correo incorrecto" required>											
											<div class="glyphicon form-control-feedback"></div>
										</div>
										<span class="help-block with-errors"></span>
									</div>									
								</div>

								<!-- Text input   -->
								<div class="form-group has-feedback">
									<label class="control-label col-md-2" for="pw">Password</label>
									<div class="inputGroupContainer col-md-8">
										<div class="input-group"><div class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></div>										
										<input id="pw" name="pw" type="password" placeholder="password" class="form-control input-md-6" data-minLength="5" data-error="Password must be more than 5" required>
										<span class="glyphicon form-control-feedback"></span>																			
									</div>
									<span class="help-block with-errors"></span>
									</div>
								</div>

								<!-- Text input-->
								<div class="form-group has-feedback">
									<label class="control-label col-md-2" for="pwv">Confirm	Password</label>
									<div class="inputGroupContainer col-md-8">
										<div class="input-group">
											<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
											<input id="pwv" name="pwv" type="password" placeholder="password again" class="form-control input-md" data-match="#pw" data-minLength="5" data-error="Password dont match" required>
											<div class="glyphicon form-control-feedback"></div>
										</div>
									<span class="help-block with-errors"></span>
								  </div>
								</div>

								<!-- Button -->
								<div class="form-group">
									<label class="control-label col-md-2" for="submit"></label>
									<div class="col-md-8">
										<button id="submit" name="submit" class="btn btn-primary" value="save">Registro</button>
									</div>
								</div>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>



</body>
</html>
