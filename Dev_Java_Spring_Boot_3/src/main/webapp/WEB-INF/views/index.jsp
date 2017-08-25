<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
</body>
</html>