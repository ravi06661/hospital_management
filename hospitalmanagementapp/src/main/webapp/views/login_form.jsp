<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body style="background-color:pink;">
<h1>Login Page</h1>
<p>${NOTIFICATION}</p>
<form action="${pageContext.request.contextPath}/HospitalController"
		method="post">
		<div class="form-group"><label>name :</label>
		<input type="text" class="form-control" name="uname" placeholder="NAME" value="${user.uname}">
		</div>
		
		<div class="form-group"><label>password :</label>
		<input type="password" class="form-control" name="upassword" placeholder="PASSWORD" value="${user.upassword}">
		</div>
		<div class="for-group">
		<input type="hidden" class="form-control" name="action" value="LOGIN">
		</div>
		
		
		<button type="submit" class="btn btn-submit">login</button>
	</form>

<div>
		<p>
			<a href="${pageContext.request.contextPath}/views/user_signup.jsp">Signup</a>
		</p>
	</div>
</body>
</html>