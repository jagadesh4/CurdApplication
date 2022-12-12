<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>
<html>
<head>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	if(session.getAttribute("Username") == null)
	{
		response.sendRedirect("Login.jsp");
	}
%>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: green">
			<div>
				<a href="https://www.google.com" class="navbar-brand"> Customer Management Application </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Customers</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${customer != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${customer == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${customer != null}">
            			Edit customer
            		</c:if>
						<c:if test="${customer == null}">
            			Add New customer
            		</c:if>
					</h2>
				</caption>

				<c:if test="${customer != null}">
					<input type="hidden" name="id" value="<c:out value='${customer.ID}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Customer Name</label> <input type="text"
						value="<c:out value='${customer.customerName}' />" class="form-control"
						name="name">
				</fieldset>

				<fieldset class="form-group">
					<label>Age</label> <input type="text"
						value="<c:out value='${customer.age}' />" class="form-control"
						name="age">
				</fieldset>

				<fieldset class="form-group">
					<label>CustomerPinCode</label> <input type="text"
						value="<c:out value='${customer.customerPinCode}' />" class="form-control"
						name="customerpincode">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				<button type="submit" class="btn btn-success" name="Back" value="Back">Back</button>					
			</div>
		</div>
	</div>
</body>
</html>

