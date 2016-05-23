<%@page import="users.TPO"%>
<%@page import="javax.jws.soap.SOAPBinding.Use"%>
<%@page import="users.Director"%>
<%@page import="users.Dean"%>
<%@page import="models.UsersModel"%>
<%@page import="users.Faculty"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update User Details</title>
<script src="../js/jquery.js"></script>
<style>
tr, td, th {
	padding: 5px 15px;
}

caption {
	padding: 15px 0px;
}
</style>
</head>
<body>
	<form action="../UpdateUserDetails" method="post">
		<table>
			<%
				String userType = request.getParameter("userType");
				String email = request.getParameter("email");
				Object user = UsersModel.searchUser(userType, email);
				if (user instanceof Faculty) {
					Faculty f = (Faculty) user;
			%>
			<tr>
				<th>Name</th>
				<td><input type="text" name="name" value="<%=f.getName()%>"></td>
			</tr>
			<tr>
				<th>Email</th>
				<td><input type="email" name="email" value="<%=f.getEmail()%>"></td>
			</tr>
			<tr>
				<th>Password</th>
				<td><input type="password" name="password"
					value="<%=f.getPassword()%>"></td>
			</tr>
			<tr>
				<th>Department</th>
				<td><select name="department">
						<option>Computer Science</option>
						<option>Information Technology</option>
						<option>Electronics and Communication</option>
						<option>Mechanical</option>
						<option>Civil</option>
						<option>Chemical</option>
				</select></td>
			</tr>
			<script> 
		  $('select[name="department"] option:contains("<%= f.getDepartment()%>")').prop('selected', true);
			</script>
			<tr>
			  <td><input type="hidden" name="oldEmail" value="<%= f.getEmail() %>"></td>
			  <td><input type="hidden" name="userType" value="Faculty"></td>
			</tr>
			<tr>
				<td><button type="submit">Update Details</button></td>
				<td><button type="button" onclick="history.back();">Cancel</button></td>
			</tr>
			<%
				} else if (user instanceof Dean) {
					Dean f = (Dean) user;
			%>
			<tr>
				<th>Name</th>
				<td><input type="text" name="name" value="<%=f.getName()%>"></td>
			</tr>
			<tr>
				<th>Email</th>
				<td><input type="email" name="email" value="<%=f.getEmail()%>"></td>
			</tr>
			<tr>
				<th>Password</th>
				<td><input type="password" name="password"
					value="<%=f.getPassword()%>"></td>
			</tr>
			<tr>
				<th>Department</th>
				<td><select name="department">
						<option>Computer Science</option>
						<option>Information Technology</option>
						<option>Electronics and Communication</option>
						<option>Mechanical</option>
						<option>Civil</option>
						<option>Chemical</option>
				</select></td>
			</tr>
			<script> 
		  $('select[name="department"] option:contains("<%= f.getDepartment()%>")').prop('selected', true);
			</script>
			<tr>
			 <td><input type="hidden" name="oldEmail" value="<%= f.getEmail() %>"></td>
			  <td><input type="hidden" name="userType" value="Dean"></td>
			</tr>
			<tr>
				<td><button type="submit">Update Details</button></td>
				<td><button type="button" onclick="history.back();">Cancel</button></td>
			</tr>
			<%
				} else if (user instanceof Director) {
					Director f = (Director) user;
			%>
			<tr>
				<th>Name</th>
				<td><input type="text" name="name" value="<%=f.getName()%>"></td>
			</tr>
			<tr>
				<th>Email</th>
				<td><input type="email" name="email" value="<%=f.getEmail()%>"></td>
			</tr>
			<tr>
				<th>Password</th>
				<td><input type="password" name="password"
					value="<%=f.getPassword()%>"></td>
			</tr>
			<tr>
			  <td><input type="hidden" name="oldEmail" value="<%= f.getEmail() %>"></td>
			  <td><input type="hidden" name="userType" value="Director"></td>	
			</tr>
			<tr>
				<td><button type="submit">Update Details</button></td>
				<td><button type="button" onclick="history.back();">Cancel</button></td>
			</tr>
			<%
				}else if (user instanceof TPO) {
					TPO t = (TPO) user;
			%>
			<tr>
				<th>Name</th>
				<td><input type="text" name="name" value="<%=t.getName()%>"></td>
			</tr>
			<tr>
				<th>Email</th>
				<td><input type="email" name="email" value="<%=t.getEmail()%>"></td>
			</tr>
			<tr>
				<th>Password</th>
				<td><input type="password" name="password"
					value="<%=t.getPassword()%>"></td>
			</tr>
			<tr>
			  <td><input type="hidden" name="oldEmail" value="<%= t.getEmail() %>"></td>
			  <td><input type="hidden" name="userType" value="TPO"></td>	
			</tr>
			<tr>
				<td><button type="submit">Update Details</button></td>
				<td><button type="button" onclick="history.back();">Cancel</button></td>
			</tr>
			<%
				} else {
			%>
			<center><h4>No User Found With Email - <%=email%></h4></center>
			<%
				}
			%>
		</table>
		</form>
</body>
</html>