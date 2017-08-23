<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
</head>
<body>
<div class="container">
	<div class="row">
		<form:form action="/registration/owner" method="POST" modelAttribute="owner">
			<div class="form-group">
				<label class="col-form-label col-2" for="email">Email:</label>
				<div class="col-10">
					<form:input path="email" id="email" class="form-control"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-form-label col-2" for="password">Password:</label>
				<div class="col-10">
					<form:password path="password" id="password" class="form-control"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-form-label col-2" for="repeatpassword">Repeat password:</label>
				<div class="col-10">
					<form:password path="repeatPassword" id="repeatpassword" class="form-control"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-form-label col-2" for="phone">Phone:</label>
				<div class="col-10">
					<form:input path="phone" id="phone" class="form-control"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-form-label col-2" for="address">Address:</label>
				<div class="col-10">
					<form:input path="address" id="address" class="form-control"/>
				</div>
			</div>
			<div class="form-group">
				<div class="col-10 ml-auto">
					<button class="btn btn-outline-success btn-sm">Register</button>
					<a href="/registration/transporter" class="btn btn-outline-primary btn-sm">Transporter registration</a>
				</div>
			</div>
		</form:form>
	</div>
</div>
</body>
</html>