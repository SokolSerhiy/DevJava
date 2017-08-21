<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<title>Component</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<form:form action="/admin/component" method="POST" modelAttribute="component">
					<div class="form-group row">
						<label class="col-2 col-form-label" for="amount">Amount:</label>
						<div class="col-10">
							<form:input class="form-control" id="amount" path="amount"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="ms">Measuring system:</label>
						<div class="col-10">
							<form:select class="form-control" id="ms" path="ms" items="${mss}"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="ingredient">Ingredient:</label>
						<div class="col-10">
							<form:select class="form-control" id="ingredient" path="ingredient" items="${ingredients}"/>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-8 mr-auto">
							<button class="btn btn-sm btn-outline-success">Save</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<tr>
						<th class="text-center">Amount</th>
						<th class="text-center">Measuring system</th>
						<th class="text-center">Ingredient</th>
						<th class="text-center">Options</th>
					</tr>
					<c:forEach var="component" items="${components}">
						<tr>
							<td>${component.amount}</td>
							<td>${component.ms}</td>
							<td>${component.ingredient}</td>
							<td class="text-center">
								<a href="/admin/component/update/${component.id}" class="btn btn-outline-warning btn-sm">Update</a>
								<a href="/admin/component/delete/${component.id}" class="btn btn-outline-danger btn-sm">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>