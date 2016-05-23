<%@page import="models.UsersModel"%>
<%@page import="users.Faculty"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String msg = (String) request.getAttribute("msg");
	List<Faculty> faculties = UsersModel.fetchAllFaculties();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enrolled Faculties</title>
<script src="/CollegeJunction/js/jquery.js"></script>
<script>
	$(document).ready(function() {

	});

	function deleteUser(email) {

		var res = confirm("Are You sure want to delete user");
		if (res) {
			$.post("/CollegeJunction/admin/deleteUser.jsp", "email=" + email + "&userType=Faculty",
					function(data, status) {
						alert(data.trim());
						location.reload();
					})
		}
	}
</script>
<style>
tr, td, th {
	padding: 5px 15px;
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
				if (faculties.size() > 0) {
			%>

			<tr>
				<th>S.no</th>
				<th>Name</th>
				<th>Email</th>
				<th>Department</th>
			</tr>
			<%
				int i = 1;
					for (Faculty f : faculties) {
			%>
			<tr>
				<td><%=i++%></td>
				<td><%=f.getName()%></td>
				<td><%=f.getEmail()%></td>
				<td><%=f.getDepartment()%></td>
				<%
					if (msg == null) {
				%>
				<td><button type="button"
						onclick="return deleteUser('<%=f.getEmail()%>')">Delete</button></td>
				<%
					}
				%>
			</tr>
			<%
				}
				} else {
			%>
			<center>
				<h4>No Faculties Enrolled</h4>
			</center>
			<%
				}
			%>
		</table>
	</center>
</body>
</html>