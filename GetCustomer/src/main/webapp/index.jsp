<%@page import="com.customer.web.model.Customer"%>
<%@page import="java.util.List"%>
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
			style="background-color: tomato">
			<div>
				<a href="https://google.com" class="navbar-brand"> Customer
					Management Application </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Customers</a></li>
			</ul>
		</nav>
	</header>
	<br>
	Welcome ${Username}
	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Customers</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
					New Customer</a>
			</div>
			<br>
			<table class="table table-bordered">
							<thead>
					<tr>
						<th>ID</th>
						<th>CustomerName</th>
						<th>Age</th>
						<th>CustomerPinCode</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="customers" items="${listCustomer}">

						<tr>
							<td><c:out value="${customers.ID}" /></td>
							<td><c:out value="${customers.customerName}" /></td>
							<td><c:out value="${customers.age}" /></td>
							<td><c:out value="${customers.customerPinCode}" /></td>
							<td><a href="edit?id=<c:out value='${customers.ID}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${customers.ID}' />">Delete</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
	<form action="Logout">	
	<center>
		<input type="submit" value="Logout"/>
	</center>
	</form>
</body>
</html>
