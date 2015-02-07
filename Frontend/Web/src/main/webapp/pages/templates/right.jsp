<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<div class="shadow rightObject margin">
	<div class="login">
		<form name='loginForm'
			action="<c:url value='j_spring_security_check' />" method='POST'>
			<div>
				<div>${login_tip}</div>
			</div>
			<table>
				<tr>
					<td>${login_username}</td>
					<td><input type='text' name='username' class="shadow"></td>
				</tr>
				<tr>
					<td>${login_password}</td>
					<td><input type='password' name='password' class="shadow" /></td>
				</tr>
				<tr>
					<td></td>
					<td colspan='2'><input name="submit" type="submit" class="button shadow" value="Login" /></td>
				</tr>
			</table>
			<div>
				<div>
					<a href="#">${login_help}</a> ${login_problems}
				</div>
			</div>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />

		</form>
	</div>
</div>
<div class="shadow rightObject margin">
	<div class="cart">
		<table>
			<tr>
				<td>Broj pogledanih:</td>
				<td>22</td>
			</tr>
			<tr>
				<td>Broj odabranih:</td>
				<td>2</td>
			</tr>
			<tr>
				<td>Test broj</td>
				<td>897</td>
			</tr>
			<tr>
				<td>Test broj dava</td>
				<td>65</td>
			</tr>
		</table>
	</div>
</div>