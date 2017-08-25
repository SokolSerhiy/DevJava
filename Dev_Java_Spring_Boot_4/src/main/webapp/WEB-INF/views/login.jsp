<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<title>Registration</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<c:if test="${param.fail}">
				<div class="col-12 text-center" style="color:red;">
					Fail to authorize
				</div>
			</c:if>
			<div class="col-12">
				<form:form action="/login" method="POST">
					<div class="form-group row">
						<label class="col-2 col-form-label" for="email">Email:</label>
						<div class="col-10">
							<input class="form-control" id="email" name="login"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="password">Password:</label>
						<div class="col-10">
							<input type="password" class="form-control" id="password" name="password"/>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-10 ml-auto">
							<label><input name="rememberMe" type="checkbox"> Remember me</label>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-10 ml-auto">
							<button class="btn btn-sm btn-outline-success">Sing in</button>
							<a href="/registration" class="btn btn-sm btn-outline-primary">Registration</a>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>