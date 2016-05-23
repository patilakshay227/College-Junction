<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log in Page</title>
<script src="/CollegeJunction/js/jquery.js"></script>
<script>
	$(document).ready(function() {

		$('select[name="userType"]').change(function() {

			var form = $('#loginForm');
			var userType = $('select[name="userType"]').val();
			console.log(userType);
			switch (userType) {

			case 'Student':
				form.attr('action', './StudentLoginAuth');
				break;
			case 'Faculty':
				form.attr('action', './FacultyLoginAuth');
				break;
			case 'Dean':
				form.attr('action', './DeanLoginAuth');
				break;
			case 'Director':
				form.attr('action', './DirectorLoginAuth');
				break;
			case 'TPO':
				form.attr('action', './TPOLoginAuth');
				break;
			}
		});

	});
</script>
<style>
tr, td, th {
	padding: 10px 5px;
}
</style>
</head>
<body>
	<%
		String errMsg = (String) request.getAttribute("errMsg");
		if (errMsg != null) {
	%>
	<div id="errMsg" align="center" style="color: red; font-size: 1.2em"><%= errMsg %></div>
	<%
		}
	%>
	<div align="center">
		<form action="./StudentLoginAuth" method="post" id="loginForm">
			<table>
				<tr>
					<th>Login As</th>
					<td><select name="userType" style="width: 100%;">
							<option>Student</option>
							<option>Faculty</option>
							<option>Dean</option>
							<option>Director</option>
							<option>TPO</option>
					</select></td>
				</tr>
				<tr>
					<th>Email</th>
					<td><input type="email" name="email" required></td>
				</tr>
				<tr>
					<th>Password</th>
					<td><input type="password" name="password" required></td>
				</tr>
				<tr>
					<td colspan="2"><button type="submit">Log In</button></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>