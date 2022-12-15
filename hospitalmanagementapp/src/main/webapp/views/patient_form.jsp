<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body align="center">
     <h1>Patient Form</h1>
	<p>${NOTIFICATION}</p>
	</div>
	<form action="${pageContext.request.contextPath}/HospitalController" method="post">
	
		<div class="form-group">
			<input type="text" class="form-control" name="name"
				placeholder="Enter Name" value="${hospital.name}" />
		</div>

		<div class="form-group">
			<input type="email" class="form-control" name="email"
				placeholder="Enter Email" value="${hospital.email}" />
		</div>

		<div class="form-group">
			<input type="text" class="form-control" name="address"
				placeholder="Enter address" value="${hospital.address}" />
		</div>
		<div class="form-group">
			<input type="text" class="form-control" name="contact"
				placeholder="Enter phone" value="${hospital.contact}" />
		</div>

		<input type="hidden" name="id" value="${hospital.id}" /> 
		<input type="hidden" name="action" value="ADD" />

		<button type="submit" class="btn btn-primary">Save</button>
	</form>
	<div>
		<p>
			<a href="${pageContext.request.contextPath}/HospitalController">patient List</a>
		</p>
	</div>

</body>
</html>