<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
<title>Transport</title>
</head>
<body>
	<h2>${message}</h2>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<a href="/admin">Admin</a>
	</sec:authorize>
	<sec:authorize access="isAnonymous()">
		<a href="/login">Login</a>
		<a href="/registration">Registration</a>
	</sec:authorize>
	<sec:authorize access="isAuthenticated()">
		<form:form action="/logout">
			<button>Logout</button>
		</form:form>
	</sec:authorize>
	<img src="/img/15621957_1847273372210538_2662072775391491197_n.jpg?version=1">
	<form:form action="/" modelAttribute="fileRequest" enctype="multipart/form-data">
		<input type="file" name="file">
		<button>Ok</button>
	</form:form>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<form:form action="/" method="GET" modelAttribute="transporterFilter">
					<div class="form-group row">
						<div class="col-6">
							<form:input path="minRate" class="form-control" placeholder="Min rate"/>
						</div>
						<div class="col-6">
							<form:input path="maxRate" class="form-control" placeholder="Max rate"/>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-6">
							<form:input path="minWeight" class="form-control" placeholder="Min weight"/>
						</div>
						<div class="col-6">
							<form:input path="maxWeight" class="form-control" placeholder="Max weight"/>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-6">
							<form:input path="minCount" class="form-control" placeholder="Min count"/>
						</div>
						<div class="col-6">
							<form:input path="maxCount" class="form-control" placeholder="Max count"/>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-12">
							<form:checkboxes items="${models}" path="modelIds" element="div"/>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-12">
							<form:checkboxes items="${brands}" path="brandIds" element="div"/>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-12">
        					<button type="submit" class="btn btn-outline-success btn-sm">Search</button>
      					</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>