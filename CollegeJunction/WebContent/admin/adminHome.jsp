<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administator Home</title>
</head>
<body>
	<%
		if (session.getAttribute("admin") == null) {
	%>
	<jsp:forward page="admin.jsp"></jsp:forward>
	<%
		} else {
	%>
	<div align="center">
	  <div>
	    <a href="./UserManager.html">User Manager</a>
	  </div>
	  <div>
	    <a href="./BusManager.htm">Bus Manager</a>
	  </div>
	</div>
	<%
		}
	%>
</body>
</html>