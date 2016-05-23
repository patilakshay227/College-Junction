<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update User Details</title>
<style>
  tr,td,th{
  	padding: 5px 15px;
  }
  caption{
  	padding: 15px 0px;
  }
</style>
</head>
<body>
	<form action="updateUser1.jsp" method="post">
	<table>
			<caption>Update User Details</caption>
			<tr>
				<th> Select User Type</th>
				<td><select name="userType">
						<option>Faculty</option>
						<option>Dean</option>
						<option>Director</option>
						<option>TPO</option>
				</select>
				</td>
			</tr>
			<tr>
				<th>Enter User Email</th>
				<td><input type="email" name="email" required="required"></td>
			</tr>
			<tr>
			  <td colspan="2" align="center"><input type="submit" value="Search User"></td>
			</tr>
	</table>
	</form>
</body>
</html>