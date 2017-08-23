<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
<div class="container">
	<div class="row">
		<form:form action="/login" method="POST">
			<div class="form-group row">
				<label class="form-col-label col-2" for="email">Email:</label>
				<div class="col-10">
					<input name="login" id="email" class="form-control"/>
				</div>
			</div>
			<div class="form-group row">
				<label class="form-col-label col-2" for="password">Password:</label>
				<div class="col-10">
					<input type="password" name="password" id="password" class="form-control"/>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-10">
					<label><input type="checkbox" name="rememberMe"> Remember me</label>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-10 ml-auto">
					<button class="btn btn-outline-success btn-sm">Sign in</button>
				</div>
			</div>
		</form:form>
	</div>
</div>
</body>
</html>