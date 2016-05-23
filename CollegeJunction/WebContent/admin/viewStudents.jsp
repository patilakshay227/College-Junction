<%@page import="models.UsersModel"%>
<%@page import="users.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	
	List<Student> list = UsersModel.fetchAllStudents();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Registered Students</title>
<script src="/CollegeJunction/js/jquery.js"></script>
<script>
	$(document).ready(function() {

	});

	function deleteUser(email) {

		var res = confirm("Are You sure want to delete user");
		if (res) {
			$.post("/CollegeJunction/admin/deleteUser.jsp", "email=" + email + "&userType=Student",
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

		<table>
			<%
				if (list.size() > 0) {
			%>

			<tr>
				<th>S.no</th>
				<th>Enrollment No</th>
				<th>Name</th>
				<th>Email</th>
				<th>Branch</th>
			</tr>
			<%
				int i = 1;
					for (Student s : list) {
			%>
			<tr>
				<td><%=i++%></td>
				<td><%=s.getRollNo()%></td>
				<td><%=s.getName()%></td>
				<td><%=s.getEmail()%></td>
				<td><%= s.getBranch() %></td>
				
				<td><button type="button"
						onclick="return deleteUser('<%=s.getEmail()%>')">Delete</button></td>
				
			</tr>
			<%
				}
				} else {
			%>
			<center>
				<h4>No Students Registered.</h4>
			</center>
			<%
				}
			%>
		</table>
	</center>
</body>
</html>