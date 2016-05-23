<%@page import="users.TPO"%>
<%@page import="models.UsersModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String msg = (String) request.getAttribute("msg");
	TPO tpo = UsersModel.fetchTPO();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enrolled TPO</title>
<script src="/CollegeJunction/js/jquery.js"></script>

<script>
	$(document).ready(function() {

	});

	function deleteUser(email) {
		var res = confirm("Are You sure want to delete user");
		if (res) {
			$.post("/CollegeJunction/admin/deleteUser.jsp", "email=" + email + "&userType=TPO",
					function(data, status) {
						alert(data.trim());
						location.reload();
					})
		}
	}
</script>
<style>
tr, td, th {
	padding: 5px 10px;
}
</style>
</head>
<body>
	<center>
		<%
			if (msg != null) {
		%>
		<center>
			<h4><%=msg%></h4>
		</center>
		<%
			}
		%>
		
		<table>
			<%
				if (tpo != null) {
			%>

			<tr>
				<th>Name</th>
				<th>Email</th>
			</tr>
			<tr>

				<td><%=tpo.getName()%></td>
				<td><%=tpo.getEmail()%></td>
				<%
					if (msg == null) {
				%>
				<td><button type="button"
						onclick="return deleteUser('<%=tpo.getEmail()%>')">Delete</button></td>
				<%
					}
				%>
			</tr>
			<%
				} else {
			%>
			<center>
				<h4>No TPO Enrolled</h4>
			</center>
			<%
				}
			%>
		</table>
	</center>
</body>
</html>