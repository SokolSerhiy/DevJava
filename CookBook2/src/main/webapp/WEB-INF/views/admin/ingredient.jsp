<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="жарена_картопля"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<div class="row">
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class="active"><a href="/admin/ingredient<custom:allParams/>">Ingredient</a></li>
					<li><a href="/admin/ms">Measuring system</a></li>
					<li><a href="/admin/country">Country</a></li>
					<li><a href="/admin/amount">Amount</a></li>
					<li><a href="/admin/recipe">Recipe</a></li>
				</ul>
			</div>
		</div>
	</nav>
</div>
<div class="row">
	<div class="col-md-3 col-xs-12">
		<жарена_картопля:form class="form-inline" action="/admin/ingredient" method="GET" modelAttribute="filter">
			<custom:hiddenInputs excludeParams="search"/>
			<div class="form-group">
				<жарена_картопля:input path="search" class="form-control" placeholder="Search"/>
			</div>
			<button class="btn btn-primary" type="submit">Ok</button>
		</жарена_картопля:form>
	</div>
	<div class="col-md-7 col-xs-12">
		<div class="row">
			<div class="col-md-12 col-xs-12">
				<жарена_картопля:form class="form-horizontal" action="/admin/ingredient" method="POST" modelAttribute="ingredient">
					<custom:hiddenInputs excludeParams="name"/>
					<div class="form-group">
						<label style="color:red;text-align:left;" for="name" class="col-sm-10 col-sm-offset-2 control-label"><жарена_картопля:errors path="name"/></label>
					</div>
					<div class="form-group">
    					<label for="name" class="col-sm-2 control-label">Name</label>
    					<div class="col-sm-10">
      						<жарена_картопля:input class="form-control" path="name" id="name"/>
    					</div>
  					</div>
  					<div class="form-group">
    					<div class="col-sm-offset-2 col-sm-10">
      						<button type="submit" class="btn btn-default">Create</button>
    					</div>
  					</div>
				</жарена_картопля:form>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4 col-xs-4"><h3>Ingredient name</h3></div>
			<div class="col-md-4 col-xs-4"><h3>Update</h3></div>
			<div class="col-md-4 col-xs-4"><h3>Delete</h3></div>
		</div>
			<c:forEach items="${page.content}" var="ingredient">
				<div class="row">
					<div class="col-md-4 col-xs-4">${ingredient.name}</div>
					<div class="col-md-4 col-xs-4"><a class="btn btn-warning" href="/admin/ingredient/update/${ingredient.id}<custom:allParams/>">update</a></div>
					<div class="col-md-4 col-xs-4"><a class="btn btn-danger" href="/admin/ingredient/delete/${ingredient.id}<custom:allParams/>">delete</a></div>
				</div>
			</c:forEach>
	</div>
	<div class="col-md-2 col-xs-12">
		<div class="row">
					<div class="col-md-6 col-xs-6 text-center">
						<div class="dropdown">
							<button class="btn btn-primary dropdown-toggle" type="button"
								data-toggle="dropdown">
								Sort <span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<custom:sort innerHtml="Name asc" paramValue="name" />
								<custom:sort innerHtml="Name desc" paramValue="name,desc" />
							</ul>
						</div>
					</div>
					<div class="col-md-6 col-xs-6 text-center">
						<custom:size posibleSizes="1,2,5,10" size="${page.size}" />
					</div>
				</div>
	</div>
</div>
<div class="row">
	<div class="col-md-12 col-xs-12 text-center">
		<custom:pageable page="${page}" cell="<li></li>"
			container="<ul class='pagination'></ul>" />
	</div>
</div>