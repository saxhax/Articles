<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
<title>Articles</title>
<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.26/angular.min.js"></script>
<script src="<c:url value='js/main.js' />"></script>
<link rel="stylesheet" type="text/css" href="<c:url value='css/style.css' />">
</head>
<body onload='document.loginForm.username.focus();'>
	<div class="login shadow background">
		<form name='loginForm'
			action="<c:url value='/j_spring_security_check' />" method='POST'>
			<div class="simpleInfo">
				<c:if test="${not empty error}">
					<div>${error}</div>
				</c:if>
				<c:if test="${not empty msg}">
					<div>${msg}</div>
				</c:if>
				<c:if test="${empty msg}">
					<div>Please insert username and password</div>
				</c:if>
			</div>
			<table>
				<tr>
					<td>Username:</td>
					<td><input type='text' name='username' class="shadow"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type='password' name='password' class="shadow" /></td>
				</tr>
				<tr>
					<td></td>
					<td colspan='2'><input name="submit" type="submit"
						class="button shadow" value="Login" /></td>
				</tr>
			</table>
			<div class="simpleInfo">
				<div>
					<a href="#">Help</a> in case of problems
				</div>
			</div>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />

		</form>
	</div>
</body>
</html>